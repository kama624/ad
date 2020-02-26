package com.ad.mapper.web.enterprise;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ad.dto.AdEnterpriseDto;
import com.ad.dto.SearchCriteria;

@Mapper
public interface AdEnterpriseMapper {

	// 게시물 페이징 목록 조회
	public List<AdEnterpriseDto> selectAdEnterpriseList(SearchCriteria scri) throws Exception;
	// 게시물 총 갯수
	public int selectAdEnterpriseListCnt(SearchCriteria scri) throws Exception;
	
	public int updateAdEnterprise(AdEnterpriseDto adEnterpriseDto) throws Exception;
	
	public int insertAdEnterprise(AdEnterpriseDto adEnterpriseDto) throws Exception;
}

