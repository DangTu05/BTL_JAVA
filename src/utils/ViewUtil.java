package utils;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import models.Movie;

public class ViewUtil {
	private static JPanel pnPhim;
	private static JLabel lblPoster;

	public static void loadData(JTable table, List<String[]> data) {
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

	public static JPanel hienThiPhim(Movie p, MouseListener listener) {
		JPanel pnPhimItem = new JPanel();
		pnPhimItem.setLayout(new BoxLayout(pnPhimItem, BoxLayout.Y_AXIS));

		// Poster (placeholder trước khi load)
		JLabel lblPoster = new JLabel("Đang tải...");
		lblPoster.setPreferredSize(new Dimension(185, 256));
		lblPoster.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblPoster.setAlignmentX(Component.CENTER_ALIGNMENT);
		// Gắn thông tin phim tương ứng vào JLabel này
		lblPoster.putClientProperty("movie", p);
		pnPhimItem.add(lblPoster);
		if (listener != null)
			lblPoster.addMouseListener(listener);

		// Tên phim
		JLabel lblTenPhim = new JLabel(p.getMovie_name());
		lblTenPhim.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnPhimItem.add(lblTenPhim);
		// Thêm sự kiện khi ấn vô poster sẽ hiện frame chi tiết phim của phim đấy
//	    		lblPoster.addMouseListener(new MouseAdapter() {
//	                public void mouseClicked(MouseEvent e) {
//	                    new frmChiTietPhim(p);
//	                }
//	            
//	                public void mouseEntered(MouseEvent e) {
//	                    
//	                }
//	            });
		// Tải ảnh bất đồng bộ
		new Thread(() -> {
			try {
				ImageIcon icon = new ImageIcon(UrlUtil.safeURL(p.getPoster())); // Tải trong luồng phụ
				Image img = icon.getImage().getScaledInstance(185, 256, Image.SCALE_SMOOTH);
				ImageIcon resizedIcon = new ImageIcon(img);
				SwingUtilities.invokeLater(() -> {
					lblPoster.setText(""); // Xóa chữ "Đang tải..."
					lblPoster.setIcon(resizedIcon);
				});
			} catch (Exception e) {
				e.printStackTrace();
				SwingUtilities.invokeLater(() -> {
					lblPoster.setText("Lỗi ảnh");
				});
			}
		}).start();
		return pnPhimItem;
	}

	public static JPanel hienThiDanhSachPhimDangChieu(List<Movie> dsPhim, MouseListener listener) {
		pnPhim = new JPanel();
		pnPhim.setLayout(new GridLayout(0, 3, 10, 10));
		for (Movie movie : dsPhim) {
			if (movie.getStatus().equals("Đang chiếu"))
				pnPhim.add(hienThiPhim(movie, listener));
		}
		return pnPhim;
	}

	public static JPanel hienThiDanhSachPhimSapChieu(List<Movie> dsPhim, MouseListener listener) {
		pnPhim = new JPanel();
		pnPhim.setLayout(new GridLayout(0, 3, 10, 10));
		for (Movie movie : dsPhim) {
			if (movie.getStatus().equals("Sắp chiếu"))
				pnPhim.add(hienThiPhim(movie,listener));
		}
		return pnPhim;
	}
}
