package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.ItemEntity;
import vo.ItemVO;

@Repository("itemDao")
public class ItemDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	public int insertItem(ItemVO vo){
		
		return sqlsession.insert("i.insertItem", vo);
	}

	public ItemEntity selectItem(int idx) {
		
		return sqlsession.selectOne("i.selectItem" , idx); 
	}

	public List<ItemEntity> selectList() {
		
		return sqlsession.selectList("i.selectList");
	}

	
	public int updateItem(ItemEntity entity) {
		
		return sqlsession.insert("i.updateItem" , entity);
	}

	public int deleteItem(int idx) {
		
		return sqlsession.delete("i.deleteItem" , idx);
	}
	
	/*
	 * public Optional<Integer> NameConfirm(ItemVO vo){
	 * 
	 * return sqlsseion.selectOne("i.NameConfirm", vo);
	 * 
	 * }
	 */

}
