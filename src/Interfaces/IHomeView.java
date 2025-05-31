package Interfaces;

import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import components.MenuBar;
import models.Movie;
import models.MovieDetail;

public interface IHomeView {

	public void hienThiDanhSachPhim(List<Movie> dsPhim,MouseListener listener);

	public JFrame getFrame();

	public MenuBar getMenu();

	public JPanel getMainContentPanel();
}
