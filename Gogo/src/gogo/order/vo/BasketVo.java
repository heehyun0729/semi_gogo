package gogo.order.vo;

public class BasketVo {
	private int basket_num;
	private String mem_id;
	private int prod_num;
	private int op_num;
	private int detailOp_num;
	private int basket_cnt;
	
	public BasketVo() {	}

	public BasketVo(int basket_num, String mem_id, int prod_num, int op_num, int detailop_num, int basket_cnt) {
		super();
		this.basket_num = basket_num;
		this.mem_id = mem_id;
		this.prod_num = prod_num;
		this.op_num = op_num;
		this.detailOp_num = detailop_num;
		this.basket_cnt = basket_cnt;
	}

	public int getBasket_num() {
		return basket_num;
	}

	public void setBasket_num(int basket_num) {
		this.basket_num = basket_num;
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

	public int getOp_num() {
		return op_num;
	}

	public void setOp_num(int op_num) {
		this.op_num = op_num;
	}

	public int getDetailop_num() {
		return detailOp_num;
	}

	public void setDetailop_num(int detailop_num) {
		this.detailOp_num = detailop_num;
	}

	public int getBasket_cnt() {
		return basket_cnt;
	}

	public void setBasket_cnt(int basket_cnt) {
		this.basket_cnt = basket_cnt;
	}
	
}
