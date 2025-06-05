package services.admin;

import dao.SettingDAO;
import models.Setting;
import utils.MessageConstants;


public class SettingService {
	private SettingDAO settingDao;

	public SettingService() {
		settingDao = new SettingDAO();
	}

	public boolean updateSetting(Setting setting) throws Exception {
		if (!settingDao.update(setting))
			throw new Exception(MessageConstants.ERROR_UPDATE_FAILED);
		return true;
	}

	public Setting getSetting(String field, String setting_id) throws Exception {
		try {
			return settingDao.findByField(field, setting_id);
		} catch (Exception e) {
			throw new Exception("Lỗi khi lấy ra setting trong dao!!!", e);
		}
	}
}
