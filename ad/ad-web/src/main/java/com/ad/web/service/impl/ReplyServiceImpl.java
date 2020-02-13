package com.ad.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.dto.ReplyDto;
import com.ad.web.mapper.ReplyMapper;
import com.ad.web.service.ReplyService;

@Service("ReplyService")
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public List<ReplyDto> readReplyList(int bno) throws Exception {
		return mapper.readReplyList(bno);
	}

	@Override
	public int insertReply(ReplyDto replyDto) throws Exception {
		return mapper.insertReply(replyDto);
	}

	@Override
	public int updateReply(ReplyDto replyDto) throws Exception {
		return mapper.updateReply(replyDto);
	}

	@Override
	public int deleteReply(ReplyDto replyDto) throws Exception {
		return mapper.deleteReply(replyDto);
	}

	@Override
	public ReplyDto selectReyply(int rno) throws Exception {
		return mapper.selectReyply(rno);
	}

}
