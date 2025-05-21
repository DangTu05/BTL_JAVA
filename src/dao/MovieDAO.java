package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Configs.Database.ConnectDB;
import models.Movie;

public class MovieDAO extends BaseDAO<Movie> {
	@Override
	protected String getTableName() {
		return "tblMovi";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		return "movie_id";
	}

	@Override
	protected PreparedStatement buildInsertStatement(Connection conn, Movie entity) throws SQLException {
		String sql = "Insert into tblMovie (movie_id,movie_name,release_date,director,duration,script,age_permission,poster,status,deleted) values(?,?,?,?,?,?,?,?,?,false)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getMovie_id());
		statement.setString(2, entity.getMovie_name());
		statement.setDate(3, entity.getRelease_date());
		statement.setString(4, entity.getDirector());
		statement.setInt(5, entity.getDuration());
		statement.setString(6, entity.getScript());
		statement.setInt(7, entity.getAge_permisson());
		statement.setString(8, entity.getPoster());
		statement.setString(9, entity.getStatus());
		return statement;
	}

	public static List<String[]> getAllMoiveTypeString() throws Exception {
		String sql = "Select * from tblMovie where deleted=false";
		List<String[]> movies = new ArrayList<>();
		try (Connection conn = ConnectDB.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			while (rs.next()) {
				movies.add(new String[] { rs.getString("movie_id"), rs.getString("movie_name"),
						rs.getString("release_date"), rs.getString("director"), rs.getString("duration"),
						rs.getString("script"), rs.getString("age_permission"), rs.getString("poster"),
						rs.getString("status") });
			}

		} catch (Exception e) {
			throw new Exception("Lỗi khi tìm kiếm tài khoản " + e.getMessage(), e);
		}
		return movies;
	}

	public static List<Movie> getAllMoiveTypeMovie() throws Exception {
		List<Movie> movies = new ArrayList<>();
		String sql = "SELECT * FROM tblMovie WHERE deleted=false";
		try (Connection conn = ConnectDB.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql)) {
			while (rs.next()) {
				Movie movie = new Movie(rs.getString("movie_id"), rs.getString("movie_name"),
						rs.getDate("release_date"), // hoặc rs.getString nếu cần
						rs.getString("director"), rs.getInt("duration"), rs.getString("script"),
						rs.getInt("age_permission"), rs.getString("poster"), rs.getString("status"));
				movies.add(movie);
			}
		} catch (Exception e) {
			throw new Exception("Lỗi khi lấy danh sách phim: " + e.getMessage(), e);
		}
		return movies;
	}

	@Override
	protected PreparedStatement buildUpdateStatement(Connection conn, Movie entity) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE tblMovie SET movie_name=?, release_date=?,director=?,duration=?,script=?,	age_permission=?,poster=?,status=? where movie_id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, entity.getMovie_name());
		statement.setDate(2, entity.getRelease_date());
		statement.setString(3, entity.getDirector());
		statement.setInt(4, entity.getDuration());
		statement.setString(5, entity.getScript());
		statement.setInt(6, entity.getAge_permisson());
		statement.setString(7, entity.getPoster());
		statement.setString(8, entity.getStatus());
		statement.setString(9, entity.getMovie_id());
		return statement;
	}

	public static List<String[]> findMovieByName(String movie_name) throws Exception {
		List<String[]> movies = new ArrayList<>();
		String query = "Select * from tblMovie where deleted=false and movie_name Like ?";
		try (Connection conn = ConnectDB.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, "%" + movie_name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				movies.add(new String[] { rs.getString("movie_id"), rs.getString("movie_name"),
						rs.getString("release_date"), rs.getString("director"), rs.getString("duration"),
						rs.getString("script"), rs.getString("age_permission"), rs.getString("poster"),
						rs.getString("status") });
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw new Exception("Lỗi khi tìm kiếm tài khoản", e1);
		}
		return movies;

	}

	@Override
	protected Movie mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
