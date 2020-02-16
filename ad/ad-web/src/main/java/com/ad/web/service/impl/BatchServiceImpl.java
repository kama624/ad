package com.ad.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.dto.BatchDto;
import com.ad.dto.SearchCriteria;
import com.ad.mapper.web.BatchMapper;
import com.ad.web.service.BatchService;

@Service("BatchService")
public class BatchServiceImpl implements BatchService {

	@Autowired
	BatchMapper batchMapper;
	
	@Override
	public List<BatchDto> selectBatchList(SearchCriteria scri) {
		
		return batchMapper.selectBatchList(scri);
	}

	@Override
	public int selectBatchListCount() {
		return batchMapper.selectBatchListCount();
	}

}
