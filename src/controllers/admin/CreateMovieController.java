package controllers.admin;

import java.util.List;
import Interfaces.ICreateMovieView;
import controllers.AppController;
import dao.ActorDAO;
import dao.CategoryDAO;
import dao.MovieActorDAO;
import dao.MovieCategoryDAO;
import dao.MovieDAO;
import middlewares.UploadCloud;
import models.Actor;
import models.Category;
import models.Movie;
import models.MovieActor;
import models.MovieCategory;
import services.CreateMovieService;
import services.admin.ActorService;
import services.admin.MovieService;
import utils.ErrorUtil;
import utils.GenerateIdUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;

public class CreateMovieController {
	private MovieDAO dao;
	private ICreateMovieView view;
	private ActorService actorService;
	private MovieService movieService;

	public CreateMovieController(ICreateMovieView view) {
		this.view = view;
		movieService = new MovieService();
		actorService = new ActorService();
		dao = new MovieDAO();
		setupEventListener();
		loadActorToView();
		loadCategoryToView();
	}

	private void setupEventListener() {
		view.setShowImgListener(e -> view.showImageChooser());
		view.setTaoListener(e -> createMovie());
		view.setTrangChuListener(e -> AppController.startDashboard(view.getFrame()));
	}

	public void createMovie() {
		String movie_id = GenerateIdUtil.generateId("MOVIE");
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
			List<Category> categories = view.getSelectedItemList(view.getListCategory());
			movie = new Movie(movie_id, movie_name, release_date, director, duration, script, age_permisson, urlImg,
					status);
			if (!movieService.createMovie(movie, actors, categories)) {
				MessageUtil.showError(MessageConstants.ERROR_CREATE);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_CREATE);
			view.reSetForm();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	public void loadActorToView() {
		List<Actor> actors = null;
		try {
			actors = actorService.getAllActorTypeActor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorUtil.handle(e, e.getMessage());
		}
		view.getItemsForList(actors, view.getListActor());
	}

	public void loadCategoryToView() {
		List<Category> categories=null;
		try {
			categories = CategoryDAO.getAllCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorUtil.handle(e, "Đã xảy ra lỗi!!!");
		}
		view.getItemsForList(categories, view.getListCategory());
	}
}
