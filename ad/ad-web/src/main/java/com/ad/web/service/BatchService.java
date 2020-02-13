package com.ad.web.service;

import java.util.List;

import com.ad.dto.BatchDto;
import com.ad.dto.SearchCriteria;

public interface BatchService {

	List<BatchDto> selectBatchList(SearchCriteria scri);
	int selectBatchListCount();

}
