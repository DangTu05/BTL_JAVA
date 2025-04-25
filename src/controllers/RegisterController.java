package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;

import javax.swing.Action;
import javax.swing.JOptionPane;

import dao.AccountDAO;
import models.Account;
import utils.ErrorUtils;
import utils.MessageUtils;
import utils.PasswordUtils;
import validator.InputValidate;
import views.Login;
import views.Register;

public class RegisterController implements MouseListener {
	public Register dk;
	private AccountDAO account;

	public RegisterController(Register dk) {
		this.dk = dk;
		this.account = new AccountDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == dk.jLabel_DN) {
			try {
				new Login().setVisible(true);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == dk.btnDK) {
			try {
				String username = dk.getUserName();
				String email = dk.getEmail();
				String password = dk.getPassword();
				if (!InputValidate.registerValidate(email, username, password))
					return;
				password = PasswordUtils.hashPassword(password);
				Account newAccount = new Account(generateAccountId(), // Tự động sinh ID
						username, email, password);
				account.addTaiKhoan(newAccount);
				boolean result = MessageUtils.confirm("Bạn đã đăng kí thành công. Chuyển sang đăng nhập?");
				if (result) {
					new Login().setVisible(true);
					dk.dispose();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				ErrorUtils.handle(e1, e1.getMessage());
			}
		}
	}

	private String generateAccountId() {
		// Logic sinh ID tự động (ví dụ: UUID hoặc từ database)
		long timestamp = System.currentTimeMillis(); // VD: 1713795134421
		String timePart = String.valueOf(timestamp);
		String last6Digits = timePart.substring(timePart.length() - 6); // Lấy 6 số cuối
		return "USER-" + last6Digits;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
