package views.Panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Interfaces.ISettingView;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Setting extends JPanel implements ISettingView {

	private static final long serialVersionUID = 1L;
	private JTextField txtTenWeb;
	private JTextField txtCEO;
	private JTextField txtEmail;
	private JTextField txtHotline;
	private JTextField txtLogo;
	private JTextField txtMap;
	private JTextField txtDiaChi;
	private JButton btnCapNhat;

	/**
	 * Create the panel.
	 */
	public Setting() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 693, 559);
		setLayout(null);
		JLabel lblTitle = new JLabel("SETTING");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setOpaque(true); // Cho phép hiện màu nền
		lblTitle.setBackground(new Color(218, 112, 214));
		lblTitle.setForeground(new Color(240, 255, 240));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 692, 25);
		add(lblTitle);
		JLabel lblTee = new JLabel("Tên website");
		lblTee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTee.setHorizontalAlignment(SwingConstants.CENTER);
		lblTee.setBounds(131, 100, 81, 20);
		add(lblTee);

		txtTenWeb = new JTextField();
		txtTenWeb.setBorder(null);
		txtTenWeb.setBounds(66, 130, 216, 19);
		add(txtTenWeb);
		txtTenWeb.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(66, 151, 216, 2);
		add(separator);

		JLabel lblNewLabel_1 = new JLabel("CEO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(487, 101, 54, 18);
		add(lblNewLabel_1);

		txtCEO = new JTextField();
		txtCEO.setBorder(null);
		txtCEO.setBounds(397, 130, 226, 19);
		add(txtCEO);
		txtCEO.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(397, 151, 226, 2);
		add(separator_1);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 205, 81, 20);
		add(lblNewLabel);

		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBounds(66, 235, 216, 19);
		add(txtEmail);
		txtEmail.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(66, 256, 216, 2);
		add(separator_2);

		JLabel lblNewLabel_2 = new JLabel("Hotline");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(471, 205, 81, 20);
		add(lblNewLabel_2);

		txtHotline = new JTextField();
		txtHotline.setBorder(null);
		txtHotline.setBounds(397, 235, 226, 19);
		add(txtHotline);
		txtHotline.setColumns(10);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(397, 256, 226, 2);
		add(separator_3);

		JLabel lblNewLabel_3 = new JLabel("Logo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(150, 306, 45, 20);
		add(lblNewLabel_3);

		txtLogo = new JTextField();
		txtLogo.setBorder(null);
		txtLogo.setBounds(66, 336, 216, 19);
		add(txtLogo);
		txtLogo.setColumns(10);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(66, 357, 216, 2);
		add(separator_4);

		JLabel lblNewLabel_4 = new JLabel("Map");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(481, 306, 45, 20);
		add(lblNewLabel_4);

		txtMap = new JTextField();
		txtMap.setBorder(null);
		txtMap.setBounds(397, 336, 226, 19);
		add(txtMap);
		txtMap.setColumns(10);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(397, 357, 226, 2);
		add(separator_5);

		JLabel lblNewLabel_5 = new JLabel("Địa chỉ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(293, 392, 98, 25);
		add(lblNewLabel_5);

		txtDiaChi = new JTextField();
		txtDiaChi.setBorder(null);
		txtDiaChi.setBounds(131, 427, 438, 19);
		add(txtDiaChi);
		txtDiaChi.setColumns(10);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(131, 448, 438, 2);
		add(separator_6);

		btnCapNhat = new JButton("Cập Nhật");

		btnCapNhat.setBackground(new Color(51, 255, 0));
		btnCapNhat.setForeground(new Color(0, 0, 0));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCapNhat.setBounds(306, 472, 98, 21);
		add(btnCapNhat);

	}

	public void setCapNhatListener(ActionListener listener) {
		btnCapNhat.addActionListener(listener);
	}

	public String getWebsite_Name() {
		return txtTenWeb.getText().trim();
	}

	public String getCEO() {
		return txtCEO.getText().trim();
	}

	public String getEmail() {
		return txtEmail.getText().trim();
	}

	public String getLogo() {
		return txtLogo.getText().trim();
	}

	public String getMap() {
		return txtMap.getText().trim();
	}

	public String getAddress() {
		return txtDiaChi.getText().trim();
	}

	public String getHotline() {
		return txtHotline.getText().trim();
	}

	public void setFormData(models.Setting setting) {
		txtTenWeb.setText(setting.getWebsite_name());
		txtCEO.setText(setting.getCeo());
		txtLogo.setText(setting.getLogo());
		txtMap.setText(setting.getMap());
		txtEmail.setText(setting.getEmail());
		txtHotline.setText(setting.getHotline());
		txtDiaChi.setText(setting.getAddress());
	}
}
