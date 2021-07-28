package entity;

import java.util.Date;

import vo.ItemVO;

public class ItemEntity {
	private int item_idx;
	private int second_idx;
	private String name;
	private String content;
	private int price;
	private int sell_count;
	private Date create_date;
	private Date update_date;
	
	public ItemVO voChange(){
			
		ItemVO itemVO = new ItemVO();
		itemVO.setContent(this.content);
		itemVO.setName(this.name);
		itemVO.setPrice(this.price);
		itemVO.setSecondIdx(this.second_idx);
		
		return itemVO;
	}
	
	
	public Date getCreateDate() {
		return create_date;
	}
	public void setCreateDate(Date createDate) {
		this.create_date = createDate;
	}
	public Date getUpdateDate() {
		return update_date;
	}
	public void setUpdateDate(Date updateDate) {
		this.update_date = updateDate;
	}
	public int getItemIdx() {
		return item_idx;
	}
	public void setItemIdx(int itemIdx) {
		this.item_idx = itemIdx;
	}
	public int getSecondIdx() {
		return second_idx;
	}
	public void setSecondIdx(int secondIdx) {
		this.second_idx = secondIdx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSell_count() {
		return sell_count;
	}
	public void setSell_count(int sell_count) {
		this.sell_count = sell_count;
	}


	@Override
	public String toString() {
		return "ItemEntity [item_idx=" + item_idx + ", second_idx=" + second_idx + ", name=" + name + ", content="
				+ content + ", price=" + price + ", sell_count=" + sell_count + ", create_date=" + create_date
				+ ", update_date=" + update_date + "]";
	}



	
}
