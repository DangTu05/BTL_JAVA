package controllers.admin;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.AccountDAO;
import models.Account;
import views.Admin.Accounts;

public class AccountsController {
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
								Status.equals("active") ? "Đang hoạt động" : "Tài khoản bị khóa", Role != null ? Role.toString() : "");
					}
				}
			}
		});
	}
}
