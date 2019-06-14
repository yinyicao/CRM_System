package com.cqut.yyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqut.yyc.dao.entity.SysRole;

public interface ISysRoleMapper {
    //通过username查找用户角色信息
    List<SysRole> findRoleByUsername(@Param("username") String username);
}