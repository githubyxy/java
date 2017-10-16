package com.effective.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.effective.dao.po.Customer;
import com.effective.service.IMyService;

@Controller
@RequestMapping(value = "/")
public class MyController {

	@Resource
	private IMyService myService;
	
	@RequestMapping(value = "/test" ,method = RequestMethod.GET)
	public String gotoPage(HttpServletRequest request){
		return "index";
	}
	
	@RequestMapping(value = "/getCustomer" ,method = RequestMethod.GET)
	public String getCustomer(Model model){
		Customer customer = myService.getCustomer();
		model.addAttribute("customer", customer);
		return "index";
	}
}
