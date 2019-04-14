package gogo.board.vo;

import java.sql.Date;

public class ReviewVo {
	
	private int review_num;
	private String mem_id;
	private int detailBuy_num;
	private String review_title;
	private String review_content;
	private int review_star;
	private Date review_wdate;
	private int review_like;
	
	public ReviewVo() {}

	public ReviewVo(int review_num, String mem_id, int detailBuy_num, String review_title, String review_content,
			int review_star, Date review_wdate, int review_like) {
		super();
		this.review_num = review_num;
		this.mem_id = mem_id;
		this.detailBuy_num = detailBuy_num;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_star = review_star;
		this.review_wdate = review_wdate;
		this.review_like = review_like;
	}


	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getDetailBuy_num() {
		return detailBuy_num;
	}

	public void setDetailBuy_num(int detailBuy_num) {
		this.detailBuy_num = detailBuy_num;
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

	public Date getReview_wdate() {
		return review_wdate;
	}

	public void setReview_wdate(Date review_wdate) {
		this.review_wdate = review_wdate;
	}

	public int getReview_like() {
		return review_like;
	}

	public void setReview_like(int review_like) {
		this.review_like = review_like;
	}
	
}
