package com.ad.mapper.web;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ad.dto.BatchDto;
import com.ad.dto.SearchCriteria;

@Mapper
public interface BatchMapper {

	List<BatchDto> selectBatchList(SearchCriteria scri);
	public int selectBatchListCount();
}
