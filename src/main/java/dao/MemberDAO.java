package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	//회원가입
	public void register(MemberVO vo) {
		sqlsession.insert("m.register", vo);
	}
	
	// 로그인 memberLogin
	public MemberVO login(MemberVO vo) {
		return sqlsession.selectOne("m.login", vo);
	}
	
	// 회원정보 수정 memberUpdate
	public void memberUpdate(MemberVO vo) {
		sqlsession.update("m.memberUpdate", vo);
	}
	
	// 회원탈퇴 memberDelete
	public void memberDelete(MemberVO vo) {
		sqlsession.delete("m.memberDelete", vo);
	}
	
	// 패스워드 체크 passChk
	public int passChk(Map data) {
		int res = sqlsession.selectOne("m.passChk", data);
		return res;
	}
	
	// 아이디 중복체크 idChk
	public int idChk(MemberVO vo) {
		int res = sqlsession.selectOne("m.idChk", vo);
		return res;
	}
	
	public Map searchUser(Map data) {
		return sqlsession.selectOne("m.searchUser", data);
	}
	
}
