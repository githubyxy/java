package com.effective.service.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
		try {
			int a = 0;
			int i = 1/a;
		} catch (Exception e) {
			System.out.println("手动回滚事务");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
	}

	@Override
	public void insert2() {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring/spring-mybatis.xml");
//		SqlSessionFactoryBean sqlSessionFactory = (SqlSessionFactoryBean) context.getBean("sqlSessionFactory");
		DefaultSqlSessionFactory sqlSessionFactory = (DefaultSqlSessionFactory) context.getBean("sqlSessionFactory");
		
//		SqlSessionFactory sessionFactory = sqlSessionFactory.getObject();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		Connection connection = openSession.getConnection();
		try {
			System.out.println(connection.getAutoCommit());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		connection.setAutoCommit(false);
		
		Kv kv = new Kv();
		kv.setK("yxy");
		openSession.insert("com.effective.dao.mapper.gen.KvMapper.insertSelective", kv);
		
		int a = 0;
		int i = 1/a;
		
	}

}
