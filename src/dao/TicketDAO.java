package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Configs.Database.ConnectDB;
import models.Ticket;

public class TicketDAO extends BaseDAO<Ticket> {

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Ticket entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, Ticket entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Ticket mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<String[]> mapData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return " tblTicket ";
	}

	@Override
	protected String getColumns() {
		// TODO Auto-generated method stub
		return " ticket_id, seat_id, showtime_id, ticket_price, ticket_bill_id, ticket_price_id ";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		// TODO Auto-generated method stub
		return " ticket_id ";
	}

	public List<String[]> getAllTicket() throws Exception {
		String sql = "select " + getColumns() + " from " + getTableName() + " where deleted=0";
		List<String[]> tickets = new ArrayList<>();
		try (Connection conn = ConnectDB.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			while (rs.next()) {
				tickets.add(new String[] { rs.getString("ticket_id"), rs.getString("seat_id"),
						rs.getString("showtime_id"), rs.getString("ticket_price"), rs.getString("ticket_bill_id"),
						rs.getString("ticket_price_id"), });
			}
			return tickets;
		} catch (Exception ex) {
			throw new Exception("Đã xảy ra lỗi truy vấn trong TicketDAO", ex);
		}
	}

}
