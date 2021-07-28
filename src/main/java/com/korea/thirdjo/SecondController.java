package com.korea.thirdjo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.SecondDAO;
import vo.SecondVO;


@CrossOrigin(origins = "*")
@RestController
public class SecondController {

	@Autowired
	SecondDAO secondDAO;
	
	@GetMapping("/secondlist") //홈화면 다음 리스트
	public List<SecondVO> secondCategory(int first_idx){

		return secondDAO.secondList(first_idx);
	}

}