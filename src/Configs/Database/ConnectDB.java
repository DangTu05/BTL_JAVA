package Configs.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectDB {
	// Load .env file và khai báo biến static theo đúng thứ tự
	private static final Dotenv dotenv = Dotenv.configure().load();
	private static final String DB_URL = dotenv.get("db.url");
	private static final String USER_NAME = dotenv.get("db.username");
	private static final String PASSWORD = dotenv.get("db.password");
	private static Connection con = null;
	private static ConnectDB instance = new ConnectDB(); // Singleton instance

	public void connect() throws SQLException, Exception {
		if (con == null || con.isClosed()) {
			try {
				con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				System.out.println("Connection established");
			} catch (Exception ex) {
				System.out.println("connect failure!");
				ex.printStackTrace();
			}

		}
	}

	// Get the existing connection or establish a new one if it's closed
	public static Connection getConnection() {
		if (con == null || !instance.isConnected()) {
			try {
				instance.connect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}

	// Check if the connection is still active
	private boolean isConnected() {
		try {
			return con != null && !con.isClosed();
		} catch (SQLException e) {
			return false;
		}
	}

	// Close the connection
	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
				con = null;
				System.out.println("Đã đóng kết nối cơ sở dữ liệu.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Đóng kết nối cơ sở dữ liệu thất bại!");
			}
		}
	}

}
