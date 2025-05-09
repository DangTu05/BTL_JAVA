package controllers.admin;

import views.Admin.CreateMovie;

public class AppController {
	private CreateMovie viewCreateMovie;

	public AppController() {

	}

	public void startCreateMovie() {
		viewCreateMovie = new CreateMovie();
		CreateMovieController controller = new CreateMovieController(viewCreateMovie);
		viewCreateMovie.setVisible(true);
	}
}
