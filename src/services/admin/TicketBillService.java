package services.admin;

import java.sql.Date;
import java.util.List;

import dao.TicketBillDAO;
import utils.ExcelUtil;

public class TicketBillService {
	private TicketBillDAO ticketBillDao;

	public TicketBillService() {
		ticketBillDao = new TicketBillDAO();
	}

	public List<String[]> getAllTicketBill() throws Exception {
		return ticketBillDao.getAllTicketBill();
	}

	public List<String[]> findTicketBillByDate(Date start, Date end) throws Exception {
		return ticketBillDao.findByDate(start, end, " transaction_history ");
	}

	public void exportExcel(String[] columns, String fileName) throws Exception {
		try {
			ExcelUtil.exportExcel(columns, getAllTicketBill(), fileName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage(), e);
		}

	}
}
