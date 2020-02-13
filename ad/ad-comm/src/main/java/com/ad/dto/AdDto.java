package com.ad.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("AdDto")
public class AdDto {

	private String id;
	private String pw;
	private String grad;
	private String day;
}
