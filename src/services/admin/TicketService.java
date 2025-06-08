package services.admin;

import java.util.List;

import dao.TicketDAO;

public class TicketService {
	private TicketDAO ticketDao;

	public TicketService() {
		ticketDao = new TicketDAO();
	}

	public List<String[]> getAllTicket() throws Exception {
		return ticketDao.getAllTicket();
	}
}
