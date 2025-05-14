package controllers.admin;

import Interfaces.IAccountView;
import Interfaces.IHomeNavigableView;
import Interfaces.IMenuView;
import Interfaces.IMoviesView;
import components.SideBarMenu;
import utils.MessageUtil;
import views.Login;
import views.Admin.Accounts;
import views.Admin.Menu;
import views.Admin.Movies;

public class MenuController extends BaseController {
	private IHomeNavigableView viewMenu;
	private IMenuView view;
	private AppController app;

	public MenuController(IMenuView viewMain) {
		this.view = viewMain;
		this.viewMenu = view.getSideBar();
		app = new AppController();
		setAction();
	}

	@Override
	protected void getSetData() {
		// TODO Auto-generated method stub

	}

	@Override
	protected IHomeNavigableView getView() {
		// TODO Auto-generated method stub
		return viewMenu;
	}

}
