package com.ad.web.enterprise.service;

import java.util.List;
import java.util.Map;

import com.ad.dto.AdEnterpriseDto;
import com.ad.dto.SearchCriteria;

public interface AdEnterpriseService {
	
	//광고업체리스트조회
	List<AdEnterpriseDto> selectAdEnterpriseList(SearchCriteria scri)throws Exception;
	// 광고업체리스트 총 갯수
	public int selectAdEnterpriseListCnt(SearchCriteria scri) throws Exception;
	public int insertAdEnterprise(AdEnterpriseDto adEnterpriseDto, SearchCriteria scri) throws Exception;
	public int updateAdEnterprise(AdEnterpriseDto adEnterpriseDto) throws Exception;
	int insertAdEnterprise2(Map<String, Object> data) throws Exception;
}
