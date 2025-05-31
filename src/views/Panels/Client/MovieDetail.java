package views.Panels.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import models.Actor;
import models.Movie;
import utils.UrlUtil;

public class MovieDetail extends JPanel {
	JButton btnThoat, btnDatVe;

	public MovieDetail(Movie p) {
		addControls(p);
	}

	public void addControls(Movie p) {
		this.setLayout(new BorderLayout());

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout(20, 20));
		pnMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding

		// ======= TOP: Poster và thông tin cơ bản =======
		JPanel pnTop = new JPanel(new BorderLayout(20, 0));

		// Poster phim
		ImageIcon img = new ImageIcon(UrlUtil.safeURL(p.getPoster()));
		Image scaledImage = img.getImage().getScaledInstance(250, 370, Image.SCALE_SMOOTH);
		JLabel lblAnhPhim = new JLabel(new ImageIcon(scaledImage));
		lblAnhPhim.setPreferredSize(new Dimension(250, 370));

		// Thông tin phim
		JPanel pnInfo = new JPanel();
		pnInfo.setLayout(new GridLayout(5, 1, 10, 10));
		pnInfo.setBorder(BorderFactory.createTitledBorder("Thông tin phim"));

		JLabel lblTenPhim = new JLabel("Tên phim: " + p.getMovie_name());
		lblTenPhim.setFont(new Font("Arial", Font.BOLD, 22));
		JLabel lblNgayPhatHanh = new JLabel("Khởi chiếu: " + p.getRelease_date());
		JLabel lblThoiLuong = new JLabel("Thời lượng: " + p.getDuration() + " phút");
		JLabel lblDaoDien = new JLabel("Đạo diễn: " + p.getDirector());
		JLabel lblDoTuoiChoPhep = new JLabel("Độ tuổi: " + p.getAge_permisson());

		Font infoFont = new Font("Arial", Font.PLAIN, 18);
		lblNgayPhatHanh.setFont(infoFont);
		lblThoiLuong.setFont(infoFont);
		lblDaoDien.setFont(infoFont);
		lblDoTuoiChoPhep.setFont(infoFont);

		pnInfo.add(lblTenPhim);
		pnInfo.add(lblNgayPhatHanh);
		pnInfo.add(lblThoiLuong);
		pnInfo.add(lblDaoDien);
		pnInfo.add(lblDoTuoiChoPhep);

		pnTop.add(lblAnhPhim, BorderLayout.WEST);
		pnTop.add(pnInfo, BorderLayout.CENTER);

		// ======= CENTER: Nội dung phim =======
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new GridLayout(2, 1, 10, 10));

		// Nội dung phim
		JTextArea txtNoiDung = new JTextArea(p.getScript());
		txtNoiDung.setFont(new Font("Arial", Font.PLAIN, 18));
		txtNoiDung.setLineWrap(true);
		txtNoiDung.setWrapStyleWord(true);
		txtNoiDung.setEditable(false);
		txtNoiDung.setOpaque(false);

		JScrollPane scrollNoiDung = new JScrollPane(txtNoiDung);
		scrollNoiDung.setBorder(BorderFactory.createTitledBorder("Nội dung phim"));
		scrollNoiDung.setPreferredSize(new Dimension(1150, 150));
		scrollNoiDung.setOpaque(false);
		scrollNoiDung.getViewport().setOpaque(false);
		scrollNoiDung.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Diễn viên
		String actors="";
		for (Actor actor : p.getActors()) {
			System.out.print(actor.getActor_name());
			 if (!actors.isEmpty()) {
			        actors += ", ";
			    }
			    actors += actor.getActor_name();  // giả sử Actor có phương thức getName()
		}
		JTextArea txtDienVien = new JTextArea("");
		txtDienVien.setText(actors);
		txtDienVien.setFont(new Font("Arial", Font.PLAIN, 18));
		txtDienVien.setLineWrap(true);
		txtDienVien.setWrapStyleWord(true);
		txtDienVien.setEditable(false);
		txtDienVien.setOpaque(false);

		JScrollPane scrollDienVien = new JScrollPane(txtDienVien);
		scrollDienVien.setBorder(BorderFactory.createTitledBorder("Diễn viên"));
		scrollDienVien.setOpaque(false);
		scrollDienVien.getViewport().setOpaque(false);
		scrollDienVien.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		pnCenter.add(scrollNoiDung);
		pnCenter.add(scrollDienVien);

		// ======= BOTTOM: Nút =======
		JPanel pnButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
		btnThoat = new JButton("Thoát");
		btnDatVe = new JButton("Đặt vé ngay");

		Font buttonFont = new Font("Arial", Font.BOLD, 16);
		btnThoat.setFont(buttonFont);
		btnDatVe.setFont(buttonFont);
		btnThoat.setBackground(new Color(108, 117, 125)); // Màu xám đẹp
		btnDatVe.setBackground(new Color(220, 53, 69)); // Màu đỏ nổi bật
		btnThoat.setForeground(Color.WHITE);
		btnDatVe.setForeground(Color.WHITE);
		btnThoat.setFocusPainted(false);
		btnDatVe.setFocusPainted(false);

		pnButton.add(btnThoat);
		pnButton.add(btnDatVe);

		// ======= Thêm vào giao diện chính =======
		pnMain.add(pnTop, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnButton, BorderLayout.SOUTH);

		JScrollPane scp = new JScrollPane(pnMain, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.add(scp, BorderLayout.CENTER);
	}
}
