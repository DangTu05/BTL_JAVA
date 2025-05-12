package Interfaces;

import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

public interface IActorsView {
	public void loadDataFromDataBase(List<String[]> list);

	public void setFormData(String actor_id, String actor_name, String birth, String nationality, String biography,
			String actor_image);

	public JTable getTable();

	public void setActorSelectionListener(ListSelectionListener listener);
}
