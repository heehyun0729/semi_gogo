package gogo.board.vo;

import java.sql.Date;

public class NoticeVo {
	private int notice_num;
	private String notice_title;
	private String notice_content;
	private Date notice_wdate;
	private int notice_step;
	private String notice_cate;
	private int notice_hit;
	
	public NoticeVo() {
		super();
	}

	public NoticeVo(int notice_num, String notice_title, String notice_content, Date notice_wdate, int notice_step,
			String notice_cate, int notice_hit) {
		super();
		this.notice_num = notice_num;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_wdate = notice_wdate;
		this.notice_step = notice_step;
		this.notice_cate = notice_cate;
		this.notice_hit = notice_hit;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Date getNotice_wdate() {
		return notice_wdate;
	}

	public void setNotice_wdate(Date notice_wdate) {
		this.notice_wdate = notice_wdate;
	}

	public int getNotice_step() {
		return notice_step;
	}

	public void setNotice_step(int notice_step) {
		this.notice_step = notice_step;
	}

	public String getNotice_cate() {
		return notice_cate;
	}

	public void setNotice_cate(String notice_cate) {
		this.notice_cate = notice_cate;
	}

	public int getNotice_hit() {
		return notice_hit;
	}

	public void setNotice_hit(int notice_hit) {
		this.notice_hit = notice_hit;
	}
}
