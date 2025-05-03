package controllers.admin;

import java.sql.Date;

import Interfaces.ICreateMovieView;
import dao.MovieDAO;
import middlewares.UploadCloud;
import models.Movie;
import utils.ErrorUtils;
import utils.GenerateId;
import utils.MessageUtils;
import validator.InputValidate;
import views.Admin.CreateMovie;

public class CreateMovieController {
	private MovieDAO dao;
	private ICreateMovieView view;

	public CreateMovieController(ICreateMovieView view) {
		this.view = view;
		dao = new MovieDAO();
		setupEventListener();
	}

	private void setupEventListener() {
		view.setShowImgListener(e -> view.showImageChooser());
		view.setTaoListener(e -> createMovie());
	}

	public void createMovie() {
		String movie_id = GenerateId.generateId("MOVIE");
		String movie_name = view.getMovieName();
		String director = view.getDirector();
		String script = view.getMoTa();
		String status = view.getStatus();
		int age_permisson = view.getDoTuoi();
		int duration = view.getThoiLuong();
		java.sql.Date release_date = view.getNgayPhatHanh();
		try {
			Movie movie = null;
			if (!InputValidate.createMovie(movie_name, view.getFileImg()))
				return;
			String urlImg = UploadCloud.upload(view.getFileImg());
			movie = new Movie(movie_id, movie_name, release_date, director, duration, script, age_permisson, urlImg,
					status);
			if (!dao.insert(movie)) {
				MessageUtils.showInfo("Tạo không thành công!!!");
				return;
			}
			MessageUtils.showInfo("Tạo thành công");
			view.reSetForm();
			return;
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtils.handle(e, "Đã xảy ra lỗi!!");
		}
	}
}
