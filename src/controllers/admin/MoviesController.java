package controllers.admin;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import Interfaces.IMoviesView;
import dao.MovieDAO;
import utils.ErrorUtil;

public class MoviesController {
	private IMoviesView view;

	public MoviesController(IMoviesView view) {
		this.view = view;
		setUpEventListeners();
		loadDataFromDataBase();
	}

	private void setUpEventListeners() {
		view.setAccountSelectionListener(e -> addTableListener());
		view.setResetListener(e -> view.reset());
		view.setTaoListener(e->view.redirectCreateMovie());
	}

	private void loadDataFromDataBase() {
		try {
			view.loadDataFromDataBase(MovieDAO.getAllMoive());
		} catch (Exception e) {
			ErrorUtil.handle(e, "đã xảy ra lỗi!!!");
		}
	}

	private void addTableListener() {
		view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {/// Kiểm tra để tránh xử lý khi người dùng đang kéo chuột chọn, chỉ
					/// xử lý khi việc chọn đã hoàn tất
					int countRow = view.getTable().getRowCount();
					int selectedRow = view.getTable().getSelectedRow();
					if (selectedRow != -1) {
						Object movie_id = view.getTable().getValueAt(selectedRow, 0);
						Object movie_name = view.getTable().getValueAt(selectedRow, 1);
						Object release_date = view.getTable().getValueAt(selectedRow, 2);
						Object director = view.getTable().getValueAt(selectedRow, 3);
						Object duration = view.getTable().getValueAt(selectedRow, 4);
						Object script = view.getTable().getValueAt(selectedRow, 5);
						Object age_permission = view.getTable().getValueAt(selectedRow, 6);
						Object poster = view.getTable().getValueAt(selectedRow, 7);
						Object status = view.getTable().getValueAt(selectedRow, 8);
						view.setFormData(movie_id != null ? movie_id.toString() : "",
								movie_name != null ? movie_name.toString() : "",
								release_date != null ? release_date.toString() : "",
								director != null ? director.toString() : "",
								duration != null ? Integer.parseInt((String) duration) : 1,
								script != null ? script.toString() : "",
								age_permission != null ? Integer.parseInt((String) age_permission) : 1,
								poster != null ? poster.toString() : "", status != null ? status.toString() : "");
					}
				}

			}
		});
	}
}
