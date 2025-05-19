package views.Frames;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.TitledBorder;
import Interfaces.ITrangChuView;
import models.Movie;
import utils.ViewUtil;

public class TrangChu extends JFrame implements ITrangChuView {
	private JMenuBar menuBar;
	private JMenu mnuPhim, mnuLichChieu, mnuGioiThieu, mnuGiaVe, mnuDangKi, mnuDangNhap;
	private JButton btnPrev, btnNext;
	private JLabel lblImage;
	private String[] images = { "F:/Cinema_JavaSwing/images/carousel/0018450.jpg",
			"F:/Cinema_JavaSwing/images/carousel/minecraft-2048_1743651882260.jpg", };
	JPanel pnPhim;
	private JPanel pnLeftofCenter2;
	private int currentImageIndex = 0;
	private JPanel pnLeftofCenter;

	public TrangChu(String tieude) {
		super(tieude);
		addControls();
		showWindow();
		addEvents();
	}

	public void showWindow() {
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void addControls() {
		// Tạo menu bar
		menuBar = new JMenuBar();
		mnuPhim = new JMenu("Phim");
		mnuLichChieu = new JMenu("Lịch Chiếu");
		mnuGioiThieu = new JMenu("Giới Thiệu");
		mnuGiaVe = new JMenu("Giá Vé");
		mnuDangKi = new JMenu("Đăng Kí");
		mnuDangNhap = new JMenu("Đăng Nhập");

		menuBar.add(mnuPhim);
		menuBar.add(mnuLichChieu);
		menuBar.add(mnuGioiThieu);
		menuBar.add(mnuGiaVe);
		menuBar.add(mnuDangKi);
		menuBar.add(mnuDangNhap);
		setJMenuBar(menuBar);

		// Tạo các nút điều khiển
		btnPrev = new JButton("<");
		btnNext = new JButton(">");

		// Tạo hình ảnh ban đầu
		lblImage = new JLabel();
		updateImage();

		// Tạo panel chứa nút và ảnh
		JPanel pnTop = new JPanel();
		pnTop.setLayout(new FlowLayout());
		pnTop.add(btnPrev);
		pnTop.add(lblImage);
		pnTop.add(btnNext);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		// Bên trái của center chứa phim đang chiếu
		pnLeftofCenter = new JPanel();
		pnLeftofCenter.setLayout(new BorderLayout());
		TitledBorder borderLeft = new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Phim đang chiếu");
		pnLeftofCenter.setBorder(borderLeft); // Thêm viền cho phim đang chiếu
		pnLeftofCenter.setPreferredSize(new Dimension(900, 1000));

		// Bên phải của center chứa khuyến mãi
		JPanel pnRightofCenter = new JPanel();
		TitledBorder borderRight = new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Khuyến mãi");
		pnRightofCenter.setBorder(borderRight); // Thêm viền khuyến mãi
		pnRightofCenter.setPreferredSize(new Dimension(200, 1000));

		pnCenter.add(pnLeftofCenter);
		pnCenter.add(pnRightofCenter);

		//
		JPanel pnCenter2 = new JPanel();
		pnCenter2.setLayout(new FlowLayout());
		pnLeftofCenter2 = new JPanel();
		pnLeftofCenter2.setLayout(new BorderLayout());
		TitledBorder borderLeft2 = new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Phim sắp chiếu");
		pnLeftofCenter2.setBorder(borderLeft2); // Thêm viền cho phim sắp chiếu
		pnLeftofCenter2.setPreferredSize(new Dimension(900, 300));

		JPanel pnRightofCenter2 = new JPanel();
		TitledBorder borderRight2 = new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Magic Box");
		pnRightofCenter2.setBorder(borderRight2); // Thêm viền khuyến mãi
		pnRightofCenter2.setPreferredSize(new Dimension(200, 300));

		pnCenter2.add(pnLeftofCenter2);
		pnCenter2.add(pnRightofCenter2);

		// Main chứa tất pn con
		JPanel pnMain = new JPanel();

		pnMain.setLayout(new BorderLayout());
		pnMain.add(pnTop, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnCenter2, BorderLayout.SOUTH);

		JScrollPane scp = new JScrollPane(pnMain, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// Thêm panel vào frame
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add(scp, BorderLayout.CENTER);
	}

	public void addEvents() {
		// Điều hướng sang các form khác trong menu
		mnuLichChieu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//                frmLichChieu LichChieu = new frmLichChieu("Lịch chiếu");        
			}

			public void mouseEntered(MouseEvent e) {

			}
		});

		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPrevImage();
			}
		});

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNextImage();
			}
		});
	}

	public void updateImage() {
		ImageIcon icon = new ImageIcon(images[currentImageIndex]);
		lblImage.setIcon(icon);
		lblImage.setPreferredSize(new Dimension(1000, 600));
	}

	public void showPrevImage() {
		if (currentImageIndex > 0) {
			currentImageIndex--;
		} else {
			currentImageIndex = images.length - 1; // Chuyển tới ảnh cuối
		}
		updateImage();
	}

	public void showNextImage() {
		if (currentImageIndex < images.length - 1) {
			currentImageIndex++;
		} else {
			currentImageIndex = 0; // Chuyển tới ảnh đầu tiên
		}
		updateImage();
	}

	public void setPhimListener(MouseListener listener) {
		mnuPhim.addMouseListener(listener);
	}

	public void setLichChieuListener(MouseListener listener) {
		mnuLichChieu.addMouseListener(listener);
	}

	public void setGioiThieuListener(MouseListener listener) {
		mnuGioiThieu.addMouseListener(listener);
	}

	public void setGiaVeListener(MouseListener listener) {
		mnuGiaVe.addMouseListener(listener);
	}

	public void setDangKiListener(MouseListener listener) {
		mnuDangKi.addMouseListener(listener);
	}

	public void setDangNhapListener(MouseListener listener) {
		mnuDangNhap.addMouseListener(listener);
	}

	public void hienThiDanhSachPhim(List<Movie> dsPhim) {
		pnLeftofCenter.add(ViewUtil.hienThiDanhSachPhimDangChieu(dsPhim), BorderLayout.CENTER); // hiển thị danh sách
																								// phim đang chiếu
		pnLeftofCenter2.add(ViewUtil.hienThiDanhSachPhimSapChieu(dsPhim), BorderLayout.CENTER); // hiển thị danh sách
																								// phim sắp chiếu
	}

	public JFrame getFrame() {
		return this;
	}
}