package com.hlm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hlm.bo.User;
import com.hlm.service.UserService;

@Controller
@RequestMapping("/user")
public class HlmUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/count")
	public ModelAndView userCount(HttpServletRequest req ,HttpServletResponse resp){
		
		ModelAndView mv = new ModelAndView();
		int count = userService.countUser();
		List< User> list = userService.findAllUser();
		mv.addObject("count", count);
		mv.addObject("list", list);
		mv.setViewName("/usercount");
		return mv;
	}

}
