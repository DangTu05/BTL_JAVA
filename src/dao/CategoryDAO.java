package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Category;

public class CategoryDAO extends BaseDAO<Category> {

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Category entity) throws SQLException {
		String sql = "Insert into tblCategory(category_id,category_name) values(?,?,)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getCategory_id());
		statement.setString(2, entity.getCategory_name());
		return statement;
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
