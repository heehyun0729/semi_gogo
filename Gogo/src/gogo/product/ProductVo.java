package gogo.product;

public class ProductVo  {
	private int prod_num;
	private int menu_num;
	private String prod_name;
	private int prod_price;
	private int prod_stat;
	public ProductVo() {}
	
	public ProductVo(int prod_num, int menu_num, String prod_name, int prod_price, int prod_stat) {
		super();
		this.prod_num = prod_num;
		this.menu_num = menu_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_stat = prod_stat;
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

	public int getProd_stat() {
		return prod_stat;
	}

	public void setProd_stat(int prod_stat) {
		this.prod_stat = prod_stat;
	}
	
}

//