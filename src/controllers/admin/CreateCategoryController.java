package controllers.admin;

import Interfaces.ICreateCategoryView;
import dao.CategoryDAO;
import models.Category;
import utils.ErrorUtils;
import utils.GenerateId;
import utils.MessageUtils;
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
		String category_id = GenerateId.generateId("CATEGORY");
		String category_name = view.getCategoryName();
		try {
			Category category = null;
			if (!InputValidate.createCategory(category_id, category_name))
				return;
			category = new Category(category_id, category_name);
			if(!dao.insert(category)) {
				MessageUtils.showInfo("Tạo không thành công");
				return;
			}	
			MessageUtils.showInfo("Tạo thành công!");
			return;
		} catch (Exception e) {
			ErrorUtils.handle(e, "Đã xảy ra lỗi!!!");
		}
	}
}
