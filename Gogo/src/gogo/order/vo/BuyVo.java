package gogo.order.vo;

import java.sql.Date;

public class BuyVo {
	private int buy_num;
	private String mem_id;
	private String buy_addr;
	private Date buy_bdate;
	
	public BuyVo() {}

	public BuyVo(int buy_num, String mem_id, String buy_addr, Date buy_bdate) {
		super();
		this.buy_num = buy_num;
		this.mem_id = mem_id;
		this.buy_addr = buy_addr;
		this.buy_bdate = buy_bdate;
	}

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getBuy_addr() {
		return buy_addr;
	}

	public void setBuy_addr(String buy_addr) {
		this.buy_addr = buy_addr;
	}

	public Date getBuy_bdate() {
		return buy_bdate;
	}

	public void setBuy_bdate(Date buy_bdate) {
		this.buy_bdate = buy_bdate;
	}
	
}
