package com.effective.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.effective.service.transaction.IKvService;
import com.effective.service.transaction.KvTestServiceImpl;

@Controller
@RequestMapping(value = "/")
public class MyController {

	@Resource
	private IKvService kvService;
	@Resource
	private KvTestServiceImpl kvTestServiceImpl;
	
	@RequestMapping(value = "/kvInsert" ,method = RequestMethod.GET)
	public String kvInsert(HttpServletRequest request){
		kvTestServiceImpl.insert();
		return "kv";
	}
	
	@RequestMapping(value = "/gotoKv" ,method = RequestMethod.GET)
	public String gotoPage(HttpServletRequest request){
		kvService.insert();
		return "kv";
	}
	@RequestMapping(value = "/session/op" ,method = RequestMethod.GET)
	public String op(HttpServletRequest request) throws Exception{
		
		kvService.insert2();
		
		return "kv";
	}
	
}
