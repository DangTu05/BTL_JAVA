package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.MovieCategory;

public class MovieCategoryDAO extends BaseDAO<MovieCategory> {

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, MovieCategory entity) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Insert into tblMovie_Category(movie_id,category_id) values(?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getMovie_id());
		statement.setString(2, entity.getCategory_id());
		return statement;
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, MovieCategory entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MovieCategory mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "tblMovie_Category";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		// TODO Auto-generated method stub
		return null;
	}

}
