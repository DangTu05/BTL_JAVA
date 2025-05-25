package Interfaces;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public interface IProfileView {
	public void setLuuListener(ActionListener listener);

	public void setLamMoiListener(ActionListener listener);

	public void setThoatListener(ActionListener listener);

	public String getUser_Id();

	public String getUser_Name();

	public String getAddress();

	public String getEmail();

	public String getUser_Image();

	public String getGender();

	public JPanel getPanel();

	public void setForm(String user_id, String user_name, String email, String address, String user_image);

	public void resetForm();
}
