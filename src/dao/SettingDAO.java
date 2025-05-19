package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Setting;

public class SettingDAO extends BaseDAO<Setting> {
	@Override
	protected PreparedStatement buildUpdateStatement(Connection con, Setting setting) throws SQLException {
		String query = "Update tblSetting Set website_name=?, ceo=?, logo=?, map=?, email=?, hotline=?, address=? where setting_id='SETTING070'";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, setting.getWebsite_name());
		statement.setString(2, setting.getCeo());
		statement.setString(3, setting.getLogo());
		statement.setString(4, setting.getMap());
		statement.setString(5, setting.getEmail());
		statement.setString(6, setting.getHotline());
		statement.setString(7, setting.getAddress());
		return statement;
	}

	@Override
	protected Setting mapRow(ResultSet rs) throws SQLException {
		Setting setting = new Setting();
		setting.setWebsite_name(rs.getString("website_name"));
		setting.setCeo(rs.getString("ceo"));
		setting.setLogo(rs.getString("logo"));
		setting.setMap(rs.getString("map"));
		setting.setEmail(rs.getString("email"));
		setting.setHotline(rs.getString("hotline"));
		setting.setAddress(rs.getString("address"));
		return setting;

	}

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Setting entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return "tblSetting";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		// TODO Auto-generated method stub
		return "setting_id";
	}

}
