package services;

import java.util.List;

import dao.UserDAO;
import models.User;

public class UserService {
	private UserDAO userDao;

	public UserService() {
		userDao = new UserDAO();
	}

	public User getUserById(String userId) throws Exception {
		User user = userDao.findByField("user_id", userId);
		if (user == null) {
			throw new Exception("User không tồn tại!");
		}
		return user;
	}

	public List<String[]> getAllUser() throws Exception {
		try {
			return UserDAO.getAllUser();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Lỗi khi lấy danh sách người dùng!!!", e);
		}
	}

	public boolean updateUser(User user) throws Exception {
		if (!userDao.update(user)) {
			throw new Exception("Cập nhật thông tin user thất bại!!!");
		}
		return true;
	}
}
