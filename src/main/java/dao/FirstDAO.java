package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.FirstVO;

@Repository
public class FirstDAO {
	
	@Autowired
	SqlSession sqlSession;

	public List<FirstVO> firstList() {
		
		return sqlSession.selectList("i.firstList");
	}
	
}
