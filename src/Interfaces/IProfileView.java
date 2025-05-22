package Interfaces;

import java.awt.event.ActionListener;

public interface IProfileView {
	public void setLuuListener(ActionListener listener);

	public void setXoaListener(ActionListener listener);

	public void setThoatListener(ActionListener listener);

	public String getUser_Id();

	public String getUser_Name();

	public String getAddress();

	public String getEmail();

	public String getUser_Image();

	public void setForm(String user_id, String user_name, String email, String address, String user_image);
}
