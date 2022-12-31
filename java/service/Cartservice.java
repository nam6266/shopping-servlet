package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Connect;
import entity.Item;
import entity.Product;

public class Cartservice {
	PreparedStatement ps = null;

	public Cartservice() {

	}

	public void inputcart(int userid, int productid, int soluong) {
		Connection conn = Connect.openConnect();
		String query = ("INSERT INTO `cart` VALUES (null, ?,?,?);");
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, userid);
			ps.setInt(2, productid);
			ps.setInt(3, soluong);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}
	
	public void updatecart(int soluong, int userid, int product) {
		Connection conn = Connect.openConnect();
		String query = ("UPDATE shoppe.cart set so_luong_san_pham = ? where user_id = ? and ma_san_pham= ?;");
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, soluong);
			ps.setInt(2, userid);
			ps.setInt(3, product);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}
	
	public void deletecart(int msp, int userid) {
		Connection conn = Connect.openConnect();
		String query = ("DELETE FROM shoppe.cart WHERE ma_san_pham= ? and user_id = ?;");
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, msp);
			ps.setInt(2,userid);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}
	
	public List<Item> loaditemformcart(int userid) {
		Connection conn = Connect.openConnect();
		List<Item> itemL = new ArrayList<Item>();
		String query = ("select * from shoppe.cart join product where user_id = ? and cart.ma_san_pham = product.ma_san_pham order by product.ma_san_pham");
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
	
	public int getsoluongfromcart(int userid, int msp) {
		int  a = 0;
		Connection conn = Connect.openConnect();
		String query = ("SELECT * FROM shoppe.cart where user_id = ? and ma_san_pham = ?;");
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, userid);
			ps.setInt(2, msp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = rs.getInt(4);
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return 0;
	}
}
