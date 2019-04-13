package gogo.image.vo;

public class ProdImgVo {
	private int prod_num;
	private int menu_num;
	private String prod_name;
	private int prod_price;
	private int img_type;
	private String img_orgImg;
	private String img_saveImg;
	
	public ProdImgVo() {}

	public ProdImgVo(int prod_num, int menu_num, String prod_name, int prod_price, int img_type, String img_orgImg,
			String img_saveImg) {
		super();
		this.prod_num = prod_num;
		this.menu_num = menu_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.img_type = img_type;
		this.img_orgImg = img_orgImg;
		this.img_saveImg = img_saveImg;
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

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public int getImg_type() {
		return img_type;
	}

	public void setImg_type(int img_type) {
		this.img_type = img_type;
	}

	public String getImg_orgImg() {
		return img_orgImg;
	}

	public void setImg_orgImg(String img_orgImg) {
		this.img_orgImg = img_orgImg;
	}

	public String getImg_saveImg() {
		return img_saveImg;
	}

	public void setImg_saveImg(String img_saveImg) {
		this.img_saveImg = img_saveImg;
	}
	
}
