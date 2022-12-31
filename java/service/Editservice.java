package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import config.Connect;
import entity.User;

public class Editservice {
	PreparedStatement ps = null;

	public void edit(String id, String giamgia, String category, String name,
			String img, String price, String manufacturer, String shipping,
			String solded) {
		Connection conn = Connect.openConnect();
		String query = ("UPDATE product SET giam_gia =?, cate_id=?, ten_san_pham =? , hinh_anh=?, gia_ban=?, hang_san_xuat=?, van_chuyen=?, so_luong_da_ban= ?  WHERE ma_san_pham = ?;");

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, giamgia);
			ps.setString(2, category);
			ps.setString(3, name);
			ps.setString(4, img);
			ps.setString(5, price);
			ps.setString(6, manufacturer);
			ps.setString(7, shipping);
			ps.setString(8, solded);
			ps.setString(9, id);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	public void editwithoutimg(String id, String giamgia, String category,
			String name, String price, String manufacturer, String shipping,
			String solded) {
		Connection conn = Connect.openConnect();
		new User();
		String query = ("UPDATE product SET giam_gia =?, cate_id=?, ten_san_pham =? , gia_ban=?, hang_san_xuat=?, van_chuyen=?, so_luong_da_ban= ?  WHERE ma_san_pham = ?;");

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, giamgia);
			ps.setString(2, category);
			ps.setString(3, name);
			ps.setString(4, price);
			ps.setString(5, manufacturer);
			ps.setString(6, shipping);
			ps.setString(7, solded);
			ps.setString(8, id);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}
	
	public void editpen(String id, String giamgia, String category, String name,
			String img, String price, String manufacturer, String shipping,
			String solded) {
		Connection conn = Connect.openConnect();
		String query = ("UPDATE temp SET giam_gia =?, cate_id=?, ten_san_pham =? , hinh_anh=?, gia_ban=?, hang_san_xuat=?, van_chuyen=?, so_luong_da_ban= ? WHERE ma_san_pham = ?;");

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, giamgia);
			ps.setString(2, category);
			ps.setString(3, name);
			ps.setString(4, img);
			ps.setString(5, price);
			ps.setString(6, manufacturer);
			ps.setString(7, shipping);
			ps.setString(8, solded);
			ps.setString(9, id);

			ps.executeUpdate();

		} catch (Exception e) {

		}
	}
	
	public void editpencomment(String comment, String id) {
		Connection conn = Connect.openConnect();
		String query = ("UPDATE shoppe.temp SET comment = ? WHERE ma_san_pham = ?;");

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, comment);
			ps.setString(2, id);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}
	
//	public static void main(String[] args) {
//		Editservice es = new Editservice();
//		es.editpencomment("3", "giá cao quá");
//	}
}
