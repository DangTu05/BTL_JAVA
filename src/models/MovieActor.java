package models;

public class MovieActor {
	private String movie_id;
	private String actor_id;

	public MovieActor(String movie_id, String actor_id) {
		this.movie_id = movie_id;
		this.actor_id = actor_id;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getActor_id() {
		return actor_id;
	}

	public void setActor_id(String actor_id) {
		this.actor_id = actor_id;
	}
}
