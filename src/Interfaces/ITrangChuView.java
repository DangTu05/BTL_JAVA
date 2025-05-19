package Interfaces;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;

import models.Movie;

public interface ITrangChuView {
	public void setPhimListener(MouseListener listener);

	public void setLichChieuListener(MouseListener listener);

	public void setGioiThieuListener(MouseListener listener);

	public void setGiaVeListener(MouseListener listener);

	public void setDangKiListener(MouseListener listener);

	public void setDangNhapListener(MouseListener listener);

	public void hienThiDanhSachPhim(List<Movie> dsPhim);

	public JFrame getFrame();
}
