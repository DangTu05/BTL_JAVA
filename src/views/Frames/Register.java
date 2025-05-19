package views.Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interfaces.IRegisterView;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Register extends JFrame implements IRegisterView {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtMk;
	private JTextField txtName;
	public JLabel jLabel_DN;
	public JButton btnDK;
	private JSeparator separator_1;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(71, 53, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Đăng Kí");
		lblNewLabel.setBounds(200, 10, 95, 31);
		lblNewLabel.setForeground(new Color(51, 255, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(71, 92, 106, 19);
		contentPane.add(lblNewLabel_2);

		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(153, 102, 204));
		txtEmail.setBounds(179, 52, 210, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtName = new JTextField();
		txtName.setBorder(null);
		txtName.setBackground(new Color(153, 102, 204));
		txtName.setBounds(179, 94, 210, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Mật khẩu:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(71, 133, 95, 18);
		contentPane.add(lblNewLabel_3);

		txtMk = new JTextField();
		txtMk.setBorder(null);
		txtMk.setBackground(new Color(153, 102, 204));
		txtMk.setBounds(179, 135, 210, 19);
		contentPane.add(txtMk);
		txtMk.setColumns(10);

		btnDK = new JButton("Đăng Kí");
		btnDK.setForeground(new Color(255, 0, 0));
		btnDK.setBackground(new Color(0, 255, 0));
		btnDK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDK.setBounds(200, 196, 101, 21);
		contentPane.add(btnDK);

		jLabel_DN = new JLabel("<html><a href=\"\">Bạn đã có tài khoản?</a></html>");
		jLabel_DN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jLabel_DN.setBounds(179, 164, 142, 13);
		contentPane.add(jLabel_DN);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(179, 71, 210, 19);
		contentPane.add(separator);

		separator_1 = new JSeparator();
		separator_1.setBounds(179, 113, 210, 19);
		contentPane.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setBounds(179, 154, 210, 19);
		contentPane.add(separator_2);

	}

	public String getEmail() {
		return txtEmail.getText().trim();
	}

	public String getPassword() {
		return txtMk.getText().trim();
	}

	public String getUserName() {
		return txtName.getText().trim();
	}

	public void setRegisterListener(ActionListener listener) {
		btnDK.addActionListener(listener);
	}

	public void setRedirectLogin(MouseListener listener) {
		jLabel_DN.addMouseListener(listener);
	}

	public void redirectLogin() {
		new Login().setVisible(true);
		this.dispose();
	}
}
