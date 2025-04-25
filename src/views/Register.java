package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.RegisterController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtMk;
	private JTextField txtName;
	public JLabel jLabel_DN;
	public JButton btnDK;

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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		RegisterController ac = new RegisterController(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(71, 53, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Đăng Kí");
		lblNewLabel.setBounds(200, 10, 86, 31);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(71, 92, 106, 19);
		contentPane.add(lblNewLabel_2);

		txtEmail = new JTextField();
		txtEmail.setBounds(179, 52, 210, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(179, 94, 210, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Mật khẩu:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(71, 133, 95, 18);
		contentPane.add(lblNewLabel_3);

		txtMk = new JTextField();
		txtMk.setBounds(179, 135, 210, 19);
		contentPane.add(txtMk);
		txtMk.setColumns(10);

		btnDK = new JButton("Đăng Kí");
		btnDK.setForeground(new Color(255, 0, 0));
		btnDK.setBackground(new Color(0, 255, 0));
		btnDK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDK.setBounds(230, 190, 101, 21);
		btnDK.addMouseListener(ac);
		contentPane.add(btnDK);

		jLabel_DN = new JLabel("<html><a href=\"\">Bạn đã có tài khoản?</a></html>");
		jLabel_DN.addMouseListener(ac);
		jLabel_DN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jLabel_DN.setBounds(179, 164, 142, 13);
		contentPane.add(jLabel_DN);

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
}
