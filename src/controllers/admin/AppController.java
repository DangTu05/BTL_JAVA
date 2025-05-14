package controllers.admin;

import javax.swing.JFrame;

import controllers.LoginController;
import views.Login;
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

	public AppController() {

	}

	public void startCreateMovie(JFrame previousFrame) {
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
		viewCreateMovie = new CreateMovie();
		new CreateMovieController(viewCreateMovie);
		viewCreateMovie.setVisible(true);
	}

	public void startActors(JFrame previousFrame) {
		// 1. Tắt frame hiện tại
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
		viewActors = new Actors();
		new ActorsController(viewActors);
		viewActors.setVisible(true);
	}

	public void startCreateActor(JFrame previousFrame) {
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
		viewCreateActor = new CreateActor();
		new CreateActorController(viewCreateActor);
		viewCreateActor.setVisible(true);
	}

	public void startHome(JFrame previousFrame) {
		previousFrame.dispose(); // hoặc previousFrame.setVisible(false);
		viewMenu = new Menu();
		new MenuController(viewMenu);
		viewMenu.setVisible(true);
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
}
