package bean;

public class Shopping {
	private int shopping_id;
	private String username;
	private String shoppingname;
	private int type;
	private int newlevel;
	private int price;
	private String state;
	private String publishdate;
	private String ps;
	private String hasPicture;

	public String getHasPicture() {
		return hasPicture;
	}
	public void setHasPicture(String hasPicture) {
		this.hasPicture = hasPicture;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getShoppingname() {
		return shoppingname;
	}
	public void setShoppingname(String shoppingname) {
		this.shoppingname = shoppingname;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public int getShopping_id() {
		return shopping_id;
	}
	public void setShopping_id(int shopping_id) {
		this.shopping_id = shopping_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNewlevel() {
		return newlevel;
	}
	public void setNewlevel(int newlevel) {
		this.newlevel = newlevel;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
