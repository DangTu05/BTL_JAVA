package utils;

import javax.swing.JOptionPane;

public class MessageUtil {
	public static void showInfo(String message) {
		JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showWarning(String message) {
		JOptionPane.showMessageDialog(null, message, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	}

	public static void showError(String message) {
		JOptionPane.showMessageDialog(null, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}

	public static boolean confirm(String message) {
		int result = JOptionPane.showConfirmDialog(null, message, "Xác nhận", JOptionPane.YES_NO_OPTION);
		return result == JOptionPane.YES_OPTION;
	}
}
