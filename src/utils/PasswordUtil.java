package utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtil {

	public PasswordUtil() {
		// TODO Auto-generated constructor stub
	}

	public static String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	public static boolean checkPassword(String password, String hashed) {
		return BCrypt.checkpw(password, hashed);
	}
}
