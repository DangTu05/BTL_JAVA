package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

import Interfaces.IHomeNavigableView;
import utils.UrlUtil;

public class SideBarMenu extends JPanel implements IHomeNavigableView {
	private static final long serialVersionUID = 1L;

	public JButton btnAccount;
	public JButton btnPhim;
	public JButton btnLogout;
	public JButton btnHome;
	private JFrame frame;

	public SideBarMenu() {
		setBackground(new Color(102, 51, 102));
		setLayout(null);
		setBounds(0, 0, 255, 571);
		btnAccount = new JButton("Tài Khoản");
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAccount.setBackground(new Color(204, 0, 153));
		btnAccount.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1747099952/user_3_x51vqi.png")));
		btnAccount.setBounds(0, 143, 255, 43);
		btnAccount.setBorder(BorderFactory.createEmptyBorder());
		add(btnAccount);

		btnPhim = new JButton("Phim");
		btnPhim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhim.setBackground(new Color(153, 51, 153));
		btnPhim.setIcon(new ImageIcon(UrlUtil
				.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1747100090/video-player_yh4aaf.png")));
		btnPhim.setBounds(0, 184, 255, 43);
		btnPhim.setBorder(BorderFactory.createEmptyBorder());
		add(btnPhim);

		btnLogout = new JButton("Đăng Xuất");
		btnLogout.setBackground(new Color(0, 250, 154));
		btnLogout.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1747099203/logout_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_eziu4r.png")));
		btnLogout.setBounds(0, 525, 255, 43);
		add(btnLogout);

		btnHome = new JButton("Trang Chủ");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHome.setBackground(new Color(153, 51, 153));
		btnHome.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1747100011/house_nyhu3s.png")));
		btnHome.setBounds(0, 101, 255, 43);
		btnHome.setBorder(BorderFactory.createEmptyBorder());
		add(btnHome);

		JLabel lblName = new JLabel("Đặng Quang Tú");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setForeground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(64, 34, 135, 21);
		add(lblName);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 76, 255, 2);
		add(separator);
	}

	@Override
	public void setHomeListener(ActionListener listener) {
		btnHome.addActionListener(listener);
	}

	@Override
	public void setAccountListener(ActionListener listener) {
		btnAccount.addActionListener(listener);
	}

	@Override
	public void setLogoutListener(ActionListener listener) {
		btnLogout.addActionListener(listener);
	}

	@Override
	public void setMovieListener(ActionListener listener) {
		btnPhim.addActionListener(listener);
	}

	@Override
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
