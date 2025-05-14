package Interfaces;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

public interface IActorsView {
	public void loadDataFromDataBase(List<String[]> list);

	public void setFormData(String actor_id, String actor_name, String birth, String nationality, String biography,
			String actor_image);

	public void reset();

	public JTable getTable();

	public String getActor_Id();

	public String getActor_Name();

	public String getActor_Image();

	public String getBiography();

	public String getNationality();

	public java.sql.Date getNgaySinh();

	public JFrame getFrame();

	public void setActorSelectionListener(ListSelectionListener listener);

	public void setResetListener(ActionListener listener);

	public void setTaoListener(ActionListener listener);

	public void setLuuListener(ActionListener listener);

	public void setXoaListener(ActionListener listener);
}
