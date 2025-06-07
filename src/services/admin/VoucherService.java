package services.admin;

import dao.VoucherDAO;
import models.Voucher;

public class VoucherService {
	private VoucherDAO voucherDao;

	public VoucherService() {
		voucherDao = new VoucherDAO();
	}

	public boolean insertVoucher(Voucher voucher) throws Exception {
		if (!voucherDao.insert(voucher))
			throw new Exception("Thêm không thành công!!!");
		return true;
	}
}
