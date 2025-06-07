package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		// TODO Auto-generated method stub
		return null;
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

}
