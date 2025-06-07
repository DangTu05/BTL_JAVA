package Interfaces;

import java.awt.event.ActionListener;
import java.io.File;

public interface ICreateVoucher {
	public void setTaoListener(ActionListener listener);

	public void setShowImgListener(ActionListener listener);

	public String getTenKhuyenMai();

	public String getMoTa();

	public java.sql.Date getNgayBatDau();

	public java.sql.Date getNgayKetThuc();

	public float getGiamGia();

	public File getFileImg();

	public void setFileImg(File fileImg);

	/// show hộp để chọn file ảnh
	public void showImageChooser();
}
