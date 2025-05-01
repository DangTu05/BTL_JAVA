package views.Admin;

import controllers.admin.AccountsController;

public class AdminMain {
	public static void main(String[] args) {
		// 1. Khởi tạo View TRƯỚC
		Accounts view = new Accounts();

		// 2. Khởi tạo Controller SAU KHI view đã sẵn sàng
		AccountsController controller = new AccountsController(view);

		// 3. Hiển thị giao diện
		view.setVisible(true);
	}
}
