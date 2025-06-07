package views.Frames.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Interfaces.ICreateVoucher;
import components.FileChooser;
import models.Voucher;
import utils.UrlUtil;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class CreateVoucher extends JFrame implements ICreateVoucher {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenKhuyenMai;
	private JSpinner spnNgayBatDau;
	private JSpinner spnNgayKetThuc;
	private JButton btnTao;
	private JTextArea txtMoTa;
	private JSpinner spnGiamGia;
	private JButton btnImg;
	private JLabel lblImg;
	private File img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateVoucher frame = new CreateVoucher();
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
	public CreateVoucher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thêm Khuyến Mãi");
		lblNewLabel.setForeground(new Color(255, 51, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(244, 33, 209, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên khuyến mãi");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(131, 90, 123, 25);
		contentPane.add(lblNewLabel_1);

		txtTenKhuyenMai = new JTextField();
		txtTenKhuyenMai.setBounds(92, 125, 196, 19);
		contentPane.add(txtTenKhuyenMai);
		txtTenKhuyenMai.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Giảm giá");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(474, 92, 90, 20);
		contentPane.add(lblNewLabel_2);
		SpinnerNumberModel model = new SpinnerNumberModel(0.0, 0.0, 10.0, 0.1);
		spnGiamGia = new JSpinner(model);
		spnGiamGia.setBounds(445, 125, 146, 20);
		JComponent editor = spnGiamGia.getEditor();
		JFormattedTextField txt = ((JSpinner.DefaultEditor) editor).getTextField();
		txt.setEditable(true);
		contentPane.add(spnGiamGia);

		JLabel lblNewLabel_3 = new JLabel("Ngày bắt đầu");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(131, 201, 110, 25);
		contentPane.add(lblNewLabel_3);

		spnNgayBatDau = new JSpinner(new SpinnerDateModel());
		spnNgayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnNgayBatDau.setEditor(new JSpinner.DateEditor(spnNgayBatDau, "dd/MM/yyyy"));
		spnNgayBatDau.setBounds(102, 236, 163, 20);
		contentPane.add(spnNgayBatDau);

		JLabel lblNewLabel_4 = new JLabel("Ngày kết thúc");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(466, 203, 110, 18);
		contentPane.add(lblNewLabel_4);

		spnNgayKetThuc = new JSpinner(new SpinnerDateModel());
		spnNgayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnNgayKetThuc.setEditor(new JSpinner.DateEditor(spnNgayKetThuc, "dd/MM/yyyy"));
		spnNgayKetThuc.setBounds(445, 239, 146, 20);
		contentPane.add(spnNgayKetThuc);

		JLabel lblNewLabel_5 = new JLabel("Mô tả");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(137, 282, 76, 19);
		contentPane.add(lblNewLabel_5);

		txtMoTa = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(txtMoTa);
		scrollPane.setBounds(92, 311, 173, 76); // ✅ setBounds cho scrollPane
		contentPane.add(scrollPane);

		btnTao = new JButton("Tạo");
		btnTao.setBackground(new Color(102, 255, 0));
		btnTao.setForeground(new Color(0, 0, 0));
		btnTao.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTao.setBounds(299, 428, 85, 25);
		contentPane.add(btnTao);

		btnImg = new JButton("Chọn ảnh");
		btnImg.setBounds(506, 295, 98, 21);
		btnImg.setIcon(new ImageIcon(UrlUtil
				.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1746028706/ocamciq8zozv3skikq43.png")));
		contentPane.add(btnImg);

		lblImg = new JLabel("");
		lblImg.setBounds(474, 326, 161, 127);
		contentPane.add(lblImg);
	}

	public void setTaoListener(ActionListener listener) {
		btnTao.addActionListener(listener);
	}

	public void setShowImgListener(ActionListener listener) {
		btnImg.addActionListener(listener);
	}

	public String getTenKhuyenMai() {
		return txtTenKhuyenMai.getText().trim();
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

	public float getGiamGia() {
		Number value = (Number) spnGiamGia.getValue();
		return value.floatValue();
	}

	public File getFileImg() {
		return img;
	}

	public void setFileImg(File fileImg) {
		this.img = fileImg;
	}

	/// show hộp để chọn file ảnh
	public void showImageChooser() {
		File selectedFile = null;
		JFileChooser fileChooser = new JFileChooser();
		setFileImg(FileChooser.showImageChooser(fileChooser, lblImg, selectedFile, this));
	}

}
