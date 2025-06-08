package controllers.admin;

import javax.swing.JPanel;
import javax.swing.JTable;

import Interfaces.IVoucherView;
import controllers.AppController;
import models.Voucher;
import services.admin.VoucherService;
import utils.ConvertUtil;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;

public class VoucherController extends BaseController<Voucher> {
	private VoucherService voucherService;
	private IVoucherView viewVoucher;

	public VoucherController(IVoucherView viewVoucher) {
		this.viewVoucher = viewVoucher;
		voucherService = new VoucherService();
		loadDataFromDataBase();
		setupEventListener();
	}

	private void setupEventListener() {
		viewVoucher.setVoucherSelectionListener(e -> addTableListener(viewVoucher.getTable()));
		viewVoucher.setResetListener(e -> reset());
		viewVoucher.setLuuListener(e -> updateVoucher());
		viewVoucher.setTaoListener(e -> AppController.startCreateVoucher(getFrame()));
		viewVoucher.setXoaListener(e -> deleteVoucher());
	}

	private void loadDataFromDataBase() {
		try {
			viewVoucher.loadDataFromDataBase(voucherService.getAllVoucher());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	private void reset() {
		viewVoucher.resetForm();
		loadDataFromDataBase();
	}

	private void updateVoucher() {
		if (viewVoucher.getMaKM().isEmpty()) {
			MessageUtil.showWarning("Vui lòng chọn voucher muốn sửa!");
			return;
		}
		if (!InputValidate.createVoucher(viewVoucher.getTenKM()))
			return;
		Voucher voucher = new Voucher(viewVoucher.getMaKM(), viewVoucher.getTenKM(), viewVoucher.getGiamGia(),
				viewVoucher.getNgayBatDau(), viewVoucher.getNgayKetThuc(), viewVoucher.getMoTa(), viewVoucher.getAnh());
		if (!MessageUtil.confirm(MessageConstants.CONFIRM_UPDATE))
			return;
		try {
			if (!voucherService.updateVoucher(voucher)) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_UPDATE);
			reset();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, "Đã xảy ra lỗi khi cập nhật!!!");
		}
	}

	/// Lấy ra data và render ra giao diện khi người dùng kích vào row nào đó
	@Override
	protected void getSetData() {
		int selectedRow = viewVoucher.getTable().getSelectedRow();
		if (selectedRow == -1)
			return;

		JTable table = viewVoucher.getTable();
		String voucher_id = String.valueOf(table.getValueAt(selectedRow, 0));
		String voucher_name = String.valueOf(table.getValueAt(selectedRow, 1));
		float voucher_discount = ConvertUtil.parseFloatSafely(table.getValueAt(selectedRow, 2), 0f);
		String voucher_start = String.valueOf(table.getValueAt(selectedRow, 3));
		String voucher_end = String.valueOf(table.getValueAt(selectedRow, 4));
		String voucher_script = String.valueOf(table.getValueAt(selectedRow, 5));
		String voucher_image = String.valueOf(table.getValueAt(selectedRow, 6));

		// Đưa về View
		viewVoucher.setFormData(voucher_id, voucher_name, voucher_discount, voucher_start, voucher_end, voucher_script,
				voucher_image);

	}

	private void deleteVoucher() {
		try {
			if (viewVoucher.getMoTa().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn voucher bạn muốn xóa!");
				return;
			}
			if (!MessageUtil.confirm("Bạn có muốn xóa voucher này?"))
				return;
			if (!voucherService.deleteVoucher(viewVoucher.getMaKM())) {
				MessageUtil.showError(MessageConstants.ERROR_DELETE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_DELETE);
			reset();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	@Override
	protected JPanel getJPanel() {
		// TODO Auto-generated method stub
		return viewVoucher.getPanel();
	}
}
