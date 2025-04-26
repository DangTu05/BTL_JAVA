package utils;

import java.net.URI;
import java.net.URL;

public class Url {
	public static URL safeURL(String urlString) {
		try {
			return new URI(urlString).toURL();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
