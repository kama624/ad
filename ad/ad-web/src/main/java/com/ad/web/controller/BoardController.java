package com.ad.web.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ad.dto.BoardDto;
import com.ad.dto.ReplyDto;
import com.ad.dto.SearchCriteria;
import com.ad.dto.page.PageMaker;
import com.ad.web.service.BoardService;
import com.ad.web.service.ReplyService;

@RestController
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	ReplyService replyService;
	
	// 게시판 글 작성 화면
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public ModelAndView writeView() throws Exception{
		ModelAndView mvc = new ModelAndView();
		mvc.setViewName("/board/writeView");
		return mvc;
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public ModelAndView write(BoardDto boardDto
			, @ModelAttribute("scri") SearchCriteria scri
			, @RequestPart("fileUpload") MultipartFile[] files) throws Exception{
		boardService.insertBoard(boardDto, files);
		
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("bno", boardDto.getBno());
		mvc.addObject("page", scri.getPage());
		mvc.addObject("perPageNum", scri.getPerPageNum());
		mvc.addObject("searchType", scri.getSearchType());
		mvc.addObject("keyword", scri.getKeyword());
		mvc.addObject("scri", scri);
		mvc.setViewName("redirect:boardList");
		
		return mvc;
	}
	
	// 게시판 목록 조회
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView list(@ModelAttribute("scri") SearchCriteria scri) throws Exception{
		ModelAndView mvc = new ModelAndView();
//		mvc.addObject("boardList",boardService.boardList());
		mvc.addObject("boardList",boardService.boardListPage(scri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.boardListCount(scri));
		mvc.addObject("pageMaker", pageMaker);
		
		mvc.setViewName("/board/boardList");
		return mvc;
	}
	
	// 게시판 조회
	@RequestMapping(value = "/boardReadView", method = RequestMethod.GET)
	public ModelAndView read(BoardDto boardDto, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("boardRead", boardService.boardRead(boardDto));
		mvc.addObject("scri", scri);
		
		mvc.addObject("replyList", replyService.readReplyList(boardDto.getBno()));
		List<Map<String, Object>> fileList = boardService.selectFileList(boardDto.getBno());
		mvc.addObject("file", fileList);
		
		mvc.setViewName("/board/boardReadView");
		return mvc;
	}
	
	// 게시판 수정뷰
	@RequestMapping(value = "/boardUpdateView", method = RequestMethod.GET)
	public ModelAndView boardUpdateView(BoardDto boardDto, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("boardRead", boardService.boardRead(boardDto));
		mvc.addObject("scri", scri);
		List<Map<String, Object>> fileList = boardService.selectFileList(boardDto.getBno());
		mvc.addObject("file", fileList);
		mvc.setViewName("/board/boardUpdateView");
		return mvc;
	}
	
	// 게시판 수정
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardDto boardDto, @ModelAttribute("scri") SearchCriteria scri
			, @RequestParam(value="fileNoDel[]") String[] files
			, @RequestParam(value="fileNameDel[]") String[] fileNames
			, @RequestPart("fileUpload") MultipartFile[] multipartFiles) throws Exception{
		ModelAndView mvc = new ModelAndView();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(multipartFiles);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		mvc.addObject("boardUpdate", boardService.boardUpdate(boardDto, files, fileNames, multipartFiles));
		mvc.addObject("page", scri.getPage());
		mvc.addObject("perPageNum", scri.getPerPageNum());
		mvc.addObject("searchType", scri.getSearchType());
		mvc.addObject("keyword", scri.getKeyword());
		mvc.addObject("scri", scri);
		mvc.setViewName("redirect:boardList");
		return mvc;
	}

	// 게시판 삭제
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public ModelAndView boardDelete(BoardDto boardDto, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("boardUpdate", boardService.boardDelete(boardDto));
		
		mvc.addObject("page", scri.getPage());
		mvc.addObject("perPageNum", scri.getPerPageNum());
		mvc.addObject("searchType", scri.getSearchType());
		mvc.addObject("keyword", scri.getKeyword());
		mvc.addObject("scri", scri);
		
		mvc.setViewName("redirect:boardList");
		return mvc;
	}
	
	//댓글 작성
	@RequestMapping(value="/replyInsert", method = RequestMethod.POST)
	public ModelAndView replyInsert(ReplyDto replyDto, SearchCriteria scri) throws Exception {
		ModelAndView mvc = new ModelAndView();
		replyService.insertReply(replyDto);
		
		mvc.addObject("bno", replyDto.getBno());
		mvc.addObject("page", scri.getPage());
		mvc.addObject("perPageNum", scri.getPerPageNum());
		mvc.addObject("searchType", scri.getSearchType());
		mvc.addObject("keyword", scri.getKeyword());
		mvc.addObject("scri", scri);
		
		mvc.setViewName("redirect:boardReadView");
		return mvc;
	}
	
	//댓글 수정 GET
	@RequestMapping(value="/replyUpdateView", method = RequestMethod.GET)
	public ModelAndView replyUpdateView(ReplyDto replyDto, SearchCriteria scri) throws Exception {
		ModelAndView mvc = new ModelAndView();
		
		mvc.addObject("replyUpdate", replyService.selectReyply(replyDto.getRno()));
		mvc.addObject("scri", scri);
		mvc.setViewName("/board/replyUpdateView");
		
		return mvc;
	}
	
	//댓글 수정 POST
	@RequestMapping(value="/replyUpdate", method = RequestMethod.POST)
	public ModelAndView replyUpdate(ReplyDto replyDto, SearchCriteria scri) throws Exception {
		ModelAndView mvc = new ModelAndView();
		
		replyService.updateReply(replyDto);
		
		mvc.addObject("bno", replyDto.getBno());
		mvc.addObject("page", scri.getPage());
		mvc.addObject("perPageNum", scri.getPerPageNum());
		mvc.addObject("searchType", scri.getSearchType());
		mvc.addObject("keyword", scri.getKeyword());
		mvc.addObject("scri", scri);
		mvc.setViewName("redirect:boardReadView");
		
		return mvc;
	}
 

	//댓글 삭제 GET
	@RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
	public ModelAndView replyDeleteView(ReplyDto replyDto, SearchCriteria scri) throws Exception {
		ModelAndView mvc = new ModelAndView();
		
		mvc.addObject("replyDelete", replyService.selectReyply(replyDto.getRno()));
		mvc.addObject("scri", scri);
		mvc.setViewName("/board/replyDeleteView");

		return mvc;
	}
	
	//댓글 삭제
	@RequestMapping(value="/replyDelete", method = RequestMethod.POST)
	public ModelAndView replyDelete(ReplyDto replyDto, SearchCriteria scri) throws Exception {
		ModelAndView mvc = new ModelAndView();
		replyService.deleteReply(replyDto);
		
		mvc.addObject("bno", replyDto.getBno());
		mvc.addObject("page", scri.getPage());
		mvc.addObject("perPageNum", scri.getPerPageNum());
		mvc.addObject("searchType", scri.getSearchType());
		mvc.addObject("keyword", scri.getKeyword());
		mvc.addObject("scri", scri);
		mvc.setViewName("redirect:boardReadView");
		return mvc;
	}
	
	@RequestMapping(value="/fileDown")
	public void fileDown(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
		Map<String, Object> resultMap = boardService.selectFileInfo(map);
		String storedFileName = (String) resultMap.get("STORED_FILE_NAME");
		String originalFileName = (String) resultMap.get("ORG_FILE_NAME");
		
		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\project\\workspace\\file"+storedFileName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}

	 
}
