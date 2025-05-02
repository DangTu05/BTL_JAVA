package dao;

import models.Account;
import utils.ErrorUtils;
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

	public static Account findTkById(String id) throws Exception {
		Account acc = null;
		String query = "Select * from account where AccountId = ?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				acc = new Account();
				acc.setAccount_Id(rs.getString("AccountId"));
				acc.setEmail(rs.getString("Email"));
				acc.setPassword(rs.getString("Password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Lỗi khi tìm kiếm tài khoản", e);
		}
		return acc;
	}

	@Override
	protected String getTableName() {
		return "account";
	}

	protected String getPrimaryKetColumn() {
		return "AccountId";
	}

	public static Account findTkByEmail(String email) throws Exception {
		Account acc = null;
		String query = "Select * from account where Email = ?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				acc = new Account();
				acc.setAccount_Id(rs.getString("AccountId"));
				acc.setEmail(rs.getString("Email"));
				acc.setPassword(rs.getString("Password"));
				acc.setStatus(rs.getString("Status"));
				acc.setRoleName(rs.getString("RoleName"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Lỗi khi tìm kiếm tài khoản", e);
		}
		return acc;
	}

	public static List<String[]> findTksByName(String name) {
		List<String[]> accounts = new ArrayList<>();
		String query = "Select * from account where UserName Like ?";
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

}