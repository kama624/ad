package com.ad.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ad.dto.BoardDto;
import com.ad.dto.SearchCriteria;

@Mapper
public interface BoardMapper {

	// 게시글 작성
	public int insertBoard(BoardDto boardDto) throws Exception;
	// 게시물 목록 조회
	public List<BoardDto> boardList() throws Exception;
	// 게시물 페이징 목록 조회
	public List<BoardDto> boardListPage(SearchCriteria scri) throws Exception;
	// 게시물 총 갯수
	public int boardListCount(SearchCriteria scri) throws Exception;
	// 게시물 조회
	public BoardDto boardRead(BoardDto boardDto) throws Exception;
	// 게시물 수정
	public int boardUpdate(BoardDto boardDto) throws Exception;
	// 게시물 삭제
	public int boardDelete(BoardDto boardDto) throws Exception;
	// 파일 등록
	public void insertFile(Map<String, Object> map) throws Exception;
	// 파일 조회
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	// 첨부파일 다운
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;	
	// 첨부파일 수정
	public void updateFile(Map<String, Object> map) throws Exception;
}
