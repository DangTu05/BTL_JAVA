package controllers.admin;

import Interfaces.IMovies;
import dao.MovieDAO;
import utils.ErrorUtil;

public class MoviesController {
	private IMovies view;

	public MoviesController(IMovies view) {
		this.view = view;
		setUpEventListeners();
		loadDataFromDataBase();
	}

	private void setUpEventListeners() {

	}

	private void loadDataFromDataBase() {
		try {
			view.loadDataFromDataBase(MovieDAO.getAllMoive());
		} catch (Exception e) {
			ErrorUtil.handle(e, "đã xảy ra lỗi!!!");
		}
	}
}
