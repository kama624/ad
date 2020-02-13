package com.ad.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ad.dto.BatchDto;
import com.ad.dto.SearchCriteria;
import com.ad.dto.page.PageMaker;
import com.ad.web.service.BatchService;

@RestController
@RequestMapping("/batch/*")
public class BatchController {

	@Autowired
	BatchService batchService;
	
	@RequestMapping(value = "/batchList", method = RequestMethod.GET)
	public ModelAndView batchList(BatchDto batchDto, @ModelAttribute("scri") SearchCriteria scri) {
		ModelAndView mav = new ModelAndView();

		List<BatchDto> batchList = batchService.selectBatchList(scri);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(batchService.selectBatchListCount());
		
		mav.addObject("pageMaker", pageMaker);
        mav.addObject("batchList",batchList);
        mav.setViewName("/batch/batchList"); //뷰의 이름
        
        return mav;
	}
}
