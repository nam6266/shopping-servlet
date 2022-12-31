package entity;

public class Category {
	private int cateID;
	private String cateName;
	private String cateimg;
	private int soluong;
	
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateimg() {
		return cateimg;
	}
	public void setCateimg(String cateimg) {
		this.cateimg = cateimg;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public String toString() {
		return "Category [cateID=" + cateID + ", cateName=" + cateName
				+ ", cateimg=" + cateimg + ", soluong=" + soluong + "]";
	}



	

}
