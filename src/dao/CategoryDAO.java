package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Configs.Database.ConnectDB;
import models.Category;

public class CategoryDAO extends BaseDAO<Category> {

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Category entity) throws SQLException {
		String sql = "Insert into tblCategory(category_id,category_name) values(?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getCategory_id());
		statement.setString(2, entity.getCategory_name());
		return statement;
	}

	public static List<Category> getAllCategory() {
		String sqp = "Select * from tblCategory ";
		try (Connection conn = ConnectDB.getConnection();
				Statement sttm = conn.createStatement();
				ResultSet rs = sttm.executeQuery(sqp)) {
			List<Category> list = new ArrayList<>();
			while (rs.next()) {
				Category category = new Category(rs.getString("category_id"), rs.getString("category_name"));
				list.add(category);
			}
			return list;

		} catch (Exception e) {
			throw new RuntimeException("Lấy danh sach thể loại thất bại: " + e.getMessage(), e);
		}
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, Category entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Category mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "tblCategory";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		// TODO Auto-generated method stub
		return "category_id";
	}

}
