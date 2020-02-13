package com.ad.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.dto.AdDto;
import com.ad.dto.SearchCriteria;
import com.ad.web.mapper.AdMapper;
import com.ad.web.service.AdService;

@Service("AdService")
public class AdServiceImpl implements AdService {

	@Autowired
	private AdMapper adMapper;
	
	@Override
	public List<AdDto> selectAdUser(SearchCriteria cri) {
		return adMapper.selectAdUser(cri);
	}

	@Override
	public int insertAdUser(AdDto adDto) {
		int aa = 0; 
		aa = adMapper.insertAdUser(adDto);
		return aa;
	}

	@Override
	public int updateAdUser(AdDto adDto) {
		return adMapper.updateAdUser(adDto);
	}

	@Override
	public int deleteAdUser(AdDto adDto) {
		return adMapper.delereAdUser(adDto);
	}

	@Override
	public int selectAdUserCount() {
		return adMapper.selectAdUserCount();
	}

	@Override
	public AdDto readUserInfo(String id) {
		// TODO Auto-generated method stub
		return adMapper.readUserInfo(id);
	}

}
