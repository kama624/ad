package com.ad.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ad.dto.AdDto;
import com.ad.dto.SearchCriteria;
import com.ad.dto.page.PageMaker;
import com.ad.web.service.AdService;

@RestController
public class adController {

	@Autowired
	private AdService adService;
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
    public ModelAndView userList(AdDto adDto, @ModelAttribute("scri") SearchCriteria scri) {
		ModelAndView mav = new ModelAndView();

		List<AdDto> adUserList = adService.selectAdUser(scri);

		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(adService.selectAdUserCount());
		
		mav.addObject("pageMaker", pageMaker);
        mav.addObject("adUserList",adUserList);
        
        mav.setViewName("ad/adUserList"); //뷰의 이름
        
        return mav;
    }
	
	// 게시판 조회
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public ModelAndView read(AdDto adDto, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("read", adService.readUserInfo(adDto.getId()));
		mav.addObject("scri", scri);
		mav.setViewName("ad/readView"); //뷰의 이름
		return mav;
	}
	
	@RequestMapping(value = "/userInsertView", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public ModelAndView userInsertView(AdDto adDto) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ad/adUserInsert"); //뷰의 이름
		return mav;
	}
	
	@RequestMapping(value = "/userInsert", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public ModelAndView userInsert(AdDto adDto) throws Exception {
		ModelAndView mav = new ModelAndView();
		int successCnt = adService.insertAdUser(adDto);
		//todo successCnt로 성공 실패를 확인
		mav.setViewName("ad/adUserList"); //뷰의 이름
		mav.addObject("successCnt", successCnt);
		return mav;
	}
	@RequestMapping(value = "/userUpdate", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public ModelAndView userUpdate(AdDto adDto) {
		ModelAndView mav = new ModelAndView();
		
		int successCnt = adService.updateAdUser(adDto);
		
		mav.setViewName("ad/adUserUpdate"); //뷰의 이름
		mav.addObject("successCnt", successCnt);
		
		return mav;
	}
	
	@RequestMapping(value = "/userDelete", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public ModelAndView userDelete(AdDto adDto) {
		ModelAndView mav = new ModelAndView();
		
		int successCnt = adService.deleteAdUser(adDto);
		
		mav.setViewName("ad/adUserDelerte"); //뷰의 이름
		mav.addObject("successCnt", successCnt);
		
		return mav;
	}
	
	/*
	 * @RequestMapping(value = "/hello", method = RequestMethod.POST, produces =
	 * "application/json; charset=utf8") public ModelAndView hello(ModelAndView mav)
	 * {
	 * 
	 * //application.properties에서 view의 prefix, suffix 설정함 ///WEB-INF/views/뷰이름.jsp
	 * mav.setViewName("helloSpring"); //뷰의 이름
	 * 
	 * mav.addObject("message","스프링 부트 애플리케이션");
	 * 
	 * return mav; }
	 */
}
