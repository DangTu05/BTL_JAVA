package models;

import java.sql.Date;

public class Voucher {
	private String voucher_id;
	private String voucher_name;
	private float voucher_discount;
	private java.sql.Date voucher_start;
	private java.sql.Date voucher_end;
	private String voucher_script;
	private String voucher_image;

	public Voucher(String voucher_id, String voucher_name, float voucher_discount, Date voucher_start, Date voucher_end,
			String voucher_script, String voucher_image) {
		super();
		this.voucher_id = voucher_id;
		this.voucher_name = voucher_name;
		this.voucher_discount = voucher_discount;
		this.voucher_start = voucher_start;
		this.voucher_end = voucher_end;
		this.voucher_script = voucher_script;
		this.voucher_image = voucher_image.isEmpty() ? null : voucher_image;
	}

	public String getVoucher_id() {
		return voucher_id;
	}

	public void setVoucher_id(String voucher_id) {
		this.voucher_id = voucher_id;
	}

	public String getVoucher_name() {
		return voucher_name;
	}

	public void setVoucher_name(String voucher_name) {
		this.voucher_name = voucher_name;
	}

	public float getVoucher_discount() {
		return voucher_discount;
	}

	public void setVoucher_discount(float voucher_discount) {
		this.voucher_discount = voucher_discount;
	}

	public java.sql.Date getVoucher_start() {
		return voucher_start;
	}

	public void setVoucher_start(java.sql.Date voucher_start) {
		this.voucher_start = voucher_start;
	}

	public java.sql.Date getVoucher_end() {
		return voucher_end;
	}

	public void setVoucher_end(java.sql.Date voucher_end) {
		this.voucher_end = voucher_end;
	}

	public String getVoucher_script() {
		return voucher_script;
	}

	public void setVoucher_script(String voucher_script) {
		this.voucher_script = voucher_script;
	}

	public String getVoucher_image() {
		return voucher_image;
	}

	public void setVoucher_image(String voucher_image) {
		this.voucher_image = voucher_image;
	}

}
