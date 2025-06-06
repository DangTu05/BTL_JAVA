package views.Panels.Client;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

import models.Movie;

public class Payment extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Payment() {
		addControl();
	}

	public void addControl() {
		JFrame frame = new JFrame("Đặt vé xem phim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(15, 0, 120));

		// === Tiêu đề Khuyến mãi ===
		JLabel lblPromo = new JLabel("Khuyến mãi");
		lblPromo.setFont(new Font("Arial", Font.BOLD, 28));
		lblPromo.setForeground(Color.WHITE);
		lblPromo.setBounds(20, 10, 300, 40);
		frame.add(lblPromo);

		// === Các ô khuyến mãi nhỏ hơn, sát nhau ===
		String[] discounts = { "<html><b>Giảm 50%</b><br>Dành tặng bạn mới</html>",
				"<html><b>Giảm 30%</b><br>Cuối tuần vui vẻ không nè!</html>",
				"<html><b>Giảm 15%</b><br>Tháng 6 rộn ràng, chào đón hè sang</html>",
				"<html><b>Giảm 10%</b><br>Suất chiếu đầu hàng tháng của bạn</html>" };

		int promoX = 20;
		for (String text : discounts) {
			JLabel promoLabel = new JLabel(text);
			promoLabel.setOpaque(true);
			promoLabel.setBackground(Color.WHITE);
			promoLabel.setForeground(Color.BLACK);
			promoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			promoLabel.setVerticalAlignment(SwingConstants.TOP);
			promoLabel.setHorizontalAlignment(SwingConstants.LEFT);
			promoLabel.setBounds(promoX, 60, 170, 60);
			frame.add(promoLabel);
			promoX += 175;
		}

		// === Tiêu đề Thanh toán ===
		JLabel lblPayment = new JLabel("Thanh toán");
		lblPayment.setFont(new Font("Arial", Font.BOLD, 24));
		lblPayment.setForeground(Color.WHITE);
		lblPayment.setBounds(20, 140, 300, 30);
		frame.add(lblPayment);

		// === Các lựa chọn thanh toán ===
		String[] methods = { "Ví ShopeePay", "Ví Momo", "Zalopay", "VNPAY" };
		ButtonGroup paymentGroup = new ButtonGroup();
		int y = 180;

		for (String method : methods) {
			JRadioButton btn = new JRadioButton("[ICON] " + method);
			btn.setBounds(20, y, 860, 50);
			btn.setBackground(Color.WHITE);
			btn.setFont(new Font("Arial", Font.PLAIN, 16));
			paymentGroup.add(btn);
			frame.add(btn);
			y += 60;
		}

		// === Phần thông tin phim bên phải ===
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBounds(950, 60, 380, 540);
		infoPanel.setBackground(Color.BLACK);

		JLabel movieTitle = new JLabel("A MINECRAFT MOVIE");
		movieTitle.setFont(new Font("Arial", Font.BOLD, 18));
		movieTitle.setForeground(Color.WHITE);
		movieTitle.setBounds(20, 10, 300, 25);
		infoPanel.add(movieTitle);

		String[] info = { "2D   Phụ đề   101 phút", "Rạp: BingeBox Cinema Hoàn Kiếm - Phòng 3",
				"Suất chiếu: 21:10 - Chủ nhật, 27-05-2025", "2 Ghế sweetbox             300.000đ", "Ghế: I7, I7" };

		int infoY = 40;
		for (String line : info) {
			JLabel lbl = new JLabel(line);
			lbl.setFont(new Font("Arial", Font.PLAIN, 14));
			lbl.setForeground(Color.WHITE);
			lbl.setBounds(20, infoY, 340, 25);
			infoPanel.add(lbl);
			infoY += 25;
		}

		JLabel totalLabel = new JLabel("Tổng tiền");
		totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
		totalLabel.setForeground(Color.YELLOW);
		totalLabel.setBounds(20, infoY + 10, 100, 30);
		infoPanel.add(totalLabel);

		JLabel priceLabel = new JLabel("270.000đ");
		priceLabel.setFont(new Font("Arial", Font.BOLD, 18));
		priceLabel.setForeground(Color.YELLOW);
		priceLabel.setBounds(120, infoY + 10, 150, 30);
		infoPanel.add(priceLabel);

		frame.add(infoPanel);

		// === Nút Quay lại & Hoàn tất ===
		JButton backBtn = new JButton("Quay lại");
		backBtn.setBounds(1030, 620, 100, 40);
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.YELLOW);
		backBtn.setFont(new Font("Arial", Font.BOLD, 14));
		frame.add(backBtn);

		JButton doneBtn = new JButton("Hoàn tất");
		doneBtn.setBounds(1150, 620, 120, 40);
		doneBtn.setBackground(new Color(0, 120, 255));
		doneBtn.setForeground(Color.WHITE);
		doneBtn.setFont(new Font("Arial", Font.BOLD, 14));
		frame.add(doneBtn);
		frame.setVisible(true);
	}
	public void setFormData() {
		
	}
}