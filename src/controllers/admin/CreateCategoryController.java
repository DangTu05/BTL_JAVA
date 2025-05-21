package controllers.admin;

import Interfaces.ICreateCategoryView;
import models.Category;
import services.admin.CategoryService;
import utils.ErrorUtil;
import utils.GenerateIdUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;

public class CreateCategoryController {
	private ICreateCategoryView view;
	private CategoryService categoryService;

	public CreateCategoryController(ICreateCategoryView view) {
		this.view = view;
		categoryService = new CategoryService();
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
			if (!categoryService.createCategory(category)) {
				MessageUtil.showError(MessageConstants.ERROR_CREATE);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_CREATE);
			return;
		} catch (Exception e) {
			ErrorUtil.handle(e, e.getMessage());
		}
	}
}
