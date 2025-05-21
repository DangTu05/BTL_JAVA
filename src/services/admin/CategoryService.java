package services.admin;

import dao.CategoryDAO;
import models.Category;
import utils.MessageConstants;

public class CategoryService {
	private CategoryDAO categoryDao;

	public CategoryService() {
		categoryDao = new CategoryDAO();
	}

	public boolean createCategory(Category category) throws Exception {
		if (!categoryDao.insert(category))
			throw new Exception(MessageConstants.ERROR_CREATE);
		return true;

	}
}
