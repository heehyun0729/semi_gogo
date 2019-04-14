package gogo.freedom;

import java.sql.Date;

public class FreedomVo {
	private int freedom_num;
	private String freedom_title;
	private String freedom_content;
	private Date freedom_wdate;
	private int freedaom_hit;
	
	public FreedomVo(){}

	public FreedomVo(int freedom_num, String freedom_title, String freedom_content, Date freedom_wdate,
			int freedaom_hit) {
		super();
		this.freedom_num = freedom_num;
		this.freedom_title = freedom_title;
		this.freedom_content = freedom_content;
		this.freedom_wdate = freedom_wdate;
		this.freedaom_hit = freedaom_hit;
	}

	public int getFreedom_num() {
		return freedom_num;
	}

	public void setFreedom_num(int freedom_num) {
		this.freedom_num = freedom_num;
	}

	public String getFreedom_title() {
		return freedom_title;
	}

	public void setFreedom_title(String freedom_title) {
		this.freedom_title = freedom_title;
	}

	public String getFreedom_content() {
		return freedom_content;
	}

	public void setFreedom_content(String freedom_content) {
		this.freedom_content = freedom_content;
	}

	public Date getFreedom_wdate() {
		return freedom_wdate;
	}

	public Date setFreedom_wdate(Date freedom_wdate) {
		return freedom_wdate;
	}

	public int getFreedaom_hit() {
		return freedaom_hit;
	}

	public void setFreedaom_hit(int freedaom_hit) {
		this.freedaom_hit = freedaom_hit;
	}

	@Override
	public String toString() {
		return "FreedomVo [freedom_num=" + freedom_num + ", freedom_title=" + freedom_title + ", freedom_content="
				+ freedom_content + ", freedom_wdate=" + freedom_wdate + ", freedaom_hit=" + freedaom_hit + "]";
	}

	
}

//
