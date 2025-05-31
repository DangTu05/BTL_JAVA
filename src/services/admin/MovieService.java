package services.admin;

import java.util.List;

import dao.MovieActorDAO;
import dao.MovieCategoryDAO;
import dao.MovieDAO;
import models.Actor;
import models.Category;
import models.Movie;
import models.MovieActor;
import models.MovieCategory;
import models.MovieDetail;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;

public class MovieService {

	private MovieDAO movieDao;
	private MovieActorDAO movie_actorDao;
	private MovieCategoryDAO movie_categoryDao;

	public MovieService() {
		movieDao = new MovieDAO();
		movie_actorDao = new MovieActorDAO();
		movie_categoryDao = new MovieCategoryDAO();
	}

	public boolean updateMovie(Movie movie) throws Exception {
		if (!movieDao.update(movie))
			throw new Exception("Cập nhật tài khoản thất bại!!!");
		return true;
	}

	public boolean softDelete(String movie_id) throws Exception {
		if (!movieDao.softDelete(movie_id))
			throw new Exception(MessageConstants.ERROR_DELETE_FAILED);
		return true;
	}

	public List<String[]> getAllMoiveTypeString() throws Exception {
		try {
			return MovieDAO.getAllMoiveTypeString();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Lỗi danh sách phim!!!", e);
		}
	}

	public List<Movie> getAllMovieTypeMovie() throws Exception {
		try {
			return MovieDAO.getAllMoiveTypeMovie();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Lỗi danh sách phim!!!", e);
		}
	}

	public List<String[]> findMovieByName(String name) throws Exception {
		try {
			return MovieDAO.findMovieByName(name);
		} catch (Exception e) {
			throw new Exception("Tìm kiếm thất bại!!!", e);
		}
	}
	public List<Movie> getListMovieDetail() throws Exception{
		try {
			return MovieDAO.getListMovieDetail();
		} catch (Exception e) {
			throw new Exception("Đã xảy ra lỗi danh sách phim!!!",e);
		}
	}

	public boolean createMovie(Movie movie, List<Actor> actors, List<Category> categories) throws Exception {
		try {
			if (!movieDao.insert(movie))
				throw new Exception(MessageConstants.ERROR_CREATE);
			if (!actors.isEmpty()) {
				for (Actor actor : actors) {
					if (!movie_actorDao.insert(new MovieActor(movie.getMovie_id(), actor.getActor_id())))
						throw new Exception(MessageConstants.ERROR_CREATE);
				}
			}
			if (!categories.isEmpty()) {
				for (Category category : categories) {
					if (!movie_categoryDao.insert(new MovieCategory(category.getCategory_id(), movie.getMovie_id())))
						throw new Exception(MessageConstants.ERROR_CREATE);
				}
			}
		} catch (Exception e) {
			movieDao.delete(movie.getMovie_id());
			throw e;
		}
		return true;

	}
}
