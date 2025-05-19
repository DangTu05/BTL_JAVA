package controllers;

import javax.swing.JFrame;

import controllers.admin.AccountsController;
import controllers.admin.ActorsController;
import controllers.admin.CreateActorController;
import controllers.admin.CreateMovieController;
import controllers.admin.MenuController;
import controllers.admin.MoviesController;
import utils.MessageUtil;
import views.Frames.ForgotPassword;
import views.Frames.Login;
import views.Frames.Register;
import views.Frames.Home;
import views.Frames.Admin.CreateActor;
import views.Frames.Admin.CreateMovie;
import views.Frames.Admin.Menu;
import views.Panels.Accounts;
import views.Panels.Actors;
import views.Panels.Movies;

public class AppController {
	private static CreateMovie viewCreateMovie;
	private static Actors viewActors;
	private static CreateActor viewCreateActor;
	private static Menu viewMenu;
	private static Accounts viewAccounts;
	private static Login viewLogin;
	private static Movies viewMovies;
	private static Register viewRegister;
	private static ForgotPassword viewForgotPassword;
	private static Home viewHome;

	public AppController() {

	}

	public static void startCreateMovie(JFrame previousFrame) {
		viewCreateMovie = new CreateMovie();
		new CreateMovieController(viewCreateMovie);
		viewCreateMovie.setVisible(true);
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public static void startActors(JFrame previousFrame) {
		viewActors = new Actors();
		new ActorsController(viewActors);
		viewActors.setVisible(true);
		// 1. Tắt frame hiện tại
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public static void startCreateActor(JFrame previousFrame) {
		viewCreateActor = new CreateActor();
		new CreateActorController(viewCreateActor);
		viewCreateActor.setVisible(true);
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public static void startDashboard(JFrame previousFrame) {
		viewMenu = new Menu();
		new MenuController(viewMenu);
		viewMenu.setVisible(true);
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public static void startAccounts(JFrame previousFrame) {
		viewAccounts = new Accounts();
		new AccountsController(viewAccounts);
		viewAccounts.setVisible(true);
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public static void startMovies(JFrame previousFrame) {
		viewMovies = new Movies();
		new MoviesController(viewMovies);
		viewMovies.setVisible(true);
		previousFrame.dispose();
	}

	public static void startLogin(JFrame previousFrame) {
		viewLogin = new Login();
		new LoginController(viewLogin);
		viewLogin.setVisible(true);
		previousFrame.dispose();
	}

	public static void startRegister(JFrame previousFrame) {
		viewRegister = new Register();
		new RegisterController(viewRegister);
		viewRegister.setVisible(true);
		previousFrame.dispose();
	}

	public static void startForgotPassword(JFrame previousFrame) {
		viewForgotPassword = new ForgotPassword();
		new ForgotPasswordController(viewForgotPassword);
		viewForgotPassword.setVisible(true);
		previousFrame.dispose();
	}

	public static void startHome(JFrame previousFrame) {
		viewHome = new Home("Trang Chủ");
		new HomeController(viewHome);
		viewHome.setVisible(true);
		previousFrame.dispose();
	}
}
