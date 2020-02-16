package com.ad.mapper.batch;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class TestMapper3 {

	@Autowired
	@Qualifier("sqlSession")
	@Resource(name = "sqlSession")
	SqlSessionTemplate sqlSession;
	
	public List<Object> selectMapper() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@selectMapper@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return sqlSession.selectList("com.ad.mapper.batch.TestMapper.selectMapper");
	}
	
}
