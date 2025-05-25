package controllers.clients;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract  class BaseController {
	protected abstract JPanel getPanel();
		public  JFrame getFrame() {
		return (JFrame) SwingUtilities.getWindowAncestor(getPanel());
	}
}
