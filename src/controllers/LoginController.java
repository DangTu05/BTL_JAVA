package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dao.AccountDAO;
import models.Account;
import utils.ErrorUtils;
import utils.MessageUtils;
import utils.PasswordUtils;
import validator.InputValidate;
import views.Login;
import views.Admin.Menu;

public class LoginController implements MouseListener {
	public Login login;

	public LoginController(Login login) {
		// TODO Auto-generated constructor stub
		this.login = login;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == login.btnDN) {
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
					login.dispose();
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				ErrorUtils.handle(e1, e1.getMessage());
			}
		}
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
