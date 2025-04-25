package views.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.admin.AccountsController;
import models.Account;

public class Accounts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private AccountsController controller;

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

		JLabel lblTitle = new JLabel("Trang Chủ");
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

		JToggleButton tglbtnStatus = new JToggleButton("Đang hoạt động");
		tglbtnStatus.setSelected(true);
		tglbtnStatus.setBounds(577, 283, 128, 21);
//		((Object) tglbtnStatus).fillRoundRect(0, 0, 40, 20, 20, 20);
		contentPane.add(tglbtnStatus);

		// Tạo JTable với model

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Mã tài khoản", "Tên đăng nhập", "Email", "Mật khẩu", "Trạng thái", "Vai trò" }));

		// Thiết lập kích thước cột
		table.getColumnModel().getColumn(0).setPreferredWidth(83);

		// Tạo JScrollPane và THIẾT LẬP BOUNDS
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(265, 468, 660, 90); // X, Y, Width, Height
		contentPane.add(scrollPane);
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

}
