package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Interfaces.ILoginView;
import dao.AccountDAO;
import models.Account;
import utils.ErrorUtil;
import utils.MessageUtil;
import utils.PasswordUtil;
import validator.InputValidate;
import views.Admin.Menu;

public class LoginController {
	private ILoginView login;
	private AccountDAO dao;

	public LoginController(ILoginView login) {
		// TODO Auto-generated constructor stub
		this.login = login;
		dao = new AccountDAO();
		setupEventListeners();
	}

	private void setupEventListeners() {
		login.setLoginListener(e -> loginAccount());
		login.setRedirectRegister((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				redirectRegister();
			}
		});
	}

	private void loginAccount() {
		try {
			if (!InputValidate.loginValidate(login.getEmail(), login.getPassword()))
				return;
			Account user = dao.findByField("Email", login.getEmail());
			if (user == null) {
				MessageUtil.showInfo("Thông tin không hợp lệ!");
				return;
			}
			if (!PasswordUtil.checkPassword(login.getPassword(), user.getPassword())) {
				MessageUtil.showInfo("Thông tin không hợp lệ!");
				return;
			}
			if (user.getRoleName().equals("ADMIN")) {
				MessageUtil.showInfo("Đăng nhập thành công");
				new Menu().setVisible(true);
				login.hidenLoginPage();
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			ErrorUtil.handle(e1, e1.getMessage());
		}
	}

	private void redirectRegister() {
		login.redirectRegister();
	}

}
