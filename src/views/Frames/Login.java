package views.Frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interfaces.ILoginView;
import utils.UrlUtil;

import javax.swing.JLabel;
import java.awt.Font;
import java.net.MalformedURLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JSeparator;

public class Login extends JFrame implements ILoginView {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	public JButton btnDN;
	private JTextField txtPassword;
	private JLabel lblDK;
	private JLabel lblQuenMatKhau;
	private JButton btnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws MalformedURLException
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setForeground(new Color(102, 102, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(170, 10, 137, 38);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(new Color(102, 0, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(114, 63, 45, 17);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mật khẩu:");
		lblNewLabel_2.setForeground(new Color(102, 0, 204));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(114, 128, 68, 17);
		contentPane.add(lblNewLabel_2);

		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(153, 102, 204));
		txtEmail.setBounds(114, 90, 224, 28);
		txtEmail.setBorder(null); // Xóa border hoàn toàn
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		btnDN = new JButton("Đăng Nhập");
		btnDN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDN.setBackground(new Color(204, 204, 255));
		btnDN.setForeground(new Color(255, 255, 255));
		btnDN.setBounds(170, 219, 122, 21);
		contentPane.add(btnDN);

		lblDK = new JLabel("<html><a href=\"\" style=\"\">Bạn chưa có tài khoản?</a></html>");
		lblDK.setForeground(new Color(153, 51, 102));
		lblDK.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblDK.setBounds(118, 192, 147, 17);
		contentPane.add(lblDK);

		JSeparator separator = new JSeparator();
		separator.setBounds(114, 117, 224, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(114, 181, 224, 2);
		contentPane.add(separator_1);
		txtPassword = new JTextField();
		txtPassword.setBounds(114, 154, 224, 28);
		contentPane.add(txtPassword);
		txtPassword.setBackground(new Color(153, 102, 204));
		txtPassword.setBorder(null);

		lblQuenMatKhau = new JLabel("<html><a href=\"\">Quên mật khẩu?</a></html>");
		lblQuenMatKhau.setBounds(275, 195, 101, 13);
		contentPane.add(lblQuenMatKhau);

		btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(
				UrlUtil.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1747100011/house_nyhu3s.png")));
		btnHome.setBackground(new Color(153, 102, 204));
		btnHome.setBorder(null);
		btnHome.setBounds(0, 0, 33, 28);
		contentPane.add(btnHome);

	}

	public String getPassword() {
		return txtPassword.getText().trim();
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return txtEmail.getText().trim();
	}

	public JFrame getFrame() {
		return this;
	}

	public void showMenuPage() {

	}

	public void redirectRegister() {
		new Register().setVisible(true);
		this.dispose();
	}

	public void setLoginListener(ActionListener listener) {
		btnDN.addActionListener(listener);
	}

	public void setForgotPassWord(MouseListener listener) {
		lblQuenMatKhau.addMouseListener(listener);
	}

	public void setRedirectRegister(MouseListener listener) {
		lblDK.addMouseListener(listener);
	}
}
