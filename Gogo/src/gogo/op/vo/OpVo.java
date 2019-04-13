package gogo.op.vo;

public class OpVo {
	private int op_num;
	private int prod_num;
	private String op_name;
	
	public OpVo() {}

	public OpVo(int op_num, int prod_num, String op_name) {
		super();
		this.op_num = op_num;
		this.prod_num = prod_num;
		this.op_name = op_name;
	}

	public int getOp_num() {
		return op_num;
	}

	public void setOp_num(int op_num) {
		this.op_num = op_num;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}

	public String getOp_name() {
		return op_name;
	}

	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}
	
}
