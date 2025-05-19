package controllers.admin;

import Interfaces.ISettingView;
import models.Setting;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;
import dao.SettingDAO;

public class SettingController {
	private ISettingView viewSetting;
	private SettingDAO dao;

	public SettingController(ISettingView viewSetting) {
		this.viewSetting = viewSetting;
		dao = new SettingDAO();
		loadDataFromDatabase();
		setupEventListeners();
	}

	private void setupEventListeners() {
		viewSetting.setCapNhatListener(e -> updateSetting());
	}

	private void loadDataFromDatabase() {
		try {
			Setting setting = dao.findByField("setting_id", "SETTING070");
			if (setting != null)
				viewSetting.setFormData(setting);
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

	private void updateSetting() {
		if (!InputValidate.checkSettingInput(viewSetting.getWebsite_Name(), viewSetting.getCEO(),
				viewSetting.getHotline(), viewSetting.getAddress()))
			return;
		try {
			Setting setting = new Setting(viewSetting.getWebsite_Name(), viewSetting.getCEO(), viewSetting.getLogo(),
					viewSetting.getMap(), viewSetting.getEmail(), viewSetting.getHotline(), viewSetting.getAddress());
			if (!MessageUtil.confirm(MessageConstants.CONFIRM_UPDATE))
				return;
			if (!dao.update(setting)) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_UPDATE);
			loadDataFromDatabase();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}
}
