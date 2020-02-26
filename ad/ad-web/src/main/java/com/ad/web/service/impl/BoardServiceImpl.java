package com.ad.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ad.dto.BoardDto;
import com.ad.dto.SearchCriteria;
import com.ad.mapper.web.BoardMapper;
import com.ad.web.service.BoardService;
import com.commons.FileUtils;

@Service("BoradService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;

	@Override
	public void insertBoard(BoardDto boardDto, MultipartFile[] files) throws Exception {
		
		mapper.insertBoard(boardDto);

		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(boardDto, files); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			mapper.insertFile(list.get(i)); 
		}
		
	}
	
	// 게시물 목록 조회
	@Override
	public List<BoardDto> boardList() throws Exception {
		return mapper.boardList();
	}
	// 게시물 목록 조회
	@Override
	public List<BoardDto> boardListPage(SearchCriteria scri) throws Exception {
		return mapper.boardListPage(scri);
	}
	// 게시물 목록 조회
	@Override
	public List<BoardDto> boardListPage2(SearchCriteria scri) throws Exception {
		return mapper.boardListPage2(scri);
	}
	
	// 게시물 총 갯수
	@Override
	public int boardListCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return mapper.boardListCount(scri);
	}
	
	// 게시물 조회
	@Override
	public BoardDto boardRead(BoardDto boardDto) throws Exception {
		return mapper.boardRead(boardDto);
	}
	// 게시물 수정
	@Override
	public int boardUpdate(BoardDto boardDto, String[] files, String[] fileNames, MultipartFile[] multipartFiles) throws Exception {
		
		int cnt = mapper.boardUpdate(boardDto);
		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(boardDto, files, fileNames, multipartFiles);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				mapper.insertFile(tempMap);
			}else {
				mapper.updateFile(tempMap);
			}
		}
		return cnt;
	}

	// 게시물 삭제
	@Override
	public int boardDelete(BoardDto boardDto) throws Exception {
		return mapper.boardDelete(boardDto);
	}

	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		return mapper.selectFileList(bno);
	}
	
	// 첨부파일 다운로드
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return mapper.selectFileInfo(map);
	}	
	
//	===========================================================================================
	@Override
	public int boardUpdate2(BoardDto boardDto, SearchCriteria scri) throws Exception{
		int cnt = mapper.boardUpdate2(boardDto);
		return cnt;
	}
}
