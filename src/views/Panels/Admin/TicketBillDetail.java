package views.Panels.Admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Interfaces.ITicketBillDetail;
import utils.ViewUtil;

import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class TicketBillDetail extends JPanel implements ITicketBillDetail {

	private static final long serialVersionUID = 1L;
	private JTable tableTicket;
	private JTable tableTicketBill;
	private JButton btnTim;
	private JButton btnXuatExcel;
	private JSpinner spnNgayBatDau;
	private JSpinner spnNgayKetThuc;
	private JButton btnLamMoi;

	/**
	 * Create the panel.
	 */
	public TicketBillDetail() {
		addControl();
	}

	public void addControl() {
		setBounds(100, 100, 693, 560);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh Sách Hóa Đơn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(208, 28, 254, 25);
		add(lblNewLabel);

		tableTicket = new JTable();
		tableTicket.setBounds(10, 411, 673, 139);
		// Tạo JTable với model
		tableTicket.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableTicket.setForeground(new Color(0, 0, 0));
		tableTicket.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Mã vé", "Mã ghế", "Mã suất chiếu", "Giá vé", "Mã hóa đơn", "Mã chi tiết vé", }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // khóa toàn bộ bảng, không ô nào cho sửa
			}
		});
		tableTicket.getColumnModel().getColumn(0).setPreferredWidth(83);
		// Tạo JScrollPane và THIẾT LẬP BOUNDS
		JScrollPane scrollPane1 = new JScrollPane(tableTicket);
		scrollPane1.setBounds(10, 317, 673, 90);
		add(scrollPane1);

		tableTicketBill = new JTable();
		tableTicketBill.setBounds(10, 431, 673, 119);
		// Tạo JTable với model
		tableTicketBill.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tableTicketBill.setForeground(new Color(0, 0, 0));
		tableTicketBill.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null }, },
				new String[] { "Mã hóa đơn", "Số lượng vé", "Tổng tiền", "Mã khuyến mãi", "Mã khách hàng",
						"Phương thức thanh toán", "Thời gian giao dịch" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // khóa toàn bộ bảng, không ô nào cho sửa
			}
		});
		tableTicketBill.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableTicketBill.getColumnModel().getColumn(0).setPreferredWidth(83);
		tableTicketBill.getColumnModel().getColumn(6).setPreferredWidth(100);
		// Tạo JScrollPane và THIẾT LẬP BOUNDS
		JScrollPane scrollPane2 = new JScrollPane(tableTicketBill);
		scrollPane2.setBounds(10, 444, 673, 90);
		add(scrollPane2);

		JLabel lblNewLabel_1 = new JLabel("Bảng vé");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(315, 409, 61, 25);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Bảng hóa đơn");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(315, 537, 94, 23);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ngày bắt đầu");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(136, 92, 87, 25);
		add(lblNewLabel_3);

		spnNgayBatDau = new JSpinner(new SpinnerDateModel());
		spnNgayBatDau.setBounds(111, 135, 136, 20);
		spnNgayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnNgayBatDau.setEditor(new JSpinner.DateEditor(spnNgayBatDau, "dd/MM/yyyy"));
		add(spnNgayBatDau);

		JLabel lblNewLabel_4 = new JLabel("Ngày kết thúc");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(457, 95, 87, 18);
		add(lblNewLabel_4);

		spnNgayKetThuc = new JSpinner(new SpinnerDateModel());
		;
		spnNgayKetThuc.setBounds(432, 135, 136, 20);
		spnNgayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnNgayKetThuc.setEditor(new JSpinner.DateEditor(spnNgayKetThuc, "dd/MM/yyyy"));
		add(spnNgayKetThuc);

		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTim.setBounds(176, 242, 101, 21);
		add(btnTim);

		btnXuatExcel = new JButton("Xuất excel");
		btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXuatExcel.setBounds(420, 242, 101, 21);
		add(btnXuatExcel);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBounds(305, 243, 85, 21);
		add(btnLamMoi);
	}

	public void setTimListener(ActionListener listener) {
		btnTim.addActionListener(listener);
	}

	public void setXuatExcel(ActionListener listener) {
		btnXuatExcel.addActionListener(listener);
	}

	public void setLamMoiListener(ActionListener listener) {
		btnLamMoi.addActionListener(listener);
	}

	public void loadDataTicketBillFromDataBase(List<String[]> list) {
		ViewUtil.loadData(tableTicketBill, list);
	}
	public void  loadDataTicketFromDataBase(List<String[]> list) {
		ViewUtil.loadData(tableTicket, list);
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
}
