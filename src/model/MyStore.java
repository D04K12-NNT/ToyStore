package model;

import util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyStore implements Store {
	private String name;

	public MyStore(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void insertProduct(Toy item) throws Exception {
		Connection conn = DBHelper.getDefaultInstance().getConnection();
		Statement stmt = conn.createStatement();
		
		// Câu lệnh mẫu, chú ý thay thế your_table phù hợp
		String sql = String.format(
				"INSERT INTO <your_table>(code, name, price, description, receiptDate) VALUES ('%s','%s','%f','%s','%s') ",
				item.getCode(), item.getName(), item.getPrice(), item.getDescription(),
				item.getReceiptDate().toString());
		
		stmt.executeUpdate(sql);
		stmt.close();
	}

	@Override
	public Toy searchProductByCode(String code) throws Exception {
		Connection conn = DBHelper.getDefaultInstance().getConnection();
		Statement stmt = conn.createStatement();
		
		// Thêm câu lệnh còn thiếu tại đây
		String sql = "**************************************************";
		
		Toy item = null;
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			item = new Toy();
			item.setId(rs.getLong("id"));
			item.setCode(rs.getString("code"));
			item.setName(rs.getNString("name"));
			item.setPrice(rs.getDouble("price"));
			item.setDescription(rs.getNString("description"));
			item.setReceiptDate(rs.getDate("receiptDate"));
		}
		rs.close();
		stmt.close();
		return item;
	}

	@Override
	public List<Toy> orderByASC() throws Exception {
		Connection conn = DBHelper.getDefaultInstance().getConnection();
		Statement stmt = conn.createStatement();
		// Thêm câu lệnh còn thiếu tại đây
		String sql = "**************************************************";
		
		ResultSet rs = stmt.executeQuery(sql);
		List<Toy> list = new ArrayList<Toy>();
		while (rs.next()) {
			Toy item = new Toy();
			item.setId(rs.getLong("id"));
			item.setCode(rs.getString("code"));
			item.setName(rs.getNString("name"));
			item.setPrice(rs.getDouble("price"));
			item.setDescription(rs.getNString("description"));
			item.setReceiptDate(rs.getDate("receiptDate"));
			list.add(item);
		}
		return list;
	}

	@Override
	public List<Toy> listExpiration() throws Exception {
		Connection conn = DBHelper.getDefaultInstance().getConnection();
		Statement stmt = conn.createStatement();
		// Thêm câu lệnh còn thiếu tại đây
		String sql = "**************************************************";
		
		ResultSet rs = stmt.executeQuery(sql);
		List<Toy> list = new ArrayList<Toy>();
		while (rs.next()) {
			Toy item = new Toy();
			item.setId(rs.getLong("id"));
			item.setCode(rs.getString("code"));
			item.setName(rs.getNString("name"));
			item.setPrice(rs.getDouble("price"));
			item.setDescription(rs.getNString("description"));
			item.setReceiptDate(rs.getDate("receiptDate"));
			list.add(item);
		}

		rs.close();
		stmt.close();
		return list;
	}

}
