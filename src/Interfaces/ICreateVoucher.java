package Interfaces;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;

public interface ICreateVoucher {
	public void setTaoListener(ActionListener listener);

	public void setShowImgListener(ActionListener listener);

	public String getTenKhuyenMai();

	public String getMoTa();

	public JFrame getFrame();

	public java.sql.Date getNgayBatDau();

	public java.sql.Date getNgayKetThuc();

	public float getGiamGia();

	public File getFileImg();

	public void setFileImg(File fileImg);

	/// show hộp để chọn file ảnh
	public void showImageChooser();
}
