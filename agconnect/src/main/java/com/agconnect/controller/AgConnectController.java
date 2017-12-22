package com.agconnect.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.agconnect.entity.User;
import com.agconnect.service.AgConnectService;

@RestController
@RequestMapping("/agconnect")
public class AgConnectController {
	
	@Autowired
	AgConnectService ags;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView login(){
		List<User> userList= new ArrayList<User>();
		userList = ags.getUsers();
		ModelAndView mv= new ModelAndView();
		mv.addObject("userList", userList);
		return mv;
	}
	
}
