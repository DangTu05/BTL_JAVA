package controllers.admin;

import Interfaces.IAccountView;
import Interfaces.IMenuView;
import Interfaces.IMoviesView;
import utils.MessageUtil;
import views.Login;
import views.Admin.Accounts;
import views.Admin.Menu;
import views.Admin.Movies;

public class MenuController {
	private IMenuView viewMenu;
	private AppController app;

	public MenuController(IMenuView viewMenu) {
		this.viewMenu = viewMenu;
		app = new AppController();
		setUpEventListeners();
	}

	private void setUpEventListeners() {
		viewMenu.setHomeListener(e -> app.startHome(viewMenu.getFrame()));
		viewMenu.setAccountListener(e -> app.startAccounts(viewMenu.getFrame()));
		viewMenu.setLogoutListener(e -> logout());
		viewMenu.setMovieListener(e -> app.startMovies(viewMenu.getFrame()));
	}

	private void logout() {
		if (!MessageUtil.confirm("Bạn có muốn đăng xuất không?"))
			return;
		app.startLogin(viewMenu.getFrame());
	}
}
