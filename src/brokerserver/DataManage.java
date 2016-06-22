package brokerserver;

import java.sql.*;

public class DataManage {
	DataBase db = new DataBase();
	String sqlString,str;
	ResultSet rs;
	StringBuilder sb = new StringBuilder();
	
	public DataManage(String str) {
		this.sqlString = str;
	}
	
	public String queryCity() {
		String city = null;
		try {
			rs = db.stmt.executeQuery(sqlString);
			while(rs.next()) {
				str = rs.getString(1) + "\t\t" + rs.getString(2);
				sb.append(str).append(":");
			}
			city = sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConn();
				if(rs != null) {
					rs.close();
					rs = null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return city;	
	}
	
	public String queryHotel() {
		String hotel = null;
		try {
			rs = db.stmt.executeQuery(sqlString);	
			while(rs.next()) {
				str = rs.getInt(1) + "\t\t" + rs.getString(2);
				sb.append(str).append(":");
			}	
			hotel = sb.toString();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConn();
				if(rs != null) {
					rs.close();
					rs = null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return hotel;	
	}
	
	public String queryRoomrate() {
		String roomrate = null;
		try {
			rs = db.stmt.executeQuery(sqlString);
			while(rs.next()) {
				str = rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3)+"\t\t" + rs.getString(4);
				sb.append(str).append(":");	
			}
			roomrate = sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConn();
				if(rs != null) {
					rs.close();
					rs = null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return roomrate;
	}
	
	public String queryRoomId() {
		String roomId = null;
		try {
			rs = db.stmt.executeQuery(sqlString);
			while(rs.next()) {
				str = rs.getString(1);
				sb.append(str).append("\t\t");
			}
			roomId = sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConn();
				if(rs != null) {
					rs.close();
					rs = null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return roomId;
	}
	
	public String queryBook() {
		String day = null;
		try {
			rs = db.stmt.executeQuery(sqlString);
			if(rs.next()) {
				str = "Check in day:" + rs.getString(1) + "\t\t Check out day:" + rs.getString(2);
				sb.append(str).append("\n");	
				while(rs.next()) {
					str = "Check in day:" + rs.getString(1) + "\t\t Check out day:" + rs.getString(2);
					sb.append(str).append("\n");	
					break;
				}
				day = sb.toString();
			} else {
				day = "you can book every room";
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConn();
				if(rs != null) {
					rs.close();
					rs = null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return day;
	}
	
	public String queryVacancy() {
		String day = null;
		try {
			rs = db.stmt.executeQuery(sqlString);
			if(rs.next()) {
				str = rs.getString(1) + "&" + rs.getString(2);
				sb.append(str).append(":");		
				while(rs.next()) {
					str = rs.getString(1) + "&" + rs.getString(2);
					sb.append(str).append(":");	
					break;
				}
				day = sb.toString();
				return day;
			} else {
				return "A";
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.closeConn();
				if(rs != null) {
					rs.close();
					rs = null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
		return null;	
	}

	public int bookroom() {
		int row = 0;
			try {
				row= db.stmt.executeUpdate(sqlString);
			} catch(SQLException e){
				e.printStackTrace();
			}
		return row;
	}	
}