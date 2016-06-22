package brokerserver;

import java.sql.*;

public class DataBase {
	Statement stmt = null;
	Connection conn = null;
	
	public DataBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/id26346745","fit5183a1","");
			stmt = conn.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConn() {
		try {
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
