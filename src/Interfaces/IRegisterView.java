package Interfaces;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface IRegisterView {
	public String getEmail();

	public String getPassword();

	public String getUserName();

	public void setRegisterListener(ActionListener listener);

	public void redirectLogin();

	public void setRedirectLogin(MouseListener listener);
}
