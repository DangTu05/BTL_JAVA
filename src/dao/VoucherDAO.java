package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Configs.Database.ConnectDB;
import models.Voucher;

public class VoucherDAO extends BaseDAO<Voucher> {

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Voucher entity) throws SQLException {
		// TODO Auto-generated method stub
		String sql = " insert into tblVoucher(voucher_id, voucher_name, voucher_discount, voucher_start, voucher_end, voucher_script, voucher_image) values(?,?,?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getVoucher_id());
		statement.setString(2, entity.getVoucher_name());
		statement.setFloat(3, entity.getVoucher_discount());
		statement.setDate(4, entity.getVoucher_start());
		statement.setDate(5, entity.getVoucher_end());
		statement.setString(6, entity.getVoucher_script());
		statement.setString(7, entity.getVoucher_image());
		return statement;
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, Voucher entity) throws SQLException {
		String sql = " Update tblVoucher set voucher_name=?, voucher_discount=?, voucher_start=?, voucher_end=?, voucher_script=?, voucher_image=? where voucher_id=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getVoucher_name());
		statement.setFloat(2, entity.getVoucher_discount());
		statement.setDate(3, entity.getVoucher_start());
		statement.setDate(4, entity.getVoucher_end());
		statement.setString(5, entity.getVoucher_script());
		statement.setString(6, entity.getVoucher_image());
		statement.setString(7, entity.getVoucher_id());
		return statement;
	}

	@Override
	protected Voucher mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		return " tblVoucher ";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		// TODO Auto-generated method stub
		return " voucher_id ";
	}

	public static List<String[]> getAllVoucher() throws Exception {
		String sql = "select voucher_id, voucher_name, voucher_discount, voucher_start, voucher_end, voucher_script, voucher_image from tblVoucher where deleted=0";
		List<String[]> vouchers = new ArrayList<>();
		try (Connection conn = ConnectDB.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			while (rs.next()) {
				vouchers.add(new String[] { rs.getString("voucher_id"), rs.getString("voucher_name"),
						rs.getString("voucher_discount"), rs.getString("voucher_start"), rs.getString("voucher_end"),
						rs.getString("voucher_script"), rs.getString("voucher_image"), });
			}
			return vouchers;
		} catch (Exception ex) {
			throw new Exception("Đã xảy ra lỗi truy vấn trong VoucherDAO", ex);
		}
	}
}
