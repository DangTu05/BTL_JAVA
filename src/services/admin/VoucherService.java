package services.admin;

import java.util.List;

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

	public List<String[]> getAllVoucher() throws Exception {

		try {
			return VoucherDAO.getAllVoucher();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Đã xảy ra lỗi!!!", e);
		}
	}

	public boolean updateVoucher(Voucher voucher) throws Exception {
		if (!voucherDao.update(voucher)) {
			throw new Exception("Đã xảy ra lỗi khi cập nhật thông tin voucher!!!");
		}
		return true;
	}

	public boolean deleteVoucher(String voucher_id) throws Exception {
		if (!voucherDao.delete(voucher_id)) {
			throw new Exception("Xóa thất bại!!!");
		}
		return true;
	}
}
