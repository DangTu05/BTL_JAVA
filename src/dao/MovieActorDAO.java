package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.MovieActor;

public class MovieActorDAO extends BaseDAO<MovieActor> {

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "tblMovie_Actor";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, MovieActor entity) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Insert into tblMovie_Actor (movie_id,actor_id) values (?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getMovie_id());
		statement.setString(2, entity.getActor_id());
		return statement;
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, MovieActor entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MovieActor mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
