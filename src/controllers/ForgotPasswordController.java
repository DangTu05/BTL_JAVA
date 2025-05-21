package controllers;

import java.awt.CardLayout;

import javax.swing.JPanel;

import Interfaces.IForgotPassword;
import dao.AccountDAO;
import services.OTPService;
import services.admin.AccountService;
import utils.EmailUtil;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import utils.PasswordUtil;
import validator.InputValidate;
import views.Panels.ChangePassword;
import views.Panels.InputOTP;

public class ForgotPasswordController {
	private IForgotPassword viewForgotPassword;
	private InputOTP otpPanel;
	private AccountDAO dao;
	private AccountService accountService;
	private JPanel mainContentPanel;
	private CardLayout cardLayout;
	private ChangePassword changePasswordPanel;

	public ForgotPasswordController(IForgotPassword view) {
		this.viewForgotPassword = view;
		dao = new AccountDAO();
		accountService = new AccountService();
		setMainContent(view.getMainContentPanel());
		initializePanels();
		setupEventListeners();
	}

	private void setupEventListeners() {
		viewForgotPassword.setNextListener(e -> createOTP());
		otpPanel.setNextListener(e -> checkOTP());
		changePasswordPanel.setThayDoiListener(e -> changePassword());
		viewForgotPassword.setBackListener(e -> AppController.startLogin(viewForgotPassword.getFrame()));
		otpPanel.setBackListener(e -> navigateTo("emailPanel"));
		changePasswordPanel.setBackListener(e -> navigateTo("otp"));
	}

	private void createOTP() {
		String email = viewForgotPassword.getEmail();
		if (email.isEmpty()) {
			MessageUtil.showWarning(MessageConstants.WARN_INPUT);
			return;
		}
		try {
			if (dao.findByField("email", email) == null) {
				MessageUtil.showInfo("Tài khoản không tồn tại!");
				return;
			}
			String otp = OTPService.generateOTP(email);
			EmailUtil.sendEmail(viewForgotPassword.getEmail(), "Mã OTP của bạn", "Mã OTP của bạn là:" + otp);
			navigateTo("otp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void checkOTP() {
		if (!OTPService.verifyOTP(viewForgotPassword.getEmail(), otpPanel.getOTP())) {
			MessageUtil.showInfo("OTP không hợp lệ!");
			return;
		}
		navigateTo("changepassword");
	}

	private void changePassword() {
		if (!InputValidate.checkChangePassword(changePasswordPanel.getPassword(), changePasswordPanel.getCFPassword()))
			return;
		String password = PasswordUtil.hashPassword(changePasswordPanel.getPassword());
		try {
			if (!accountService.changePassword(password, viewForgotPassword.getEmail())) {
				MessageUtil.showError("Đổi mật khẩu không thành công!");
				return;
			}
			MessageUtil.showInfo("Đổi thành công!");
		} catch (Exception e) {
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	private void initializePanels() {
		otpPanel = new InputOTP();
		mainContentPanel.add(otpPanel, "otp");

		changePasswordPanel = new ChangePassword();
		mainContentPanel.add(changePasswordPanel, "changepassword");
	}

	private void setMainContent(JPanel mainContentPanel) {
		this.mainContentPanel = mainContentPanel;
		this.cardLayout = (CardLayout) mainContentPanel.getLayout();
	}

	private void navigateTo(String panelName) {
		cardLayout.show(mainContentPanel, panelName);
	}

}
