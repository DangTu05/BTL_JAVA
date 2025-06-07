package controllers.admin;

import Interfaces.ICreateCategoryView;
import models.Category;
import services.admin.CategoryService;
import utils.ErrorUtil;
import utils.GenerateIdUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;

public class CreateCategoryController extends AbstractCreateController<Category, ICreateCategoryView> {
	private final CategoryService categoryService = new CategoryService();

	public CreateCategoryController(ICreateCategoryView view) {
		super(view);
	}

	@Override
	protected boolean createEntity(Category model) throws Exception {
		return categoryService.createCategory(model);
	}
}
