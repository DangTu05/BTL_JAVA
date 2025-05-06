package utils;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewUtil {
	public static void loadDataFromDataBase(JTable table,List<String[]> data) {
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
}
