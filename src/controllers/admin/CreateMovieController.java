package controllers.admin;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import Configs.Database.ConnectDB;
import Interfaces.ICreateMovieView;
import dao.ActorDAO;
import dao.CategoryDAO;
import dao.MovieActorDAO;
import dao.MovieDAO;
import middlewares.UploadCloud;
import models.Actor;
import models.Category;
import models.Movie;
import models.MovieActor;
import utils.ErrorUtils;
import utils.GenerateId;
import utils.MessageUtils;
import validator.InputValidate;
import views.Admin.CreateMovie;

public class CreateMovieController {
	private MovieDAO dao;
	private ICreateMovieView view;
	private MovieActorDAO movie_actorDao;

	public CreateMovieController(ICreateMovieView view) {
		this.view = view;
		dao = new MovieDAO();
		movie_actorDao = new MovieActorDAO();
		setupEventListener();
		loadActorToView();
		loadCategoryToView();
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
			List<Actor> actors = view.getSelectedItemList(view.getListActor());

			movie = new Movie(movie_id, movie_name, release_date, director, duration, script, age_permisson, urlImg,
					status);
			if (!dao.insert(movie)) {
				MessageUtils.showInfo("Tạo không thành công!!!");
				return;
			}
			if (!actors.isEmpty()) {
				for (Actor actor : actors) {
					movie_actorDao.insert(new MovieActor(movie_id, actor.getActor_id()));
				}
			}
			MessageUtils.showInfo("Tạo thành công");
			view.reSetForm();
			return;
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtils.handle(e, "Đã xảy ra lỗi!!");
		}
	}

	public void loadActorToView() {
		List<Actor> actors = ActorDAO.getAllActors();
		view.getItemsForList(actors, view.getListActor());
	}

	public void loadCategoryToView() {
		List<Category> categories = CategoryDAO.getAllCategory();
		view.getItemsForList(categories, view.getListCategory());
	}
}
