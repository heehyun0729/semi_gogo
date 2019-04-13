package gogo.mypage.vo;

public class InterListVo {
	private int inter_num;
	private int prod_num;
	private int menu_num;
	private String img_saveImg;
	private String prod_name;
	private int price;
	
	public InterListVo() {}


	public InterListVo(int inter_num, int prod_num, int menu_num, String img_saveImg, String prod_name, int price) {
		super();
		this.inter_num = inter_num;
		this.prod_num = prod_num;
		this.menu_num = menu_num;
		this.img_saveImg = img_saveImg;
		this.prod_name = prod_name;
		this.price = price;
	}

	public int getInter_num() {
		return inter_num;
	}

	public void setInter_num(int inter_num) {
		this.inter_num = inter_num;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
