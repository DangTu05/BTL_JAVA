package utils;

import java.security.SecureRandom;

public class TokenGenerator {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final int TOKEN_LENGTH = 32; // độ dài token

	private static final SecureRandom random = new SecureRandom();

	public static String generateToken() {
		StringBuilder token = new StringBuilder(TOKEN_LENGTH);
		for (int i = 0; i < TOKEN_LENGTH; i++) {
			int index = random.nextInt(CHARACTERS.length());
			token.append(CHARACTERS.charAt(index));
		}
		return token.toString();
	}
}
