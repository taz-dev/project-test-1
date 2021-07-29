package com.korea.thirdjo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dao.LoginDAO;

@RestController
public class LoginController {

	@Autowired
	LoginDAO loginDao;
	
}
