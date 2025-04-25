package dao;

import models.Account;
import utils.ErrorUtils;
import Configs.Database.ConnectDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
	public boolean addTaiKhoan(Account tk) throws Exception {
		String sql = "INSERT INTO account (UserName, Email, Password,AccountId, RoleName) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, tk.getUser_Name());
			statement.setString(2, tk.getEmail());
			statement.setString(3, tk.getPassword());
			statement.setString(4, tk.getAccount_Id().substring(0, 10));
			statement.setString(5, tk.getRoleName());
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new IllegalArgumentException("Đăng Kí Thất Bại");
		}
	}

	public Account findTkById(String id) throws Exception {
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
			e.printStackTrace();
		}
		return acc;
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
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return acc;
	}

	public List<String[]> getAllAccounts() {
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
		} catch (SQLException e) {
			ErrorUtils.handle(e, e.getMessage());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return accounts;
	}

}