package controllers.admin;

import Interfaces.IDashBoard;
import services.admin.TicketBillService;
import utils.ErrorUtil;
import utils.MessageConstants;

public class DashBoardController {
	private IDashBoard viewDashBoard;
	private TicketBillService ticketBillService;

	public DashBoardController(IDashBoard viewDashBoard) {
		this.viewDashBoard = viewDashBoard;
		ticketBillService = new TicketBillService();
		loadChart();
	}

	private void loadChart() {
		try {
			viewDashBoard.createChart(ticketBillService.getDatasetFromDB());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}
}
