package Interfaces;

public interface IActor {
	void setActor_id(String Actor_Id);

	String getActor_id();

	void setActor_name(String actor_name);

	String getActor_name();

	void setActor_image(String actor_image);

	String getActor_image();

	void setNationality(String nationality);

	String getNationality();

	void setBirth(java.sql.Date birth);

	java.sql.Date getBirth();

	void setBiography(String biography);

	String getBiography();
}
