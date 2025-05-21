package Interfaces;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public interface IRegisterView {
	public String getEmail();

	public String getPassword();

	public String getUserName();

	public JFrame getFrame();

	public void setRegisterListener(ActionListener listener);

	public void setRedirectLogin(MouseListener listener);
}
