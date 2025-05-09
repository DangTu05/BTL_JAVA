package views.Admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Interfaces.IMoviesView;
import utils.ConvertUtil;
import utils.UrlUtil;
import utils.ViewUtil;
import views.Login;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Movies extends JFrame implements IMoviesView {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_2;
	private JButton btnReset;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnTao;
	private JTable table;
	private JTextField txtMaPhim;
	private JTextField txtTenPhim;
	private JSpinner dateNgayPhatHanh;
	private JTextField txtTacGia;
	private JTextField txtAnh;
	private JTextArea txtMoTa;
	private JSpinner doTuoi;
	private JSpinner thoiLuong;
	private JComboBox<String> cmbTrangThai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies frame = new Movies();
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
	public Movies() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 605);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 255, 573);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(102, 51, 102));
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

		JLabel lblTitle = new JLabel("Quản Lý Phim");
		lblTitle.setBounds(255, 0, 680, 25);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setOpaque(true); // Cho phép hiện màu nền
		lblTitle.setBackground(new Color(218, 112, 214));
		lblTitle.setForeground(new Color(240, 255, 240));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle);
		panel_2 = new JPanel();
		panel_2.setBounds(813, 101, 112, 203);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(Color.GREEN, 2));
		contentPane.add(panel_2);
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

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "Mã phim", "Tên phim", "Ngày phát hành", "Tác giả", "Thời lượng(phút)", "Mô tả",
						"Độ tuổi", "Img", "Trạng thái" }) {
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
		scrollPane.setBounds(255, 468, 680, 90);
		contentPane.add(scrollPane);

		JLabel lblMaPhim = new JLabel("Mã Phim");
		lblMaPhim.setBounds(319, 50, 59, 19);
		lblMaPhim.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMaPhim.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMaPhim);

		txtMaPhim = new JTextField();
		txtMaPhim.setBounds(291, 83, 112, 19);
		txtMaPhim.setBorder(null);
		txtMaPhim.setEditable(false);
		contentPane.add(txtMaPhim);
		txtMaPhim.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tên Phim");
		lblNewLabel.setBounds(488, 52, 71, 15);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(291, 104, 112, 2);
		contentPane.add(separator);

		txtTenPhim = new JTextField();
		txtTenPhim.setBounds(452, 83, 160, 19);
		txtTenPhim.setBorder(null);
		contentPane.add(txtTenPhim);
		txtTenPhim.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(452, 104, 160, 19);
		contentPane.add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("Ngày Phát Hành");
		lblNewLabel_1.setBounds(669, 50, 112, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);

		dateNgayPhatHanh = new JSpinner(new SpinnerDateModel());
		dateNgayPhatHanh.setBounds(679, 76, 102, 26);
		dateNgayPhatHanh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateNgayPhatHanh.setEditor(new JSpinner.DateEditor(dateNgayPhatHanh, "dd/MM/yyyy"));
		contentPane.add(dateNgayPhatHanh);

		JLabel lblNewLabel_2 = new JLabel("Tác Giả");
		lblNewLabel_2.setBounds(319, 147, 59, 19);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);

		txtTacGia = new JTextField();
		txtTacGia.setBounds(291, 176, 112, 19);
		txtTacGia.setBorder(null);
		contentPane.add(txtTacGia);
		txtTacGia.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(291, 196, 112, 19);
		contentPane.add(separator_2);

		JLabel lblNewLabel_3 = new JLabel("Ảnh");
		lblNewLabel_3.setBounds(585, 145, 71, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3);

		txtAnh = new JTextField();
		txtAnh.setBounds(452, 176, 329, 19);
		txtAnh.setBorder(null);
		contentPane.add(txtAnh);
		txtAnh.setColumns(10);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(452, 196, 329, 19);
		contentPane.add(separator_3);

		JLabel lblNewLabel_4 = new JLabel("Mô Tả");
		lblNewLabel_4.setBounds(417, 259, 59, 19);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(291, 288, 321, 81);
		Border redBorder = BorderFactory.createLineBorder(Color.BLACK); // tạo viền đỏ
		txtMoTa.setBorder(redBorder);
		contentPane.add(txtMoTa);

		thoiLuong = new JSpinner();
		thoiLuong.setBounds(669, 284, 78, 25);
		contentPane.add(thoiLuong);

		JLabel lblNewLabel_5 = new JLabel("Thời Lượng");
		lblNewLabel_5.setBounds(671, 259, 76, 19);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Độ Tuổi");
		lblNewLabel_6.setBounds(669, 333, 69, 19);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_6);

		doTuoi = new JSpinner();
		doTuoi.setBounds(669, 362, 78, 25);
		contentPane.add(doTuoi);

		cmbTrangThai = new JComboBox<>();
		cmbTrangThai.addItem("Sắp chiếu");
		cmbTrangThai.addItem("Đang chiếu");
		cmbTrangThai.addItem("Đã ngưng");
		cmbTrangThai.setBounds(813, 332, 112, 25);
		contentPane.add(cmbTrangThai);

	}

	public void setAccountSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
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

	public void loadDataFromDataBase(List<String[]> list) {
		ViewUtil.loadDataFromDataBase(table, list);
		reset();
	}

	public void setFormData(String movie_id, String movie_name, String release_date, String director, int duration,
			String script, int age_permission, String poster, String status) {
		txtMaPhim.setText(movie_id);
		txtTenPhim.setText(movie_name);
		txtTacGia.setText(director);
		txtMoTa.setText(script);
		txtAnh.setText(poster);
		doTuoi.setValue(age_permission);
		thoiLuong.setValue(duration);
		dateNgayPhatHanh.setValue(ConvertUtil.convertDateFromDB(release_date));
		cmbTrangThai.setSelectedItem(status);

	}

	public void reset() {
		txtMaPhim.setText("");
		txtTenPhim.setText("");
		txtTacGia.setText("");
		txtMoTa.setText("");
		txtMoTa.setText("");
		txtAnh.setText("");
		dateNgayPhatHanh.setValue(new Date());
		doTuoi.setValue(1);
		thoiLuong.setValue(1);
		cmbTrangThai.setSelectedIndex(0);
	}

	public JTable getTable() {
		return table;
	}

	public String getMovie_Id() {
		return txtMaPhim.getText();
	}

	public String getMovie_Name() {
		return txtTenPhim.getText();
	}

	public String getPoster() {
		return txtAnh.getText();
	}

	public String getDirector() {
		return txtTacGia.getText();
	}

	public String getScript() {
		return txtMoTa.getText();
	}

	public String getStatus() {
		return (String) cmbTrangThai.getSelectedItem();
	}

	public java.sql.Date getNgayPhatHanh() {
		java.util.Date selectedDate = (java.util.Date) dateNgayPhatHanh.getValue();
		java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
		return sqlDate;
	}

	public int getThoiLuong() {
		return (int) thoiLuong.getValue();
	}

	public int getDoTuoi() {
		return (int) doTuoi.getValue();
	}
}
