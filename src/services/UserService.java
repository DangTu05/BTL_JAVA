package services;

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
}
