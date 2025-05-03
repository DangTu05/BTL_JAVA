package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.ErrorManager;

import Configs.Database.ConnectDB;
import models.Actor;
import utils.ErrorUtils;

public class ActorDAO extends BaseDAO<Actor> {

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Actor entity) throws SQLException {
		String sql = "Insert into tblActor (actor_id,actor_name,birth,nationality,biography,actor_image) values (?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getActor_id());
		statement.setString(2, entity.getActor_name());
		statement.setDate(3, entity.getBirth());
		statement.setString(4, entity.getNationality());
		statement.setString(5, entity.getBiography());
		statement.setString(6, entity.getActor_image());
		return statement;

	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, Actor entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Actor mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "tblActor";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		// TODO Auto-generated method stub
		return null;
	}
}
