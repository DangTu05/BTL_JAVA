package Interfaces;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import models.Actor;
import models.Category;

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

	public JButton getBtnTrangChu();

	public JFrame getFrame();

	public void setTrangChuListener(ActionListener listener);

	public void setShowImgListener(ActionListener listener);

	public void setTaoListener(ActionListener listener);

	public void reSetForm();

	public <T> void getItemsForList(List<T> dataList, JList<T> jList);

	public <T> List<T> getSelectedItemList(JList<T> jList);

	public JList<Actor> getListActor();

	public JList<Category> getListCategory();
}
