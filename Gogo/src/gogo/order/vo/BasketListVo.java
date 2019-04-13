package gogo.order.vo;

public class BasketListVo {
	private int basket_num;
	private int prod_num;
	private int menu_num;
	private String img_saveImg;
	private String prod_name;
	private int op_num;
	private String op_name;
	private int detailOp_num;
	private String detailOp_name;
	private int detailOp_price;
	private int price;
	private int cnt;
	private int tot;
	
	public BasketListVo() {}

	public BasketListVo(int basket_num, int prod_num, int menu_num, String img_saveImg, String prod_name, int op_num,
			String op_name, int detailOp_num, String detailOp_name, int detailOp_price, int price, int cnt, int tot) {
		super();
		this.basket_num = basket_num;
		this.prod_num = prod_num;
		this.menu_num = menu_num;
		this.img_saveImg = img_saveImg;
		this.prod_name = prod_name;
		this.op_num = op_num;
		this.op_name = op_name;
		this.detailOp_num = detailOp_num;
		this.detailOp_name = detailOp_name;
		this.detailOp_price = detailOp_price;
		this.price = price;
		this.cnt = cnt;
		this.tot = tot;
	}

	public int getBasket_num() {
		return basket_num;
	}

	public void setBasket_num(int basket_num) {
		this.basket_num = basket_num;
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

	public int getOp_num() {
		return op_num;
	}

	public void setOp_num(int op_num) {
		this.op_num = op_num;
	}

	public String getOp_name() {
		return op_name;
	}

	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}

	public int getDetailOp_num() {
		return detailOp_num;
	}

	public void setDetailOp_num(int detailOp_num) {
		this.detailOp_num = detailOp_num;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}
	
}
