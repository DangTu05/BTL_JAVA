package controllers.admin;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Interfaces.IHomeNavigableView;
import utils.MessageUtil;
import views.Admin.Accounts;
import views.Admin.Actors;
import views.Admin.Menu;
import views.Admin.Movies;

public abstract class BaseController<T> {
	private AppController app;


	protected abstract void getSetData();

//	protected abstract IHomeNavigableView getView();

	protected void addTableListener(JTable table) {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {/// Kiểm tra để tránh xử lý khi người dùng đang kéo chuột chọn, chỉ
					/// xử lý khi việc chọn đã hoàn tất
					int countRow = table.getRowCount();
					getSetData();
				}

			}
		});
	}

//	protected void setAction() {
//		app = new AppController();
//		getView().setHomeListener(e -> app.startHome(getView().getFrame()));
//		getView().setAccountListener(e -> app.startAccounts(getView().getFrame()));
//		getView().setLogoutListener(e -> logout());
//		getView().setMovieListener(e -> app.startMovies(getView().getFrame()));
//	}
//
//	private void logout() {
//		if (!MessageUtil.confirm("Bạn có muốn đăng xuất không?"))
//			return;
//		app.startLogin(getView().getFrame());
//	}
	

}
