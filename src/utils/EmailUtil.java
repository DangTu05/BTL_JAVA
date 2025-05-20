package utils;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

import java.util.Properties;

import Configs.EmailConfig;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil {
	public static void sendEmail(String toEmail, String subject, String body) {
		final String fromEmail = EmailConfig.getFromEmail();
		final String password = EmailConfig.getPassword();

		Properties props = EmailConfig.getEmailProperties();
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getInstance(props, auth);

		try {
			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(fromEmail));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");

			Transport.send(msg);
			System.out.println("Email sent successfully to: " + toEmail);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Failed to send email.");
		}
	}
}
