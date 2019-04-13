package gogo.mypage.vo;

public class InterVo {
	private int inter_num;
	private String mem_id;
	private int prod_num;
	
	public InterVo() {}

	public InterVo(int inter_num, String mem_id, int prod_num) {
		super();
		this.inter_num = inter_num;
		this.mem_id = mem_id;
		this.prod_num = prod_num;
	}

	public int getInter_num() {
		return inter_num;
	}

	public void setInter_num(int inter_num) {
		this.inter_num = inter_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	
}
