package utils;

import javax.swing.JOptionPane;

public class ErrorUtil {
	// custom thông báo lỗi và ghi log
	public static void handle(Exception e, String userMessage) {
		e.printStackTrace(); // log ra console
		JOptionPane.showMessageDialog(null, userMessage, "Lỗi",
				JOptionPane.ERROR_MESSAGE);
	}
}
