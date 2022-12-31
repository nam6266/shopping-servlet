package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import config.Connect;
import entity.User;

public class Productlistservice {
	PreparedStatement ps = null;

	public Productlistservice() {

	}

	public void input(String giamgia, String category, String name, String img,
			String gia) {
		Connection conn = Connect.openConnect();
		new User();
		String query = ("INSERT INTO `product` VALUES (null, ?,?, ?, ?, ?, 'Goku', 'Miễn phí ship', '100 cái', null);");
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, giamgia);
			ps.setString(2, category);
			ps.setString(3, name);
			ps.setString(4, img);
			ps.setString(5, gia);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	public void delted(String id) {
		Connection conn = Connect.openConnect();
		new User();
		String query = ("DELETE FROM shoppe.product WHERE `ma_san_pham` = ?;");
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, id);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	public void edit(String name, String price, String id) {
		Connection conn = Connect.openConnect();
		new User();
		String query = ("UPDATE product SET ten_san_pham =? , gia_ban= ?  WHERE ma_san_pham = ?;");

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, id);

			ps.executeUpdate();

		} catch (Exception e) {

		}

	}
	
	public void inputpen(String giamgia, String category, String name, String img,
			String gia) {
		Connection conn = Connect.openConnect();
		new User();
		String query = ("INSERT INTO `temp` VALUES (null, ?,?, ?, ?, ?, 'Goku', 'Miễn phí ship', '100 cái',null);");
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, giamgia);
			ps.setString(2, category);
			ps.setString(3, name);
			ps.setString(4, img);
			ps.setString(5, gia);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}
	
	public void deltedpen(String id) {
		Connection conn = Connect.openConnect();
		new User();
		String query = ("DELETE FROM shoppe.temp WHERE `ma_san_pham` = ?;");
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, id);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}
	
//	public static void main(String[] args) {
//		Productlistservice ps = new Productlistservice();
//		ps.inputpen("1", "1", "1", "1", "1");
//	}
}
