package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;

import javax.swing.Action;
import javax.swing.JOptionPane;
import Interfaces.IRegisterView;
import dao.AccountDAO;
import models.Account;
import utils.ErrorUtils;
import utils.GenerateId;
import utils.MessageUtils;
import utils.PasswordUtils;
import validator.InputValidate;
import views.Login;
import views.Register;

public class RegisterController {
	private IRegisterView dk;

	public RegisterController(IRegisterView dk) {
		this.dk = dk;
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
			if (!AccountDAO.addTaiKhoan(newAccount)) {
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
