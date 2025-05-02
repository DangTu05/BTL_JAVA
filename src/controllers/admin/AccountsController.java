package controllers.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Interfaces.IAccountView;
import dao.AccountDAO;
import models.Account;
import utils.ErrorUtils;
import utils.MessageUtils;
import utils.PasswordUtils;
import views.Admin.Accounts;

public class AccountsController {
	private IAccountView view;
	private AccountDAO dao;

	public AccountsController(IAccountView acc) {
		this.view = acc;
		dao = new AccountDAO();
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
				MessageUtils.showWarning("Vui lòng chọn tài khoản muốn sửa!!!");
				return;
			}
			if (!checkData()) {
				MessageUtils.showWarning("Thông tin không được để trống!!!");
				return;
			}
			Account user = AccountDAO.findTkById(view.getMa());
			user.setEmail(view.getEmail());
			user.setUser_Name(view.getName());
			user.setStatus(view.getStatus().equals("Đang hoạt động") ? "active" : "inactive");
			if (!view.getPassword().isEmpty()) {
				user.setPassword(PasswordUtils.hashPassword(view.getPassword()));
			}
			if (!MessageUtils.confirm("Bạn có muốn cập nhật?"))
				return;
			if (!dao.update(user)) {
				MessageUtils.showError("Cập nhật thất bại");
				return;
			}
			MessageUtils.showInfo("Cập nhật thành công");
			view.loadDataFromDataBase(AccountDAO.getAllAccounts());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorUtils.handle(e, "Đã xảy ra lỗi!!!");
		}

	}

	public void deleteAccount() {

		try {
			if (view.getMa().isEmpty()) {
				MessageUtils.showWarning("Vui lòng chọn 1 tài khoản cần xóa!");
				return;
			}
			if (!MessageUtils.confirm("Bạn có chắc chắn muốn xóa tài khoản này không?"))
				return;
			if (!dao.delete(view.getMa())) {
				MessageUtils.showError("Xóa thất bại!");
				return;
			}
			MessageUtils.showInfo("Đã xóa thành công");
			view.loadDataFromDataBase(AccountDAO.getAllAccounts());

		} catch (Exception e) {
			ErrorUtils.handle(e, "Đã xảy ra lỗi");
		}
	}

	public void loadDataFromDataBase() {
		try {
			view.loadDataFromDataBase(AccountDAO.getAllAccounts());
		} catch (Exception e) {
			ErrorUtils.handle(e, "Đã xảy ra lỗi!!!");
		}
	}

	public void loadDataFromSearch() {
		try {
			view.loadDataFromForSearch(AccountDAO.findTksByName(view.getTextSearch()));
		} catch (Exception e) {
			ErrorUtils.handle(e, "Đã xảy ra lỗi!!!");
		}
	}

	public boolean checkData() {
		if (view.getEmail().isEmpty() || view.getName().isEmpty())
			return false;
		return true;
	}

	public void resetData() {
		view.reset();
	}

	public void toggleAccountStatus() {

		try {
			if (view.getMa().isEmpty()) {
				MessageUtils.showWarning("Vui lòng chọn tài khoản muốn đổi trạng thái!");
				return;
			}
			// Lấy trạng thái hiện tại từ view
			String currentStatus = view.getStatus();
			String newStatus = currentStatus.equals("Đang hoạt động") ? "Tài khoản bị khóa" : "Đang hoạt động";

			// Cập nhật trạng thái trên giao diện
			view.setStatus(newStatus);

			// Nếu muốn lưu ngay lập tức
			updateAccount();
		} catch (Exception e) {
			ErrorUtils.handle(e, "Đã xảy ra lỗi!!!");
		}
	}
}
