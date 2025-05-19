package models;

public class User {
	private String user_id;
	private String user_name;
	private String gender;
	private String address;
	private String user_image;
	private float reward_points;

	public User(String user_id, String user_name, String gender, String address, String user_image,
			float reward_points) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.gender = gender;
		this.address = address;
		this.user_image = user_image;
		this.reward_points = reward_points;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public float getReward_points() {
		return reward_points;
	}

	public void setReward_points(float reward_points) {
		this.reward_points = reward_points;
	}
}
