package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import utils.UrlUtil;

public class SideBarMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnAccount;
	private JButton btnPhim;
	private JButton btnLogout;
	private JButton btnHome;
	private JButton btnDienVien;
	private JButton btnSetting;
	private JLabel lblWebsiteName;
	private List<JButton> buttons = new ArrayList<>();
	private JButton btnKhachHang;
	private JButton btnHoaDon;
	private JButton btnKhuyenMai;

	public SideBarMenu() {
		setBackground(new Color(102, 51, 102));
		setLayout(null);
		setBounds(0, 0, 255, 571);
		setPreferredSize(new Dimension(255, 568)); // thêm dòng này
		btnAccount = new JButton("Tài Khoản");
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAccount.setBackground(new Color(153, 51, 153));
		btnAccount.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1747099952/user_3_x51vqi.png")));
		btnAccount.setBounds(0, 131, 255, 43);
		btnAccount.setBorder(BorderFactory.createEmptyBorder());
		add(btnAccount);

		btnPhim = new JButton("Phim");
		btnPhim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhim.setBackground(new Color(153, 51, 153));
		btnPhim.setIcon(new ImageIcon(UrlUtil
				.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1747100090/video-player_yh4aaf.png")));
		btnPhim.setBounds(0, 173, 255, 43);
		btnPhim.setBorder(BorderFactory.createEmptyBorder());
		add(btnPhim);

		btnLogout = new JButton("Đăng Xuất");
		btnLogout.setBackground(new Color(0, 250, 154));
		btnLogout.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1747099203/logout_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_eziu4r.png")));
		btnLogout.setBounds(0, 535, 255, 33);
		add(btnLogout);

		btnHome = new JButton("Trang Chủ");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHome.setBackground(new Color(204, 0, 153));
		btnHome.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1747100011/house_nyhu3s.png")));
		btnHome.setBounds(0, 88, 255, 43);
		btnHome.setBorder(BorderFactory.createEmptyBorder());
		add(btnHome);

		lblWebsiteName = new JLabel("Đặng Quang Tú");
		lblWebsiteName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWebsiteName.setForeground(Color.WHITE);
		lblWebsiteName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWebsiteName.setBounds(64, 34, 135, 21);
		add(lblWebsiteName);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 76, 255, 2);
		add(separator);

		btnDienVien = new JButton("Diễn Viên");
		btnDienVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDienVien.setBackground(new Color(153, 51, 153));
		btnDienVien.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1747323748/casting_sk1q35.png")));
		btnDienVien.setBounds(0, 215, 255, 43);
		btnDienVien.setBorder(BorderFactory.createEmptyBorder());
		add(btnDienVien);

		btnSetting = new JButton("");
		btnSetting.setBackground(new Color(102, 51, 102));
		btnSetting.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1747618718/settings_jionkl.png")));
		btnSetting.setBorder(null);
		btnSetting.setBounds(0, 0, 35, 33);
		add(btnSetting);
		btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhachHang.setBackground(new Color(153, 51, 153));
		btnKhachHang.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1749185775/group_y1jxnv.png")));
		btnKhachHang.setBounds(0, 257, 255, 43);
		btnKhachHang.setBorder(BorderFactory.createEmptyBorder());
		add(btnKhachHang);

		btnHoaDon = new JButton("Hóa Đơn");
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHoaDon.setBackground(new Color(153, 51, 153));
		btnHoaDon.setBounds(0, 299, 255, 43);
		btnHoaDon.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1749292152/bill_jrveyu.png")));
		btnHoaDon.setBorder(BorderFactory.createEmptyBorder());
		add(btnHoaDon);

		btnKhuyenMai = new JButton("Khuyến Mãi");
		btnKhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhuyenMai.setBounds(0, 341, 255, 43);
		btnKhuyenMai.setBackground(new Color(153, 51, 153));
		btnKhuyenMai.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1749293777/voucher_osucze.png")));
		btnKhuyenMai.setBorder(BorderFactory.createEmptyBorder());
		add(btnKhuyenMai);
		buttons.add(btnAccount);
		buttons.add(btnDienVien);
		buttons.add(btnPhim);
		buttons.add(btnHome);
		buttons.add(btnKhachHang);
		buttons.add(btnKhuyenMai);
		buttons.add(btnHoaDon);

	}

	public void setHomeListener(ActionListener listener) {
		btnHome.addActionListener(listener);
	}

	public void setAccountListener(ActionListener listener) {
		btnAccount.addActionListener(listener);
	}

	public void setLogoutListener(ActionListener listener) {
		btnLogout.addActionListener(listener);
	}

	public void setMovieListener(ActionListener listener) {
		btnPhim.addActionListener(listener);
	}

	public void setSettingListener(ActionListener listener) {
		btnSetting.addActionListener(listener);
	}

	public void setKhachHangListener(ActionListener listener) {
		btnKhachHang.addActionListener(listener);
	}

	public void setKhuyenMaiListener(ActionListener listener) {
		btnKhuyenMai.addActionListener(listener);
	}

	public void setHoaDonListener(ActionListener listener) {
		btnHoaDon.addActionListener(listener);
	}

	public void setWebsite_Name(String website_name) {
		lblWebsiteName.setText(website_name);
	}

	public JButton getBtnAccount() {
		return btnAccount;
	}

	public JButton getBtnDienVien() {
		return btnDienVien;
	}

	public JButton getBtnPhim() {
		return btnPhim;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JButton getBtnSetting() {
		return btnSetting;
	}

	public JButton getBtnKhachHang() {
		return btnKhachHang;
	}

	public JButton getBtnKhuyenMai() {
		return btnKhuyenMai;
	};

	public JButton getBtnHoaDon() {
		return btnHoaDon;
	}

	public void setBackColor(JButton buttonClicked) {
		for (JButton jButton : buttons) {
			if (jButton != null) {
				if (buttonClicked == jButton) {
					buttonClicked.setBackground(new Color(204, 0, 153));
				} else {
					jButton.setBackground(new Color(153, 51, 153));
				}
			}

		}
	}
}
