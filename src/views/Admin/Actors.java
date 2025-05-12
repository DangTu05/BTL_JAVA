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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Interfaces.IActorsView;
import utils.ConvertUtil;
import utils.UrlUtil;
import utils.ViewUtil;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JTable;

public class Actors extends JFrame implements IActorsView {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_2;
	private JButton btnReset;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnTao;
	private JTextField txtMaDienVien;
	private JTextField txtTenDienVien;
	private JTextField txtQuocGia;
	private JTextField txtAnh;
	private JSpinner dateNgaySinh;
	private JTable table;
	private JTextArea txtTieuSu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actors frame = new Actors();
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
	public Actors() {
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
		JLabel lblTitle = new JLabel("Quản Lý Diễn Viên");
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

		JLabel lblNewLabel = new JLabel("Mã Diễn Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(328, 75, 112, 19);
		contentPane.add(lblNewLabel);

		txtMaDienVien = new JTextField();
		txtMaDienVien.setBounds(328, 104, 112, 19);
		txtMaDienVien.setBorder(null);
		txtMaDienVien.setEditable(false);
		contentPane.add(txtMaDienVien);
		txtMaDienVien.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(328, 125, 112, 2);
		contentPane.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Tên Diễn Viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(604, 75, 112, 18);
		contentPane.add(lblNewLabel_1);

		txtTenDienVien = new JTextField();
		txtTenDienVien.setBounds(584, 104, 152, 19);
		txtTenDienVien.setBorder(null);
		contentPane.add(txtTenDienVien);
		txtTenDienVien.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(584, 125, 152, 2);
		contentPane.add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("Quốc Gia");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(328, 199, 105, 19);
		contentPane.add(lblNewLabel_2);

		txtQuocGia = new JTextField();
		txtQuocGia.setBounds(316, 228, 139, 19);
		txtQuocGia.setBorder(null);
		contentPane.add(txtQuocGia);
		txtQuocGia.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(316, 249, 139, 2);
		contentPane.add(separator_2);

		JLabel lblNewLabel_3 = new JLabel("Tiểu Sử");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(621, 202, 70, 13);
		contentPane.add(lblNewLabel_3);

		txtTieuSu = new JTextArea();
		txtTieuSu.setBounds(563, 225, 185, 93);
		txtTieuSu.setBorder(new LineBorder(Color.BLACK, 1));
		contentPane.add(txtTieuSu);

		JLabel lblNewLabel_4 = new JLabel("Ảnh");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(385, 363, 70, 25);
		contentPane.add(lblNewLabel_4);

		txtAnh = new JTextField();
		txtAnh.setBounds(282, 398, 281, 19);
		txtAnh.setBorder(null);
		contentPane.add(txtAnh);
		txtAnh.setColumns(10);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(282, 419, 281, 2);
		contentPane.add(separator_3);

		dateNgaySinh = new JSpinner(new SpinnerDateModel());
		dateNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateNgaySinh.setEditor(new JSpinner.DateEditor(dateNgaySinh, "dd/MM/yyyy"));
		dateNgaySinh.setBounds(666, 398, 105, 23);
		contentPane.add(dateNgaySinh);

		JLabel lblNewLabel_5 = new JLabel("Ngày Sinh");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(684, 365, 77, 21);
		contentPane.add(lblNewLabel_5);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Mã Diễn Viên", "Tên Diễn Viên", "Ngày Sinh", "Quốc Gia", "Tiểu Sử", "Ảnh" }) {
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

	}

	public void setActorSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}

	public void setResetListener(ActionListener listener) {
		btnReset.addActionListener(listener);
	}

	public void loadDataFromDataBase(List<String[]> list) {
		ViewUtil.loadDataFromDataBase(table, list);
	}

	public void setFormData(String actor_id, String actor_name, String birth, String nationality, String biography,
			String actor_image) {
		txtMaDienVien.setText(actor_id);
		txtTenDienVien.setText(actor_name);
		txtQuocGia.setText(nationality);
		txtAnh.setText(actor_image);
		txtTieuSu.setText(biography);
		dateNgaySinh.setValue(ConvertUtil.convertDateFromDB(birth));
	}

	public void reset() {
		txtMaDienVien.setText("");
		txtTenDienVien.setText("");
		txtTieuSu.setText("");
		txtQuocGia.setText("");
		txtAnh.setText("");
		dateNgaySinh.setValue(new Date());
	}

	public JTable getTable() {
		return table;
	}
}
