package models;

public class ShowTime {
	private String showtime_id;
	private String showtime;
	private String movie_id;
	private String room_id;
	private String showtime_day;

	public ShowTime(String showtime_id, String showtime, String movie_id, String room_id, String showtime_day) {
		super();
		this.showtime_id = showtime_id;
		this.showtime = showtime;
		this.movie_id = movie_id;
		this.room_id = room_id;
		this.showtime_day = showtime_day;
	}

	public String getShowtime_id() {
		return showtime_id;
	}

	public void setShowtime_id(String showtime_id) {
		this.showtime_id = showtime_id;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getShowtime_day() {
		return showtime_day;
	}

	public void setShowtime_day(String showtime_day) {
		this.showtime_day = showtime_day;
	}

}
