package views.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interfaces.ICreateMovieView;
import components.FileChooser;
import utils.UrlUtil;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class CreateMovie extends JFrame implements ICreateMovieView {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenPhim;
	private JTextField txtTacGia;
	private JButton btnImg;
	private File img;
	private JLabel lblImg;
	private JComboBox<String> cmbTrangThai;
	private JSpinner thoiLuong;
	private JSpinner doTuoi;
	private JSpinner dateNgayPhatHanh;
	private JTextArea txtMoTa;
	private JButton btnTao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateMovie frame = new CreateMovie();
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
	public CreateMovie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Thêm Phim");
		lblTitle.setForeground(new Color(255, 0, 51));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(385, 10, 209, 31);
		contentPane.add(lblTitle);

		JPanel panel = new JPanel();
		panel.setBounds(112, 72, 719, 486);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên phim:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(83, 62, 66, 18);
		panel.add(lblNewLabel);
		dateNgayPhatHanh = new JSpinner(new SpinnerDateModel());
		dateNgayPhatHanh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateNgayPhatHanh.setEditor(new JSpinner.DateEditor(dateNgayPhatHanh, "dd/MM/yyyy"));
		dateNgayPhatHanh.setBounds(489, 55, 102, 32);
		panel.add(dateNgayPhatHanh);

		JLabel lblNewLabel_1 = new JLabel("Ngày phát hành:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(384, 63, 94, 17);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tác giả:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(95, 139, 66, 18);
		panel.add(lblNewLabel_2);

		thoiLuong = new JSpinner(new SpinnerNumberModel(1, 1, 240, 1));
		thoiLuong.setBounds(488, 134, 75, 32);
		panel.add(thoiLuong);

		JLabel lblNewLabel_3 = new JLabel("Thời lượng(phút):");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(371, 142, 107, 18);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Mô tả:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(433, 296, 45, 20);
		panel.add(lblNewLabel_4);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(488, 279, 136, 71);
		panel.add(txtMoTa);

		JLabel lblNewLabel_5 = new JLabel("Độ tuổi:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(428, 224, 54, 13);
		panel.add(lblNewLabel_5);
		doTuoi = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		doTuoi.setBounds(489, 216, 75, 32);
		panel.add(doTuoi);

		txtTenPhim = new JTextField();
		txtTenPhim.setBounds(147, 63, 169, 19);
		panel.add(txtTenPhim);
		txtTenPhim.setColumns(10);

		txtTacGia = new JTextField();
		txtTacGia.setBounds(147, 140, 169, 19);
		panel.add(txtTacGia);
		txtTacGia.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Trạng thái:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(83, 224, 66, 13);
		panel.add(lblNewLabel_6);

		cmbTrangThai = new JComboBox<>();
		cmbTrangThai.addItem("Sắp chiếu");
		cmbTrangThai.addItem("Đang chiếu");
		cmbTrangThai.addItem("Đã ngưng");
		cmbTrangThai.setBounds(147, 221, 169, 21);
		panel.add(cmbTrangThai);

		lblImg = new JLabel("");
		lblImg.setBounds(106, 323, 181, 140);
		panel.add(lblImg);

		btnImg = new JButton("Chọn ảnh");
		btnImg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImg.setBounds(147, 269, 124, 25);
		btnImg.setIcon(new ImageIcon(UrlUtil
				.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1746028706/ocamciq8zozv3skikq43.png")));
		panel.add(btnImg);

		btnTao = new JButton("Tạo");
		btnTao.setBackground(new Color(153, 255, 51));
		btnTao.setForeground(new Color(255, 255, 255));
		btnTao.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTao.setBounds(320, 431, 102, 32);
		panel.add(btnTao);

	}

	public void setFileImg(File fileImg) {
		this.img = fileImg;
	}

	public void showImageChooser() {
		File selectedFile = null;
		JFileChooser fileChooser = new JFileChooser();
		setFileImg(FileChooser.showImageChooser(fileChooser, lblImg, selectedFile, this));
	}

	public String getMovieName() {
		return txtTenPhim.getText().trim();
	}

	public String getDirector() {
		return txtTacGia.getText().trim();
	}

	public String getStatus() {
		return (String) cmbTrangThai.getSelectedItem();
	}

	public String getMoTa() {
		return txtMoTa.getText().trim();
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

	public File getFileImg() {
		return img;
	}

	public void setShowImgListener(ActionListener listener) {
		btnImg.addActionListener(listener);
	}

	public void setTaoListener(ActionListener listener) {
		btnTao.addActionListener(listener);
	}

	public void reSetForm() {
		txtMoTa.setText("");
		txtTacGia.setText("");
		txtTenPhim.setText("");
		cmbTrangThai.setSelectedIndex(0);
		doTuoi.setValue(1);
		thoiLuong.setValue(0);
		lblImg.setIcon(null);
	}
}
