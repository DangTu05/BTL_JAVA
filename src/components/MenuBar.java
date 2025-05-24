package components;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import utils.Session;

public class MenuBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnuPhim;
	private JMenu mnuLichChieu;
	private JMenu mnuGioiThieu;
	private JMenu mnuGiaVe;
	private JMenu mnuDangKi;
	private JMenu mnuDangNhap;
	private JMenu mnuUser;
	private JMenu mnuDiem;
	private JMenuItem mnuItemInfo;
	private JMenuItem mnuItemLogout;
	private boolean isMenuSetup = false;

	/**
	 * Create the panel.
	 */
	public MenuBar() {
		menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(0, 40)); // chiều cao 40px
		mnuPhim = new JMenu("Phim");
		mnuLichChieu = new JMenu("Lịch Chiếu");
		mnuGioiThieu = new JMenu("Giới Thiệu");
		mnuGiaVe = new JMenu("Giá Vé");
		mnuDiem = new JMenu("");
		setupStaticMenus();
		setupViewMenu();
		setDiemTichLuy();
	}

	public void setPhimListener(MouseListener listener) {
		mnuPhim.addMouseListener(listener);
	}

	public void setLichChieuListener(MouseListener listener) {
		mnuLichChieu.addMouseListener(listener);
	}

	public void setGioiThieuListener(MouseListener listener) {
		mnuGioiThieu.addMouseListener(listener);
	}

	public void setGiaVeListener(MouseListener listener) {
		mnuGiaVe.addMouseListener(listener);
	}

	public void setDangKiListener(MouseListener listener) {
		if (mnuDangKi != null)
			mnuDangKi.addMouseListener(listener);
	}

	public void setDangNhapListener(MouseListener listener) {
		if (mnuDangNhap != null)
			mnuDangNhap.addMouseListener(listener);
	}

	public void setInfoListener(ActionListener listener) {
		if (mnuItemInfo != null)
			mnuItemInfo.addActionListener(listener);
	}

	public void setLogoutListener(ActionListener listener) {
		if (mnuItemLogout != null)
			mnuItemLogout.addActionListener(listener);
	}

	public void setDiemTichLuy() {
		if (Session.isLogin()) {
			mnuDiem.setText("Điểm tích lũy: " + Session.getUser().getReward_points());
			menuBar.add(mnuDiem);
		}
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setupViewMenu() {
		if (isMenuSetup)
			return;
		if (!Session.isLogin()) {
			mnuDangKi = new JMenu("Đăng Kí");
			mnuDangNhap = new JMenu("Đăng Nhập");
			menuBar.add(mnuDangKi);
			menuBar.add(mnuDangNhap);
		} else {
			System.out.print(Session.getUser().getUser_name());
			if (mnuDangKi != null)
				menuBar.remove(mnuDangKi);
			if (mnuDangNhap != null)
				menuBar.remove(mnuDangNhap);
			// Tạo lại user menu
			mnuUser = new JMenu(Session.getUser().getUser_name());
			mnuItemInfo = new JMenuItem("Thông tin cá nhân");
			mnuItemLogout = new JMenuItem("Đăng xuất");

			mnuUser.add(mnuItemInfo);
			mnuUser.add(mnuItemLogout);
			menuBar.add(mnuUser);

		}
		isMenuSetup = true;
		menuBar.revalidate(); // Tính lại bố cục
		menuBar.repaint(); // Vẽ lại giao diện

	}

	private void setupStaticMenus() {
		menuBar.add(mnuPhim);
		menuBar.add(mnuLichChieu);
		menuBar.add(mnuGioiThieu);
		menuBar.add(mnuGiaVe);
	}

	public void resetMenu() {
		menuBar.removeAll(); // Xóa hết các menu
		setupStaticMenus();
		isMenuSetup = false; // Cho phép setup lại
		setupViewMenu(); // Gọi lại setup
	}

}
