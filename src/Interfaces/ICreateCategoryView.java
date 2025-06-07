package Interfaces;

import java.awt.event.ActionListener;

import models.Category;

public interface ICreateCategoryView extends ICreateView<Category> {
	public String getCategoryName();
}
