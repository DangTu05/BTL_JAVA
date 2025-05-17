package views.Frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interfaces.IForgotPassword;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class ForgotPassword extends JFrame implements IForgotPassword {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JButton btnNext;
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cardLayout = new CardLayout();
		contentPane = new JPanel(cardLayout);
		setContentPane(contentPane);
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(null); // Bạn có thể dùng null layout ở đây nếu cần
		emailPanel.setBackground(new Color(153, 102, 204));
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(153, 102, 204));
		txtEmail.setBounds(97, 58, 226, 20);
		emailPanel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(161, 23, 84, 25);
		emailPanel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(97, 78, 226, 2);
		emailPanel.add(separator);

		btnNext = new JButton("Tiếp");
		btnNext.setBackground(new Color(102, 255, 51));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNext.setBorder(null);
		btnNext.setBounds(160, 104, 85, 21);
		emailPanel.add(btnNext);
		contentPane.add(emailPanel, "emailPanel");
	}

	public void setNextListener(ActionListener listener) {
		btnNext.addActionListener(listener);
	}

	public String getEmail() {
		return txtEmail.getText().trim();
	}

	public JPanel getMainContentPanel() {
		return contentPane;
	}

	public JFrame getFrame() {
		return this;
	}
}
