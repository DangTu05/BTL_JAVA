package controllers.admin;

import Interfaces.IActorsView;
import dao.ActorDAO;
import models.Actor;
import utils.ErrorUtil;

public class ActorsController extends BaseController<Actor> {
	private IActorsView view;
	private ActorDAO dao;

	public ActorsController(IActorsView view) {
		this.view = view;
		dao = new ActorDAO();
		loadDataFromDataBase();
		setUpEventListeners();
	}

	private void setUpEventListeners() {
		view.setActorSelectionListener(e -> addTableListener(view.getTable()));
		view.setResetListener(e -> view.reset());
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
		Object actor_id = view.getTable().getValueAt(selectedRow, 0);
		Object actor_name = view.getTable().getValueAt(selectedRow, 1);
		Object birth = view.getTable().getValueAt(selectedRow, 2);
		Object nationality = view.getTable().getValueAt(selectedRow, 3);
		Object biography = view.getTable().getValueAt(selectedRow, 4);
		Object actor_image = view.getTable().getValueAt(selectedRow, 5);
		view.setFormData(actor_id != null ? actor_id.toString() : "", actor_name != null ? actor_name.toString() : "",
				birth != null ? birth.toString() : "", nationality != null ? nationality.toString() : "",
				biography != null ? biography.toString() : "", actor_image != null ? actor_image.toString() : "");
	}
}
