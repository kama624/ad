package com.ad.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("adEnterpriseDto")
public class AdEnterpriseDto {

	private String advrtsEntrpsId;		//광고업체id
	private String advrtsEntrpsNm;		//광고업체명
	private String rprsntvNm;			//광고대표자명
	private String advrtsEntrpsBizrno;	//점포사업자번호
	private String entrpsTlphonNo;		//업체전화번호
	private String entrpsMbtlnum;		//업체휴대폰번호
	private String entrpsAtpt;			//업체주소(시도)
	private String entrpsGuGun;			//업체주소(구군)
	private String entrpsDetailAdres;	//업체상세주소
	private String qrFileId;			//파일id
	private String status;				//상태
	private String useYn;				//이용여부
//	//임시
//	private String beginDate;
//	private String endDate;
//	private String rcpmnyDate;
//	private String rcpmnyer;
//	private String cntrctAmount;
//	//삭제예정
//	private String tlphonNo;//	전화번호1
//	private String mbtlnum;//	휴대폰번호1
//	private String atpt;//	광고업체주소(시도)
//	private String guGun;//	광고업체주소(구군)
//	private String detailAdres;//	광고업체상세주소
}
