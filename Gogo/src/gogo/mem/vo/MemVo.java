package gogo.mem.vo;

import java.sql.Date;

public class MemVo {
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_phone;
	private String mem_email;
	private String mem_addr;
	private String mem_bday;
	private int mem_stat;
	public MemVo() {}
	public MemVo(String mem_id, String mem_pwd, String mem_name, String mem_phone, String mem_email, String mem_addr,
			String mem_bday, int mem_stat) {
		super();
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_addr = mem_addr;
		this.mem_bday = mem_bday;
		this.mem_stat = mem_stat;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public String getMem_email() {
		return mem_email;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public String getMem_bday() {
		return mem_bday;
	}
	public int getMem_stat() {
		return mem_stat;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public void setMem_bday(String mem_bday) {
		this.mem_bday = mem_bday;
	}
	public void setMem_stat(int mem_stat) {
		this.mem_stat = mem_stat;
	}
	
}
