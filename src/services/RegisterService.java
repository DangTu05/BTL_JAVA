package services;

import dao.AccountDAO;
import dao.UserDAO;
import models.Account;
import models.User;
import utils.ErrorUtil;
import utils.GenerateIdUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import utils.PasswordUtil;
import validator.InputValidate;

public class RegisterService {
	private AccountDAO accountDao;
	private UserDAO userDao;

	public RegisterService() {
		accountDao = new AccountDAO();
		userDao = new UserDAO();
	}

	public boolean registerAccount(User newUser, Account newAccount) throws Exception {

		if (!userDao.insert(newUser))
			throw new Exception("Đăng kí không thành công!!!");
		if (!accountDao.insert(newAccount)) {
			userDao.delete(newUser.getUser_id());
			throw new Exception("Đăng kí không thành công!!!");
		}
		return true;
	}
}
