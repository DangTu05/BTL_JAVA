package controllers.admin;

import java.sql.Date;
import java.sql.Timestamp;

import Interfaces.ITicketBillDetail;
import services.admin.TicketBillService;
import services.admin.TicketService;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;

public class TicketBillController {
	private ITicketBillDetail viewTicketBillDetail;
	private TicketBillService ticketBillService;
	private TicketService ticketService;

	public TicketBillController(ITicketBillDetail viewITicketBillDetail) {
		this.viewTicketBillDetail = viewITicketBillDetail;
		ticketBillService = new TicketBillService();
		ticketService = new TicketService();
		loadDataFromDataBase();
		setupEventListener();
	}

	private void setupEventListener() {
		viewTicketBillDetail.setTimListener(e -> findTicketBillByDate());
		viewTicketBillDetail.setLamMoiListener(e -> loadDataFromDataBase());
		viewTicketBillDetail.setXuatExcel(e -> exportExcel());
	}

	private void loadDataFromDataBase() {
		try {
			viewTicketBillDetail.loadDataTicketBillFromDataBase(ticketBillService.getAllTicketBill());
			viewTicketBillDetail.loadDataTicketFromDataBase(ticketService.getAllTicket());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

	private void findTicketBillByDate() {
		Date voucher_start = viewTicketBillDetail.getNgayBatDau();
		Date voucher_end = viewTicketBillDetail.getNgayKetThuc();
		if (voucher_start.after(voucher_end)) {
			// voucher_start > voucher_end
			MessageUtil.showWarning("Ngày bắt đầu không được phép lớn hơn ngày kết thúc!");
			return;
		}
		try {
			viewTicketBillDetail
					.loadDataTicketBillFromDataBase(ticketBillService.findTicketBillByDate(voucher_start, voucher_end));
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, "Đã xảy ra lỗi khi tìm kiếm!!!");
		}
	}

	private void exportExcel() {
		String[] columns = { "Mã hóa đơn", "Số lượng vé", "Tổng tiền", "Mã khuyến mãi", "Mã khách hàng",
				"Phương thức thanh toán", "Thời gian giao dịch" };
		try {
			long timestamp = System.currentTimeMillis();
			String timestampStr = Long.toString(timestamp);
			ticketBillService.exportExcel(columns, timestampStr);
		} catch (Exception e) {
			ErrorUtil.handle(e, e.getMessage());
		}
	}
}
