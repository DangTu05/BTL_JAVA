package middlewares;

import javax.swing.JFrame;

import controllers.AppController;
import utils.MessageUtil;
import utils.Session;

public class Auth {
	public static void authentication(JFrame Frame) {
		if (!Session.isLogin()) {
			MessageUtil.showWarning("Vui lòng đăng nhập!");
			AppController.startLogin(Frame);
		}
	}
}
