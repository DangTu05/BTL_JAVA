package Interfaces;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

public interface IMoviesView {
	public void setAccountSelectionListener(ListSelectionListener listener);

	public void loadDataFromDataBase(List<String[]> list);

	public void setFormData(String movie_id, String movie_name, String release_date, String director, int duration,
			String script, int age_permission, String poster, String status);

	public void reset();

	public void setResetListener(ActionListener listener);

	public JTable getTable();
}
