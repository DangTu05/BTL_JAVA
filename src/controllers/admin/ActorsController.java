package controllers.admin;

import Interfaces.IActorsView;
import Interfaces.IHomeNavigableView;
import dao.ActorDAO;
import dao.MovieDAO;
import models.Actor;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;

public class ActorsController extends BaseController<Actor> {
	private IActorsView view;
	private ActorDAO dao;
	private AppController app;
	private IHomeNavigableView viewSideBar;

	public ActorsController(IActorsView view) {
		this.view = view;
//		viewSideBar = view.getSideBar();
		dao = new ActorDAO();
		app = new AppController();
		loadDataFromDataBase();
		setUpEventListeners();
//		setAction();
	}

	private void setUpEventListeners() {
		view.setActorSelectionListener(e -> addTableListener(view.getTable()));
		view.setResetListener(e -> view.reset());
		view.setTaoListener(e -> app.startCreateActor(view.getFrame()));
		view.setLuuListener(e -> updateActor());
		view.setXoaListener(e -> softDelete());
	}

	private void loadDataFromDataBase() {

		try {

			view.loadDataFromDataBase(ActorDAO.getAllActor());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, "Đã xảy ra lỗi!!!");
		}
	}

	@Override
	protected void getSetData() {
		int selectedRow = view.getTable().getSelectedRow();
		if (selectedRow != -1) {
			Object actor_id = view.getTable().getValueAt(selectedRow, 0);
			Object actor_name = view.getTable().getValueAt(selectedRow, 1);
			Object birth = view.getTable().getValueAt(selectedRow, 2);
			Object nationality = view.getTable().getValueAt(selectedRow, 3);
			Object biography = view.getTable().getValueAt(selectedRow, 4);
			Object actor_image = view.getTable().getValueAt(selectedRow, 5);
			view.setFormData(actor_id != null ? actor_id.toString() : "",
					actor_name != null ? actor_name.toString() : "", birth != null ? birth.toString() : "",
					nationality != null ? nationality.toString() : "", biography != null ? biography.toString() : "",
					actor_image != null ? actor_image.toString() : "");
		}

	}

	private void updateActor() {

		try {
			if (view.getActor_Id().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn tài khoản muốn sửa!");
				return;
			}
			if (!InputValidate.createActor(view.getActor_Name(), view.getNgaySinh()))
				return;
			Actor actor = new Actor(view.getActor_Id(), view.getActor_Name(), view.getActor_Image(),
					view.getNationality(), view.getNgaySinh(), view.getBiography());
			if (!MessageUtil.confirm(MessageConstants.CONFIRM_UPDATE))
				return;
			if (!dao.update(actor)) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_UPDATE);
			loadDataFromDataBase();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

	private void softDelete() {

		try {
			if (view.getActor_Id().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn tài khoản muốn xóa!");
				return;
			}
			if (!dao.softDelete(view.getActor_Id())) {
				MessageUtil.showError(MessageConstants.ERROR_DELETE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_DELETE);
			view.loadDataFromDataBase(ActorDAO.getAllActor());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

//	protected IHomeNavigableView getView() {
//		return viewSideBar;
//	}
}
