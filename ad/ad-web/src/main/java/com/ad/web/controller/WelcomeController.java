/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ad.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ad.dto.BoardDto;
import com.ad.dto.SearchCriteria;
import com.ad.dto.page.PageMaker;
import com.ad.web.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WelcomeController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		model.put("time", new Date());
		model.put("message", this.message);
		 List<BoardDto> list = boardService.boardListPage(scri);
		    ObjectMapper om = new ObjectMapper();
	         
	        // Map or List Object 를 JSON 문자열로 변환
	        String jsonStr = om.writeValueAsString(list);
	        System.out.println("object to json : " + jsonStr);

		model.put("boardList",jsonStr);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.boardListCount(scri));
		model.put("pageMaker", pageMaker);
		
		return "/welcome";
	}
	
//	@RequestMapping("/index")
//	public String welcome2(Map<String, Object> model) {
//		model.put("time", new Date());
//		model.put("message", this.message);
//		return "/index";
//	}
	
	@RequestMapping("/index")
	public ModelAndView index(Map<String, Object> model) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("contentPage", "board/boardList.jsp");
		mav.setViewName("/index");
		return mav;
	}
	
}
