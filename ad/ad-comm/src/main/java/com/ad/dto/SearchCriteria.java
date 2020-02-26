package com.ad.dto;

import org.apache.ibatis.type.Alias;

import com.ad.dto.page.Criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("searchCriteria")
public class SearchCriteria extends Criteria{
	private String searchType;
	private String keyword;
	private String iu;
	

	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
}
