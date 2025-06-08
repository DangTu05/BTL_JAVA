package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Configs.Database.ConnectDB;
import utils.MessageConstants;

public abstract class BaseDAO<T> {
	protected abstract PreparedStatement buildInsertStatement(Connection conn, T entity) throws SQLException;

	protected abstract PreparedStatement buildUpdateStatement(Connection conn, T entity) throws SQLException;

	protected abstract T mapRow(ResultSet rs) throws SQLException;

	protected abstract List<String[]> mapData(ResultSet rs) throws SQLException;

	protected abstract String getTableName();

	protected abstract String getColumns();

	protected abstract String getPrimaryKeyColumn();

	public boolean insert(T entity) {
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = buildInsertStatement(conn, entity)) {
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(T entity) {
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = buildUpdateStatement(conn, entity)) {
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		String sql = "Delete from " + getTableName() + " where " + getPrimaryKeyColumn() + "=?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, id);
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public T findByField(String fieldName, String value) throws Exception {
		String query = "Select * from " + getTableName() + " where " + fieldName + "=? ";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return mapRow(rs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(MessageConstants.ERROR_GENERIC, e);
		}
		return null;

	}

	public boolean softDelete(String id) {
		String sql = "UPDATE " + getTableName() + " SET deleted=true where " + getPrimaryKeyColumn() + "=?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, id);
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean changeStatus(String status, String id) {
		String sql = "Update " + getTableName() + " Set Status =? where " + getPrimaryKeyColumn() + "=?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, status);
			statement.setString(2, id);
			return statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<String[]> findByDate(Date start, Date end, String fieldDate) throws Exception {
		String query = "Select " + getColumns() + " from " + getTableName() + " where " + fieldDate
				+ " Between ? And ?  AND deleted = 0 ";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setDate(1, start);
			ps.setDate(2, end);
			ResultSet rs = ps.executeQuery();
			List<String[]> result = mapData(rs); // GỌI TRỰC TIẾP, KHÔNG rs.next() TRƯỚC

			return result.isEmpty() ? null : result;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Đã xảy ra lỗi khi tìm kiếm trong DAO!!!", e);
		}

	}
}
