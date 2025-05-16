package views.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
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
import javax.swing.event.ListSelectionListener;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Interfaces.IAccountView;
import Interfaces.IHomeNavigableView;
import components.SideBarMenu;

//import com.mysql.cj.xdevapi.Table;

import controllers.admin.AccountsController;
import models.Account;
import utils.UrlUtil;
import utils.ViewUtil;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;

public class Accounts extends JPanel implements IAccountView, IHomeNavigableView {

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
	private JLabel lblBanGhi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame("Quản Lý Tài Khoản");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 949, 604);;
					frame.setLocationRelativeTo(null);
					Accounts panel = new Accounts(); // <- Tạo đối tượng JPanel
					frame.setContentPane(panel);     // <- Thêm vào JFrame
					frame.setVisible(true);          // <- Hiển thị giao diện
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

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 573);
//		contentPane = new JPanel();
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));

//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		setLayout(null);
		JLabel lblTitle = new JLabel("Quản Lý Tài Khoản");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setOpaque(true); // Cho phép hiện màu nền
		lblTitle.setBackground(new Color(218, 112, 214));
		lblTitle.setForeground(new Color(240, 255, 240));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 692, 25);
		add(lblTitle);

		JLabel lblNewLabel = new JLabel("Mã tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(105, 51, 112, 25);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(381, 51, 51, 25);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(105, 179, 134, 25);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Mật khẩu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(348, 179, 112, 25);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Vai trò");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(153, 277, 64, 25);
		add(lblNewLabel_4);

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
		scrollPane.setBounds(0, 424, 660, 90); // X, Y, Width, Height
		add(scrollPane);

		txtMa = new JTextField();
		txtMa.setBounds(76, 86, 187, 19);
		txtMa.setBorder(null);
		txtMa.setEditable(false);
		add(txtMa);
		txtMa.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(76, 106, 187, 2);
		add(separator);

		txtEmail = new JTextField();
		txtEmail.setBounds(309, 86, 187, 19);
		txtEmail.setBorder(null);
		add(txtEmail);
		txtEmail.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(309, 106, 187, 2);
		add(separator_1);

		txtName = new JTextField();
		txtName.setBounds(81, 214, 182, 19);
		txtName.setBorder(null);
		add(txtName);
		txtName.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(81, 237, 187, 2);
		add(separator_2);

		txtMK = new JTextField();
		txtMK.setBounds(309, 214, 187, 19);
		txtMK.setBorder(null);
		add(txtMK);
		txtMK.setColumns(10);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(309, 237, 187, 2);
		add(separator_3);

		btnRole = new JButton("");

		btnRole.setBackground(Color.GREEN);
		btnRole.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRole.setBounds(132, 314, 85, 21);
		add(btnRole);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 255));
		panel_1.setBounds(0, 521, 660, 42);
		add(panel_1);
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
		btnSearch.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1745899467/search_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_na27t8.png")));
		panel_1.add(btnSearch);

		lblBanGhi = new JLabel("Bản ghi ");
		lblBanGhi.setForeground(new Color(255, 0, 0));
		lblBanGhi.setFont(new Font("Arial", Font.BOLD, 13));
		lblBanGhi.setBounds(164, 14, 128, 16);
		panel_1.add(lblBanGhi);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(534, 127, 112, 171);
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
		btnLuu.setBounds(10, 77, 92, 25);
		panel_2.add(btnLuu);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnXoa.setIcon(new ImageIcon(UrlUtil.safeURL(
				"https://res.cloudinary.com/dry3sdlc1/image/upload/v1745691214/delete_16dp_1F1F1F_FILL0_wght400_GRAD0_opsz20_jedmju.png")));
		btnXoa.setBackground(new Color(204, 255, 255));
		btnXoa.setBounds(10, 127, 92, 21);
		panel_2.add(btnXoa);
		btnStatus = new JButton("");
		btnStatus.setBackground(new Color(102, 255, 51));
		btnStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnStatus.setBounds(309, 314, 151, 21);
		add(btnStatus);
//		add(contentPane); // Nếu vẫn muốn giữ contentPane

	}

	public void loadDataFromDataBase(List<String[]> data) {
		ViewUtil.loadDataFromDataBase(table, data);
	}

	public void loadDataFromForSearch(List<String[]> data) {
		// Gọi Controller để lấy dữ liệu
		// Tắt auto resize trước khi thêm dữ liệu
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0); // Xóa dữ liệu cũ
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

	public void setAccountSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public void setTextLblBanGhi(int countRow, int selectedRow) {
		lblBanGhi.setText("Bản ghi: " + selectedRow + " trên " + countRow);
	}

	public void setSaveListener(ActionListener listener) {
		btnLuu.addActionListener(listener);
	}

	public void setDeleteListener(ActionListener listener) {
		btnXoa.addActionListener(listener);
	}

	public void setRefreshListener(ActionListener listener) {
		btnReset.addActionListener(listener);
	}

	public void setStatusToggleListener(ActionListener listener) {
		btnStatus.addActionListener(listener);
	}

	public void setSearchListener(ActionListener listener) {
		btnSearch.addActionListener(listener);
	}


//	public JFrame getFrame() {
//		return this;
//	}
}
