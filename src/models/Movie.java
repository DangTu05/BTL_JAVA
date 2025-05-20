package models;

import java.sql.Date;

public class Movie {
	private String movie_id;
	private String movie_name;
	private java.sql.Date release_date;
	private String director;
	private int duration;
	private String script;
	private int age_permisson;
	private String poster;
	private String status;

	public Movie(String movie_id, String movie_name, Date release_date, String director, int duration, String script,
			int age_permisson, String poster, String status) {
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.release_date = release_date;
		this.director = director;
		this.duration = duration;
		this.script = script;
		this.age_permisson = age_permisson;
		this.poster = poster;
		this.status = status;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public java.sql.Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(java.sql.Date release_date) {
		this.release_date = release_date;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public int getAge_permisson() {
		return age_permisson;
	}

	public void setAge_permisson(int age_permisson) {
		this.age_permisson = age_permisson;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
