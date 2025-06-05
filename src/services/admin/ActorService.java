package services.admin;

import java.util.List;

import dao.ActorDAO;
import models.Actor;
import utils.MessageConstants;
public class ActorService {
	private ActorDAO actorDao;

	public ActorService() {
		actorDao = new ActorDAO();
	}

	public boolean updateActor(Actor actor) throws Exception {
		if (!actorDao.update(actor))
			throw new Exception(MessageConstants.ERROR_UPDATE_FAILED);
		return true;
	}

	public boolean softDelete(String actor_id) throws Exception {

			if (!actorDao.softDelete(actor_id)){
				throw new Exception(MessageConstants.ERROR_DELETE_FAILED);
			}
			return true;
	}

	public List<String[]> getAllActorTypeString() throws Exception {
		try {
			return ActorDAO.getAllActor();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Đã xảy ra lỗi danh sách diễn viên!!!", e);
		}
	}

	public List<String[]> findActorsByName(String actor_name) throws Exception {
		try {
			return ActorDAO.findActorsByName(actor_name);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Đã xảy ra lỗi khi tìm kiếm diễn viên!!!", e);
		}
	}

	public List<Actor> getAllActorTypeActor() throws Exception {
		try {
			return ActorDAO.getAllActors();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Đã xảy ra lỗi danh sách diễn viên!!!", e);
		}
	}

	public boolean createActor(Actor actor) throws Exception {
		if (!actorDao.insert(actor))
			throw new Exception(MessageConstants.ERROR_CREATE);
		return true;

	}

}
