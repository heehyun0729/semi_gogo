package gogo.board.vo;

import java.sql.Date;

public class QnaVo {
	private int qna_num;
	private String mem_id;
	private String qna_cate;
	private String qna_title;
	private String qna_content;
	private Date qna_wdate;
	private String qna_pwd;
	private int qna_ref;
	private int qna_level;
	private int qna_step;
	
	public QnaVo() {}

	public QnaVo(int qna_num, String mem_id, String qna_cate, String qna_title, String qna_content, 
			String qna_pwd, Date qna_wdate, int qna_ref, int qna_level, int qna_step) {
		super();
		this.qna_num = qna_num;
		this.mem_id = mem_id;
		this.qna_cate = qna_cate;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_wdate = qna_wdate;
		this.qna_pwd = qna_pwd;
		this.qna_ref = qna_ref;
		this.qna_level = qna_level;
		this.qna_step = qna_step;
	}

	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getQna_cate() {
		return qna_cate;
	}

	public void setQna_cate(String qna_cate) {
		this.qna_cate = qna_cate;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public Date getQna_wdate() {
		return qna_wdate;
	}

	public void setQna_wdate(Date qna_wdate) {
		this.qna_wdate = qna_wdate;
	}

	public String getQna_pwd() {
		return qna_pwd;
	}

	public void setQna_pwd(String qna_pwd) {
		this.qna_pwd = qna_pwd;
	}

	public int getQna_ref() {
		return qna_ref;
	}

	public void setQna_ref(int qna_ref) {
		this.qna_ref = qna_ref;
	}

	public int getQna_level() {
		return qna_level;
	}

	public void setQna_level(int qna_level) {
		this.qna_level = qna_level;
	}

	public int getQna_step() {
		return qna_step;
	}

	public void setQna_step(int qna_step) {
		this.qna_step = qna_step;
	}
}
