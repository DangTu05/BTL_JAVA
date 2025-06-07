package views.Panels.Admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Interfaces.IVoucherView;
import utils.ConvertUtil;
import utils.UrlUtil;
import utils.ViewUtil;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JSeparator;

public class Vouchers extends JPanel implements IVoucherView {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JPanel panel_2;
	private JButton btnReset;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnTao;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtMaKhuyenMai;
	private JTextField txtTenKhuyenMai;
	private JSpinner spnNgayBatDau;
	private JSpinner spnNgayKetThuc;
	private JSpinner spnGiamGia;
	private JTextField txtAnh;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JTextArea txtMoTa;

	/**
	 * Create the panel.
	 */
	public Vouchers() {
		setBackground(new Color(255, 255, 255));
		addControl();
	}

	public void addControl() {
		setBounds(100, 100, 693, 560);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh Sách Khuyến Mãi");
		lblNewLabel.setForeground(new Color(255, 0, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(245, 25, 224, 25);
		add(lblNewLabel);

		table = new JTable();
		table.setBounds(10, 442, 673, 64);
		// Tạo JTable với model
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "Mã khuyến mãi", "Tên khuyến mãi", "Giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả",
						"Ảnh" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // khóa toàn bộ bảng, không ô nào cho sửa
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(83);
		// Tạo JScrollPane và THIẾT LẬP BOUNDS
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 417, 673, 90);
		add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBounds(10, 508, 673, 42);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm mã khuyến mãi theo tên");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(246, 10, 210, 22);
		panel.add(lblNewLabel_1);
		panel_2 = new JPanel();
		panel_2.setBounds(552, 95, 112, 203);
		panel_2.setBackground(new Color(255, 255, 255));
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
		btnLuu.setBounds(10, 111, 92, 25);
		panel_2.add(btnLuu);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnXoa.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1745691214/delete_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_jedmju.png")));
		btnXoa.setBackground(new Color(204, 255, 255));
		btnXoa.setBounds(10, 158, 92, 25);
		panel_2.add(btnXoa);

		btnTao = new JButton("Tạo ");
		btnTao.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnTao.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1746550129/add_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_qhui7p.png")));
		btnTao.setBackground(new Color(204, 255, 255));
		btnTao.setBounds(10, 66, 92, 25);
		panel_2.add(btnTao);

		txtSearch = new JTextField();
		txtSearch.setBounds(449, 13, 183, 19);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		btnSearch = new JButton("");
		btnSearch.setBounds(635, 11, 32, 21);
		btnSearch.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1745899467/search_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_na27t8.png")));
		panel.add(btnSearch);

		lblNewLabel_2 = new JLabel("Mã khuyến mãi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(83, 95, 105, 25);
		add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Tên khuyến mãi");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(303, 99, 130, 16);
		add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Ngày bắt đầu");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(83, 217, 105, 25);
		add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Ngày kết thúc");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(315, 219, 104, 20);
		add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Giảm giá");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(90, 298, 70, 16);
		add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Ảnh");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(357, 294, 45, 25);
		add(lblNewLabel_7);

		txtMaKhuyenMai = new JTextField();
		txtMaKhuyenMai.setEditable(false);
		txtMaKhuyenMai.setBounds(69, 128, 130, 19);
		txtMaKhuyenMai.setBorder(null);
		add(txtMaKhuyenMai);
		txtMaKhuyenMai.setColumns(10);

		txtTenKhuyenMai = new JTextField();
		txtTenKhuyenMai.setBounds(275, 128, 181, 19);
		txtTenKhuyenMai.setBorder(null);
		add(txtTenKhuyenMai);
		txtTenKhuyenMai.setColumns(10);

		spnNgayBatDau = new JSpinner(new SpinnerDateModel());
		spnNgayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnNgayBatDau.setEditor(new JSpinner.DateEditor(spnNgayBatDau, "dd/MM/yyyy"));
		spnNgayBatDau.setBounds(69, 245, 130, 20);
		add(spnNgayBatDau);

		spnNgayKetThuc = new JSpinner(new SpinnerDateModel());
		spnNgayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnNgayKetThuc.setEditor(new JSpinner.DateEditor(spnNgayKetThuc, "dd/MM/yyyy"));
		spnNgayKetThuc.setBounds(303, 245, 130, 20);
		add(spnNgayKetThuc);

		SpinnerNumberModel model = new SpinnerNumberModel(0.0, 0.0, 100.0, 0.1);
		spnGiamGia = new JSpinner(model);
		spnGiamGia.setBounds(69, 325, 105, 20);
		JComponent editor = spnGiamGia.getEditor();
		JFormattedTextField txt = ((JSpinner.DefaultEditor) editor).getTextField();
		txt.setEditable(true);
		add(spnGiamGia);

		txtAnh = new JTextField();
		txtAnh.setBounds(245, 325, 271, 19);
		txtAnh.setBorder(null);
		add(txtAnh);
		txtAnh.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(69, 147, 130, 2);
		add(separator);

		separator_1 = new JSeparator();
		separator_1.setBounds(275, 147, 181, 2);
		add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setBounds(245, 344, 271, 2);
		add(separator_2);

		txtMoTa = new JTextArea();
		JScrollPane scrollPane1 = new JScrollPane(txtMoTa);
		scrollPane1.setBounds(526, 308, 157, 90);
		add(scrollPane1);
	}

	public void setResetListener(ActionListener listener) {
		btnReset.addActionListener(listener);
	}

	public void setTaoListener(ActionListener listener) {
		btnTao.addActionListener(listener);
	}

	public void setLuuListener(ActionListener listener) {
		btnLuu.addActionListener(listener);
	}

	public void setXoaListener(ActionListener listener) {
		btnXoa.addActionListener(listener);
	}

	public void setSearchListener(ActionListener listener) {
		btnSearch.addActionListener(listener);
	}

	public void setVoucherSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public String getAnh() {
		return txtAnh.getText().trim();
	}

	public String getMaKM() {
		return txtMaKhuyenMai.getText().trim();
	}

	public String getTenKM() {
		return txtTenKhuyenMai.getText().trim();
	}

	public String getSearch() {
		return txtSearch.getText().trim();
	}
//	public String getMoTa() {
//		return txt
//	}

	public float getGiamGia() {
		Number value = (Number) spnGiamGia.getValue();
		return value.floatValue();
	}

	public String getMoTa() {
		return txtMoTa.getText().trim();
	}

	public java.sql.Date getNgayBatDau() {
		java.util.Date selectedDate = (java.util.Date) spnNgayBatDau.getValue();
		java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
		return sqlDate;
	}

	public java.sql.Date getNgayKetThuc() {
		java.util.Date selectedDate = (java.util.Date) spnNgayKetThuc.getValue();
		java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
		return sqlDate;
	}

	public JTable getTable() {
		return table;
	}

	public void loadDataFromDataBase(List<String[]> list) {
		ViewUtil.loadData(table, list);
	}

	public void resetForm() {
		txtMaKhuyenMai.setText("");
		txtTenKhuyenMai.setText("");
		txtAnh.setText("");
		txtMoTa.setText("");
		spnGiamGia.setValue(1.0);
		spnNgayBatDau.setValue(new Date());
		spnNgayKetThuc.setValue(new Date());
	}

	public void setFormData(String voucher_id, String voucher_name, float voucher_discount, String voucher_start,
			String voucher_end, String voucher_script, String voucher_image) {
		txtMaKhuyenMai.setText(voucher_id);
		txtTenKhuyenMai.setText(voucher_name);
		spnGiamGia.setValue((double) voucher_discount);
		spnNgayBatDau.setValue(ConvertUtil.convertDateFromDB(voucher_start));
		spnNgayKetThuc.setValue(ConvertUtil.convertDateFromDB(voucher_end));
		txtAnh.setText(voucher_image);
		txtMoTa.setText(voucher_script);
	}

	public JPanel getPanel() {
		return this;
	}

}
