package dao;

import models.Account;
import Configs.Database.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends BaseDAO<Account> {
	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Account tk) throws SQLException {
		String sql = "INSERT INTO account (UserName, Email, Password,AccountId, RoleName,Status,User_id) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, tk.getUser_Name());
		statement.setString(2, tk.getEmail());
		statement.setString(3, tk.getPassword());
		statement.setString(4, tk.getAccount_Id().substring(0, 10));
		statement.setString(5, tk.getRoleName());
		statement.setString(6, tk.getStatus());
		statement.setString(7, tk.getUser_id());
		return statement;
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, Account tk) throws SQLException {
		String sql = "UPDATE account SET UserName=?, Email=?,Password=?,Status=? where AccountId = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, tk.getUser_Name());
		statement.setString(2, tk.getEmail());
		statement.setString(3, tk.getPassword());
		statement.setString(4, tk.getStatus());
		statement.setString(5, tk.getAccount_Id());
		return statement;
	}

	@Override
	protected Account mapRow(ResultSet rs) throws SQLException {
		Account acc = new Account();
		acc.setAccount_Id(rs.getString("AccountId"));
		acc.setEmail(rs.getString("Email"));
		acc.setPassword(rs.getString("Password"));
		acc.setRoleName(rs.getString("RoleName"));
		acc.setStatus(rs.getString("Status"));
		acc.setUser_Name(rs.getString("UserName"));
		acc.setUser_id(rs.getString("User_id"));
		return acc;
	}

	@Override
	protected String getTableName() {
		return "account";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		return "AccountId";
	}

	public static List<String[]> findTksByName(String name) throws Exception {
		List<String[]> accounts = new ArrayList<>();
		String query = "Select * from account where deleted=false and UserName Like ? and RoleName='USER'";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(new String[] { rs.getString("AccountId"), rs.getString("UserName"), rs.getString("Email"),
						"******", // Che mật khẩu
						rs.getString("Status"), rs.getString("RoleName") });
			}
		} catch (Exception e1) {
			throw new Exception("Lỗi tìm kiếm tài khoản trong DAO!!!", e1);
		}
		return accounts;
	}

	public static List<String[]> getAllAccounts() throws Exception {
		String query = "SELECT * FROM account where RoleName='USER'";
		List<String[]> accounts = new ArrayList<>();

		try (Connection conn = ConnectDB.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				accounts.add(new String[] { rs.getString("AccountId"), rs.getString("UserName"), rs.getString("Email"),
						"******", // Che mật khẩu
						rs.getString("Status"), rs.getString("RoleName") });
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new Exception("Lỗi khi tìm kiếm tài khoản trong DAO", e1);
		}
		return accounts;
	}

	public static boolean changePassword(String password, String email) throws Exception {
		String sql = "Update account set password=? where email=?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, password);
			statement.setString(2, email);
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Đổi mật khẩu thất bại: " + e.getMessage(), e);
		}
	}

}