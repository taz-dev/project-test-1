package com.korea.thirdjo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.MemberDAO;
import vo.MemberVO;

@CrossOrigin(origins = "*")
@RestController
public class MemberController {

	@Autowired
	MemberDAO memberDAO;

	/*
	 * // 회원가입 get // 회원가입 폼으로 이동할 때
	 * 
	 * @GetMapping("/member/getRegister") public String getRegister( ) { return
	 * "/member/register"; }
	 */

	// 회원가입 post
	// 회원가입 버튼을 눌렀을 때 
	@GetMapping("/member/postRegister")
	public int postRegister(MemberVO vo) {

		return memberDAO.register(vo);
	}
	// 로그아웃 post

	// 로그인 post
	@PostMapping("/member/login")
	public MemberVO login(MemberVO vo) {

		return memberDAO.login(vo);
	}


	// 회원정보 수정 post
	@GetMapping("/member/updateview")
	public String registerUpdateView() throws Exception{

		return "member/memberUpdateView";
	}


	@PatchMapping("/member/memberUpdate")
	public String registerUpdate(MemberVO vo) throws Exception{
		return null;
	}

	//회원탈퇴

	@PostMapping("/member/memberDelete")
	public int memberDelete(int idx) {
		return memberDAO.memberDelete(idx);
	}
}
