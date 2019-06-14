package com.cqut.yyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqut.yyc.dao.entity.SysPermission;

public interface ISysPermissionMapper {
    //根据角色ID查询角色对应的权限信息
    List<SysPermission> findPermissionByRoleId(@Param("roleId") Integer roleId);
    //查询所有权限信息-主要需要url和permission
    List<SysPermission> findAllPermission();
}