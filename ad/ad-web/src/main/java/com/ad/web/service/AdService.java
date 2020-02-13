package com.ad.web.service;

import java.util.List;

import com.ad.dto.AdDto;
import com.ad.dto.SearchCriteria;

public interface AdService {

	List<AdDto> selectAdUser(SearchCriteria cri);

	int insertAdUser(AdDto adDto) throws Exception;

	int updateAdUser(AdDto adDto);

	int deleteAdUser(AdDto adDto);

	int selectAdUserCount();

	AdDto readUserInfo(String id);

}
