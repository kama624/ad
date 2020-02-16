package com.ad.mapper.batch;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

	String selectMapper();
	
	int updateBoard();

}
