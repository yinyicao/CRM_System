package com.cqut.yyc.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cqut.yyc.dao.ISysPermissionMapper;
import com.cqut.yyc.dao.ISysRoleMapper;
import com.cqut.yyc.dao.entity.UserInfo;
import com.cqut.yyc.service.IUserInfoService;


public class MyShiroRealm extends AuthorizingRealm {
	
	private final static Logger log = LoggerFactory.getLogger(MyShiroRealm.class);
	
    @Autowired
    IUserInfoService userInfoService;
    @Autowired
    ISysRoleMapper sysRoleMapper;
    @Autowired
    ISysPermissionMapper sysPermissionMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        log.info("开始权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principal.getPrimaryPrincipal();
        sysRoleMapper.findRoleByUsername(userInfo.getUsername()).stream().forEach(
                sysRole -> {
                    authorizationInfo.addRole(sysRole.getRole());
                    sysPermissionMapper.findPermissionByRoleId(sysRole.getId()).stream().forEach(
                            sysPermission -> {
                                authorizationInfo.addStringPermission(sysPermission.getPermission());
                            }
                    );
                }
        );
        
		log.info("当前登录用户" + userInfo.getUsername() + "具有的角色:" + authorizationInfo.getRoles());
		log.info("当前登录用户" + userInfo.getUsername() + "具有的权限：" + authorizationInfo.getStringPermissions());
        
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	log.info("开始验证身份-->method:doGetAuthenticationInfo");
    	//获取用户的输入的账号.
//        String username = (String)token.getPrincipal();
//        System.out.println(token.getCredentials());
    	
    	// 将token转换成UsernamePasswordToken
    	UsernamePasswordToken upToken = (UsernamePasswordToken) token;
    	// 从转换后的token中获取登录名
    	String username = upToken.getUsername();
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            throw new UnknownAccountException();// 用户不存在
        }
        
        ByteSource salt = ByteSource.Util.bytes(userInfo.getCredentialsSalt());
        
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户
                userInfo.getPassword(), //密码
                salt,//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
