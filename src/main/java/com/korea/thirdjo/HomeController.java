package com.korea.thirdjo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import util.MyCommon;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String apiSpack() {
		
		return "apiSpack";
	}
}


