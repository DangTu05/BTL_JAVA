package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ErrorManager;

import Configs.Database.ConnectDB;
import models.Actor;
import utils.ErrorUtil;
import utils.MessageUtil;

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

	public static List<Actor> getAllActors() {
		String sql = "Select * from tblActor";
		try (Connection conn = ConnectDB.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			List<Actor> list = new ArrayList<>();
			while (rs.next()) {
				Actor actor = new Actor(rs.getString("actor_id"), rs.getString("actor_name"),
						rs.getString("actor_image"), rs.getString("nationality"), rs.getDate("birth"),
						rs.getString("biography"));
				list.add(actor);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	public static List<String[]> getAllActor() {
		String sql = "Select * from tblActor";
		try (Connection conn = ConnectDB.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			List<String[]> actors = new ArrayList<>();
			while (rs.next()) {
				actors.add(new String[] { rs.getString("actor_id"), rs.getString("actor_name"), rs.getString("birth"),
						rs.getString("nationality"), rs.getString("biography"), rs.getString("actor_image") });
			}
			return actors;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, Actor entity) throws SQLException {
		String sql = "Update tblActor SET actor_name=?, birth=?,nationality=?, biography=?,actor_image=? where actor_id=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getActor_name());
		statement.setDate(2, entity.getBirth());
		statement.setString(3, entity.getNationality());
		statement.setString(4, entity.getBiography());
		statement.setString(5, entity.getActor_image());
		statement.setString(6, entity.getActor_id());
		return statement;
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
		return "actor_id";
	}
}
