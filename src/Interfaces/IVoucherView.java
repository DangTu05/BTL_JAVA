package Interfaces;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;

public interface IVoucherView {

	public void setResetListener(ActionListener listener);

	public void setTaoListener(ActionListener listener);

	public void setLuuListener(ActionListener listener);

	public void setXoaListener(ActionListener listener);

	public void setSearchListener(ActionListener listener);

	public void setVoucherSelectionListener(ListSelectionListener listener);

	public String getAnh();

	public String getMaKM();

	public String getTenKM();

	public String getSearch();

	public JTable getTable();

	public String getMoTa();

	public JPanel getPanel();

	public void loadDataFromDataBase(List<String[]> list);

	public void resetForm();

	public float getGiamGia();

	public java.sql.Date getNgayBatDau();

	public java.sql.Date getNgayKetThuc();

	public void setFormData(String voucher_id, String voucher_name, float voucher_discount, String voucher_start,
			String voucher_end, String voucher_script, String voucher_image)

}
