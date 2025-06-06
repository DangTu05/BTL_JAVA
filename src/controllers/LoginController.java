package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Interfaces.ILoginView;
import models.Account;
import services.UserService;
import services.admin.AccountService;
import utils.ErrorUtil;
import utils.MessageUtil;
import utils.PasswordUtil;
import utils.Session;
import validator.InputValidate;


public class LoginController {
	private ILoginView viewLogin;
	private UserService userService;
	private AccountService accountService;

	public LoginController(ILoginView login) {
		// TODO Auto-generated constructor stub
		this.viewLogin = login;
		accountService = new AccountService();
		userService = new UserService();
		setupEventListeners();
	}

	private void setupEventListeners() {
		viewLogin.setLoginListener(e -> loginAccount());
		viewLogin.setRedirectRegister((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				redirectRegister();
			}
		});
		viewLogin.setForgotPassWord((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				redirectForgotPassword();
			}
		});
	}

	private void loginAccount() {
		try {
			if (!InputValidate.loginValidate(viewLogin.getEmail(), viewLogin.getPassword()))
				return;
			Account account = accountService.findAccountByEmail(viewLogin.getEmail());
			if (!PasswordUtil.checkPassword(viewLogin.getPassword(), account.getPassword())) {
				MessageUtil.showInfo("Thông tin không hợp lệ!");
				return;
			}
			if(account.getStatus().equals("inactive")) {
				MessageUtil.showInfo("Tài khoản này đã bị khóa!");
				return;
			}
			MessageUtil.showInfo("Đăng nhập thành công!");
			if (account.getRoleName().equals("ADMIN"))
				AppController.startDashboard(viewLogin.getFrame());
			else {
				Session.setEmail(account.getEmail());
				Session.setUser(userService.getUserById(account.getUser_id()));
				AppController.startHome(viewLogin.getFrame());
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			ErrorUtil.handle(e1, e1.getMessage());
		}
	}

	private void redirectRegister() {
		AppController.startRegister(viewLogin.getFrame());
	}

	private void redirectForgotPassword() {
		AppController.startForgotPassword(viewLogin.getFrame());
	}

}
