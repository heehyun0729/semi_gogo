package gogo.menu.vo;

public class MenuVo {
	private int menu_num;
	private String menu_name;
	private int cate_num;
	
	public MenuVo() {}

	public MenuVo(int menu_num, String menu_name, int cate_num) {
		super();
		this.menu_num = menu_num;
		this.menu_name = menu_name;
		this.cate_num = cate_num;
	}

	public int getMenu_num() {
		return menu_num;
	}

	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getCate_num() {
		return cate_num;
	}

	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}
	
}
