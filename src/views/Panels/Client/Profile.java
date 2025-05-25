package views.Panels.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import Interfaces.IProfileView;
import java.awt.Font;

public class Profile extends JPanel implements IProfileView {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private JTextField txtMaKH, txtEmail, txtTenKH, txtDiaChi, txtAnh;
	private JComboBox<String> cmbGioiTinh;
	private JButton btnLuu, btnLamMoi, btnThoat;

	public Profile(String title) {
		addControls();

	}

	private void addControls() {
		// Panel chính
		JPanel pnMain = new JPanel(new BorderLayout());

		// Panel thông tin khách hàng
		JPanel pnForm = new JPanel(new GridLayout(6, 2, 10, 10));
		pnForm.setBackground(new Color(204, 255, 51));
		pnForm.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Thông Tin Khách Hàng"));
		pnForm.setPreferredSize(new Dimension(500, 200));
		pnForm.setBorder(BorderFactory.createEmptyBorder(20, 40, 10, 40));

		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setEditable(false);
		txtTenKH = new JTextField();
		txtDiaChi = new JTextField();
		txtAnh = new JTextField();
		JLabel label = new JLabel("Mã Khách Hàng:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnForm.add(label);
		pnForm.add(txtMaKH);
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnForm.add(lblEmail);
		pnForm.add(txtEmail);
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnForm.add(lblTnKhchHng);
		pnForm.add(txtTenKH);
		JLabel label_4 = new JLabel("Địa Chỉ:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnForm.add(label_4);
		pnForm.add(txtDiaChi);
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbGioiTinh = new JComboBox<>();
		cmbGioiTinh.addItem("Nam");
		cmbGioiTinh.addItem("Nữ");
		pnForm.add(lblGioiTinh);
		pnForm.add(cmbGioiTinh);
		JLabel label_5 = new JLabel("Ảnh:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnForm.add(label_5);
		pnForm.add(txtAnh);

		// Panel nút
		JPanel pnButtons = new JPanel(new FlowLayout());
		pnButtons.setBackground(new Color(204, 255, 0));
		pnButtons.setPreferredSize(new Dimension(0, 56)); // 0 = chiều rộng tự động, 60 = chiều cao cố định
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThoat = new JButton("Đóng");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));

		pnButtons.add(btnLuu);
		pnButtons.add(btnLamMoi);
		pnButtons.add(btnThoat);

		// Thêm vào main
		pnMain.add(pnForm, BorderLayout.CENTER);
		pnMain.add(pnButtons, BorderLayout.SOUTH);

		this.setLayout(new BorderLayout());
		this.add(pnMain, BorderLayout.CENTER);
	}

	public void setLuuListener(ActionListener listener) {
		btnLuu.addActionListener(listener);
	}

	public void setLamMoiListener(ActionListener listener) {
		btnLamMoi.addActionListener(listener);
	}

	public void setThoatListener(ActionListener listener) {
		btnThoat.addActionListener(listener);
	}

	public String getUser_Id() {
		return txtMaKH.getText().trim();
	}

	public String getUser_Name() {
		return txtTenKH.getText().trim();
	}

	public String getAddress() {
		return txtDiaChi.getText().trim();
	}

	public String getEmail() {
		return txtEmail.getText().trim();
	}

	public String getUser_Image() {
		return txtAnh.getText().trim();
	}
	public String getGender() {
		return (String) cmbGioiTinh.getSelectedItem();
	}
	public JPanel getPanel() {
		return this;
	}
	public void setForm(String user_id, String user_name, String email, String address, String user_image) {
		txtMaKH.setText(user_id);
		txtEmail.setText(email);
		txtTenKH.setText(user_name);
		txtDiaChi.setText(address);
		txtAnh.setText(user_image);
	}
	public void resetForm() {
		txtTenKH.setText("");
		txtAnh.setText("");
		txtDiaChi.setText("");
	}

}
