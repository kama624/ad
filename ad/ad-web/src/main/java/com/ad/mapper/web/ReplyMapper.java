package com.ad.mapper.web;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ad.dto.ReplyDto;

@Mapper
public interface ReplyMapper {

	// 댓글리스트 조회
	public List<ReplyDto> readReplyList(int bno) throws Exception;
	// 댓글 작성
	public int insertReply(ReplyDto replyDto) throws Exception;
	// 댓글 수정
	public int updateReply(ReplyDto replyDto) throws Exception;
	// 댓글 삭제
	public int deleteReply(ReplyDto replyDto) throws Exception;
	// 댓글 조회
	public ReplyDto selectReyply(int rno) throws Exception;
	
}
