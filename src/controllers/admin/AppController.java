package controllers.admin;

import views.Admin.Actors;
import views.Admin.CreateActor;
import views.Admin.CreateMovie;

public class AppController {
	private CreateMovie viewCreateMovie;
	private Actors viewActors;
	private CreateActor viewCreateActor;

	public AppController() {

	}

	public void startCreateMovie() {
		viewCreateMovie = new CreateMovie();
		CreateMovieController controller = new CreateMovieController(viewCreateMovie);
		viewCreateMovie.setVisible(true);
	}

	public void startActors() {
		viewActors = new Actors();
		new ActorsController(viewActors);
		viewActors.setVisible(true);
	}

	public void startCreateActor() {
		viewCreateActor = new CreateActor();
		new CreateActorController(viewCreateActor);
		viewCreateActor.setVisible(true);
	}
}
