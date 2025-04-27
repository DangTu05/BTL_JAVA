package models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Configs.Database.ConnectDB;
import Interfaces.IAccount;

public class Account implements IAccount {
	private String Account_Id;
	private String User_Name;
	private String Email;
	private String Password;
	private String RoleName;
	private String Status;

	public Account(String account_Id, String user_Name, String email, String password) {
		super();
		Account_Id = account_Id;
		User_Name = user_Name;
		Email = email;
		Password = password;
		RoleName = "USER";
		Status = "active";
	}

	public Account(String account_Id, String user_Name, String email, String password, String roleName) {
		super();
		Account_Id = account_Id;
		User_Name = user_Name;
		Email = email;
		Password = password;
		RoleName = roleName;
	}

	public String getAccount_Id() {
		return Account_Id;
	}

	public void setAccount_Id(String account_Id) {
		Account_Id = account_Id;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	// public void setRole_Id() {
//			RoleName = "USER";
//		}
//	public Account(String role_Id) {
//			this.RoleName = "USER";
//		}
	public Account() {
		// TODO Auto-generated constructor stub
	}
//	public void addTaiKhoan(IAccount tk) throws Exception{
//		Connection conn=ConnectDB.getConnection();
//		String sql= "INSERT INTO account VALUES (?, ?)";
//		PreparedStatement statement= conn.prepareStatement(sql);
//		statement.setString(1,tk.getUser_Name());
//		statement.setString(2,tk.getEmail());
//		statement.setString(3,tk.getPassword());
//		statement.setString(4,tk.getAccount_Id());
//		statement.setString(5,tk.getRole_Id());
//		statement.executeUpdate();
//	}


	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
