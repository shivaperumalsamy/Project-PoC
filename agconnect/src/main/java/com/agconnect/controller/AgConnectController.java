package com.agconnect.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.agconnect.entity.Premise;
import com.agconnect.entity.User;
import com.agconnect.service.AgConnectServiceImpl;

@RestController
@RequestMapping("/agconnect")
public class AgConnectController {
	
	@Autowired
	AgConnectServiceImpl agService;
	
	@GetMapping("/index")
	public ModelAndView login(){
		List<User> userList= new ArrayList<User>();
		//userList = ags.getUsers();
		ModelAndView mv= new ModelAndView();
		mv.addObject("userList", userList);
		return mv;
	}
	
	@GetMapping("/get-premises")
	public List getPremises() {
		ModelAndView mav = new ModelAndView();
		List<Premise> premises= new ArrayList<Premise>();
		premises = agService.getPremises();
		mav.setViewName("display-premises");
		mav.addObject("premise-list",premises);
		return premises;
	}
	
}
