package views.Admin;

import controllers.LoginController;
import controllers.RegisterController;
import controllers.admin.AccountsController;
import controllers.admin.ActorsController;
import controllers.admin.CreateActorController;
import controllers.admin.CreateCategoryController;
import controllers.admin.CreateMovieController;
import controllers.admin.MoviesController;
import views.Login;
import views.Register;

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
		Actors view = new Actors();
		// 2. Khởi tạo Controller SAU KHI view đã sẵn sàng
//		AccountsController controller = new AccountsController(view);
//RegisterController controller=new RegisterController(dk);
//		LoginController controller=new LoginController(view);
//		CreateActorController controller = new CreateActorController(view);
//		CreateMovieController controller = new CreateMovieController(view);
//		new CreateCategoryController(view); 
//		new MoviesController(view);
		new ActorsController(view);
		// 3. Hiển thị giao diện
		view.setVisible(true);
	}
}
