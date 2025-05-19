package Interfaces;

import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;

public interface ICreateActorView {
	public String getActorName();

	public String getTieuSu();

	public String getQuocGia();

	public java.sql.Date getNgaySinh();

	public void setFileImg(File fileImg);

	public File getFileImg();

	public JFrame getFrame();

	public void showImageChooser();

	public void setShowImgListener(ActionListener listener);

	public void setTaoListener(ActionListener listener);

	public void setTrangChuListener(ActionListener listener);
}
