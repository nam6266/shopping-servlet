package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.Connect;
import entity.User;

public class Loginservice {
	PreparedStatement ps = null;

	public Loginservice() {
	}

	public User search(String user, String pass) {
		Connection conn = Connect.openConnect();
		User users = new User();
		String query = ("SELECT * FROM shoppe.user where username = ? and password = ?;");
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String ngaysinh = rs.getString(4);
				String gioitinh = rs.getString(5);
				String email = rs.getString(6);
				String sdt = rs.getString(7);
				String diachi = rs.getString(8);
				int role = rs.getInt(9);

				users.setUserid(id);
				users.setUsername(username);
				users.setPassword(password);
				users.setNgaysinh(ngaysinh);
				users.setGioitinh(gioitinh);
				users.setEmail(email);
				users.setSdt(sdt);
				users.setDiachi(diachi);
				users.setRole(role);

				return users;
			}
		} catch (SQLException e) {
		}
		return null;
	}
}
