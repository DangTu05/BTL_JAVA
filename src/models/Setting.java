package models;

public class Setting {
	private String website_name;
	private String ceo;
	private String logo;
	private String map;
	private String email;
	private String hotline;
	private String address;

	public Setting() {

	}

	public Setting(String website_name, String ceo, String logo, String map, String email, String hotline,
			String address) {
		this.website_name = website_name;
		this.ceo = ceo;
		this.logo = logo;
		this.map = map;
		this.email = email;
		this.hotline = hotline;
		this.address = address;
	}

	public String getWebsite_name() {
		return website_name;
	}

	public void setWebsite_name(String website_name) {
		this.website_name = website_name;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
