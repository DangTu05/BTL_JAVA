package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Interfaces.IRegisterView;
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

public class RegisterController {
	private IRegisterView dk;
	private AccountDAO daoAccount;
	private UserDAO daoUser;

	public RegisterController(IRegisterView dk) {
		this.dk = dk;
		daoAccount = new AccountDAO();
		daoUser = new UserDAO();
		setupEventListeners();
		// TODO Auto-generated constructor stub
	}

	public void setupEventListeners() {
		dk.setRegisterListener(e -> registerAccount());
		dk.setRedirectLogin((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				redirectLogin();
			}
		});

	}

	public void registerAccount() {

		try {
			String username = dk.getUserName();
			String email = dk.getEmail();
			String password = dk.getPassword();
			if (!InputValidate.registerValidate(email, username, password))
				return;
			password = PasswordUtil.hashPassword(password);
			User newUser = new User(GenerateIdUtil.generateId("USER"), "", "", "", "", 0);
			Account newAccount = new Account(GenerateIdUtil.generateId("ACC"), username, email, password,
					newUser.getUser_id());
			if (!daoUser.insert(newUser)) {
				MessageUtil.showError(MessageConstants.ERROR_CREATE);
				return;
			}
			if (!daoAccount.insert(newAccount)) {
				daoUser.delete(newUser.getUser_id());
				return;
			}
			boolean result = MessageUtil.confirm("Bạn đã đăng kí thành công. Chuyển sang đăng nhập?");
			if (result) {
				redirectLogin();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

	public void redirectLogin() {
		dk.redirectLogin();
	}
}
