package Interfaces;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

public interface IUserView {
	public void setLuuListener(ActionListener listener);

	public void setLamMoiListener(ActionListener listener);

	public String getTenKhachHang();

	public String getDiaChi();

	public String getAnh();

	public String getGioiTinh();

	public String getMaKH();

	public float getDiemTichLuy();

	public void reset();

	public void loadDataFromDataBase(List<String[]> data);

	public JTable getTable();

	public void setUserSelectionListener(ListSelectionListener listener);

	public void setFormData(String user_id, String user_name, String gender, String address, String user_image,
			float reward_points);
}
