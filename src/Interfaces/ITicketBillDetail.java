package Interfaces;

import java.awt.event.ActionListener;
import java.util.List;

public interface ITicketBillDetail {
	public void setTimListener(ActionListener listener);

	public void setXuatExcel(ActionListener listener);

	public void setLamMoiListener(ActionListener listener);

	public java.sql.Date getNgayBatDau();

	public java.sql.Date getNgayKetThuc();

	public void loadDataTicketBillFromDataBase(List<String[]> list);

	public void loadDataTicketFromDataBase(List<String[]> list);
}
