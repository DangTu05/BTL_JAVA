package views.Panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class InputOTP extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtOTP;
	private JButton btnNext;

	/**
	 * Create the panel.
	 */
	public InputOTP() {
		setBackground(new Color(153, 102, 204));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("OTP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(197, 63, 69, 25);
		add(lblNewLabel);

		txtOTP = new JTextField();
		txtOTP.setBorder(null);
		txtOTP.setBackground(new Color(153, 102, 204));
		txtOTP.setBounds(151, 98, 163, 19);
		add(txtOTP);
		txtOTP.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(151, 118, 163, 2);
		add(separator);

		btnNext = new JButton("Tiếp");
		btnNext.setBackground(new Color(102, 255, 51));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNext.setBorder(null);
		btnNext.setBounds(192, 161, 85, 25);
		add(btnNext);
	}

	public String getOTP() {
		return txtOTP.getText().trim();
	}
	public void setNextListener(ActionListener listener) {
		btnNext.addActionListener(listener);
	}
}
