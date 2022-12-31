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
import entity.Penproduct;
import entity.Product;

public class Homeservice {
	PreparedStatement ps = null;

	public Homeservice() {
	}

	public List<Product> findAllProduct() {
		Connection conn = Connect.openConnect();
		List<Product> products = new ArrayList<Product>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM shoppe.product order by ma_san_pham;");
			while (rs.next()) {
				int id = rs.getInt(1);
				int giamgia = rs.getInt(2);
				int cateid = rs.getInt(3);
				String name = rs.getString(4);
				String img = rs.getString(5);
				double price = rs.getDouble(6);
				String manufacturer = rs.getString(7);
				String ship = rs.getString(8);
				String soldes = rs.getString(9);

				Product product = new Product();
				product.setId(id);
				product.setGiamgia(giamgia);
				product.setCateid(cateid);
				product.setName(name);
				product.setImg(img);
				product.setPrice(price);
				product.setManufacturer(manufacturer);
				product.setShip(ship);
				product.setSolded(soldes);

				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return Collections.emptyList();
	}
	
	public List<Product> findAllProductbycateid(int categoryid) {
		Connection conn = Connect.openConnect();
		List<Product> products = new ArrayList<Product>();
		String query = "SELECT * FROM shoppe.product where cate_id = ?  order by ma_san_pham;";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, categoryid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int giamgia = rs.getInt(2);
				int cateid = rs.getInt(3);
				String name = rs.getString(4);
				String img = rs.getString(5);
				double price = rs.getDouble(6);
				String manufacturer = rs.getString(7);
				String ship = rs.getString(8);
				String soldes = rs.getString(9);

				Product product = new Product();
				product.setId(id);
				product.setGiamgia(giamgia);
				product.setCateid(cateid);
				product.setName(name);
				product.setImg(img);
				product.setPrice(price);
				product.setManufacturer(manufacturer);
				product.setShip(ship);
				product.setSolded(soldes);

				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return Collections.emptyList();
	}

	public Product getID(String ID) {
		Connection conn = Connect.openConnect();
		String query = "select * from shoppe.product\n"
				+ "where ma_san_pham = ?";
		Product product = new Product();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int giamgia = rs.getInt(2);
				int cateid = rs.getInt(3);
				String name = rs.getString(4);
				String img = rs.getString(5);
				double price = rs.getDouble(6);
				String manufacturer = rs.getString(7);
				String ship = rs.getString(8);
				String soldes = rs.getString(9);

				product.setId(id);
				product.setGiamgia(giamgia);
				product.setName(name);
				product.setCateid(cateid);
				product.setImg(img);
				product.setPrice(price);
				product.setManufacturer(manufacturer);
				product.setShip(ship);
				;
				product.setSolded(soldes);

			}
			return product;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return null;
	}

	public List<Product> findAllProductbyname(String PRname) {
		Connection conn = Connect.openConnect();
		List<Product> products = new ArrayList<Product>();

		String query = "SELECT * FROM shoppe.product where ten_san_pham like ? order by ma_san_pham ;";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + PRname + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int giamgia = rs.getInt(2);
				int cateid = rs.getInt(3);
				String name = rs.getString(4);
				String img = rs.getString(5);
				double price = rs.getDouble(6);
				String manufacturer = rs.getString(7);
				String ship = rs.getString(8);
				String soldes = rs.getString(9);

				Product product = new Product();
				product.setId(id);
				product.setGiamgia(giamgia);
				product.setName(name);
				product.setCateid(cateid);
				product.setImg(img);
				product.setPrice(price);
				product.setManufacturer(manufacturer);
				product.setShip(ship);
				;
				product.setSolded(soldes);

				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return null;
	}

	public Integer countproduct() {
		int count = 0;
		Connection conn = Connect.openConnect();
		String query = "select count(*) from product;";
		new Product();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return null;
	}
	

	public List<Product> pagingproduct(int index) {
		Connection conn = Connect.openConnect();
		List<Product> products = new ArrayList<Product>();
		String query = "SELECT * FROM shoppe.product order by ma_san_pham LIMIT 6 OFFSET ?;";
		try {
			int i = (index - 1) * 6;
			ps = conn.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int giamgia = rs.getInt(2);
				int cateid = rs.getInt(3);
				String name = rs.getString(4);
				String img = rs.getString(5);
				double price = rs.getDouble(6);
				String manufacturer = rs.getString(7);
				String ship = rs.getString(8);
				String soldes = rs.getString(9);

				Product product = new Product();
				product.setId(id);
				product.setGiamgia(giamgia);
				product.setName(name);
				product.setCateid(cateid);
				product.setImg(img);
				product.setPrice(price);
				product.setManufacturer(manufacturer);
				product.setShip(ship);
				;
				product.setSolded(soldes);

				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return Collections.emptyList();
	}
	

	
	public List<Penproduct> findAllPendingProduct() {
		Connection conn = Connect.openConnect();
		List<Penproduct> products = new ArrayList<Penproduct>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM shoppe.temp order by ma_san_pham;");
			while (rs.next()) {
				int id = rs.getInt(1);
				int giamgia = rs.getInt(2);
				int cateid = rs.getInt(3);
				String name = rs.getString(4);
				String img = rs.getString(5);
				double price = rs.getDouble(6);
				String manufacturer = rs.getString(7);
				String ship = rs.getString(8);
				String soldes = rs.getString(9);
				String comment = rs.getString(10);

				Penproduct product = new Penproduct();
				product.setId(id);
				product.setGiamgia(giamgia);
				product.setCateid(cateid);
				product.setName(name);
				product.setImg(img);
				product.setPrice(price);
				product.setManufacturer(manufacturer);
				product.setShip(ship);
				product.setSolded(soldes);
				product.setComment(comment);

				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return Collections.emptyList();
	}
	
	public Product getIDPen(String ID) {
		Connection conn = Connect.openConnect();
		String query = "select * from shoppe.temp\n"
				+ "where ma_san_pham = ?";
		Product product = new Product();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int giamgia = rs.getInt(2);
				int cateid = rs.getInt(3);
				String name = rs.getString(4);
				String img = rs.getString(5);
				double price = rs.getDouble(6);
				String manufacturer = rs.getString(7);
				String ship = rs.getString(8);
				String soldes = rs.getString(9);
				String comment = rs.getString(10);

				product.setId(id);
				product.setGiamgia(giamgia);
				product.setName(name);
				product.setCateid(cateid);
				product.setImg(img);
				product.setPrice(price);
				product.setManufacturer(manufacturer);
				product.setShip(ship);
				product.setComment(comment);
				
				product.setSolded(soldes);

			}
			return product;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnect();
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		Homeservice hs = new Homeservice();
//		List<Penproduct> pro = hs.findAllPendingProduct();
//		for(Penproduct s:pro)
//		{
//			System.out.println(s);
//		}
//	}
	
}
