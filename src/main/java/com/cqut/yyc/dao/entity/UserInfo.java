package com.cqut.yyc.dao.entity;

import java.io.Serializable;

public class UserInfo implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(implements Serializable以实现通过Ecache使用“记住我”)   
	 */   
	private static final long serialVersionUID = -429496302208889298L;
	Integer uid;//用户id
    String username;//帐号
    String name;
    String password;
    String salt;
    byte state;
    /**
     * 
     * @Title: getCredentialsSalt   
     * @Description: TODO(密码盐)   
     * @param: @return      
     * @return: String      
     * @throws
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", salt=" + salt + ", state=" + state + "]";
	}
    
    
}
