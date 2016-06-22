package hotelServer;

import org.omg.CORBA.ORB;

import brokerserver.DataManage;

public class HotelWMServant extends corba.hotelbooking.HotelWMPOA {
	private ORB orb;
	
	public void setORB(ORB orb_val) {
		orb = orb_val;
	}
	public String queryHotel(String req) {
		String str ="SELECT idhotel, hotelname FROM hotel WHERE cityname = 'Melbourne';";
		DataManage dm = new DataManage(str);
		return dm.queryHotel();
	}

	public String queryRoomrate(String req) {
		String str = "SELECT * FROM windsor_m;";
		DataManage dm = new DataManage(str);
		return dm.queryRoomrate();
	}

	public String queryVacancy(String req) {
		DataManage dm = null;
		String[] strs = req.split(":");

		if(strs[1].equalsIgnoreCase("A")) {
			String str = "SELECT checkin, checkout FROM windsor_mb WHERE roomtype = 'single' and roomno ='" + strs[2] + "';";
			dm = new DataManage(str);
			return dm.queryVacancy();
		} else if(strs[1].equalsIgnoreCase("B")) {
			String str = "SELECT checkin, checkout FROM windsor_mb WHERE roomtype = 'double' and roomno ='" + strs[2] + "';";
			dm = new DataManage(str);
			return dm.queryVacancy();
		} else if(strs[1].equalsIgnoreCase("C")) {
			String str = "SELECT checkin, checkout FROM windsor_mb WHERE roomtype = 'standard' and roomno ='" + strs[2] + "';";
			dm = new DataManage(str);
			return dm.queryVacancy();
		}

		return null;
	}

	public String queryRoomId(String req) {
		DataManage dm = null;
		String[] strs = req.split(":");

		if(strs[1].equalsIgnoreCase("A")) {
			String str = "SELECT roomno FROM windsor_m WHERE roomtype = 'single';";
			dm = new DataManage(str);
			return dm.queryRoomId();
		} else if(strs[1].equalsIgnoreCase("B")) {
			String str = "SELECT roomno FROM windsor_m WHERE roomtype = 'double';";
			dm = new DataManage(str);
			return dm.queryRoomId();
		} else if(strs[1].equalsIgnoreCase("C")) {
			String str = "SELECT roomno FROM windsor_m WHERE roomtype = 'standard';";
			dm = new DataManage(str);
			return dm.queryRoomId();
		}
		
		return null;
	}

	public String booking(String req) {
		String[] strs = req.split(":");
		String sqlString = null;
		
		if(strs[1].equalsIgnoreCase("A")) {
			sqlString="insert into windsor_mb"+ "(roomtype,roomno,name,phone,credit,checkin,checkout) values('single','"+ strs[2] +"','" + strs[3]+"','"+strs[4]+"','"+strs[5]+"','"+strs[6]+"','"+strs[7]+"')";
		}else if(strs[1].equalsIgnoreCase("B")) {
			sqlString="insert into windsor_mb"+ "(roomtype,roomno,name,phone,credit,checkin,checkout) values('double','"+ strs[2] +"','" + strs[3]+"','"+strs[4]+"','"+strs[5]+"','"+strs[6]+"','"+strs[7]+"')";
		}else if(strs[1].equalsIgnoreCase("C")) {
			sqlString="insert into windsor_mb"+ "(roomtype,roomno,name,phone,credit,checkin,checkout) values('standard','"+ strs[2] +"','" + strs[3]+"','"+strs[4]+"','"+strs[5]+"','"+strs[6]+"','"+strs[7]+"')";
		}
		
		DataManage dm = new DataManage(sqlString);
		int i = dm.bookroom();
		if(i != 0) {
			return "you have book the room successfully";
		}else {
			return "fail";
		}
	}

	public String queryBook(String req) {
		String[] strs = req.split(":");
		String sqlString = "SELECT checkin,checkout FROM windsor_mb WHERE roomno ='" + strs[2] + "';";
		DataManage dm = new DataManage(sqlString);
		return dm.queryBook();
	}
}
