package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Interfaces.ILoginView;
import dao.AccountDAO;
import models.Account;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import utils.PasswordUtil;
import validator.InputValidate;
import views.Frames.Admin.Menu;

public class LoginController {
	private ILoginView viewLogin;
	private AccountDAO dao;
	private AppController app;

	public LoginController(ILoginView login) {
		// TODO Auto-generated constructor stub
		this.viewLogin = login;
		app = new AppController();
		dao = new AccountDAO();
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
			Account user = dao.findByField("Email", viewLogin.getEmail());
			if (user == null) {
				MessageUtil.showInfo("Thông tin không hợp lệ!");
				return;
			}
			if (!PasswordUtil.checkPassword(viewLogin.getPassword(), user.getPassword())) {
				MessageUtil.showInfo("Thông tin không hợp lệ!");
				return;
			}
			if (user.getRoleName().equals("ADMIN")) {
				MessageUtil.showInfo("Đăng nhập thành công!");
				new Menu().setVisible(true);
//				login.hidenLoginPage();
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			ErrorUtil.handle(e1, MessageConstants.ERROR_GENERIC);
		}
	}

	private void redirectRegister() {
		app.startRegister(viewLogin.getFrame());
	}

	private void redirectForgotPassword() {
		app.startForgotPassword(viewLogin.getFrame());
	}

}
