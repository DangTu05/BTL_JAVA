package controllers.admin;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controllers.AppController;

public abstract class BaseController<T> {
	private AppController app;

	protected abstract void getSetData();

	protected abstract JPanel getJPanel();
//	protected abstract IHomeNavigableView getView();

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

	protected JFrame getFrame() {
		return (JFrame) SwingUtilities.getWindowAncestor(getJPanel());
	}

}
