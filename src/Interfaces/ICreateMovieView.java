package Interfaces;

import java.awt.event.ActionListener;
import java.io.File;

public interface ICreateMovieView {
	public void setFileImg(File fileImg);

	public void showImageChooser();

	public String getMovieName();

	public String getDirector();

	public String getStatus();

	public String getMoTa();

	public java.sql.Date getNgayPhatHanh();

	public int getThoiLuong();

	public int getDoTuoi();

	public File getFileImg();

	public void setShowImgListener(ActionListener listener);

	public void setTaoListener(ActionListener listener);

	public void reSetForm();
}
