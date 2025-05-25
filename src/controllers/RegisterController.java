package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Interfaces.IRegisterView;
import models.Account;
import models.User;
import services.RegisterService;
import utils.ErrorUtil;
import utils.GenerateIdUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import utils.PasswordUtil;
import validator.InputValidate;

public class RegisterController {
	private IRegisterView dk;
	private RegisterService registerService;

	public RegisterController(IRegisterView dk) {
		this.dk = dk;
		registerService = new RegisterService();
		setupEventListeners();
		// TODO Auto-generated constructor stub
	}

	public void setupEventListeners() {
		dk.setRegisterListener(e -> registerAccount());
		dk.setRedirectLogin((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AppController.startLogin(dk.getFrame());
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
			if (!registerService.registerAccount(newUser, newAccount)) {
				MessageUtil.showError(MessageConstants.ERROR_CREATE);
				return;
			}
			boolean result = MessageUtil.confirm("Bạn đã đăng kí thành công. Chuyển sang đăng nhập?");
			if (result) {
				AppController.startLogin(dk.getFrame());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorUtil.handle(e, e.getMessage());
		}
	}

}
