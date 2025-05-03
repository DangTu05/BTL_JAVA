package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Actor;
import models.Movie;

public class MovieDAO extends BaseDAO<Movie> {
	@Override
	protected String getTableName() {
		return "tblMovie";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		return "movie_id";
	}

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Movie entity) throws SQLException {
		String sql = "Insert into tblMovie (movie_id,movie_name,release_date,director,duration,script,age_permisson,poster,status) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getMovie_id());
		statement.setString(2, entity.getMovie_name());
		statement.setDate(3, entity.getRelease_date());
		statement.setString(4, entity.getDirector());
		statement.setInt(5, entity.getDuration());
		statement.setString(6, entity.getScript());
		statement.setInt(7, entity.getAge_permisson());
		statement.setString(8, entity.getPoster());
		statement.setString(9, entity.getStatus());
		return statement;
	}
}
