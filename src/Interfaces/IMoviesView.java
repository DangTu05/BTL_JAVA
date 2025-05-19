package Interfaces;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;


public interface IMoviesView {
	public void setMovieSelectionListener(ListSelectionListener listener);

	public void loadDataFromDataBase(List<String[]> list);

	public void setFormData(String movie_id, String movie_name, String release_date, String director, int duration,
			String script, int age_permission, String poster, String status);

	public void reset();

	public void setResetListener(ActionListener listener);

	public void setTaoListener(ActionListener listener);

	public void setLuuListener(ActionListener listener);

	public void setXoaListener(ActionListener listener);

	public void setSearchListener(ActionListener listener);

	public String getMovie_Id();

	public String getTextSearch();

	public String getMovie_Name();

	public String getPoster();

	public String getDirector();

	public String getScript();

	public String getStatus();

	public java.sql.Date getNgayPhatHanh();

	public int getThoiLuong();

	public int getDoTuoi();

	public JTable getTable();

	public JPanel getMainPanel();
}
