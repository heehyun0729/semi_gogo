package gogo.order.vo;

import java.sql.Date;

public class OrderListVo {
	private int buy_num;
	private Date buy_bdate;
	private int detailBuy_num;
	private int prod_num;
	private int menu_num;
	private String img_saveImg;
	private String prod_name;
	private String op_name;
	private String detailOp_name;
	private int detailOp_price;
	private int detailBuy_review;
	private int price;
	private int cnt;
	private int tot;
	private int length;
	
	public OrderListVo() {}

	public OrderListVo(int buy_num, Date buy_bdate, int detailBuy_num, int prod_num, int menu_num, String img_saveImg,
			String prod_name, String op_name, String detailOp_name, int detailOp_price, int detailBuy_review, 
			int price, int cnt, int tot, int length) {
		super();
		this.buy_num = buy_num;
		this.buy_bdate = buy_bdate;
		this.detailBuy_num = detailBuy_num;
		this.prod_num = prod_num;
		this.menu_num = menu_num;
		this.img_saveImg = img_saveImg;
		this.prod_name = prod_name;
		this.op_name = op_name;
		this.detailOp_name = detailOp_name;
		this.detailOp_price = detailOp_price;
		this.price = price;
		this.cnt = cnt;
		this.tot = tot;
		this.detailBuy_review = detailBuy_review;
		this.length = length;
	}

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	public Date getBuy_bdate() {
		return buy_bdate;
	}

	public void setBuy_bdate(Date buy_bdate) {
		this.buy_bdate = buy_bdate;
	}

	public int getDetailBuy_num() {
		return detailBuy_num;
	}

	public void setDetailBuy_num(int detailBuy_num) {
		this.detailBuy_num = detailBuy_num;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}

	public int getMenu_num() {
		return menu_num;
	}

	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}

	public String getImg_saveImg() {
		return img_saveImg;
	}

	public void setImg_saveImg(String img_saveImg) {
		this.img_saveImg = img_saveImg;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getOp_name() {
		return op_name;
	}

	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}

	public String getDetailOp_name() {
		return detailOp_name;
	}

	public void setDetailOp_name(String detailOp_name) {
		this.detailOp_name = detailOp_name;
	}

	public int getDetailOp_price() {
		return detailOp_price;
	}

	public void setDetailOp_price(int detailOp_price) {
		this.detailOp_price = detailOp_price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getDetailBuy_review() {
		return detailBuy_review;
	}

	public void setDetailBuy_review(int detailBuy_review) {
		this.detailBuy_review = detailBuy_review;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
}
