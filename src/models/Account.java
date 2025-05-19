package models;

public class Account {
	private String Account_Id;
	private String User_Name;
	private String Email;
	private String Password;
	private String RoleName;
	private String Status;
	private String User_id;

	public Account(String account_Id, String user_Name, String email, String password, String user_id) {
		Account_Id = account_Id;
		User_Name = user_Name;
		Email = email;
		Password = password;
		RoleName = "USER";
		Status = "active";
		User_id = user_id;
	}

	public Account() {
		// TODO Auto-generated constructor stub
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

}
