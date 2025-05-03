package validator;

import java.io.File;

import javax.swing.JOptionPane;

import utils.MessageUtils;

public class InputValidate {

	public InputValidate() {
		// TODO Auto-generated constructor stub
	}

	public static boolean registerValidate(String email, String username, String password) {
		if (email == null || email.trim().isEmpty()) {
			MessageUtils.showWarning("Email không được để trống!");
			return false;
		}
		if (username == null || username.trim().isEmpty()) {
			MessageUtils.showWarning("Tên người dùng không được để trống!");
			return false;
		}
		if (password == null || password.trim().isEmpty()) {
			MessageUtils.showWarning("Mật khẩu dùng không được để trống!");
			return false;
		}
		return true;
	}

	public static boolean loginValidate(String email, String password) {
		if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
			MessageUtils.showWarning("Thông tin không được để trống!");
			return false;
		}
		return true;
	}

	public static boolean createActor(String actor_name, java.sql.Date ngaysinh) {
		if (actor_name == null || actor_name.trim().isEmpty() || ngaysinh == null) {
			MessageUtils.showWarning("Thông tin không được để trống!");
			return false;
		}
		return true;
	}

	public static boolean createMovie(String movie_name, File poster) {
		if (movie_name == null || movie_name.trim().isEmpty() || poster == null ) {
			MessageUtils.showWarning("Thông tin không được để trống!");
			return false;
		}
		return true;
	}
}
