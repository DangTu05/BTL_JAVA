package models;

public class MovieCategory {
	private String category_id;
	private String movie_id;

	public MovieCategory(String category_id, String movie_id) {
		this.category_id = category_id;
		this.movie_id = movie_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
}
