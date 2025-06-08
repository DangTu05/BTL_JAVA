package controllers.admin;

import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import Interfaces.IMenuView;
import controllers.AppController;
import dao.SettingDAO;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;
import views.Panels.Admin.Accounts;
import views.Panels.Admin.Actors;
import views.Panels.Admin.Dashboard;
import views.Panels.Admin.User;
import views.Panels.Admin.Vouchers;
import views.Panels.Admin.Movies;
import views.Panels.Admin.Setting;
import views.Panels.Admin.TicketBillDetail;

public class MenuController {
	private IMenuView view;
	private SettingDAO dao;
	private JPanel mainContentPanel;
	private CardLayout cardLayout;
	private Map<String, JPanel> panelMap = new HashMap<>();

	public MenuController(IMenuView viewMain) {
		this.view = viewMain;
		dao = new SettingDAO();
		setupSetting();
		setMainContent(view.getMainContentJpanel());
		initializePanelsAndControllers();
		setUpEventListeners();

	}

	protected void setMainContent(JPanel mainContentPanel) {
		this.mainContentPanel = mainContentPanel;
		this.cardLayout = (CardLayout) mainContentPanel.getLayout();
	}

	private void initializePanelsAndControllers() {
		// Accounts
		// Home panel luôn có sẵn
		Dashboard dashboardPanel = new Dashboard();
		new DashBoardController(dashboardPanel);
		panelMap.put("dashboard", dashboardPanel);
		mainContentPanel.add(dashboardPanel, "dashboard");

		// Show mặc định
		cardLayout.show(mainContentPanel, "dashboard");
	}

	protected void navigateTo(String panelName) {
		// Method này kiểm tra xem panel có tồn tại chưa.
		// Nếu chưa, tạo mới panel, controller, lưu map và thêm vào main panel.
		if (!panelMap.containsKey(panelName)) {
			switch (panelName) {
			case "accounts":
				Accounts accountsPanel = new Accounts();
				new AccountsController(accountsPanel);
				panelMap.put("accounts", accountsPanel);
				mainContentPanel.add(accountsPanel, "accounts");
				break;

			case "movies":
				Movies moviesPanel = new Movies();
				new MoviesController(moviesPanel);
				panelMap.put("movies", moviesPanel);
				mainContentPanel.add(moviesPanel, "movies");
				break;

			case "actors":
				Actors actorsPanel = new Actors();
				new ActorsController(actorsPanel);
				panelMap.put("actors", actorsPanel);
				mainContentPanel.add(actorsPanel, "actors");
				break;

			case "setting":
				Setting settingPanel = new Setting();
				new SettingController(settingPanel);
				panelMap.put("setting", settingPanel);
				mainContentPanel.add(settingPanel, "setting");
				break;
			case "users":
				User userPanel = new User();
				new UserController(userPanel);
				panelMap.put("users", userPanel);
				mainContentPanel.add(userPanel, "users");
				break;
			case "vouchers":
				Vouchers vouchersPanel = new Vouchers();
				new VoucherController(vouchersPanel);
				panelMap.put("vouchers", vouchersPanel);
				mainContentPanel.add(vouchersPanel, "vouchers");
				break;
			case "ticketbilldetails":
				TicketBillDetail ticketBillDetailPanel = new TicketBillDetail();
				new TicketBillController(ticketBillDetailPanel);
				panelMap.put("ticketbilldetails", ticketBillDetailPanel);
				mainContentPanel.add(ticketBillDetailPanel, "ticketbilldetails");
				break;
			default:
				System.out.println("Panel not found: " + panelName);
				return;
			}
		}
		/// Hiển thị panel đã click
		cardLayout.show(mainContentPanel, panelName);
	}

	public void setUpEventListeners() {
		view.getSideBar().getBtnHome().addActionListener(e -> {
			view.getSideBar().setBackColor(view.getSideBar().getBtnHome());
			navigateTo("dashboard");
		});
		view.getSideBar().getBtnAccount().addActionListener(e -> {
			view.getSideBar().setBackColor(view.getSideBar().getBtnAccount());
			navigateTo("accounts");
		});
		view.getSideBar().getBtnPhim().addActionListener(e -> {
			view.getSideBar().setBackColor(view.getSideBar().getBtnPhim());
			navigateTo("movies");
		});
		view.getSideBar().getBtnDienVien().addActionListener(e -> {
			view.getSideBar().setBackColor(view.getSideBar().getBtnDienVien());
			navigateTo("actors");
		});
		view.getSideBar().setKhachHangListener(e -> {
			view.getSideBar().setBackColor(view.getSideBar().getBtnKhachHang());
			navigateTo("users");
		});
		view.getSideBar().setKhuyenMaiListener(e -> {
			view.getSideBar().setBackColor(view.getSideBar().getBtnKhuyenMai());
			navigateTo("vouchers");
		});
		view.getSideBar().setHoaDonListener(e -> {
			view.getSideBar().setBackColor(view.getSideBar().getBtnHoaDon());
			navigateTo("ticketbilldetails");
		});
		view.getSideBar().getBtnLogout().addActionListener(e -> logout());
		view.getSideBar().getBtnSetting().addActionListener(e -> navigateTo("setting"));
	}

	public void logout() {
		if (!MessageUtil.confirm(MessageConstants.CONFIRM_LOGOUT))
			return;
		AppController.startLogin(view.getFrame());
	}

	private void setupSetting() {
		try {
			models.Setting setting = dao.findByField("setting_id", "SETTING070");
			view.getSideBar().setWebsite_Name(setting.getWebsite_name());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}

	}
}
