package com.ad.web.enterprise.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.dto.AdEnterpriseDto;
import com.ad.dto.AdMemberDto;
import com.ad.dto.SearchCriteria;
import com.ad.mapper.web.enterprise.AdEnterpriseMapper;
import com.ad.web.enterprise.service.AdEnterpriseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("AdEnterpriseService")
public class AdEnterpriseServiceImpl implements AdEnterpriseService {

	@Autowired
	AdEnterpriseMapper adEnterpriseMapper; 
	
	@Override
	public List<AdEnterpriseDto> selectAdEnterpriseList(SearchCriteria scri) throws Exception {
		return adEnterpriseMapper.selectAdEnterpriseList(scri);
	}

	@Override
	public int selectAdEnterpriseListCnt(SearchCriteria scri) throws Exception {
		return adEnterpriseMapper.selectAdEnterpriseListCnt(scri);
	}
	
	@Override
	public int updateAdEnterprise(AdEnterpriseDto adEnterpriseDto) throws Exception{
		int cnt = adEnterpriseMapper.updateAdEnterprise(adEnterpriseDto);
		return cnt;
	}
	
	@Override
	public int insertAdEnterprise(AdEnterpriseDto adEnterpriseDto, SearchCriteria scri) throws Exception {
		System.out.println("insertAdEnterprise(AdEnterpr    ======================= "   + adEnterpriseDto.toString());
		int cnt = adEnterpriseMapper.insertAdEnterprise(adEnterpriseDto);
		return cnt;
	}

	@Override
	public int insertAdEnterprise2(Map<String, Object> data)  throws Exception {
		
		int cnt = 0;
		ObjectMapper mapper = new ObjectMapper();
		//1. 광고업체 리스트  convert
		List<AdEnterpriseDto> gridData =  mapper.convertValue(data.get("gridData"), new TypeReference<List<AdEnterpriseDto>>() {});
		
		//2. 광고업체등록  및 수정
		for(AdEnterpriseDto adEnterpriseDto : gridData) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@AdEnterpriseDto"+adEnterpriseDto.toString());
			String status = adEnterpriseDto.getStatus();
			if(status.equals("I")) {
				//2-1 업체정보 등록
				cnt += adEnterpriseMapper.insertAdEnterprise(adEnterpriseDto);
			}else if(status.equals("U")) {
				//2-2 업체정보 수정
				cnt += adEnterpriseMapper.updateAdEnterprise(adEnterpriseDto);
			}
		}
		return cnt;
	}
}
