package Interfaces;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public interface IMenuView {
	public void setHomeListener(ActionListener listener);

	public void setAccountListener(ActionListener listener);

	public void setLogoutListener(ActionListener listener);

	public void setMovieListener(ActionListener listener);

	public JFrame getFrame();
}
