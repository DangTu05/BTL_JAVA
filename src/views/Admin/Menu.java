package views.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.admin.MenuController;
import utils.UrlUtil;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		MenuController ac = new MenuController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(102, 51, 102));
		panel.setBounds(0, 0, 255, 571);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnAccount = new JButton("Tài Khoản");
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAccount.setBackground(new Color(204, 0, 153));
		btnAccount.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1747099952/user_3_x51vqi.png")));
		btnAccount.setBounds(0, 143, 255, 43);
		btnAccount.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnAccount);
		btnAccount.addActionListener(ac);
		JButton btnPhim = new JButton("Phim");
		btnPhim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPhim.setForeground(new Color(0, 0, 0));
		btnPhim.setBackground(new Color(153, 51, 153));
		btnPhim.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1747100090/video-player_yh4aaf.png")));
		btnPhim.setBounds(0, 184, 255, 43);
		btnPhim.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnPhim);
		btnPhim.addActionListener(ac);
		JButton btnLogout = new JButton("Đăng Xuất");
		btnLogout.setBackground(new Color(0, 250, 154));
		btnLogout.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1747099203/logout_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_eziu4r.png")));
		btnLogout.setBounds(0, 525, 255, 43);
		panel.add(btnLogout);
		btnLogout.addActionListener(ac);
		JButton btnHome = new JButton("Trang Chủ");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHome.setBackground(new Color(153, 51, 153));
		btnHome.setBounds(0, 101, 255, 43);
		btnHome.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1747100011/house_nyhu3s.png")));
		btnHome.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnHome);
		btnHome.addActionListener(ac);
		JLabel lblName = new JLabel("Đặng Quang Tú");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(64, 34, 135, 21);
		panel.add(lblName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 76, 255, 2);
		panel.add(separator);

	}
}
