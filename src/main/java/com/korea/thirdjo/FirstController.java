package com.korea.thirdjo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.FirstDAO;
import vo.FirstVO;

@CrossOrigin(origins = "*")
@RestController
public class FirstController {
	
	@Autowired
	FirstDAO firstDAO;

	@GetMapping("/list")
	public List<FirstVO> firstCategory(){
		
		return firstDAO.firstList();
	}
	
}
