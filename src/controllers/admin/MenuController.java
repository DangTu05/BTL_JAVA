package controllers.admin;

import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Interfaces.IAccountView;
import Interfaces.IHomeNavigableView;
import Interfaces.IMenuView;
import Interfaces.IMoviesView;
import components.SideBarMenu;
import controllers.AppController;
import utils.MessageConstants;
import utils.MessageUtil;
import views.Login;
import views.Admin.Accounts;
import views.Admin.Actors;
import views.Admin.Menu;
import views.Admin.Movies;

public class MenuController extends BaseController {
	private IHomeNavigableView viewMenu;
	private IMenuView view;
	private AppController app;
	private JPanel mainContentPanel;
	private CardLayout cardLayout;
	private Map<String, JPanel> panelMap = new HashMap<>();

	public MenuController(IMenuView viewMain) {
		this.view = viewMain;
		this.viewMenu = view.getSideBar();
		app = new AppController();
		setMainContent(view.getMainContentJpanel());
		initializePanelsAndControllers();
		setUpEventListeners();

	}

	@Override
	protected void getSetData() {
		// TODO Auto-generated method stub
	}

	protected void setMainContent(JPanel mainContentPanel) {
		this.mainContentPanel = mainContentPanel;
		this.cardLayout = (CardLayout) mainContentPanel.getLayout();
	}

	private void initializePanelsAndControllers() {
		// Accounts
		Accounts accountsPanel = new Accounts();
		new AccountsController(accountsPanel);
		panelMap.put("accounts", accountsPanel);
		mainContentPanel.add(accountsPanel, "accounts");

		// Movies
		Movies moviesPanel = new Movies();
		new MoviesController(moviesPanel);
		panelMap.put("movies", moviesPanel);
		mainContentPanel.add(moviesPanel, "movies");

		// Actors
		Actors actorsPanel = new Actors();
		new ActorsController(actorsPanel);
		panelMap.put("actors", actorsPanel);
		mainContentPanel.add(actorsPanel, "actors");

		// (Optional) Home - có thể là dashboard hoặc trang trắng
		JPanel homePanel = new JPanel();
		homePanel.add(new javax.swing.JLabel("Welcome to Admin Dashboard"));
		panelMap.put("home", homePanel);
		mainContentPanel.add(homePanel, "home");

		// Show mặc định
		cardLayout.show(mainContentPanel, "home");
	}

	protected void navigateTo(String panelName) {
		if (panelMap.containsKey(panelName)) {
			cardLayout.show(mainContentPanel, panelName);
		}
	}

	public void setUpEventListeners() {
		view.getSideBar().getBtnHome().addActionListener(e -> navigateTo("home"));
		view.getSideBar().getBtnAccount().addActionListener(e -> navigateTo("accounts"));
		view.getSideBar().getBtnPhim().addActionListener(e -> navigateTo("movies"));
		view.getSideBar().getBtnDienVien().addActionListener(e -> navigateTo("actors"));
		view.getSideBar().getBtnLogout().addActionListener(e -> logout());
	}

	public void logout() {
		if (!MessageUtil.confirm(MessageConstants.CONFIRM_LOGOUT))
			return;
		app.startLogin(view.getFrame());
	}

}
