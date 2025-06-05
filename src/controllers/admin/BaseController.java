package controllers.admin;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public abstract class BaseController<T> {
	protected abstract void getSetData();
	protected abstract JPanel getJPanel();
	protected void addTableListener(JTable table) {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {/// Kiểm tra để tránh xử lý khi người dùng đang kéo chuột chọn, chỉ
					/// xử lý khi việc chọn đã hoàn tất
					int countRow = table.getRowCount();
					getSetData();
				}

			}
		});
	}
	/// Lấy ra cửa sổ chính bọc Panel đó
	protected JFrame getFrame() {
		return (JFrame) SwingUtilities.getWindowAncestor(getJPanel());
	}

}
