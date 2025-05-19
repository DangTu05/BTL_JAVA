package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Interfaces.ILoginView;
import dao.AccountDAO;
import dao.UserDAO;
import models.Account;
import models.User;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import utils.PasswordUtil;
import utils.Session;
import validator.InputValidate;
import views.Frames.Admin.Menu;

public class LoginController {
	private ILoginView viewLogin;
	private AccountDAO daoAccount;
	private UserDAO daoUser;

	public LoginController(ILoginView login) {
		// TODO Auto-generated constructor stub
		this.viewLogin = login;
		daoAccount = new AccountDAO();
		daoUser = new UserDAO();
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
			Account account = daoAccount.findByField("Email", viewLogin.getEmail());

			if (account == null) {
				MessageUtil.showInfo("Thông tin không hợp lệ!");
				return;
			}
			User user = daoUser.findByField("user_id", account.getUser_id());
			if (!PasswordUtil.checkPassword(viewLogin.getPassword(), account.getPassword())) {
				MessageUtil.showInfo("Thông tin không hợp lệ!");
				return;
			}
			MessageUtil.showInfo("Đăng nhập thành công!");
			if (account.getRoleName().equals("ADMIN"))
				AppController.startDashboard(viewLogin.getFrame());
			else {
				Session.setUser(user);
				AppController.startHome(viewLogin.getFrame());
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			ErrorUtil.handle(e1, MessageConstants.ERROR_GENERIC);
		}
	}

	private void redirectRegister() {
		AppController.startRegister(viewLogin.getFrame());
	}

	private void redirectForgotPassword() {
		AppController.startForgotPassword(viewLogin.getFrame());
	}

}
