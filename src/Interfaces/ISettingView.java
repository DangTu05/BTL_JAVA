package Interfaces;

import java.awt.event.ActionListener;

import models.Setting;

public interface ISettingView {
	public void setCapNhatListener(ActionListener listener);

	public String getWebsite_Name();

	public String getCEO();

	public String getEmail();

	public String getLogo();

	public String getMap();

	public String getAddress();

	public String getHotline();

	public void setFormData(Setting setting);
}
