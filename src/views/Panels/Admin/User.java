package views.Panels.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Interfaces.IUserView;
import utils.UrlUtil;
import utils.ViewUtil;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JSeparator;

public class User extends JPanel implements IUserView {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> cmbGioiTinh;
	private JTextField txtDiaChi;
	private JTextField txtAnh;
	private JTextField txtTenKH;
	private JTextField txtMaKH;
	private JPanel panel_2;
	private JTable table;
	private JButton btnReset;
	private JButton btnLuu;
	private JTextField textField_4;
	private JButton btnSearch;
	private JSpinner spnDiem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame("Quản Lý Khách Hàng");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 949, 604);
					frame.setLocationRelativeTo(null);
					User customerPanel = new User();
					frame.setContentPane(customerPanel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public User() {
		setBackground(new Color(255, 255, 255));
		addControl();
	}

	public void addControl() {
		setBounds(100, 100, 693, 560);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 93, 116, 19);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Danh Sách Khách Hàng");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(191, 21, 293, 32);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên khách hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(304, 93, 116, 18);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(441, 315, 64, 19);
		add(lblNewLabel_3);

		cmbGioiTinh = new JComboBox<String>();
		cmbGioiTinh.setBounds(402, 344, 130, 21);
		cmbGioiTinh.addItem("Nam");
		cmbGioiTinh.addItem("Nữ");
		add(cmbGioiTinh);

		JLabel lblNewLabel_4 = new JLabel("Địa chỉ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(125, 215, 72, 19);
		add(lblNewLabel_4);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(29, 260, 273, 19);
		txtDiaChi.setBorder(null);
		add(txtDiaChi);
		txtDiaChi.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Ảnh");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(165, 315, 64, 19);
		add(lblNewLabel_5);

		txtAnh = new JTextField();
		txtAnh.setBounds(29, 345, 318, 19);
		txtAnh.setBorder(null);
		add(txtAnh);
		txtAnh.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Điểm");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(385, 215, 64, 18);
		add(lblNewLabel_6);

		spnDiem = new JSpinner();
		// Model cho float: giá trị ban đầu = 0.0, min = 0.0, max = 10.0, bước nhảy =
		// 0.1
		SpinnerNumberModel model = new SpinnerNumberModel(0.0, 0.0, 10.0, 0.1);
		spnDiem = new JSpinner(model);
		spnDiem.setBounds(339, 260, 145, 20);

		// Format hiển thị: 1 chữ số sau dấu phẩy
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spnDiem, "0.0");
		spnDiem.setEditor(editor);
		add(spnDiem);
		txtTenKH = new JTextField();
		txtTenKH.setBounds(255, 134, 206, 19);
		txtTenKH.setBorder(null);
		add(txtTenKH);
		txtTenKH.setColumns(10);

		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 10));

		txtMaKH.setBackground(new Color(255, 255, 255));
		txtMaKH.setBounds(23, 134, 136, 19);
		txtMaKH.setBorder(null);
		add(txtMaKH);
		txtMaKH.setColumns(10);
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(542, 185, 112, 120);
		panel_2.setBorder(new LineBorder(Color.GREEN, 2));
		add(panel_2);
		panel_2.setLayout(null);

		btnReset = new JButton("Làm mới");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnReset.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1745691099/description_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_yyrxmb.png")));
		btnReset.setBackground(new Color(204, 255, 255));
		btnReset.setBounds(10, 24, 92, 25);
		panel_2.add(btnReset);

		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnLuu.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1745690459/download_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_otwyyc.png")));
		btnLuu.setBackground(new Color(204, 255, 255));
		btnLuu.setBounds(10, 71, 92, 25);
		panel_2.add(btnLuu);

		// Tạo JTable với model

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Mã khách hàng", "Tên khách hàng", "Giới tính", "Địa chỉ", "Điểm", "Ảnh" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // khóa toàn bộ bảng, không ô nào cho sửa
			}
		});
		// Thiết lập kích thước cột
		table.getColumnModel().getColumn(0).setPreferredWidth(83);
		// Tạo JScrollPane và THIẾT LẬP BOUNDS
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 418, 692, 90); // X, Y, Width, Height
		add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBounds(0, 509, 692, 51);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Tìm nhân viên theo mã:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(317, 15, 141, 19);
		panel.add(lblNewLabel_7);

		textField_4 = new JTextField();
		textField_4.setBounds(471, 16, 165, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);

		btnSearch = new JButton("");
		btnSearch.setBounds(635, 15, 32, 21);
		btnSearch.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1745899467/search_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_na27t8.png")));
		panel.add(btnSearch);

		JSeparator separator = new JSeparator();
		separator.setBounds(23, 154, 136, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(255, 154, 206, 2);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(29, 279, 273, 2);
		add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(29, 366, 318, 2);
		add(separator_3);
	}

	public void setLuuListener(ActionListener listener) {
		btnLuu.addActionListener(listener);
	}

	public void setLamMoiListener(ActionListener listener) {
		btnReset.addActionListener(listener);
	}

	public void setUserSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public String getMaKH() {
		return txtMaKH.getText().trim();
	}

	public String getTenKhachHang() {
		return txtTenKH.getText().trim();
	}

	public String getDiaChi() {
		return txtDiaChi.getText().trim();
	}

	public String getAnh() {
		return txtAnh.getText().trim();
	}

	public String getGioiTinh() {
		return cmbGioiTinh.getSelectedItem().toString();
	}

	public float getDiemTichLuy() {
		Number value = (Number) spnDiem.getValue();
		return value.floatValue();
	}

	public void loadDataFromDataBase(List<String[]> data) {
		ViewUtil.loadData(table, data);
	}

	public JTable getTable() {
		return table;
	}

	public void setFormData(String user_id, String user_name, String gender, String address, String user_image,
			float reward_points) {
		txtMaKH.setText(user_id);
		txtTenKH.setText(user_name);
		txtDiaChi.setText(address);
		txtAnh.setText(user_image);
		spnDiem.setValue(reward_points);
		cmbGioiTinh.setSelectedItem(gender);
	}

	public void reset() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtAnh.setText("");
		spnDiem.setValue(1);
		cmbGioiTinh.setSelectedIndex(0);
	}

}
