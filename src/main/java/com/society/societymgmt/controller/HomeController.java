package com.society.societymgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping("/")
	public String gethome() {
		
		return "This is home page";	
	}
	
}
