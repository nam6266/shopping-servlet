package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.Connect;
import entity.User;

public class Dangkyservice {
	PreparedStatement ps = null;

	public Dangkyservice() {
	}

	public void input(String user, String pass, String email) {
		Connection conn = Connect.openConnect();

		String query = ("INSERT INTO `user` VALUES (?, ?, ?, '2015-05-04', 'Nam', ?, '0962491151', 'hochiminh', '2');");
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, null);
			ps.setString(2, user);
			ps.setString(3, pass);
			ps.setString(4, email);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	public User checkuserid(String username) {
		Connection conn = Connect.openConnect();
		User users = new User();
		String query = ("SELECT * FROM shoppe.user where username = ?;");

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString(2);

				users.setUsername(name);

				return users;
			}

		} catch (Exception e) {

		}
		return null;

	}
}
