package gogo.image.vo;

public class ImageVo {
	private int img_num;
	private int img_type;
	private String img_orgImg;
	private String img_saveImg;
	private int menu_num;
	private int img_bnum;
	
	public ImageVo() {}

	public ImageVo(int img_num, int img_type, String img_orgImg, String img_saveImg, int menu_num, int img_bnum) {
		super();
		this.img_num = img_num;
		this.img_type = img_type;
		this.img_orgImg = img_orgImg;
		this.img_saveImg = img_saveImg;
		this.menu_num = menu_num;
		this.img_bnum = img_bnum;
	}

	public int getImg_num() {
		return img_num;
	}

	public void setImg_num(int img_num) {
		this.img_num = img_num;
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

	public int getMenu_num() {
		return menu_num;
	}

	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}

	public int getImg_bnum() {
		return img_bnum;
	}

	public void setImg_bnum(int img_bnum) {
		this.img_bnum = img_bnum;
	}
	
}
