package controllers.admin;

import javax.swing.JPanel;
import javax.swing.JTable;

import Interfaces.IUserView;
import models.User;
import services.UserService;
import utils.ConvertUtil;
import utils.ErrorUtil;
import utils.MessageConstants;
import utils.MessageUtil;

public class UserController extends BaseController<User> {
	private IUserView viewUser;
	private UserService userService;

	public UserController(IUserView userPanel) {
		this.viewUser = userPanel;
		userService = new UserService();
		loadDataFromDataBase();
		setupEventListeners();
	}

	private void loadDataFromDataBase() {
		try {
			viewUser.loadDataFromDataBase(userService.getAllUser());
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, "Đã xảy ra lỗi!!!");
		}
	}

	public void setupEventListeners() {
		viewUser.setUserSelectionListener(e -> addTableListener(viewUser.getTable()));
		viewUser.setLuuListener(e -> updateUser());
		viewUser.setLamMoiListener(e -> reset());
	}

	@Override
	protected void getSetData() {
		// TODO Auto-generated method stub
		int selectedRow = viewUser.getTable().getSelectedRow();
		if (selectedRow == -1)
			return;
		JTable table = viewUser.getTable();
		String user_id = String.valueOf(table.getValueAt(selectedRow, 0));
		String user_name = String.valueOf(table.getValueAt(selectedRow, 1));
		String gender = String.valueOf(table.getValueAt(selectedRow, 2));
		String address = String.valueOf(table.getValueAt(selectedRow, 3));
		float reward_points = ConvertUtil.parseFloatSafely(table.getValueAt(selectedRow, 4), 0f);
		String user_image = String.valueOf(table.getValueAt(selectedRow, 5));
		viewUser.setFormData(user_id, user_name, gender, address, user_image, reward_points);
	}

	@Override
	protected JPanel getJPanel() {
		return null;
	}

	public void updateUser() {
		try {
			User user = new User(viewUser.getMaKH(), viewUser.getTenKhachHang(), viewUser.getGioiTinh(),
					viewUser.getDiaChi(), viewUser.getAnh(), viewUser.getDiemTichLuy());
			if (!MessageUtil.confirm("Bạn có muốn cập nhật không?"))
				return;
			if (!userService.updateUser(user)) {
				MessageUtil.showError(MessageConstants.ERROR_UPDATE_FAILED);
				return;
			}
			MessageUtil.showInfo("Cập nhật thành công!");
			reset();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorUtil.handle(e, MessageConstants.ERROR_GENERIC);
		}
	}

	private void reset() {
		viewUser.reset();
		loadDataFromDataBase();
	}
}
