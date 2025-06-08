package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jfree.data.category.DefaultCategoryDataset;

import Configs.Database.ConnectDB;
import models.TicketBill;

public class TicketBillDAO extends BaseDAO<TicketBill> {

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, TicketBill entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, TicketBill entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected TicketBill mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		return " tblTicketBill ";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		return " payment_id ";
	}

	public List<String[]> getAllTicketBill() throws Exception {
		String sql = " Select " + getColumns() + " from tblTicketBill where deleted=0";
		List<String[]> ticketbills = new ArrayList<>();
		try (Connection conn = ConnectDB.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			while (rs.next()) {
				ticketbills.add(new String[] { rs.getString("payment_id"), rs.getString("ticket_quantity"),
						rs.getString("price_total"), rs.getString("voucher_id"), rs.getString("user_id"),
						rs.getString("payment_method"), rs.getString("transaction_history") });
			}
		} catch (Exception ex) {
			throw new Exception("Đã xảy ra lỗi khi truy vấn hóa đơn!!!", ex);
		}
		return ticketbills;
	}

	@Override
	protected List<String[]> mapData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<String[]> ticketbills = new ArrayList<>();
		while (rs.next()) {
			ticketbills.add(new String[] { rs.getString("payment_id"), rs.getString("ticket_quantity"),
					rs.getString("price_total"), rs.getString("voucher_id"), rs.getString("user_id"),
					rs.getString("payment_method"), rs.getString("transaction_history") });
		}
		return ticketbills;
	}

	@Override
	protected String getColumns() {
		// TODO Auto-generated method stub
		return "payment_id, ticket_quantity, price_total, voucher_id, user_id, payment_method, transaction_history";
	}

	public Map<String, Integer> getRevenueFromDB() throws Exception {
		Map<String, Integer> data = new LinkedHashMap<>();
		String sql = "SELECT \r\n" + "    MONTH(transaction_history) AS month,\r\n"
				+ "    SUM(price_total) AS total_revenue\r\n" + "FROM tblTicketBill\r\n" + "WHERE deleted = 0\r\n"
				+ "  AND YEAR(transaction_history) = YEAR(CURDATE())\r\n" + "GROUP BY month\r\n" + "ORDER BY month;";

		try (Connection conn = ConnectDB.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String month = rs.getString("month");
				int revenue = rs.getInt("total_revenue");
				data.put(month, revenue);
			}
		} catch (Exception e) {
			throw new Exception("Lỗi lấy dữ liệu từ DB", e);
		}
		return data;
	}

	public DefaultCategoryDataset createDatasetFromDB() throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try {
			Map<String, Integer> revenueData = getRevenueFromDB();
			for (Map.Entry<String, Integer> entry : revenueData.entrySet()) {
				dataset.addValue(entry.getValue(), "Doanh thu", entry.getKey());
			}
		} catch (Exception e) {
			throw new Exception("Đã xảy ra lỗi trong TicketDAO!!!", e);
		}
		return dataset;
	}
}
