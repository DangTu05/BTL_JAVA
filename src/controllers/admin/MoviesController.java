package controllers.admin;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Interfaces.IHomeNavigableView;
import Interfaces.IMoviesView;
import dao.MovieDAO;
import models.Movie;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;

public class MoviesController extends BaseController<Movie> {
	private IMoviesView view;
	private MovieDAO dao;
	private AppController app;

	public MoviesController(IMoviesView view) {
		this.view = view;
		dao = new MovieDAO();
		app = new AppController();
		setUpEventListeners();
		loadDataFromDataBase();
	}

	private void setUpEventListeners() {
		view.setMovieSelectionListener(e -> addTableListener(view.getTable()));
		view.setResetListener(e -> view.reset());
		view.setTaoListener(e -> app.startCreateMovie(getFrame()));
		view.setLuuListener(e -> updateMovie());
		view.setXoaListener(e -> softDelete());
		view.setSearchListener(e -> loadDataFromSearch());
	}

	private void loadDataFromDataBase() {
		try {
			view.loadDataFromDataBase(MovieDAO.getAllMoive());
		} catch (Exception e) {
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

	private void updateMovie() {
		try {
			if (view.getMovie_Id().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn phim muốn sửa!");
				return;
			}
			Movie movie = new Movie(view.getMovie_Id(), view.getMovie_Name(), view.getNgayPhatHanh(),
					view.getDirector(), view.getThoiLuong(), view.getScript(), view.getDoTuoi(), view.getPoster(),
					view.getStatus());
			if (!MessageUtil.confirm(MessageConstants.CONFIRM_UPDATE))
				return;
			if (!dao.update(movie)) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_UPDATE);
			view.loadDataFromDataBase(MovieDAO.getAllMoive());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

	private void softDelete() {

		try {
			if (view.getMovie_Id().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn phim muốn xóa!");
				return;
			}
			if (!dao.softDelete(view.getMovie_Id())) {
				MessageUtil.showError(MessageConstants.ERROR_DELETE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_DELETE);
			view.loadDataFromDataBase(MovieDAO.getAllMoive());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

	@Override
	protected void getSetData() {
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
					release_date != null ? release_date.toString() : "", director != null ? director.toString() : "",
					duration != null ? Integer.parseInt((String) duration) : 1, script != null ? script.toString() : "",
					age_permission != null ? Integer.parseInt((String) age_permission) : 1,
					poster != null ? poster.toString() : "", status != null ? status.toString() : "");
		}
	}

	protected JPanel getJPanel() {
		return view.getMainPanel();
	}

	public void loadDataFromSearch() {
		try {
			view.loadDataFromDataBase(MovieDAO.findMovieByName(view.getTextSearch()));
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

}
