package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.SecondVO;

@Repository
public class SecondDAO {

	@Autowired
	SqlSession sqlSession;

	public List<SecondVO> secondList(int first_idx) {
		
		return sqlSession.selectList("i.secondList", first_idx);
	}
}
