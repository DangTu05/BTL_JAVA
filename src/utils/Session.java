package utils;

import models.User;

public class Session {
	private static User currentUser = null;

	public static boolean isLogin() {
		return currentUser != null;
	}

	public static void setUser(User user) {
		currentUser = user;
	}

	public static User getUser() {
		return currentUser;
	}

	public static void logout() {
		currentUser = null;
	}
}
