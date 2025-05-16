package controllers.admin;

import Interfaces.ICreateActorView;
import dao.ActorDAO;
import middlewares.UploadCloud;
import models.Actor;
import utils.ErrorUtil;
import utils.GenerateIdUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import validator.InputValidate;

public class CreateActorController {
	private ICreateActorView createActorView;
	private ActorDAO dao;

	public CreateActorController(ICreateActorView createActor) {
		this.createActorView = createActor;
		dao = new ActorDAO();
		setupEventListeners();
	}

	private void setupEventListeners() {
		createActorView.setShowImgListener(e -> createActorView.showImageChooser());
		createActorView.setTaoListener(e -> createActor());
	}

	public void createActor() {
		String actor_name = createActorView.getActorName();
		String nationality = createActorView.getQuocGia();
		String biography = createActorView.getTieuSu();
		java.sql.Date birth = createActorView.getNgaySinh();
		String actor_id = GenerateIdUtil.generateId("ACTOR");
		try {
			Actor actor = null;
			if (!InputValidate.createActor(actor_name, birth))
				return;
			if (createActorView.getFileImg() != null) {
				String urlImg = UploadCloud.upload(createActorView.getFileImg());
				actor = new Actor(actor_id, actor_name, urlImg, nationality, birth, biography);
			} else {
				actor = new Actor(actor_id, actor_name, nationality, birth, biography);
			}
			if (!dao.insert(actor)) {
				MessageUtil.showError(MessageConstants.ERROR_CREATE);
				return;
			}
			MessageUtil.showInfo(MessageConstants.SUCCESS_CREATE);
			return;
		} catch (Exception e) {
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
			// TODO: handle exception
		}
	}

}
