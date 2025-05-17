package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Configs.Database.ConnectDB;
import models.Account;

public abstract class BaseDAO<T> {
	protected abstract PreparedStatement buildInsertStatement(Connection conn, T entity) throws SQLException;

	protected abstract PreparedStatement buildUpdateStatement(Connection conn, T entity) throws SQLException;

	protected abstract T mapRow(ResultSet rs) throws SQLException;

	protected abstract String getTableName();

	protected abstract String getPrimaryKeyColumn();

	public boolean insert(T entity) {
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = buildInsertStatement(conn, entity)) {
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			throw new RuntimeException("Thêm tài khoản thất bại: " + e.getMessage(), e);
		}
	}

	public boolean update(T entity) {
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = buildUpdateStatement(conn, entity)) {
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			throw new RuntimeException("Cập nhật tài khoản thất bại: " + e.getMessage(), e);
		}
	}

	public boolean delete(String id) {
		String sql = "Delete from" + getTableName() + "where " + getPrimaryKeyColumn() + "=?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, id);
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			throw new RuntimeException("Xóa tài khoản thất bại: " + e.getMessage(), e);
		}
	}

	public T findByField(String fieldName, String value) throws Exception {
		String query = "Select * from " + getTableName() + " where " + fieldName + "= ?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return mapRow(rs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Tìm kiếm thất bại: " + e.getMessage(), e);
		}
		return null;
	}

	public boolean softDelete(String id) {
		String sql = "UPDATE " + getTableName() + " SET deleted=true where " + getPrimaryKeyColumn() + "=?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, id);
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			throw new RuntimeException("Xóa tài khoản thất bại: " + e.getMessage(), e);
		}
	}

	public boolean changeStatus(String status, String id) {
		String sql = "Update " + getTableName() + " Set Status =? where " + getPrimaryKeyColumn() + "=?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, status);
			statement.setString(2, id);
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			throw new RuntimeException("Cập nhật trạng thái thất bại: " + e.getMessage(), e);
		}
	}
}
