package utils;

import java.net.URI;
import java.net.URL;

public class UrlUtil {
	// convert uri sang url
	public static URL safeURL(String urlString) {
		try {
			return new URI(urlString).toURL();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
