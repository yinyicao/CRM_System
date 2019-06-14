package com.cqut.yyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqut.yyc.dao.entity.Contact;

public interface IContactMapper {
	Integer addContact(Contact cus);
	List<Contact> selectContactsByCusNo(@Param("cusNo")String cusNo);
	Integer deleteContact(@Param("ctId")Integer ctId);
}
