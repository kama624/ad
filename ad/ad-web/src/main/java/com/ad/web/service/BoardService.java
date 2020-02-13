package com.ad.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ad.dto.BoardDto;
import com.ad.dto.SearchCriteria;

public interface BoardService {

	// 게시글 작성
	public void insertBoard(BoardDto boardDto, MultipartFile[] files) throws Exception;
	// 게시물 목록 조회
	public List<BoardDto> boardList() throws Exception;
	// 게시물 목록 조회
	public List<BoardDto> boardListPage(SearchCriteria scri) throws Exception;
	// 게시물 총 갯수
	public int boardListCount(SearchCriteria scri) throws Exception;
	// 게시물 목록 조회
	public BoardDto boardRead(BoardDto boardDto) throws Exception;
	// 게시물 수정
	public int boardUpdate(BoardDto boardDto, String[] files, String[] fileNames, MultipartFile[] multipartFiles) throws Exception;
	// 게시물 삭제
	public int boardDelete(BoardDto boardDto) throws Exception;
	// 첨부파일 조회
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	// 첨부파일 다운'
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
}
