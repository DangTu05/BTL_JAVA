package views.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import controllers.admin.CreateActorController;
import utils.UrlUtil;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CreateActor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtActorName;
	private JTextField txtQuocGia;
	private JTextArea txtTieuSu;
	private JSpinner dateNgaySinh;
	private File img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateActor frame = new CreateActor();
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
	public CreateActor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		CreateActorController action = new CreateActorController(this);
		JLabel lblNewLabel = new JLabel("Thêm Thông Tin Diễn Viên");
		lblNewLabel.setBounds(342, 10, 250, 24);
		lblNewLabel.setForeground(new Color(255, 0, 51));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(62, 56, 826, 476);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblActorName = new JLabel("Tên tác giả:");
		lblActorName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblActorName.setBounds(86, 55, 77, 16);
		panel.add(lblActorName);
		txtActorName = new JTextField();
		txtActorName.setBounds(165, 54, 185, 19);
		panel.add(txtActorName);
		txtActorName.setColumns(10);

		dateNgaySinh = new JSpinner(new SpinnerDateModel());
		dateNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateNgaySinh.setEditor(new JSpinner.DateEditor(dateNgaySinh, "dd/MM/yyyy"));
		dateNgaySinh.setBounds(590, 47, 99, 31);
		panel.add(dateNgaySinh);

		JLabel lblNewLabel_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(509, 55, 71, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Quốc gia:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(86, 126, 77, 16);
		panel.add(lblNewLabel_2);

		txtQuocGia = new JTextField();
		txtQuocGia.setBounds(165, 126, 185, 19);
		panel.add(txtQuocGia);
		txtQuocGia.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Tiểu sử:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(509, 126, 59, 19);
		panel.add(lblNewLabel_3);

		txtTieuSu = new JTextArea();
		txtTieuSu.setBounds(578, 99, 142, 77);
		panel.add(txtTieuSu);

		JButton btnImg = new JButton("Chọn ảnh");
		btnImg.setFont(new Font("Arial", Font.PLAIN, 14));
		btnImg.setIcon(new ImageIcon(UrlUtil
				.safeURL("https://res.cloudinary.com/dry3sdlc1/image/upload/v1746028706/ocamciq8zozv3skikq43.png")));
		btnImg.setBounds(165, 208, 142, 21);
		btnImg.addActionListener(action);
		panel.add(btnImg);

		JButton btnTao = new JButton("Tạo");
		btnTao.setFont(new Font("Arial", Font.PLAIN, 15));
		btnTao.setBounds(393, 346, 85, 21);
		btnTao.addActionListener(action);
		panel.add(btnTao);

//		JFileChooser fileChooser = new JFileChooser();
//		fileChooser.setBounds(27, 81, 576, 399);
//		 fileChooser.setAcceptAllFileFilterUsed(false);
//	        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
//	            public boolean accept(File f) {
//	                String name = f.getName().toLowerCase();
//	                return f.isDirectory() || 
//	                       name.endsWith(".jpg") || 
//	                       name.endsWith(".jpeg") || 
//	                       name.endsWith(".png") || 
//	                       name.endsWith(".gif");
//	            }
//
//	            public String getDescription() {
//	                return "Image Files (*.jpg, *.jpeg, *.png, *.gif)";
//	            }
//	        });
//		panel.add(fileChooser);
//		

	}

	public String getActorName() {
		return txtActorName.getText().trim();
	}

	public String getTieuSu() {
		return txtTieuSu.getText().trim();
	}

	public String getQuocGia() {
		return txtQuocGia.getText().trim();
	}

	public java.sql.Date getNgaySinh() {
		Date selectedDate = (Date) dateNgaySinh.getValue();

		// Chuyển thành java.sql.Date để dùng với JDBC
		java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
		return sqlDate;
	}

	public void setFileImg(File fileImg) {
		this.img = fileImg;
	}

	public File getFileImg() {
		return img;
	}

	public void showImageChooser() {
		File selectedFile = null;
		JFileChooser fileChooser = new JFileChooser();

		// Thiết lập bộ lọc chỉ hiển thị file ảnh
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
			@Override
			public boolean accept(File f) {
				String name = f.getName().toLowerCase();
				return f.isDirectory() || name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")
						|| name.endsWith(".gif");
			}

			@Override
			public String getDescription() {
				return "Image Files (*.jpg, *.jpeg, *.png, *.gif)";
			}
		});
		int result = fileChooser.showOpenDialog(this);/// Hiển thị hộp thoại lên giữa cửa sổ
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}
		setFileImg(selectedFile);
	}

}
