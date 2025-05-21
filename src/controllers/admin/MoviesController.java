package controllers.admin;

import javax.swing.JPanel;
import javax.swing.JTable;

import Interfaces.IMoviesView;
import controllers.AppController;
import dao.MovieDAO;
import models.Movie;
import services.admin.MovieService;
import utils.ConvertUtil;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;

public class MoviesController extends BaseController<Movie> {
	private IMoviesView view;
	private MovieService movieService;

	public MoviesController(IMoviesView view) {
		this.view = view;
		movieService = new MovieService();
		setUpEventListeners();
		loadDataFromDataBase();
	}

	private void setUpEventListeners() {
		view.setMovieSelectionListener(e -> addTableListener(view.getTable()));
		view.setResetListener(e -> view.reset());
		view.setTaoListener(e -> AppController.startCreateMovie(getFrame()));
		view.setLuuListener(e -> updateMovie());
		view.setXoaListener(e -> softDelete());
		view.setSearchListener(e -> loadDataFromSearch());
	}

	private void loadDataFromDataBase() {
		try {
			view.loadDataFromDataBase(movieService.getAllMoiveTypeString());
		} catch (Exception e) {
			ErrorUtil.handle(e, e.getMessage());
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
			if (!movieService.updateMovie(movie)) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_UPDATE);
			view.loadDataFromDataBase(MovieDAO.getAllMoiveTypeString());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	private void softDelete() {

		try {
			if (view.getMovie_Id().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn phim muốn xóa!");
				return;
			}
			if (!movieService.softDelete(view.getMovie_Id())) {
				MessageUtil.showError(MessageConstants.ERROR_DELETE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_DELETE);
			loadDataFromDataBase();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	@Override
	protected void getSetData() {
		int selectedRow = view.getTable().getSelectedRow();
		if (selectedRow == -1)
			return;

		JTable table = view.getTable();
		String movieId = String.valueOf(table.getValueAt(selectedRow, 0));
		String name = String.valueOf(table.getValueAt(selectedRow, 1));
		String releaseDate = String.valueOf(table.getValueAt(selectedRow, 2));
		String director = String.valueOf(table.getValueAt(selectedRow, 3));

		int duration = ConvertUtil.parseIntSafely(table.getValueAt(selectedRow, 4), 1);
		String script = String.valueOf(table.getValueAt(selectedRow, 5));
		int agePermission = ConvertUtil.parseIntSafely(table.getValueAt(selectedRow, 6), 0);
		String poster = String.valueOf(table.getValueAt(selectedRow, 7));
		String status = String.valueOf(table.getValueAt(selectedRow, 8));

		// Đưa về View
		view.setFormData(movieId, name, releaseDate, director, duration, script, agePermission, poster, status);

	}

	protected JPanel getJPanel() {
		return view.getMainPanel();
	}

	public void loadDataFromSearch() {
		try {
			view.loadDataFromDataBase(movieService.findMovieByName(view.getTextSearch()));
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}

}
