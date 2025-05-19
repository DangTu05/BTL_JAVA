package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Interfaces.ITrangChuView;
import dao.MovieDAO;
import views.Frames.TrangChu;

public class TrangChuController {
	private ITrangChuView viewTrangChu;
	private AppController app;

	public TrangChuController(ITrangChuView viewTrangChu) {
		this.viewTrangChu = viewTrangChu;
		app = new AppController();
		loadDataFromDatabase();
		setupEventListeners();

	}

	private void setupEventListeners() {
		viewTrangChu.setDangKiListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				app.startRegister(viewTrangChu.getFrame());
			}
		});
		viewTrangChu.setDangNhapListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				app.startLogin(viewTrangChu.getFrame());
			}
		});
	}

	private void loadDataFromDatabase() {
		viewTrangChu.hienThiDanhSachPhim(MovieDAO.getListMoive());
	}
}
