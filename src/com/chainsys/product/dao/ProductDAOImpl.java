package com.chainsys.product.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.chainsys.product.model.Product;

public class ProductDAOImpl implements ProductDAO {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Product> productSet;

	public ProductDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "password");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Product> findAll() {
		try {
			pstmt = con.prepareStatement("select * from product_2606");
			rs = pstmt.executeQuery();
			productSet = new HashSet<>();
			while (rs.next()) {
				Product product = new Product(rs.getInt("id"), rs.getString("name"),
						rs.getDate("expiry_date").toLocalDate());
				productSet.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productSet;
	}

	@Override
	public Product findById(int id) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2606 where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDate("expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void save(Product product) {
		try {
			pstmt = con.prepareStatement("insert into product_2606 values(?,?,?)");
			pstmt.setInt(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setDate(3, Date.valueOf(product.getExpiryDate()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Product product) {
		try {
			pstmt = con.prepareStatement("update product_2606 set name=? where id=?");
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try {
			pstmt = con.prepareStatement("delete product_2606 where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public Product findByName(String name) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2606 where name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDate("expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	@Override
	public void updatedate(Product product) {
		try {
			pstmt = con.prepareStatement("update product_2606 set expiry_date=? where id=?");
			pstmt.setDate(1,Date.valueOf( product.getExpiryDate()));
			pstmt.setInt(2, product.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public Product findByDate(LocalDate expiryDate) {
		Product product = null;
		try {
			pstmt = con.prepareStatement("select * from product_2611 where expiry_date=?");
			pstmt.setDate(1, Date.valueOf(expiryDate));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDate("expiry_date").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	

}
