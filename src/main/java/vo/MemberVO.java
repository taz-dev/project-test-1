package vo;

public class MemberVO {
	
	private int mem_idx;
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String tel;
	private String isAdmin;
	
	public int getMem_idx() {
		return mem_idx;
	}
	
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getIsAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
