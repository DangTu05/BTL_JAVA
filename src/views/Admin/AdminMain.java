package views.Admin;

import controllers.LoginController;
import controllers.RegisterController;
import controllers.admin.AccountsController;
import views.Login;
import views.Register;

public class AdminMain {
	public static void main(String[] args) {
		// 1. Khởi tạo View TRƯỚC
//		Accounts view = new Accounts();
//Register dk=new Register();
		Login view=new Login();
		// 2. Khởi tạo Controller SAU KHI view đã sẵn sàng
//		AccountsController controller = new AccountsController(view);
//RegisterController controller=new RegisterController(dk);
		LoginController controller=new LoginController(view);
		// 3. Hiển thị giao diện
		view.setVisible(true);
	}
}
