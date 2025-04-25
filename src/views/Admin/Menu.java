package views.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(102, 51, 102));
		panel.setBounds(0, 0, 120, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAccount = new JButton("Tài Khoản");
		btnAccount.setBackground(new Color(153, 51, 153));
		btnAccount.setBounds(0, 110, 120, 21);
		btnAccount.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnAccount);
		
		JButton btnPhim = new JButton("Phim");
		btnPhim.setForeground(new Color(0, 0, 0));
		btnPhim.setBackground(new Color(153, 51, 153));
		btnPhim.setBounds(0, 130, 120, 21);
		btnPhim.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnPhim);
		
		JButton btnLogout = new JButton("Đăng Xuất");
		btnLogout.setBackground(new Color(0, 250, 154));
		btnLogout.setBounds(0, 242, 120, 21);
		panel.add(btnLogout);
		
		JButton btnHome = new JButton("Trang Chủ");
		btnHome.setBackground(new Color(153, 51, 153));
		btnHome.setBounds(0, 90, 120, 21);
		btnHome.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnHome);
		
		JLabel lblName = new JLabel("Đặng Quang Tú");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 57, 100, 13);
		panel.add(lblName);
		
		JLabel lblTitle = new JLabel("Trang Chủ");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setOpaque(true); // Cho phép hiện màu nền
		lblTitle.setBackground(new Color(218, 112, 214));
		lblTitle.setForeground(new Color(240, 255, 240));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(119, 0, 317, 25);
		contentPane.add(lblTitle);

	}
}
