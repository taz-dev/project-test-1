package vo;

public class UpdateItemVO{
	private int itemIdx;
	private String name;
	private String content;
	private int price;

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

	public int getItemIdx() {
		return itemIdx;
	}

	public void setItemIdx(int itemIdx) {
		this.itemIdx = itemIdx;
	}

	@Override
	public String toString() {
		return "UpdateItemVO [itemIdx=" + itemIdx + ",  name=" + name + ", content="
				+ content + ", price=" + price + "]";
	}
	
}
