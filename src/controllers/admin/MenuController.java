package controllers.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.Admin.Accounts;
import views.Admin.Menu;

public class MenuController implements ActionListener {
	public Menu menu;

	public MenuController(Menu menu) {
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cm=e.getActionCommand();
		if(cm.equals("Tài Khoản")) {
			new Accounts().setVisible(true);
		}
		else if(cm.equals("Trang Chủ")) {
			new Menu().setVisible(true);
		}

	}

}
