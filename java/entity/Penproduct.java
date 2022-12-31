package entity;

public class Penproduct {
	private int id;
	private double giamgia;
	private int cateid;
	private String name;
	private String img;
	private double price;
	private String manufacturer;
	private String ship;
	private String solded;
	private String comment;
	@Override
	public String toString() {
		return "Penproduct [id=" + id + ", giamgia=" + giamgia + ", cateid="
				+ cateid + ", name=" + name + ", img=" + img + ", price="
				+ price + ", manufacturer=" + manufacturer + ", ship=" + ship
				+ ", solded=" + solded + ", comment=" + comment + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGiamgia() {
		return giamgia;
	}
	public void setGiamgia(double giamgia) {
		this.giamgia = giamgia;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getShip() {
		return ship;
	}
	public void setShip(String ship) {
		this.ship = ship;
	}
	public String getSolded() {
		return solded;
	}
	public void setSolded(String solded) {
		this.solded = solded;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
