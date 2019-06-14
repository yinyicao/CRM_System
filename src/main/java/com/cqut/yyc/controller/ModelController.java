package com.cqut.yyc.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cqut.yyc.vo.ResponseMessageBase;


@RestController
//@CrossOrigin
public class ModelController {

	@RequestMapping("/home/{service}/{method}")
	public ResponseMessageBase home(@PathVariable(value = "service") String serviceName,
			@PathVariable(value = "method") String methodName, @RequestBody String json, 
			HttpServletRequest request) {
		System.err.println("ModelController--->"+request.getSession().getAttribute("loginname"));
		return MsgProcessor.process(serviceName, methodName, json, request.getSession());
	}

}