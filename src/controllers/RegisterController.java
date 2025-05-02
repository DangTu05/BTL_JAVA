package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Interfaces.IRegisterView;
import dao.AccountDAO;
import models.Account;
import utils.ErrorUtils;
import utils.GenerateId;
import utils.MessageUtils;
import utils.PasswordUtils;
import validator.InputValidate;

public class RegisterController {
	private IRegisterView dk;
	private AccountDAO dao;

	public RegisterController(IRegisterView dk) {
		this.dk = dk;
		dao = new AccountDAO();
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
			password = PasswordUtils.hashPassword(password);
			Account newAccount = new Account(GenerateId.generateId("ACC"), username, email, password);
			if (!dao.insert(newAccount)) {
				return;
			}
			boolean result = MessageUtils.confirm("Bạn đã đăng kí thành công. Chuyển sang đăng nhập?");
			if (result) {
				redirectLogin();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorUtils.handle(e, "Đã xảy ra lỗi!!!");
		}
	}

	public void redirectLogin() {
		dk.redirectLogin();
	}
}
