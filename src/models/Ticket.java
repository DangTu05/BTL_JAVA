package models;

public class Ticket {
	private String ticket_id;
	private String seat_id;
	private String showtime_id;
	private float ticket_price;
	private String ticket_bill_id;
	private String ticket_price_id;

	public Ticket(String ticket_id, String seat_id, String showtime_id, float ticket_price, String ticket_bill_id,
			String ticket_price_id) {
		this.ticket_id = ticket_id;
		this.seat_id = seat_id;
		this.showtime_id = showtime_id;
		this.ticket_price = ticket_price;
		this.ticket_bill_id = ticket_bill_id;
		this.ticket_price_id = ticket_price_id;
	}

	public String getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}

	public String getShowtime_id() {
		return showtime_id;
	}

	public void setShowtime_id(String showtime_id) {
		this.showtime_id = showtime_id;
	}

	public float getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(float ticket_price) {
		this.ticket_price = ticket_price;
	}

	public String getTicket_bill_id() {
		return ticket_bill_id;
	}

	public void setTicket_bill_id(String ticket_bill_id) {
		this.ticket_bill_id = ticket_bill_id;
	}

	public String getTicket_price_id() {
		return ticket_price_id;
	}

	public void setTicket_price_id(String ticket_price_id) {
		this.ticket_price_id = ticket_price_id;
	}

}
