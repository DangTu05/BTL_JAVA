package controllers.admin;

import java.sql.ResultSet;
import java.util.List;

import dao.AccountDAO;
import models.Account;
import views.Admin.Accounts;

public class AccountsController {
	public Accounts acc;
	private AccountDAO account;

	public AccountsController(Accounts acc) {
		this.acc = acc;
		this.account = new AccountDAO();
	}

	public AccountsController() {
		this.account = new AccountDAO();
	}

	public List<String[]> getAllAccount() {
		return account.getAllAccounts();
	}

}
