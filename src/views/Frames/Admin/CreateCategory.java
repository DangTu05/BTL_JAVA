package views.Frames.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interfaces.ICreateCategoryView;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class CreateCategory extends JFrame implements ICreateCategoryView {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenTheLoai;
	private JButton btnTao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCategory frame = new CreateCategory();
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
	public CreateCategory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Tạo Thể Loại Phim");
		lblTitle.setForeground(new Color(255, 0, 51));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(192, 42, 197, 37);
		contentPane.add(lblTitle);

		txtTenTheLoai = new JTextField();
		txtTenTheLoai.setBounds(198, 195, 215, 19);
		contentPane.add(txtTenTheLoai);
		txtTenTheLoai.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tên thể loại");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(252, 136, 105, 37);
		contentPane.add(lblNewLabel);

		btnTao = new JButton("Tạo");
		btnTao.setBackground(new Color(51, 255, 0));
		btnTao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTao.setBounds(264, 236, 85, 27);
		contentPane.add(btnTao);
	}

	public void setTaoListener(ActionListener listener) {
		btnTao.addActionListener(listener);
	}

	public String getCategoryName() {
		return txtTenTheLoai.getText().trim();
	}
}
