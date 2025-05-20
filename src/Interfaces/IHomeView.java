package Interfaces;

import java.util.List;

import javax.swing.JFrame;

import components.MenuBar;
import models.Movie;

public interface IHomeView {

	public void hienThiDanhSachPhim(List<Movie> dsPhim);

	public JFrame getFrame();

	public MenuBar getMenu();
}
