package views.Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class ChangePassword extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMK;
	private JTextField txtConfirmMK;
	private JButton btnThayDoi;

	/**
	 * Create the panel.
	 */
	public ChangePassword() {
		setBackground(new Color(153, 102, 204));
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Thay Đổi Mật Khẩu");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(106, 39, 212, 25);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(174, 85, 86, 19);
		add(lblNewLabel_1);

		txtMK = new JTextField();
		txtMK.setBorder(null);
		txtMK.setBackground(new Color(153, 102, 204));
		txtMK.setBounds(140, 108, 151, 19);
		add(txtMK);
		txtMK.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(140, 127, 151, 2);
		add(separator);

		JLabel lblNewLabel_2 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(155, 151, 117, 19);
		add(lblNewLabel_2);

		txtConfirmMK = new JTextField();
		txtConfirmMK.setBorder(null);
		txtConfirmMK.setBackground(new Color(153, 102, 204));
		txtConfirmMK.setBounds(140, 181, 151, 19);
		add(txtConfirmMK);
		txtConfirmMK.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(140, 200, 151, 2);
		add(separator_1);

		btnThayDoi = new JButton("Thay Đổi");
		btnThayDoi.setBackground(new Color(102, 255, 51));
		btnThayDoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThayDoi.setBorder(null);
		btnThayDoi.setBounds(175, 219, 85, 21);
		add(btnThayDoi);

	}

	public String getPassword() {
		return txtMK.getText().trim();
	}

	public String getCFPassword() {
		return txtConfirmMK.getText().trim();
	}
	public void setThayDoiListener(ActionListener listener) {
		btnThayDoi.addActionListener(listener);
	}
}
