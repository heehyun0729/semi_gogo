package gogo.order.vo;

import java.sql.Date;

public class ReviewProdListVo {
	private int detailBuy_num;
	private int prod_num;
	private int menu_num;
	private String img_saveImg;
	private String prod_name;
	private String op_name;
	private String detailOp_name;
	private int detailOp_price;
	
	public ReviewProdListVo() {}

	public ReviewProdListVo(int detailBuy_num, int prod_num, int menu_num, String img_saveImg, String prod_name,
			String op_name, String detailOp_name, int detailOp_price) {
		super();
		this.detailBuy_num = detailBuy_num;
		this.prod_num = prod_num;
		this.menu_num = menu_num;
		this.img_saveImg = img_saveImg;
		this.prod_name = prod_name;
		this.op_name = op_name;
		this.detailOp_name = detailOp_name;
		this.detailOp_price = detailOp_price;
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

	@Override
	public String toString() {
		return "ReviewProdListVo [detailBuy_num=" + detailBuy_num + ", prod_num=" + prod_num + ", menu_num=" + menu_num
				+ ", img_saveImg=" + img_saveImg + ", prod_name=" + prod_name + ", op_name=" + op_name
				+ ", detailOp_name=" + detailOp_name + ", detailOp_price=" + detailOp_price + ", getDetailBuy_num()="
				+ getDetailBuy_num() + ", getProd_num()=" + getProd_num() + ", getMenu_num()=" + getMenu_num()
				+ ", getImg_saveImg()=" + getImg_saveImg() + ", getProd_name()=" + getProd_name() + ", getOp_name()="
				+ getOp_name() + ", getDetailOp_name()=" + getDetailOp_name() + ", getDetailOp_price()="
				+ getDetailOp_price() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
