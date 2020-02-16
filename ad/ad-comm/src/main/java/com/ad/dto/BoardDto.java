package com.ad.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("boardDto")
public class BoardDto {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	public BoardDto(int bno, String title, String content, String writer, Date regdate) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}

	public BoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
