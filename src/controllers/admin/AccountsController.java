package controllers.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.AccountDAO;
import models.Account;
import utils.ErrorUtils;
import utils.MessageUtils;
import views.Admin.Accounts;

public class AccountsController implements ActionListener {
	public Accounts acc;
	private AccountDAO account;

	public AccountsController(Accounts acc) {
		this.acc = acc;
		this.account = new AccountDAO();
	}

	public AccountsController() {
		this.account = new AccountDAO();
	}

	public List<String[]> getAllAccount() {
		return account.getAllAccounts();
	}

	public void addTableListener() {
		acc.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = acc.getTable().getSelectedRow();
					if (selectedRow != -1) {
						Object maTaiKhoan = acc.getTable().getValueAt(selectedRow, 0);
						Object tenDangNhap = acc.getTable().getValueAt(selectedRow, 1);
						Object Email = acc.getTable().getValueAt(selectedRow, 2);
						Object Password = acc.getTable().getValueAt(selectedRow, 3);
						Object Status = acc.getTable().getValueAt(selectedRow, 4);
						Object Role = acc.getTable().getValueAt(selectedRow, 5);
						acc.setFormData(maTaiKhoan != null ? maTaiKhoan.toString() : "",
								tenDangNhap != null ? tenDangNhap.toString() : "",
								Email != null ? Email.toString() : "", Password != null ? Password.toString() : "",
								Status.equals("active") ? "Đang hoạt động" : "Tài khoản bị khóa",
								Role != null ? Role.toString() : "");
					}
				}
			}
		});
	}

	public void updateAccount() {
		try {
			if (acc.getMa().isEmpty()) {
				MessageUtils.showWarning("Vui lòng chọn tài khoản muốn sửa!!!");
				return;
			}
			if (!checkData()) {
				MessageUtils.showWarning("Thông tin không được để trống!!!");
				return;
			}
			Account user = AccountDAO.findTkById(acc.getMa());
			user.setEmail(acc.getEmail());
			user.setUser_Name(acc.getName());
			user.setStatus(acc.getStatus().equals("Đang hoạt động") ? "active" : "inactive");
			if (!MessageUtils.confirm("Bạn có muốn cập nhật?"))
				return;
			if (!AccountDAO.updateAccount(user)) {
				MessageUtils.showError("Cập nhật thất bại");
				return;
			}
			MessageUtils.showInfo("Cập nhật thành công");
			acc.loadDataFromDatabase();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorUtils.handle(e, e.getMessage());
			e.printStackTrace();
		}

	}

	public boolean checkData() {
		if (acc.getEmail().isEmpty() || acc.getName().isEmpty())
			return false;
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Lưu")) {
			updateAccount();
		} else if (cm.equals("Đang hoạt động")) {
			acc.setStatus("Tài khoản bị khóa");
			updateAccount();
		} else if (cm.equals("Tài khoản bị khóa")) {
			acc.setStatus("Đang hoạt động");
			updateAccount();
		}

	}
}
