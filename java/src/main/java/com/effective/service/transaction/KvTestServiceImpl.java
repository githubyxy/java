package com.effective.service.transaction;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.effective.dao.mapper.gen.KvMapper;
import com.effective.dao.po.Kv;

@Service
public class KvTestServiceImpl {

    @Resource
    private KvMapper kvMapper;

    public void insert() {
        Kv kv = new Kv();
        kv.setK("yxy");
        kvMapper.insertSelective(kv);

        System.err.println(1 / 0);
    }

}
