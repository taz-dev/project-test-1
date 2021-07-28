package com.korea.thirdjo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.MemberDAO;
import vo.MemberVO;

@CrossOrigin(origins = "*")
@RestController
public class MemberController {
	
	@Autowired
	MemberDAO memberDAO;

	// 패스워드 체크
	@PostMapping("/member/passChk")
	public Map<String, Object> passChk(@RequestParam Map<String, Object> data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		return map;
	}

	// 아이디 중복 체크
	@PostMapping("/member/idChk")
	public Map<String, Object> idChk(@RequestParam Map<String, Object> data) {	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		return map; 
	}

	// 회원가입
	@GetMapping("/member/getregister")
	public String getRegister(HttpServletRequest request) throws Exception {
		return "member/register";
	}

	// 회원가입 post
	@PostMapping("/member/postregister")
	public String postRegister(MemberVO vo) {
		int result = memberDAO.idChk(vo);
		try {
			if(result == 1) {
				return "/member/register";
			}else if(result == 0) {
				String inputPass = vo.getPw();
				vo.setPw(inputPass);

				memberDAO.register(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	// 로그아웃 post
	@PostMapping("/member/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/";
	}

	// 로그인 post
	@PostMapping("/member/login")
	public MemberVO login(MemberVO vo) {
		
		return memberDAO.login(vo);
	}

	// json
	@ResponseBody
	@PostMapping("/member/getActiveUser")
	public Map<String, Object> getActiveUser(HttpSession session) throws Exception{
		boolean islogin = false; 
		Map<String, Object> map = new HashMap<String, Object>();

		MemberVO login = (MemberVO)session.getAttribute("member");
		//MemberVO login = service.login(v);

		if (login != null) { 
			islogin = true;
		} else {
			islogin = false;
		}

		map.put("islogin", islogin);
		if(islogin) {
			map.put("userid", login.getId());
		}
		return map;
	}

	// 회원정보 수정 post
	@RequestMapping(value="/memberUpdateView", method = RequestMethod.GET)
	public String registerUpdateView() throws Exception{

		return "member/memberUpdateView";
	}

	@PostMapping("/member/memberUpdate")
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception{

		memberDAO.memberUpdate(vo);

		session.invalidate();

		return "redirect:/";
	}

	// 회원 탈퇴 post
	@GetMapping("/member/memberDeleteView")
	public String memberDeleteView() throws Exception{
		return "member/memberDeleteView";
	}

	@PostMapping("/member/memberDelete")
	public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{

		// 세션에 있는 member를 가져와 member변수에 넣어줍니다.
		MemberVO member = (MemberVO) session.getAttribute("member");
		System.out.println(member);
		// 세션에있는 비밀번호
		String sessionPass = member.getPw();
		// vo로 들어오는 비밀번호
		String voPass = vo.getPw();

		memberDAO.memberDelete(vo);
		session.invalidate();
		return "redirect:/";
	}

}
