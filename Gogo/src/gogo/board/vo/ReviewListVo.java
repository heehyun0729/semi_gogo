package gogo.board.vo;

import java.sql.Date;

public class ReviewListVo {
	private int review_num;
	private int prod_num;
	private int menu_num;
	private String img_saveImg;
	private String prod_name;
	private String op_name;
	private String detailOp_name;
	private int detailOp_price;
	private String mem_id;
	private String review_title;
	private String review_content;
	private int review_star;
	private int review_like;
	private Date review_wdate;
	
	public ReviewListVo() {}

	public ReviewListVo(int review_num, int prod_num, int menu_num, String img_saveImg, String prod_name,
			String op_name, String detailOp_name, int detailOp_price, String mem_id, String review_title,
			String review_content, int review_star, int review_like, Date review_wdate) {
		super();
		this.review_num = review_num;
		this.prod_num = prod_num;
		this.menu_num = menu_num;
		this.img_saveImg = img_saveImg;
		this.prod_name = prod_name;
		this.op_name = op_name;
		this.detailOp_name = detailOp_name;
		this.detailOp_price = detailOp_price;
		this.mem_id = mem_id;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_star = review_star;
		this.review_like = review_like;
		this.review_wdate = review_wdate;
	}



	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
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

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getReview_star() {
		return review_star;
	}

	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}

	public int getReview_like() {
		return review_like;
	}

	public void setReview_like(int review_like) {
		this.review_like = review_like;
	}

	public Date getReview_wdate() {
		return review_wdate;
	}

	public void setReview_wdate(Date review_wdate) {
		this.review_wdate = review_wdate;
	}
	
}
