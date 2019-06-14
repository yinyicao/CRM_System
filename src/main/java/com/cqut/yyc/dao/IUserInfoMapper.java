package com.cqut.yyc.dao;

import org.apache.ibatis.annotations.Param;

import com.cqut.yyc.dao.entity.UserInfo;

public interface IUserInfoMapper {
    //通过username查找用户角色信息
    UserInfo findByUsername(@Param("username") String username);
}