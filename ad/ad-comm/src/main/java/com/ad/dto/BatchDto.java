package com.ad.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("batchDto")
public class BatchDto {
	private int jobInstanceId;
	private int version;
	private String jobName;
	private String jobKey;	
}
