package views.Admin;

import controllers.RegisterController;
import controllers.admin.AccountsController;
import views.Register;

public class AdminMain {
	public static void main(String[] args) {
		// 1. Khởi tạo View TRƯỚC
//		Accounts view = new Accounts();
Register dk=new Register();
		// 2. Khởi tạo Controller SAU KHI view đã sẵn sàng
//		AccountsController controller = new AccountsController(view);
RegisterController controller=new RegisterController(dk);
		// 3. Hiển thị giao diện
		dk.setVisible(true);
	}
}
