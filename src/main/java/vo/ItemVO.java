package vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemVO{
	@NotNull(message = "카테고리 번호(5(침구),6,7,8)를 보내주세요 주인님")
	private int secondIdx;
	@NotNull(message = "상품이름을 써주세요 주인님")
	private String name;
	private String content;
	@NotBlank(message = "상품가격을 정해주세요 주인님")
	private int price;
	
	
	
	public int getSecondIdx() {
		return secondIdx;
	}
	public void setSecondIdx(int secondIdx) {
		this.secondIdx = secondIdx;
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
	@Override
	public String toString() {
		return "ItemVO [secondIdx=" + secondIdx + ", name=" + name + ", content=" + content + ", price=" + price + "]";
	}
	
	
	
}
