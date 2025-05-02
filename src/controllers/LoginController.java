package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Interfaces.ILoginView;
import dao.AccountDAO;
import models.Account;
import utils.ErrorUtils;
import utils.MessageUtils;
import utils.PasswordUtils;
import validator.InputValidate;
import views.Admin.Menu;

public class LoginController {
	private ILoginView login;

	public LoginController(ILoginView login) {
		// TODO Auto-generated constructor stub
		this.login = login;
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
			Account user = AccountDAO.findTkByEmail(login.getEmail());
			if (user == null) {
				MessageUtils.showInfo("Thông tin không hợp lệ!");
				return;
			}
			if (!PasswordUtils.checkPassword(login.getPassword(), user.getPassword())) {
				MessageUtils.showInfo("Thông tin không hợp lệ!");
				return;
			}
			if (user.getRoleName().equals("ADMIN")) {
				MessageUtils.showInfo("Đăng nhập thành công");
				new Menu().setVisible(true);
				login.hidenLoginPage();
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			ErrorUtils.handle(e1, e1.getMessage());
		}
	}

	private void redirectRegister() {
		login.redirectRegister();
	}

}
