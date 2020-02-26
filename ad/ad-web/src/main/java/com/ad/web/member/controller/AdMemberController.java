package com.ad.web.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ad.dto.AdEnterpriseDto;
import com.ad.dto.AdMemberDto;
import com.ad.web.member.service.AdMemberService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/member/*")
public class AdMemberController {

	@Autowired
	private AdMemberService adMemberService;
	@Autowired 
	private ModelMapper modelMapper;
	
	@RequestMapping(value = "/adMemberView", method = RequestMethod.GET)
	public ModelAndView adMemberView(Map<String, Object> model) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ad/member/adMemberView");
		return mav;
	}
	
	@RequestMapping(value = "/adMemberCreate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> adMemberCreate(@RequestBody Map<String, Object> data) throws Exception{
		int cnt = adMemberService.addMember(data);
		Map resultMap = new HashMap<>();
		resultMap.put("success", cnt);
		resultMap.put("msg", cnt >= 0 ? "저장되었습니다." : "저장에 실패하였습니다." );
		return resultMap;
	}
	
	@RequestMapping(value = "/adMemberCreate2", method = RequestMethod.GET)
	public ModelAndView adMemberCreate2(Map<String, Object> model) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ad/member/adMemberCreate");
		return mav;
	}
}
