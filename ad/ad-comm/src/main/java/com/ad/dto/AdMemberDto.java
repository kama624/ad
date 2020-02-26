package com.ad.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("adMemberDto")
public class AdMemberDto {

	private String id;			//id
	private String pw;			//pw
	private String name;		//name
	private String tlphonNo;	//전화번호
	private String mbtlnum;		//휴대폰번호
	private String grad;		//등급
	private String atpt;		//주소(시도)
	private String guGun;		//주소(구군)
	private String detailAdres;	//상세주소
	private String useYn;		//이용여부
	
}
