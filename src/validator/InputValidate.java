package validator;

import java.io.File;
import utils.MessageConstants;
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
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}

	public static boolean createActor(String actor_name, java.sql.Date ngaysinh) {
		if (actor_name == null || actor_name.trim().isEmpty() || ngaysinh == null) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}

	public static boolean createCategory(String category_id, String category_name) {
		if (category_id == null || category_id.trim().isEmpty() || category_name == null
				|| category_name.trim().isEmpty()) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}

	public static boolean createMovie(String movie_name, File poster) {
		if (movie_name == null || movie_name.trim().isEmpty() || poster == null) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
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

	public static boolean checkChangePassword(String password, String confirmPassword) {
		if (password.isEmpty() || confirmPassword.isEmpty()) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		if (!password.equals(confirmPassword)) {
			MessageUtil.showWarning("Mật khẩu không khớp!");
			return false;
		}
		return true;
	}

	public static boolean checkSettingInput(String website_name, String ceo, String hotline, String address) {
		if (website_name.isEmpty() || ceo.isEmpty() || hotline.isEmpty() || address.isEmpty()) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}
}
