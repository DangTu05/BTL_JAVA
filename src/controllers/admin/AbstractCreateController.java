package controllers.admin;

import Interfaces.ICreateView;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;

public abstract class AbstractCreateController<M, V extends ICreateView<M>> {
	protected final V view;

	public AbstractCreateController(V view) {
		this.view = view;
		setupListeners();
	}

	private void setupListeners() {
		view.setTaoListener(e -> create());
	}

	private void create() {
		try {
			if (!view.validateInput())
				return;

			M model = view.buildModel();
			if (!createEntity(model)) {
				MessageUtil.showError(MessageConstants.ERROR_CREATE);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_CREATE);
		} catch (Exception e) {
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	protected abstract boolean createEntity(M model) throws Exception;
}
