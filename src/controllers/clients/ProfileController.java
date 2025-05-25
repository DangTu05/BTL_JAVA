package controllers.clients;

import javax.swing.JPanel;

import Interfaces.IProfileView;
import controllers.AppController;
import models.User;
import services.ProfileService;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import utils.Session;

public class ProfileController extends BaseController {
	private IProfileView viewProfile;
	private ProfileService profileService;

	public ProfileController(IProfileView viewProfile) {
		this.viewProfile = viewProfile;
		profileService=new ProfileService();
		loadForm();
		setupEventListeners();
	}

	private void setupEventListeners() {
		viewProfile.setLuuListener(e->updateProfile());
		viewProfile.setThoatListener(e->AppController.startHome(getFrame()));
		viewProfile.setLamMoiListener(e->viewProfile.resetForm());
	}

	private void loadForm() {
		User user = Session.getUser();
		viewProfile.setForm(user.getUser_id(), user.getUser_name(), Session.getEmail(), user.getAddress(),
				user.getUser_image());
	}
	private void updateProfile() {
		User user= new User(viewProfile.getUser_Id(),viewProfile.getUser_Name(),viewProfile.getGender(),viewProfile.getAddress(),viewProfile.getUser_Image(),Session.getUser().getReward_points());
		if(!MessageUtil.confirm(MessageConstants.CONFIRM_UPDATE)){
			return;
		}
		try {
			if(!profileService.updateProfile(user)) {
				MessageUtil.showWarning(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_UPDATE);
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}


	@Override
	protected JPanel getPanel() {
		// TODO Auto-generated method stub
		return viewProfile.getPanel();
	}

}
