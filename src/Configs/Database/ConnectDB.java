package Configs.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectDB {
    // Load .env file và khai báo biến static theo đúng thứ tự
    private static final Dotenv dotenv = Dotenv.configure().load();
    private static final String DB_URL = dotenv.get("db.url");
    private static final String USER_NAME = dotenv.get("db.username");
    private static final String PASSWORD = dotenv.get("db.password");
    private static Connection con = null;
    private static ConnectDB instance=new ConnectDB(); // Singleton instance

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
	public static Connection getConnection() throws Exception {
		if (con == null || !instance.isConnected()) {
			try {
				instance.connect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//	                System.out.println("Kết nối cơ sở dữ liệu thành công!");
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

//	public static void main(String args[]) {
//		try {
////	      // connnect to database 'hungnd-demo'
////	      Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
////	      // crate statement
////	      Statement stmt = conn.createStatement();
////	      // get data from table 'student'
////	      ResultSet rs = stmt.executeQuery("select * from account");
////	      // show data
////	      while (rs.next()) {
////	        System.out.println(rs.getInt(1) + "  " + rs.getString(2)
////	            + "  " + rs.getString(3));
////	      }
////	      // close connection
////	      conn.close();
//			ConnectDB db = new ConnectDB();
//			db.connect();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}

//	  /**
//	   * create connection
//	   * 
//	   * @author 
//	   * @param dbURL:    database's url
//	   * @param userName: username is used to login
//	   * @param password: password is used to login
//	   * @return connection
//	   */
//	  public static Connection getConnection(String dbURL, String userName, String password) {
//	    Connection conn = null;
//	    try {
//	      Class.forName("com.mysql.cj.jdbc.Driver");
//	      conn = DriverManager.getConnection(dbURL, userName, password);
//	      System.out.println("connect successfully!");
//	    } catch (Exception ex) {
//	      System.out.println("connect failure!");
//	      ex.printStackTrace();
//	    }
//	    return conn;
//	  }

}
