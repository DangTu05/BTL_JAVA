package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Interfaces.IHomeView;
import dao.MovieDAO;
import services.admin.MovieService;
import utils.Session;
import views.Frames.Home;

public class HomeController {
	private IHomeView viewTrangChu;
	private MovieService movieService;

	public HomeController(IHomeView viewTrangChu) {
		this.viewTrangChu = viewTrangChu;
		movieService = new MovieService();
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
	}

	private void loadDataFromDatabase() {
		viewTrangChu.hienThiDanhSachPhim(movieService.getAllMovieTypeMovie()));
	}

	private void logout() {
		Session.logout();
		AppController.startLogin(viewTrangChu.getFrame());
	}
}
