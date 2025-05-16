package Interfaces;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface ILoginView {
	public String getPassword();

	public String getEmail();

	public void hidenLoginPage();

	public void redirectRegister();

	public void setLoginListener(ActionListener listener);

	public void setRedirectRegister(MouseListener listener);

	public void setForgotPassWord(MouseListener listener);
}
