package controllers.admin;

import java.io.File;
import java.sql.Date;

import Interfaces.ICreateVoucher;
import controllers.AppController;
import middlewares.UploadCloud;
import models.Voucher;
import services.admin.VoucherService;
import utils.ErrorUtil;
import utils.GenerateIdUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;

public class CreateVoucherController {
	private ICreateVoucher viewCreateVoucher;
	private VoucherService voucherService;

	public CreateVoucherController(ICreateVoucher viewCreateVoucher) {
		this.viewCreateVoucher = viewCreateVoucher;
		voucherService = new VoucherService();
		setupEventListeners();
	}

	public void setupEventListeners() {
		viewCreateVoucher.setTaoListener(e -> insertVoucher());
		viewCreateVoucher.setShowImgListener(e -> viewCreateVoucher.showImageChooser());
	}

	public void insertVoucher() {
		Date voucher_start = viewCreateVoucher.getNgayBatDau();
		Date voucher_end = viewCreateVoucher.getNgayKetThuc();
		float voucher_discount = viewCreateVoucher.getGiamGia();
		File voucher_iamge = viewCreateVoucher.getFileImg();
		String voucher_name = viewCreateVoucher.getTenKhuyenMai();
		String voucher_script = viewCreateVoucher.getMoTa();
		if (!InputValidate.createVoucher(voucher_name))
			return;
		if (voucher_start.after(voucher_end)) {
			// voucher_start > voucher_end
			MessageUtil.showWarning("Ngày bắt đầu không được phép lớn hơn ngày kết thúc!");
			return;
		}
		String voucher_id = GenerateIdUtil.generateId("VOU");
		try {
			if (!MessageUtil.confirm("Bạn có muốn tạo không?"))
				return;
			String urlImg = "";
			if (voucher_iamge != null)
				urlImg = UploadCloud.upload(viewCreateVoucher.getFileImg());
			Voucher voucher = new Voucher(voucher_id, voucher_name, voucher_discount, voucher_start, voucher_end,
					voucher_script, urlImg);

			if (!voucherService.insertVoucher(voucher)) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_CREATE);
			AppController.startDashboard(viewCreateVoucher.getFrame());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}
}
