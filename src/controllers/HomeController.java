package controllers;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import Interfaces.IHomeView;
import controllers.admin.AccountsController;
import controllers.admin.ActorsController;
import controllers.admin.BaseController;
import controllers.admin.MoviesController;
import controllers.admin.SettingController;
import dao.MovieDAO;
import services.admin.MovieService;
import utils.ErrorUtil;
import utils.Session;
import views.Frames.Home;
import views.Panels.Admin.Accounts;
import views.Panels.Admin.Actors;
import views.Panels.Admin.Movies;
import views.Panels.Admin.Setting;
import views.Panels.Client.Profile;

public class HomeController {
	private IHomeView viewTrangChu;
	private MovieService movieService;
	private JPanel mainContentPanel;
	private CardLayout cardLayout;
	private Map<String, JPanel> panelMap = new HashMap<>();

	public HomeController(IHomeView viewTrangChu) {
		this.viewTrangChu = viewTrangChu;
		movieService = new MovieService();
		setMainContent(viewTrangChu.getMainContentPanel());
		initializePanelsAndControllers();
		loadDataFromDatabase();
		setupEventListeners();

	}

	private void setupEventListeners() {
		viewTrangChu.getMenu().setDangKiListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AppController.startRegister(viewTrangChu.getFrame());
			}
		});
		viewTrangChu.getMenu().setDangNhapListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AppController.startLogin(viewTrangChu.getFrame());
			}
		});
		viewTrangChu.getMenu().setLogoutListener(e -> logout());
		viewTrangChu.getMenu().setInfoListener(e -> navigateTo("profile"));
	}

	private void loadDataFromDatabase() {
		try {
			viewTrangChu.hienThiDanhSachPhim(movieService.getAllMovieTypeMovie());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}

	}

	private void logout() {
		Session.logout();
		AppController.startLogin(viewTrangChu.getFrame());
	}

	private void setMainContent(JPanel mainContentPanel) {
		this.mainContentPanel = mainContentPanel;
		this.cardLayout = (CardLayout) mainContentPanel.getLayout();
	}

	private void initializePanelsAndControllers() {
		cardLayout.show(mainContentPanel, "HomePage");
	}

	protected void navigateTo(String panelName) {
		if (!panelMap.containsKey(panelName)) {
			switch (panelName) {
			case "profile":
				Profile profilePanel = new Profile("Trang cá nhân");
				new ProfileController(profilePanel);
				panelMap.put("profile", profilePanel);
				mainContentPanel.add(profilePanel, "profile");
				break;
			default:
				System.out.println("Panel not found: " + panelName);
				return;
			}
		}
		cardLayout.show(mainContentPanel, panelName);
	}
}
