package Interfaces;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import components.SideBarMenu;

public interface IMenuView {
	public void setHomeListener(ActionListener listener);

	public void setAccountListener(ActionListener listener);

	public void setLogoutListener(ActionListener listener);

	public void setMovieListener(ActionListener listener);

	public SideBarMenu getSideBar();

	public JFrame getFrame();

	public JPanel getMainContentJpanel();
}
