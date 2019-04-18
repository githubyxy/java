package com.effective.service.transaction;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.effective.dao.mapper.gen.KvMapper;
import com.effective.dao.po.Kv;

@Service
public class KvServiceImpl implements IKvService {

	@Resource
	private KvMapper kvMapper;
	
	@Override
	public void insert() {
		Kv kv = new Kv();
		kv.setK("yxy");
		kvMapper.insertSelective(kv);
		
		int a = 0;
		int i = 1/a;
	}

}
