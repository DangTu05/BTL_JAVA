package services.admin;

import java.util.List;

import dao.AccountDAO;
import dao.UserDAO;
import models.Account;
import utils.PasswordUtil;

public class AccountService {
	private AccountDAO accountDao;

	public AccountService() {
		accountDao = new AccountDAO();
	}

	public boolean updateAccount(String AccountId, String email, String name, String status, String password)
			throws Exception {
		Account account = accountDao.findByField("AccountId", AccountId);
		if (account == null)
			throw new Exception("Không tìm thấy tài khoản!");
		account.setEmail(email);
		account.setUser_Name(name);
		account.setStatus(status.equals("Đang hoạt động") ? "active" : "inactive");
		if (!password.isEmpty()) {
			account.setPassword(PasswordUtil.hashPassword(password));
		}
	
		if (!accountDao.update(account)) {
			throw new Exception("Cập nhật thất bại!!!");
		}
		return true;
	}

	public boolean deleteAccount(String AccountId) throws Exception {
		Account account = accountDao.findByField("account_id", AccountId);
		if (account == null)
			throw new Exception("Tài khoản không tồn tại!");
		if (!accountDao.delete(AccountId)) {
			throw new Exception("Xóa tài khoản thất bại!");
		}
		return true;
	}

	public boolean toggleAccountStatus(String status, String account_id) throws Exception {
		// Nếu muốn lưu ngay lập tức
		if (!accountDao.changeStatus(status.equals("Đang hoạt động") ? "inactive" : "active", account_id))
			throw new Exception("Đổi trạng thái thất bại!");
		return true;
	}

	public List<String[]> getAllAccounts() throws Exception {
		try {
			return AccountDAO.getAllAccounts();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Đã xảy ra lỗi danh sách tài khoản!!!", e);
		}
	}

	public List<String[]> findAccountByName(String name) throws Exception {
		try {
			return AccountDAO.findTksByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Đã xảy ra lỗi khi tìm kiếm!!!", e);
		}
	}

	public Account findAccountByEmail(String email) throws Exception {
		try {
			return accountDao.findByField("email", email);
		} catch (Exception e) {
			throw new Exception("Lỗi khi tìm kiếm tài khoản!!!", e);
		}
	}

	public boolean changePassword(String password, String email) throws Exception {
		try {
			if (!AccountDAO.changePassword(password, email))
				throw new Exception("Đổi mật khẩu không thành công!");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Đổi mật khẩu không thành công!",e);
		}

	}

}
