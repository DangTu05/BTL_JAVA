package models;

public class TicketBill {
	private String payment_id;
	private double ticket_quantity;
	private double price_total;
	private String voucher_id;
	private String user_id;
	private String payment_method;

	public TicketBill(String payment_id, double ticket_quantity, double price_total, String voucher_id, String user_id,
			String payment_method) {
		super();
		this.payment_id = payment_id;
		this.ticket_quantity = ticket_quantity;
		this.price_total = price_total;
		this.voucher_id = voucher_id;
		this.user_id = user_id;
		this.payment_method = payment_method;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public double getTicket_quantity() {
		return ticket_quantity;
	}

	public void setTicket_quantity(double ticket_quantity) {
		this.ticket_quantity = ticket_quantity;
	}

	public double getPrice_total() {
		return price_total;
	}

	public void setPrice_total(double price_total) {
		this.price_total = price_total;
	}

	public String getVoucher_id() {
		return voucher_id;
	}

	public void setVoucher_id(String voucher_id) {
		this.voucher_id = voucher_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

}
