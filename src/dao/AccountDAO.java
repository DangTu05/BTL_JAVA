package dao;

import models.Account;
import utils.ErrorUtil;
import Configs.Database.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends BaseDAO<Account> {
	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Account tk) throws SQLException {
		String sql = "INSERT INTO account (UserName, Email, Password,AccountId, RoleName,Status) VALUES (?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, tk.getUser_Name());
		statement.setString(2, tk.getEmail());
		statement.setString(3, tk.getPassword());
		statement.setString(4, tk.getAccount_Id().substring(0, 10));
		statement.setString(5, tk.getRoleName());
		statement.setString(6, tk.getStatus());
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

	public static List<String[]> findTksByName(String name) {
		List<String[]> accounts = new ArrayList<>();
		String query = "Select * from account where deleted=false and UserName Like ?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accounts.add(new String[] { rs.getString("AccountId"), rs.getString("UserName"), rs.getString("Email"),
						"******", // Che mật khẩu
						rs.getString("Status"), rs.getString("RoleName") });
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Lỗi khi tìm kiếm tài khoản", e1);
		}
		return accounts;
	}

	public static List<String[]> getAllAccounts() {
		String query = "SELECT * FROM account";
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
			throw new RuntimeException("Lỗi khi tìm kiếm tài khoản", e1);
		}
		return accounts;
	}

	public static boolean changePassword(String password, String email) {
		String sql = "Update account set password=? where email=?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, password);
			statement.setString(2, email);
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Cập nhật trạng thái thất bại: " + e.getMessage(), e);
		}
	}

}