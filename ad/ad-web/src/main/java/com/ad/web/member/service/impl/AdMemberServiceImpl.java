package com.ad.web.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.dto.AdEnterpriseDto;
import com.ad.dto.AdMemberDto;
import com.ad.mapper.web.member.AdMemberMapper;
import com.ad.web.member.service.AdMemberService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Service("AdMemberService")
public class AdMemberServiceImpl implements AdMemberService {

	@Autowired
	private AdMemberMapper adMemberMapper;
//	@Autowired 
//	private ModelMapper modelMapper;
	
	@Override
	public int addMember(Map<String, Object> data) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		AdMemberDto adMemberDto = mapper.convertValue(data.get("userData"), AdMemberDto.class);
		System.out.println("@@@@@@@@@@@@@@@adMemberDto@@@@@@@@@@@@@@@@"+adMemberDto.toString());
		List<AdEnterpriseDto> gridData = mapper.convertValue(data.get("gridData"), new TypeReference<List<AdEnterpriseDto>>() {});
		
		//1. 회원등록
		adMemberMapper.insertAdMember(adMemberDto);
		
		//2. 광고업체등록 
		for(AdEnterpriseDto dto : gridData) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@AdEnterpriseDto"+dto.toString());
//			AdEnterpriseDto adEnterpriseDto = modelMapper.map(dto.toString(), AdEnterpriseDto.class);
			//2-1 업체정보 등록
			adMemberMapper.insertAdEnterprise(dto);
			//2-2 사용자와 업체를 맵핑한다.
			Map<String, Object> mappingData = new HashMap<String, Object>();
			mappingData.put("id", adMemberDto.getId());
			mappingData.put("advrtsEntrpsId", dto.getAdvrtsEntrpsId());
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@id"+mappingData.get("id"));
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@advrtsEntrpsId"+mappingData.get("advrtsEntrpsId"));
			adMemberMapper.insertUserMapping(mappingData);
		}
		
		return 0;
	}

}
