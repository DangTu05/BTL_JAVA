package utils;

import javax.swing.JOptionPane;

public class ErrorUtils {
	public static void handle(Exception e, String userMessage) {
		e.printStackTrace(); // log ra console
		JOptionPane.showMessageDialog(null, userMessage, "Lỗi",
				JOptionPane.ERROR_MESSAGE);
	}
}
