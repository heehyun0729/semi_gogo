package gogo.op.vo;

public class DetailOpVo {
	private int detailOp_num;
	private int op_num;
	private int detailOp_price;
	private String detailOp_name;
	
	public DetailOpVo() {}

	public DetailOpVo(int detailOp_num, int op_num, int detailOp_price, String detailOp_name) {
		super();
		this.detailOp_num = detailOp_num;
		this.op_num = op_num;
		this.detailOp_price = detailOp_price;
		this.detailOp_name = detailOp_name;
	}

	public int getDetailOp_num() {
		return detailOp_num;
	}

	public void setDetailOp_num(int detailOp_num) {
		this.detailOp_num = detailOp_num;
	}

	public int getOp_num() {
		return op_num;
	}

	public void setOp_num(int op_num) {
		this.op_num = op_num;
	}

	public int getDetailOp_price() {
		return detailOp_price;
	}

	public void setDetailOp_price(int detailOp_price) {
		this.detailOp_price = detailOp_price;
	}

	public String getDetailOp_name() {
		return detailOp_name;
	}

	public void setDetailOp_name(String detailOp_name) {
		this.detailOp_name = detailOp_name;
	}
	
}
