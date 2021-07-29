package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	//회원가입
	
	
	// 로그인 memberLogin
	public MemberVO login(MemberVO vo) {
		return sqlsession.selectOne("m.login", vo);
	}
	
	// 회원정보 수정 memberUpdate
	public int memberUpdate(MemberVO vo) {
		return sqlsession.update("m.memberUpdate", vo);
	}
	

	//회원가입
	public int register(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlsession.insert("m.register", vo);
	}

	public int memberDelete(int idx) {
		// TODO Auto-generated method stub
		return sqlsession.delete("m.memberDelete", idx);
	}
	
}
