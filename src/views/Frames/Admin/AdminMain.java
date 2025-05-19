package views.Frames.Admin;

import Interfaces.IMoviesView;
import controllers.LoginController;
import controllers.RegisterController;
import controllers.TrangChuController;
import controllers.admin.AccountsController;
import controllers.admin.ActorsController;
import controllers.admin.CreateActorController;
import controllers.admin.CreateCategoryController;
import controllers.admin.CreateMovieController;
import controllers.admin.MenuController;
import controllers.admin.MoviesController;
import views.Frames.Login;
import views.Frames.Register;
import views.Frames.TrangChu;

public class AdminMain {
	public static void main(String[] args) {
		// 1. Khởi tạo View TRƯỚC
//		Accounts view = new Accounts();
//Register dk=new Register();
//		Login view=new Login();
//		CreateActor view = new CreateActor();
//		CreateMovie view = new CreateMovie();
//		CreateCategory view=new CreateCategory();
//		Movies view = new Movies();
		Menu view=new Menu();
//		TrangChu view=new TrangChu("Trang chủ");
//		Actors view = new Actors();
		// 2. Khởi tạo Controller SAU KHI view đã sẵn sàng
//		AccountsController controller = new AccountsController(view);
//RegisterController controller=new RegisterController(dk);
//		LoginController controller=new LoginController(view);
//		CreateActorController controller = new CreateActorController(view);
//		CreateMovieController controller = new CreateMovieController(view);
//		new CreateCategoryController(view); 
//		new MoviesController(view);
		new MenuController(view);
//		new TrangChuController(view);
//		new ActorsController(view);
		// 3. Hiển thị giao diện
		view.setVisible(true);
	}
}
