package Interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

import components.SideBarMenu;

public interface IMenuView {


	public SideBarMenu getSideBar();

	public JFrame getFrame();

	public JPanel getMainContentJpanel();
}
