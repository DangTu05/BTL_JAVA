package utils;

import models.User;

public class Session {
	// lưu thông tin và trạng thái tài khoản khi người dùng đăng nhập
	private static User currentUser = null;
	private static String userEmail = null;

	public static boolean isLogin() {
		return currentUser != null;
	}

	public static void setUser(User user) {
		currentUser = user;
	}

	public static User getUser() {
		return currentUser;
	}

	public static void setEmail(String email) {
		userEmail = email;
	}

	public static String getEmail() {
		return userEmail;
	}

	public static void logout() {
		currentUser = null;
	}
}
