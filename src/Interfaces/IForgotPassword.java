package Interfaces;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public interface IForgotPassword {
	public void setNextListener(ActionListener listener);

	public String getEmail();

	public JPanel getMainContentPanel();
}
