package com.ad.mapper.batch;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestMapper {

	String selectMapper();
	
	int updateBoard();

}
