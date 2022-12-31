package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import config.Connect;
import entity.Category;
import entity.Item;
import entity.Product;

public class Categoryservice {
	PreparedStatement ps = null;

	public Categoryservice() {

	}

	
	
	public List<Category> findAllCategory() {
		Connection conn = Connect.openConnect();
		List<Category> categoryL = new ArrayList<Category>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM shoppe.category;");
			while (rs.next()) {
				int id = rs.getInt(1);
				String theloai = rs.getString(2);
				String mota = rs.getString(3);
				int soluong = rs.getInt(4);

				Category category = new Category();
				category.setCateID(id);
				category.setCateName(theloai);
				category.setCateimg(mota);
				category.setSoluong(soluong);

				categoryL.add(category);
			}
			return categoryL;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return Collections.emptyList();
	}
	
	public List<Item> loaditemformcate(int userid) {
		Connection conn = Connect.openConnect();
		List<Item> itemL = new ArrayList<Item>();
		String query = ("select *,COUNT(*) from shoppe.cart join product where user_id = ? and cart.ma_san_pham = product.ma_san_pham order by product.ma_san_pham");
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, userid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt(3);
				int soluong = rs.getInt(4);
				int giamgia = rs.getInt(6);
				int cateid = rs.getInt(7);
				String name = rs.getString(8);
				String img = rs.getString(9);
				double price = rs.getDouble(10);
				String manufacturer = rs.getString(11);
				String ship = rs.getString(12);
				String soldes = rs.getString(13);
				
				Product product = new Product();
				product.setId(id);
				product.setGiamgia(giamgia);
				product.setName(name);
				product.setCateid(cateid);
				product.setImg(img);
				product.setPrice(price);
				product.setManufacturer(manufacturer);
				product.setShip(ship);
				product.setSolded(soldes);
				
				Item item = new Item();
				item.setProduct(product);
				item.setSoluong(soluong);
				item.setPrice(price*soluong);
				item.setPricediscount((price-(price*giamgia/100))*soluong);
				
				itemL.add(item);
				
			} 
			return itemL;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		Categoryservice cs = new Categoryservice();
//		List<Category> catel=cs.findAllCategory();
//		for(Category s:catel)
//		{
//			System.out.println(s);
//		}
//	}
}
