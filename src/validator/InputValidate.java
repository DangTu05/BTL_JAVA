package validator;

import java.io.File;
import java.sql.Date;

import utils.MessageConstants;
import utils.MessageUtil;

public class InputValidate {

	public InputValidate() {
		// TODO Auto-generated constructor stub
	}

	// Validate dữ liệu khi người dùng đk tài khoản
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

	// validate dữ liệu tài khoản
	public static boolean AccountValidate(String email, String name) {
		if (email.isEmpty() || name.isEmpty()) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}

		return true;
	}

	// kiểm tra đăng nhập
	public static boolean loginValidate(String email, String password) {
		if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}

	// validate dữ liệu khi tạo thông tin diễn viên
	public static boolean createActor(String actor_name, java.sql.Date ngaysinh) {
		if (actor_name == null || actor_name.trim().isEmpty() || ngaysinh == null) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}

	// validate khi tạo thể loại phim
	public static boolean createCategory(String category_id, String category_name) {
		if (category_id == null || category_id.trim().isEmpty() || category_name == null
				|| category_name.trim().isEmpty()) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}

	// validate khi tạo phim
	public static boolean createMovie(String movie_name, File poster) {
		if (movie_name == null || movie_name.trim().isEmpty() || poster == null) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}

	// kiểm tra id
	public static boolean checkId(String id, String message) {
		if (id.isEmpty()) {
			MessageUtil.showWarning(message);
			return false;
		}
		return true;
	}

	// kiểm tra mật khẩu có khớp hay ko
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

	// validate dữ liệu khi thay đổi thông tin phần mềm
	public static boolean checkSettingInput(String website_name, String ceo, String hotline, String address) {
		if (website_name.isEmpty() || ceo.isEmpty() || hotline.isEmpty() || address.isEmpty()) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}

	// validate dữ liệu khi thêm voucher
	public static boolean createVoucher(String voucher_name) {
		if (voucher_name.isEmpty()) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return false;
		}
		return true;
	}
}
