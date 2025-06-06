package Interfaces;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

public interface IActorsView {
	public void loadDataFromDataBase(List<String[]> list);

	public void loadDataFromSearch(List<String[]> actors);

	public void setFormData(String actor_id, String actor_name, String birth, String nationality, String biography,
			String actor_image);

	public void reset();

	public JTable getTable();

	public String getActor_Id();

	public String getActor_Name();

	public String getActor_Image();

	public String getBiography();

	public String getSearch();

	public String getNationality();

	public java.sql.Date getNgaySinh();

	public JPanel getJPanel();

	public void setActorSelectionListener(ListSelectionListener listener);

	public void setResetListener(ActionListener listener);

	public void setTaoListener(ActionListener listener);

	public void setLuuListener(ActionListener listener);

	public void setXoaListener(ActionListener listener);

	public void setSearchListener(ActionListener listener);
}
