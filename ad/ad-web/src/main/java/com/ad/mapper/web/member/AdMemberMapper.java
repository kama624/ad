package com.ad.mapper.web.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ad.dto.AdEnterpriseDto;
import com.ad.dto.AdMemberDto;
import com.ad.dto.SearchCriteria;

@Mapper
public interface AdMemberMapper {

//	// 게시물 페이징 목록 조회
//	public List<AdEnterpriseDto> selectAdEnterpriseList(SearchCriteria scri) throws Exception;
//	// 게시물 총 갯수
//	public int selectAdEnterpriseListCnt(SearchCriteria scri) throws Exception;
//	
//	public int updateAdEnterprise(AdEnterpriseDto adEnterpriseDto) throws Exception;
//	
	public int insertAdMember(AdMemberDto adMemberDto) throws Exception;
	public int insertAdEnterprise(AdEnterpriseDto adEnterpriseDto) throws Exception;
	public int insertUserMapping(Map<String, Object> mappingData) throws Exception;
}

