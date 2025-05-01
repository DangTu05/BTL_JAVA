package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.ErrorManager;

import Configs.Database.ConnectDB;
import models.Actor;
import utils.ErrorUtils;

public class ActorDAO {
	public static boolean addActor(Actor actor) {
		String sql = "Insert into tblActor (actor_id,actor_name,birth,nationality	,biography,actor_image) values (?,?,?,?,?,?)";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, actor.getActor_id());
			statement.setString(2, actor.getActor_name());
			statement.setDate(3, actor.getBirth());
			statement.setString(4, actor.getNationality());
			statement.setString(5, actor.getBiography());
			statement.setString(6, actor.getActor_image());
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
}
