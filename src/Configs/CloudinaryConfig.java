package Configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import io.github.cdimascio.dotenv.Dotenv;

//Phải có cả 2 imports này

public class CloudinaryConfig {
	private static final Dotenv dotenv = Dotenv.configure().load();
	private static final String CLOUD_NAME = dotenv.get("CLOUD_NAME");
	private static final String API_KEY = dotenv.get("API_KEY");
	private static final String API_SECRET = dotenv.get("API_SECRET");

	public static Cloudinary getCloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", CLOUD_NAME, "api_key", API_KEY, "api_secret", API_SECRET,
				"secure", true));
	}
}
