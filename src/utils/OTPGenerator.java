package utils;

import java.util.Random;

public class OTPGenerator {
	public static String generateOTP(int length) {
		StringBuilder otp = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			otp.append(random.nextInt(10)); // số từ 0 đến 9
		}
		return otp.toString();
	}
}
