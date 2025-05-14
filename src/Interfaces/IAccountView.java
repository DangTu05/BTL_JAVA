package Interfaces;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

public interface IAccountView {
	public void loadDataFromDataBase(List<String[]> list);

	public void loadDataFromForSearch(List<String[]> data);

	public void reset();

	public JTable getTable();

	public String getMa();

	public String getEmail();

	public void setStatus(String status);

	public String getStatus();

	public String getName();

	public String getTextSearch();

	public String getPassword();

	public JFrame getFrame();

	public void setFormData(String maTk, String tenTk, String email, String mk, String status, String role);

	public void setTextLblBanGhi(int countRow, int selectedRow);

	public void setSaveListener(ActionListener listener);

	public void setDeleteListener(ActionListener listener);

	public void setRefreshListener(ActionListener listener);

	public void setStatusToggleListener(ActionListener listener);

	public void setSearchListener(ActionListener listener);

	public void setAccountSelectionListener(ListSelectionListener listener);
}
