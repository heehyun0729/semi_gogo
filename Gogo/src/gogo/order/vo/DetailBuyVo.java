package gogo.order.vo;

public class DetailBuyVo {
	private int detailBuy_num;
	private int buy_num;
	private int prod_num;
	private int op_num;
	private int detailOp_num;
	private int detailBuy_cnt;
	private int detailBuy_review;
	
	public DetailBuyVo() {}

	public DetailBuyVo(int detailBuy_num, int buy_num, int prod_num, int op_num, int detailOp_num, int detailBuy_cnt,
			int detailBuy_review) {
		super();
		this.detailBuy_num = detailBuy_num;
		this.buy_num = buy_num;
		this.prod_num = prod_num;
		this.op_num = op_num;
		this.detailOp_num = detailOp_num;
		this.detailBuy_cnt = detailBuy_cnt;
		this.detailBuy_review = detailBuy_review;
	}


	public int getDetailBuy_num() {
		return detailBuy_num;
	}

	public void setDetailBuy_num(int detailBuy_num) {
		this.detailBuy_num = detailBuy_num;
	}

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
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

	public int getDetailOp_num() {
		return detailOp_num;
	}

	public void setDetailOp_num(int detailOp_num) {
		this.detailOp_num = detailOp_num;
	}

	public int getDetailBuy_cnt() {
		return detailBuy_cnt;
	}

	public void setDetailBuy_cnt(int detailBuy_cnt) {
		this.detailBuy_cnt = detailBuy_cnt;
	}

	public int getDetailBuy_review() {
		return detailBuy_review;
	}

	public void setDetailBuy_review(int detailBuy_review) {
		this.detailBuy_review = detailBuy_review;
	}

	@Override
	public String toString() {
		return "DetailBuyVo [detailBuy_num=" + detailBuy_num + ", buy_num=" + buy_num + ", prod_num=" + prod_num
				+ ", op_num=" + op_num + ", detailOp_num=" + detailOp_num + ", detailBuy_cnt=" + detailBuy_cnt + "]";
	}
	
}
