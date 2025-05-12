package Interfaces;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

public interface IActorsView {
	public void loadDataFromDataBase(List<String[]> list);

	public void setFormData(String actor_id, String actor_name, String birth, String nationality, String biography,
			String actor_image);

	public void reset();

	public JTable getTable();

	public void setActorSelectionListener(ListSelectionListener listener);

	public void setResetListener(ActionListener listener);
}
