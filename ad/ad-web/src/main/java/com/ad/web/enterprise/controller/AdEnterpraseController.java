package com.ad.web.enterprise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ad.dto.AdEnterpriseDto;
import com.ad.dto.BoardDto;
import com.ad.dto.SearchCriteria;
import com.ad.dto.page.PageMaker;
import com.ad.web.enterprise.service.AdEnterpriseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/enterprise/*")
public class AdEnterpraseController {

	@Autowired
	private AdEnterpriseService adEnterpriseService;
	
	// 게시판 목록 조회
	@RequestMapping(value = "/adEnterpriseList", method = RequestMethod.GET)
	public ModelAndView enterpriseList(@ModelAttribute("scri") SearchCriteria scri) throws Exception{
		ModelAndView mvc = new ModelAndView();
		List<AdEnterpriseDto> list = adEnterpriseService.selectAdEnterpriseList(scri);
	    ObjectMapper om = new ObjectMapper();
        // Map or List Object 를 JSON 문자열로 변환
        String jsonStr = om.writeValueAsString(list);
        mvc.addObject("enterpriseList",jsonStr);
        
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(adEnterpriseService.selectAdEnterpriseListCnt(scri));
		mvc.addObject("pageMaker", pageMaker);
		
		mvc.setViewName("ad/enterprise/adEnterpriseList");
		return mvc;
	}
	
	@RequestMapping(value = "/updateAdEnterprise", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateAdEnterprise(String iu, AdEnterpriseDto adEnterpriseDto, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		Map resultMap = new HashMap<>();
		int cnt = 0;
		cnt = adEnterpriseService.insertAdEnterprise(adEnterpriseDto, scri);
		resultMap.put("boardUpdate", cnt);
		resultMap.put("msg", cnt >= 0 ? "저장되었습니다." : "저장에 실패하였습니다." );
		return resultMap;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 게시판 목록 조회
	@RequestMapping(value = "/adEnterpriseList2", method = RequestMethod.GET)
	public ModelAndView adEnterpriseList2(@ModelAttribute("scri") SearchCriteria scri) throws Exception{
		ModelAndView mvc = new ModelAndView();
		List<AdEnterpriseDto> list = adEnterpriseService.selectAdEnterpriseList(scri);
	    ObjectMapper om = new ObjectMapper();
        // Map or List Object 를 JSON 문자열로 변환
        String jsonStr = om.writeValueAsString(list);
        mvc.addObject("enterpriseList",jsonStr);
        
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(adEnterpriseService.selectAdEnterpriseListCnt(scri));
		mvc.addObject("pageMaker", pageMaker);
		
		mvc.setViewName("ad/enterprise/adEnterpriseList2");
		return mvc;
	}
	
	
	@RequestMapping(value = "/updateAdEnterprise2", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateAdEnterprise2(@RequestBody Map<String, Object> data) throws Exception{
		int cnt = adEnterpriseService.insertAdEnterprise2(data);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+cnt);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+cnt);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+cnt);
		Map resultMap = new HashMap<>();
		resultMap.put("success", cnt);
		resultMap.put("msg", cnt >= 0 ? cnt+"건 저장되었습니다." : "저장에 실패하였습니다." );
		return resultMap;
	}
}
