package controllers.admin;

import javax.swing.JPanel;
import javax.swing.JTable;

import Interfaces.IActorsView;
import controllers.AppController;
import dao.ActorDAO;
import models.Actor;
import services.admin.ActorService;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;

public class ActorsController extends BaseController<Actor> {
	private IActorsView view;
	private ActorService actorService;

	public ActorsController(IActorsView view) {
		this.view = view;
		actorService = new ActorService();
		loadDataFromDataBase();
		setUpEventListeners();
	}

	private void setUpEventListeners() {
		view.setActorSelectionListener(e -> addTableListener(view.getTable()));
		view.setResetListener(e -> view.reset());
		view.setTaoListener(e -> AppController.startCreateActor(getFrame()));
		view.setLuuListener(e -> updateActor());
		view.setXoaListener(e -> softDelete());
		view.setSearchListener(e -> loadDataFromSearch());
	}

	private void loadDataFromDataBase() {

		try {
			view.loadDataFromDataBase(actorService.getAllActorTypeString());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

	private void loadDataFromSearch() {
		try {
			view.loadDataFromSearch(actorService.findActorsByName(view.getSearch()));
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	@Override
	protected void getSetData() {
		int selectedRow = view.getTable().getSelectedRow();
		if (selectedRow == -1)
			return;
		JTable table = view.getTable();
		String actor_id = String.valueOf(table.getValueAt(selectedRow, 0));
		String actor_name = String.valueOf(table.getValueAt(selectedRow, 1));
		String birth = String.valueOf(table.getValueAt(selectedRow, 2));
		String nationality = String.valueOf(table.getValueAt(selectedRow, 3));
		String biography = String.valueOf(table.getValueAt(selectedRow, 4));
		String actor_image = String.valueOf(table.getValueAt(selectedRow, 5));
		view.setFormData(actor_id, actor_name, birth, nationality, biography, actor_image);

	}

	protected JPanel getJPanel() {
		return view.getJPanel();
	}

	private void updateActor() {

		try {
			if (view.getActor_Id().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn diễn viên muốn sửa!");
				return;
			}
			if (!InputValidate.createActor(view.getActor_Name(), view.getNgaySinh()))
				return;
			Actor actor = new Actor(view.getActor_Id(), view.getActor_Name(), view.getActor_Image(),
					view.getNationality(), view.getNgaySinh(), view.getBiography());
			if (!MessageUtil.confirm(MessageConstants.CONFIRM_UPDATE))
				return;
			if (!actorService.updateActor(actor)) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_UPDATE);
			loadDataFromDataBase();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}

	private void softDelete() {

		try {
			if (view.getActor_Id().isEmpty()) {
				MessageUtil.showWarning("Vui lòng chọn diễn viên muốn xóa!");
				return;
			}
			if (!actorService.softDelete(view.getActor_Id())) {
				MessageUtil.showError(MessageConstants.ERROR_DELETE_FAILED);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_DELETE);
			loadDataFromDataBase();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, e.getMessage());
		}
	}

}
