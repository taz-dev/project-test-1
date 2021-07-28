package com.korea.thirdjo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.ItemDAO;
import entity.ItemEntity;
import vo.ItemVO;
import vo.UpdateItemVO;

@CrossOrigin(origins = "*")
@RestController
public class ItemController {
	
	@Autowired
	ItemDAO itemDao;
	
	@PostMapping("/item/insert") // 아이템등록
	public ResponseEntity insertItem(@RequestBody @Valid ItemVO vo,BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
    }/*,@SessionAttribute("user") UserVO user) {
			
			if(user.getRank().equals("admin")) {
				
				return itemDao.insertItem(vo);
				
			}*/
			/*
			 * Optional<Integer> nameCofirm_= itemDao.NameConfirm(vo);
			 * 
			 * 
			 * if(!nameCofirm_.isPresent()) {
			 * 
			 * return itemDao.insertItem(vo);
			 * 
			 * 
			 * }
			 * 
			 * return -1; //중복체크
			 */
			return ResponseEntity.ok(itemDao.insertItem(vo));
	}

	@GetMapping("/item/selectone") //리스트 하나 가져오기
	public ItemVO selectOne(int idx) {
		
		ItemEntity entity = itemDao.selectItem(idx);
	
		return entity.voChange();
	}
	
	@CrossOrigin("*")
	@GetMapping("/item/selectlist") //리스트
	public List<ItemVO> selectlist(){ //페이징처리하기()
		
		List<ItemEntity> list = itemDao.selectList();
		
		List<ItemVO> reponseList = new ArrayList<ItemVO>(); //이터레이터
		
		for( int i = 0 ; i<list.size(); i ++) {
			
			reponseList.add(list.get(i).voChange());
		}
		
		return reponseList;
	}
	
	@PatchMapping("/item/update") //수정 업데이트문이 잘안되서 인설트후 삭제과정
	public int updateItem(@RequestBody UpdateItemVO vo) {

		ItemEntity itemEntity = itemDao.selectItem(vo.getItemIdx()); 
		itemDao.deleteItem(vo.getItemIdx());
		itemEntity.setContent(vo.getContent());
		itemEntity.setName(vo.getName());
		itemEntity.setPrice(vo.getPrice());
		
		return itemDao.updateItem(itemEntity);
	}
	
	@DeleteMapping("/item/delete") //삭제
	public int deleteItem(int idx) {
		
		return itemDao.deleteItem(idx);
	}
	
	
}













