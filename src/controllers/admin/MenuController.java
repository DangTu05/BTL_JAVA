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
import dao.SettingDAO;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import views.Frames.Login;
import views.Frames.Admin.Menu;
import views.Panels.Accounts;
import views.Panels.Actors;
import views.Panels.Movies;
import views.Panels.Setting;

public class MenuController extends BaseController {
	private IHomeNavigableView viewMenu;
	private IMenuView view;
	private SettingDAO dao;
	private JPanel mainContentPanel;
	private CardLayout cardLayout;
	private Map<String, JPanel> panelMap = new HashMap<>();

	public MenuController(IMenuView viewMain) {
		this.view = viewMain;
		dao = new SettingDAO();
		setupSetting();
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

		Setting settingPanel = new Setting();
		new SettingController(settingPanel);
		panelMap.put("setting", settingPanel);
		mainContentPanel.add(settingPanel, "setting");

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
		view.getSideBar().getBtnSetting().addActionListener(e -> navigateTo("setting"));
	}

	public void logout() {
		if (!MessageUtil.confirm(MessageConstants.CONFIRM_LOGOUT))
			return;
		AppController.startLogin(view.getFrame());
	}

	private void setupSetting() {
		try {
			models.Setting setting = dao.findByField("setting_id", "SETTING070");
			view.getSideBar().setWebsite_Name(setting.getWebsite_name());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}

	}
}
