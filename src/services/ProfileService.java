package services;

import dao.UserDAO;
import models.User;

public class ProfileService {
	private UserDAO userDao;
	public ProfileService() {
		userDao=new UserDAO();
	}
	public boolean updateProfile(User user) throws Exception {
		
		if(!userDao.update(user)) {
			throw new Exception("Sửa không thành công!");
		}
		return true;
	}
}
