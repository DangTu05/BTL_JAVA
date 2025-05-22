package controllers;

import Interfaces.IProfileView;
import models.User;
import utils.Session;

public class ProfileController {
	private IProfileView viewProfile;

	public ProfileController(IProfileView viewProfile) {
		this.viewProfile = viewProfile;
		loadForm();
	}

	private void setupEventListeners() {
		viewProfile.setLuuListener(null);
	}

	private void loadForm() {
		User user = Session.getUser();
		viewProfile.setForm(user.getUser_id(), user.getUser_name(), Session.getEmail(), user.getAddress(),
				user.getUser_image());
	}
}
