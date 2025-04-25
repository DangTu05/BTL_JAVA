package Interfaces;

import java.sql.Date;

public interface IAccount {
	String getAccount_Id();

	void setAccount_Id(String account_Id);

	String getUser_Name();

	void setUser_Name(String user_Name);

	String getEmail();

	void setEmail(String email);

	String getPassword();

	void setPassword(String password);

	String getRoleName();

//	void setRoleName();
}
