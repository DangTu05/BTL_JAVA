package controllers.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import dao.ActorDAO;
import middlewares.UploadCloud;
import models.Actor;
import utils.ErrorUtils;
import utils.GenerateId;
import utils.MessageUtils;
import views.Admin.CreateActor;

public class CreateActorController implements ActionListener {
	public CreateActor createActor;

	public CreateActorController(CreateActor createActor) {
		this.createActor = createActor;
	}

	public void createRecord() {
		String actor_name = createActor.getActorName();
		String nationality = createActor.getQuocGia();
		String biography = createActor.getTieuSu();
		java.sql.Date birth = createActor.getNgaySinh();
		String actor_id = GenerateId.generateId("ACTOR");
		try {
			if (createActor.getFileImg() != null) {
				String urlImg = UploadCloud.upload(createActor.getFileImg());
				Actor actor = new Actor(actor_id, actor_name, urlImg, nationality, birth, biography);
				if (!ActorDAO.addActor(actor)) {
					MessageUtils.showInfo("Tạo không thành công");
					return;
				}
				MessageUtils.showInfo("Tạo thành công");
				return;
			}
		} catch (Exception e) {
			ErrorUtils.handle(e, "Đã xảy ra lỗi!");
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cm = e.getActionCommand();
		if (cm.equals("Chọn ảnh")) {
			createActor.showImageChooser();
		} else if (cm.equals("Tạo")) {
			createRecord();
		}
	}

}
