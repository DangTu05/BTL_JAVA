package controllers;

import javax.swing.JFrame;

import controllers.admin.AccountsController;
import controllers.admin.ActorsController;
import controllers.admin.CreateActorController;
import controllers.admin.CreateMovieController;
import controllers.admin.MenuController;
import controllers.admin.MoviesController;
import utils.MessageUtil;
import views.ForgotPassword;
import views.Login;
import views.Register;
import views.Admin.Accounts;
import views.Admin.Actors;
import views.Admin.CreateActor;
import views.Admin.CreateMovie;
import views.Admin.Menu;
import views.Admin.Movies;

public class AppController {
	private CreateMovie viewCreateMovie;
	private Actors viewActors;
	private CreateActor viewCreateActor;
	private Menu viewMenu;
	private Accounts viewAccounts;
	private Login viewLogin;
	private Movies viewMovies;
	private Register viewRegister;
	private ForgotPassword viewForgotPassword;

	public AppController() {

	}

	public void startCreateMovie(JFrame previousFrame) {
		viewCreateMovie = new CreateMovie();
		new CreateMovieController(viewCreateMovie);
		viewCreateMovie.setVisible(true);
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public void startActors(JFrame previousFrame) {
		viewActors = new Actors();
		new ActorsController(viewActors);
		viewActors.setVisible(true);
		// 1. Tắt frame hiện tại
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public void startCreateActor(JFrame previousFrame) {
		viewCreateActor = new CreateActor();
		new CreateActorController(viewCreateActor);
		viewCreateActor.setVisible(true);
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public void startHome(JFrame previousFrame) {
		viewMenu = new Menu();
		new MenuController(viewMenu);
		viewMenu.setVisible(true);
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public void startAccounts(JFrame previousFrame) {
		viewAccounts = new Accounts();
		new AccountsController(viewAccounts);
		viewAccounts.setVisible(true);
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
	}

	public void startMovies(JFrame previousFrame) {
		viewMovies = new Movies();
		new MoviesController(viewMovies);
		viewMovies.setVisible(true);
		previousFrame.dispose();
	}

	public void startLogin(JFrame previousFrame) {
		viewLogin = new Login();
		new LoginController(viewLogin);
		viewLogin.setVisible(true);
		previousFrame.dispose();
	}

	public void startRegister(JFrame previousFrame) {
		viewRegister = new Register();
		new RegisterController(viewRegister);
		viewRegister.setVisible(true);
		previousFrame.dispose();
	}

	public void startForgotPassword(JFrame previousFrame) {
		viewForgotPassword = new ForgotPassword();
		new ForgotPasswordController(viewForgotPassword);
		viewForgotPassword.setVisible(true);
		previousFrame.dispose();
	}
}
