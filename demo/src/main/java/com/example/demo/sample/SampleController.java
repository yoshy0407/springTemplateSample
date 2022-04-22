package com.example.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.template.annotation.Paging;
import com.example.demo.template.paging.Page;

@Controller
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	SampleService sampleService;
	
	@GetMapping("index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("list");
		mav.addObject("init", true);
		return mav;
	}

	@GetMapping("list")
	public ModelAndView index(String name, @Paging(requestAttr = "pageNo") Page page, ModelAndView mav) {
		mav.addObject("list", sampleService.selectList(name, page));
		mav.setViewName("list");
		return mav;
	}
}
