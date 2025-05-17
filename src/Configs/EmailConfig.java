package Configs;

import java.util.Properties;

import io.github.cdimascio.dotenv.Dotenv;

public class EmailConfig {
	private static final Dotenv dotenv = Dotenv.configure().load();
	private static final String FROM_EMAIL = dotenv.get("EMAIL_USER");
	private static final String PASSWORD = dotenv.get("EMAIL_PASS");

	public static Properties getEmailProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // Enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
		return props;
	}

	public static String getFromEmail() {
		return FROM_EMAIL;
	}

	public static String getPassword() {
		return PASSWORD;
	}
}
