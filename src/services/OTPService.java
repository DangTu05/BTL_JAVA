package services;

import java.util.HashMap;
import java.util.Map;
import entry.OTPEntry;
import utils.OTPGenerator;

public class OTPService {
	private static final long EXPIRATION_TIME = 3 * 60 * 1000; // 3 phút
	private static final Map<String, OTPEntry> otpStorage = new HashMap<>();

	public static String generateOTP(String email) {
		String otp = OTPGenerator.generateOTP(6);
		otpStorage.put(email, new OTPEntry(otp, System.currentTimeMillis()));
		return otp;
	}

	public static boolean verifyOTP(String email, String inputOtp) {
		OTPEntry entry = otpStorage.get(email);
		if (entry == null)
			return false;

		long currentTime = System.currentTimeMillis();
		if (currentTime - entry.timestamp > EXPIRATION_TIME) {
			otpStorage.remove(email); // Hết hạn
			return false;
		}

		boolean isValid = entry.otp.equals(inputOtp);
		if (isValid)
			otpStorage.remove(email); // Chỉ dùng 1 lần
		return isValid;
	}

}
