package controllers.admin;

import Interfaces.ICreateCategoryView;
import dao.CategoryDAO;
import models.Category;
import utils.ErrorUtil;
import utils.GenerateIdUtil;
import utils.MessageUtil;
import validator.InputValidate;

public class CreateCategoryController {
	private ICreateCategoryView view;
	private CategoryDAO dao;

	public CreateCategoryController(ICreateCategoryView view) {
		this.view = view;
		dao = new CategoryDAO();
		setUpEventListeners();

	}

	private void setUpEventListeners() {
		view.setTaoListener(e -> createCategory());
	}

	private void createCategory() {
		String category_id = GenerateIdUtil.generateId("CATEGORY");
		String category_name = view.getCategoryName();
		try {
			Category category = null;
			if (!InputValidate.createCategory(category_id, category_name))
				return;
			category = new Category(category_id, category_name);
			if(!dao.insert(category)) {
				MessageUtil.showInfo("Tạo không thành công");
				return;
			}	
			MessageUtil.showInfo("Tạo thành công!");
			return;
		} catch (Exception e) {
			ErrorUtil.handle(e, "Đã xảy ra lỗi!!!");
		}
	}
}
