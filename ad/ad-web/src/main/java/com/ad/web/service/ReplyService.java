package com.ad.web.service;

import java.util.List;

import com.ad.dto.BoardDto;
import com.ad.dto.ReplyDto;

public interface ReplyService {

	// 댓글 조회
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
