package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection connect = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/bansach";
			String username = "root";
			String password = "";
			
			connect = DriverManager.getConnection(url, username, password);
			System.out.println("thanh cong");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("thatbai");
			e.printStackTrace();
		}
		
		return connect;
	}
  public static void closeConnection(Connection con) {
	 try {
		if(con!=null) {
			con.close();
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
	
}
