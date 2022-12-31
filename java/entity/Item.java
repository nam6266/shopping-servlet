package entity;

public class Item {

	private Product product;
	private int soluong;
	private double price;
	private double pricediscount;

	public double getPricediscount() {
		return pricediscount;
	}

	public void setPricediscount(double pricediscount) {
		this.pricediscount = pricediscount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", soluong=" + soluong + ", price="
				+ price + ", pricediscount=" + pricediscount + "]";
	}

	
}

