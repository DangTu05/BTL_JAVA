package views.Frames.Admin;

import Interfaces.IMoviesView;
import controllers.LoginController;
import controllers.RegisterController;
import controllers.HomeController;
import controllers.admin.AccountsController;
import controllers.admin.ActorsController;
import controllers.admin.CreateActorController;
import controllers.admin.CreateCategoryController;
import controllers.admin.CreateMovieController;
import controllers.admin.CreateVoucherController;
import controllers.admin.MenuController;
import controllers.admin.MoviesController;
import views.Frames.Login;
import views.Frames.Register;
import views.Frames.Home;

public class AdminMain {
	public static void main(String[] args) {
		// 1. Khởi tạo View TRƯỚC
//		Accounts view = new Accounts();
//Register view=new Register();
//		Login view=new Login();
//		CreateActor view = new CreateActor();
//		CreateMovie view = new CreateMovie();
//		CreateCategory view=new CreateCategory();
//		CreateVoucher view = new CreateVoucher();
//		Movies view = new Movies();
		Menu view=new Menu();
//		Home view=new Home("Trang chủ");
//		Actors view = new Actors();
		// 2. Khởi tạo Controller SAU KHI view đã sẵn sàng
//		AccountsController controller = new AccountsController(view);
//RegisterController controller=new RegisterController(view);
//		LoginController controller=new LoginController(view);
//		CreateActorController controller = new CreateActorController(view);
//		CreateMovieController controller = new CreateMovieController(view);
//		new CreateVoucherController(view);
//		new CreateCategoryController(view); 
//		new MoviesController(view);
		new MenuController(view);
//		new HomeController(view);
//		new ActorsController(view);
		// 3. Hiển thị giao diện
		view.setVisible(true);
	}
}
