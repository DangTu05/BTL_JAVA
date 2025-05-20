package utils;

public class GenerateIdUtil {
	public static String generateId(String key) {
		// Logic sinh ID tự động (ví dụ: UUID hoặc từ database)
		long timestamp = System.currentTimeMillis(); // VD: 1713795134421
		String timePart = String.valueOf(timestamp);
		String lastDigits = timePart.substring(timePart.length() - (10 - key.length()));
		return key + lastDigits;
	}
}
