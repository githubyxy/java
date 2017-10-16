package com.effective.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.effective.dao.mapper.gen.CustomerMapper;
import com.effective.dao.po.Customer;
import com.effective.service.IMyService;

@Service
public class MyserviceImpl implements IMyService {

	@Resource
	private CustomerMapper customerMapper;
	
	@Override
	public Customer getCustomer() {
		Customer customer = customerMapper.selectByPrimaryKey(1);
		return customer;
	}

}
