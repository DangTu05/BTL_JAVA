package controllers.admin;

import Interfaces.IActorsView;
import dao.ActorDAO;
import utils.ErrorUtil;

public class ActorsController {
	private IActorsView view;
	private ActorDAO dao;

	public ActorsController(IActorsView view) {
		this.view = view;
		dao = new ActorDAO();
		loadDataFromDataBase();
	}

	private void loadDataFromDataBase() {

		try {
			view.loadDataFromDataBase(ActorDAO.getAllActor());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, "Đã xảy ra lỗi!!!");
		}
	}
}
