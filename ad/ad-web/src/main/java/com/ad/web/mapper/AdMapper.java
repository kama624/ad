package com.ad.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ad.dto.AdDto;
import com.ad.dto.SearchCriteria;

@Repository
@Mapper
public interface AdMapper {

	public List<AdDto> selectAdUser(SearchCriteria cri);
//	public List<AdDto> selectAllBoard();
	public int insertAdUser(AdDto adDto);
	public int updateAdUser(AdDto adDto);
	public int delereAdUser(AdDto adDto);
	public int selectAdUserCount();
	public AdDto readUserInfo(String id);
}
