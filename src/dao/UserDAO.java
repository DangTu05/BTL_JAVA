package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Configs.Database.ConnectDB;
import models.User;

public class UserDAO extends BaseDAO<User> {

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, User entity) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Insert into tblUser(user_id,user_name,gender,address,reward_points,user_image) values(?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getUser_id());
		statement.setString(2, entity.getUser_name());
		statement.setString(3, entity.getGender());
		statement.setString(4, entity.getAddress());
		statement.setFloat(5, entity.getReward_points());
		statement.setString(6, entity.getUser_image());
		return statement;
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, User entity) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Update tblUser SET user_name=?, gender=?, address=?, reward_points=? , user_image=? where user_id=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getUser_name());
		statement.setString(2, entity.getGender());
		statement.setString(3, entity.getAddress());
		statement.setFloat(4, entity.getReward_points());
		statement.setString(5, entity.getUser_image());
		statement.setString(6, entity.getUser_id());
		return statement;
	}

	@Override
	protected User mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUser_id(rs.getString("user_id"));
		user.setUser_name(rs.getString("user_name"));
		user.setGender(rs.getString("gender"));
		user.setAddress(rs.getString("address"));
		user.setReward_points(rs.getFloat("reward_points"));
		user.setUser_image(rs.getString("user_image"));
		return user;
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "tblUser";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		// TODO Auto-generated method stub
		return "user_id";
	}

	public static List<String[]> getAllUser() throws Exception {
		String sql = "select user_id, user_name, gender,address, reward_points, user_image from tblUser where deleted=0";
		List<String[]> users = new ArrayList<>();
		try (Connection conn = ConnectDB.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			while (rs.next()) {
				users.add(new String[] { rs.getString("user_id"), rs.getString("user_name"), rs.getString("gender"),
						rs.getString("address"), rs.getString("reward_points"), rs.getString("user_image") });
			}
			return users;
		} catch (Exception ex) {
			throw new Exception("Đã xảy ra lỗi truy vấn trong UserDAO", ex);
		}
	}

}
