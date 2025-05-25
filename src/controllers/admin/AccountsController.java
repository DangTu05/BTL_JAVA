package controllers.admin;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Interfaces.IAccountView;
import Interfaces.IHomeNavigableView;
import dao.AccountDAO;
import models.Account;
import services.admin.AccountService;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import utils.PasswordUtil;
import utils.errors.CustomException;
import validator.InputValidate;

public class AccountsController extends BaseController<Account> {
	private IAccountView view;
	private AccountDAO dao;
	private AccountService accountService;

	public AccountsController(IAccountView acc) {
		this.view = acc;
		dao = new AccountDAO();
		accountService = new AccountService();
		setupEventListeners();
		loadDataFromDataBase();
	}

	public AccountsController() {

	}

	private void setupEventListeners() {
		view.setSaveListener(e -> updateAccount()); // Gán sự kiện Lưu
		view.setDeleteListener(e -> deleteAccount()); // Gán sự kiện Xóa
		view.setRefreshListener(e -> resetData()); // Gán sự kiện Làm mới
		view.setStatusToggleListener(e -> toggleAccountStatus()); // Gán sự kiện Đổi trạng thái
		view.setSearchListener(e -> loadDataFromSearch()); // Gán sự kiện Tìm kiếm
		view.setAccountSelectionListener(e -> addTableListener());// Sự kiện người dùng nhấn vào hàng trong table
	}

	@Override
	protected void getSetData() {
		JTable table = view.getTable();
		int selectedRow = table.getSelectedRow();
		int countRow = table.getRowCount();
		if (selectedRow == -1)
			return;
		String accountId = String.valueOf(table.getValueAt(selectedRow, 0));
		String username = String.valueOf(table.getValueAt(selectedRow, 1));
		String email = String.valueOf(table.getValueAt(selectedRow, 2));
		String password = String.valueOf(table.getValueAt(selectedRow, 3));
		String rawStatus = String.valueOf(table.getValueAt(selectedRow, 4));
		String role = String.valueOf(table.getValueAt(selectedRow, 5));
		String displayStatus = rawStatus.equalsIgnoreCase("active") ? "Đang hoạt động" : "Tài khoản bị khóa";
		view.setFormData(accountId, username, email, password, displayStatus, role);
		view.setTextLblBanGhi(countRow, selectedRow);

	}

	public void addTableListener() {
		view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {/// Kiểm tra để tránh xử lý khi người dùng đang kéo chuột chọn, chỉ
													/// xử lý khi việc chọn đã hoàn tất
					int countRow = view.getTable().getRowCount();
					int selectedRow = view.getTable().getSelectedRow();
					if (selectedRow != -1) {
						Object maTaiKhoan = view.getTable().getValueAt(selectedRow, 0);
						Object tenDangNhap = view.getTable().getValueAt(selectedRow, 1);
						Object Email = view.getTable().getValueAt(selectedRow, 2);
						Object Password = view.getTable().getValueAt(selectedRow, 3);
						Object Status = view.getTable().getValueAt(selectedRow, 4);
						Object Role = view.getTable().getValueAt(selectedRow, 5);
						view.setFormData(maTaiKhoan != null ? maTaiKhoan.toString() : "",
								tenDangNhap != null ? tenDangNhap.toString() : "",
								Email != null ? Email.toString() : "", Password != null ? Password.toString() : "",
								Status.equals("active") ? "Đang hoạt động" : "Tài khoản bị khóa",
								Role != null ? Role.toString() : "");
					}
					view.setTextLblBanGhi(countRow, selectedRow);
				}
			}
		});
	}

	public void updateAccount() {
		try {
			if (view.getMa().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn tài khoản cần sửa!");
				return;
			}
			if (!InputValidate.AccountValidate(view.getEmail(), view.getName()))
				return;
			if (!MessageUtil.confirm(MessageConstants.CONFIRM_UPDATE))
				return;
			if (!accountService.updateAccount(view.getMa(), view.getEmail(), view.getName(), view.getStatus(),
					view.getPassword())) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_UPDATE);
			view.loadDataFromDataBase(AccountDAO.getAllAccounts());
		} catch (Exception e) {
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);

			// TODO: handle exception
		}

	}

	public void deleteAccount() {
		try {
			if (view.getMa().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn 1 tài khoản cần xóa!");
				return;
			}
			if (!MessageUtil.confirm("Bạn có chắc chắn muốn xóa tài khoản này không?"))
				return;
			if (!accountService.deleteAccount(view.getMa())) {
				MessageUtil.showError(MessageConstants.ERROR_DELETE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_DELETE);
			view.loadDataFromDataBase(AccountDAO.getAllAccounts());

		} catch (Exception e) {
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	public void loadDataFromDataBase() {
		try {
			view.loadDataFromDataBase(accountService.getAllAccounts());
		} catch (Exception e) {
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	public void loadDataFromSearch() {
		try {
			view.loadDataFromForSearch(accountService.findAccountByName(view.getTextSearch()));
		} catch (Exception e) {
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	public void resetData() {
		view.reset();
	}

	public void toggleAccountStatus() {

		try {
			if (view.getMa().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn tài khoản muốn đổi trạng thái!");
				return;
			}
			// Lấy trạng thái hiện tại từ view
			String currentStatus = view.getStatus();
			String newStatus = currentStatus.equals("Đang hoạt động") ? "Tài khoản bị khóa" : "Đang hoạt động";
			// Nếu muốn lưu ngay lập tức
			if (!accountService.toggleAccountStatus(newStatus.equals("Đang hoạt động") ? "inactive" : "active",
					view.getMa())) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			// Cập nhật trạng thái trên giao diện
			view.setStatus(newStatus);
			loadDataFromDataBase();
		} catch (Exception e) {
			ErrorUtil.handle(e, e.getMessage());
		}
	}

}
