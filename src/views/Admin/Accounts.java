package views.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.List;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import controllers.admin.AccountsController;
import models.Account;
import utils.UrlUtil;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class Accounts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private AccountsController controller;
	private JTextField txtMa;
	private JTextField txtEmail;
	private JTextField txtName;
	private JTextField txtMK;
	private JTextField txtSearch;
	private JPanel panel_2;
	private JButton btnReset;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnRole;
	private JButton btnStatus;
	public JButton btnSearch;
	private AccountsController action;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accounts frame = new Accounts();
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
	public Accounts() {
		controller = new AccountsController();
		action = new AccountsController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 605);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(102, 51, 102));
		panel.setBounds(0, 0, 255, 573);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnAccount = new JButton("Tài Khoản");
		btnAccount.setBackground(new Color(204, 0, 153));
		btnAccount.setBounds(0, 143, 255, 43);
		btnAccount.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnAccount);

		JButton btnPhim = new JButton("Phim");
		btnPhim.setForeground(new Color(0, 0, 0));
		btnPhim.setBackground(new Color(153, 51, 153));
		btnPhim.setBounds(0, 184, 255, 43);
		btnPhim.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnPhim);

		JButton btnLogout = new JButton("Đăng Xuất");
		btnLogout.setBackground(new Color(0, 250, 154));
		btnLogout.setBounds(0, 525, 255, 43);
		panel.add(btnLogout);

		JButton btnHome = new JButton("Trang Chủ");
		btnHome.setBackground(new Color(153, 51, 153));
		btnHome.setBounds(0, 101, 255, 43);
		btnHome.setBorder(BorderFactory.createEmptyBorder());
		panel.add(btnHome);

		JLabel lblName = new JLabel("Đặng Quang Tú");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(59, 50, 135, 21);
		panel.add(lblName);

		JLabel lblTitle = new JLabel("Quản Lý Tài Khoản");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setOpaque(true); // Cho phép hiện màu nền
		lblTitle.setBackground(new Color(218, 112, 214));
		lblTitle.setForeground(new Color(240, 255, 240));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(255, 0, 680, 25);
		contentPane.add(lblTitle);

		JLabel lblNewLabel = new JLabel("Mã tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(282, 73, 112, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(593, 73, 51, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(282, 179, 134, 25);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Mật khẩu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(593, 179, 112, 25);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Vai trò");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(281, 278, 64, 25);
		contentPane.add(lblNewLabel_4);

		// Tạo JTable với model

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Mã tài khoản", "Tên đăng nhập", "Email", "Mật khẩu", "Trạng thái", "Vai trò" }) {
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
		scrollPane.setBounds(265, 423, 660, 90); // X, Y, Width, Height
		contentPane.add(scrollPane);

		txtMa = new JTextField();
		txtMa.setBounds(282, 110, 187, 19);
		txtMa.setBorder(null);
		txtMa.setEditable(false);
		contentPane.add(txtMa);
		txtMa.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(282, 135, 187, 2);
		contentPane.add(separator);

		txtEmail = new JTextField();
		txtEmail.setBounds(593, 110, 187, 19);
		txtEmail.setBorder(null);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(593, 139, 187, 2);
		contentPane.add(separator_1);

		txtName = new JTextField();
		txtName.setBounds(282, 229, 182, 19);
		txtName.setBorder(null);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(282, 252, 187, 2);
		contentPane.add(separator_2);

		txtMK = new JTextField();
		txtMK.setBounds(593, 229, 187, 19);
		txtMK.setBorder(null);
		contentPane.add(txtMK);
		txtMK.setColumns(10);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(593, 250, 187, 2);
		contentPane.add(separator_3);

		btnRole = new JButton("");
		btnRole.setBackground(Color.GREEN);
		btnRole.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRole.setBounds(282, 313, 85, 21);
		contentPane.add(btnRole);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 255));
		panel_1.setBounds(265, 516, 660, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Tìm theo tên người dùng:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(303, 10, 166, 22);
		panel_1.add(lblNewLabel_5);

		txtSearch = new JTextField();
		txtSearch.setBounds(467, 13, 153, 19);
		panel_1.add(txtSearch);
		txtSearch.setColumns(10);

		btnSearch = new JButton("");
		btnSearch.setBounds(630, 12, 20, 21);
		btnSearch.addActionListener(action);
		btnSearch.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1745899467/search_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_na27t8.png")));
		panel_1.add(btnSearch);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(813, 99, 112, 171);
		panel_2.setBorder(new LineBorder(Color.GREEN, 2));
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		btnReset = new JButton("Làm mới");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnReset.addActionListener(action);
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
		btnLuu.setBounds(10, 77, 92, 25);
		panel_2.add(btnLuu);
		btnLuu.addActionListener(action);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnXoa.addActionListener(action);
		btnXoa.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1745691214/delete_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_jedmju.png")));
		btnXoa.setBackground(new Color(204, 255, 255));
		btnXoa.setBounds(10, 127, 92, 21);
		panel_2.add(btnXoa);
		System.out.print(getTextSearch());
		btnStatus = new JButton("");
		btnStatus.setBackground(new Color(102, 255, 51));
		btnStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnStatus.setBounds(593, 314, 151, 21);
		contentPane.add(btnStatus);
		btnStatus.addActionListener(action);
		new AccountsController(this).addTableListener();
		loadDataFromDatabase();
	}

	public void loadDataFromDatabase() {
		// Gọi Controller để lấy dữ liệu
		// Tắt auto resize trước khi thêm dữ liệu
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0); // Xóa dữ liệu cũ

			List<String[]> data = controller.getAllAccount(); // Lấy dữ liệu
			for (String[] row : data) {
				model.addRow(row); // Thêm từng dòng
			}
		} finally {
			// Luôn bật lại auto resize dù có lỗi hay không
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}
	}

	public void loadDataFromForSearch() {
		// Gọi Controller để lấy dữ liệu
		// Tắt auto resize trước khi thêm dữ liệu
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0); // Xóa dữ liệu cũ

			List<String[]> data = action.getAccountsByName(); // Lấy dữ liệu
			for (String[] row : data) {
				model.addRow(row); // Thêm từng dòng
			}
		} finally {
			// Luôn bật lại auto resize dù có lỗi hay không
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}
	}

	public void reset() {
		txtEmail.setText("");
		txtMa.setText("");
		txtMK.setText("");
		txtName.setText("");
		btnRole.setText("");
		btnStatus.setText("");
		table.clearSelection();
	}

	public JTable getTable() {
		return table;
	}

	public String getMa() {
		return txtMa.getText().trim();
	}

	public String getEmail() {
		return txtEmail.getText().trim();
	}

	public void setStatus(String status) {
		this.btnStatus.setText(status);
	}

	public String getStatus() {
		return btnStatus.getText().trim();
	}

	public String getName() {
		return txtName.getText().trim();
	}

	public String getTextSearch() {
		return txtSearch.getText().trim();
	}

	public String getPassword() {
		return txtMK.getText().trim();
	}

	public void setFormData(String maTk, String tenTk, String email, String mk, String status, String role) {
		txtMa.setText(maTk);
		txtName.setText(tenTk);
		txtEmail.setText(email);
		btnStatus.setText(status);
		btnRole.setText(role);
	}
}
