package gogo.order.vo;

import java.sql.Date;

public class PayVo {
	private int pay_num;
	private int buy_num;
	private String pay_how;
	private int pay_sum;
	private Date pay_data;
	private int pay_stat;
	
	public PayVo() {}

	public PayVo(int pay_num, int buy_num, String pay_how, int pay_sum, Date pay_data, int pay_stat) {
		super();
		this.pay_num = pay_num;
		this.buy_num = buy_num;
		this.pay_how = pay_how;
		this.pay_sum = pay_sum;
		this.pay_data = pay_data;
		this.pay_stat = pay_stat;
	}

	public int getPay_num() {
		return pay_num;
	}

	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	public String getPay_how() {
		return pay_how;
	}

	public void setPay_how(String pay_how) {
		this.pay_how = pay_how;
	}

	public int getPay_sum() {
		return pay_sum;
	}

	public void setPay_sum(int pay_sum) {
		this.pay_sum = pay_sum;
	}

	public Date getPay_data() {
		return pay_data;
	}

	public void setPay_data(Date pay_data) {
		this.pay_data = pay_data;
	}

	public int getPay_stat() {
		return pay_stat;
	}

	public void setPay_stat(int pay_stat) {
		this.pay_stat = pay_stat;
	}
	
}
