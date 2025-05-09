package validator;

import java.io.File;

import javax.swing.JOptionPane;

import utils.MessageUtil;

public class InputValidate {

	public InputValidate() {
		// TODO Auto-generated constructor stub
	}

	public static boolean registerValidate(String email, String username, String password) {
		if (email == null || email.trim().isEmpty()) {
			MessageUtil.showWarning("Email không được để trống!");
			return false;
		}
		if (username == null || username.trim().isEmpty()) {
			MessageUtil.showWarning("Tên người dùng không được để trống!");
			return false;
		}
		if (password == null || password.trim().isEmpty()) {
			MessageUtil.showWarning("Mật khẩu dùng không được để trống!");
			return false;
		}
		return true;
	}

	public static boolean loginValidate(String email, String password) {
		if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
			MessageUtil.showWarning("Thông tin không được để trống!");
			return false;
		}
		return true;
	}

	public static boolean createActor(String actor_name, java.sql.Date ngaysinh) {
		if (actor_name == null || actor_name.trim().isEmpty() || ngaysinh == null) {
			MessageUtil.showWarning("Thông tin không được để trống!");
			return false;
		}
		return true;
	}

	public static boolean createCategory(String category_id, String category_name) {
		if (category_id == null || category_id.trim().isEmpty() || category_name == null
				|| category_name.trim().isEmpty()) {
			MessageUtil.showWarning("Thông tin không được để trống!");
			return false;
		}
		return true;
	}

	public static boolean createMovie(String movie_name, File poster) {
		if (movie_name == null || movie_name.trim().isEmpty() || poster == null) {
			MessageUtil.showWarning("Thông tin không được để trống!");
			return false;
		}
		return true;
	}

	public static boolean checkId(String id, String message) {
		if (id.isEmpty()) {
			MessageUtil.showWarning(message);
			return false;
		}
		return true;
	}
}
