package hotelServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import brokerserver.DataManage;
import common.HotelAction;

public class HotelHMImpl extends UnicastRemoteObject implements HotelAction {

	protected HotelHMImpl() throws RemoteException {
		super();
	}

	public String queryHotel(String req) throws RemoteException {
		String str ="SELECT idhotel, hotelname FROM hotel WHERE cityname = 'Melbourne';";
		DataManage dm = new DataManage(str);
		return dm.queryHotel();	
	}

	public String queryRoomrate(String req) throws RemoteException {
		String str = "SELECT * FROM hilton_m;";
		DataManage dm = new DataManage(str);
		return dm.queryRoomrate();
	}

	public String queryVacancy(String req) throws RemoteException {
		DataManage dm = null;
		String[] strs = req.split(":");

		if(strs[1].equalsIgnoreCase("A")) {
			String str = "SELECT checkin, checkout FROM hilton_mb WHERE roomtype = 'single' and roomno ='" + strs[2] + "';";
			dm = new DataManage(str);
			return dm.queryVacancy();
		} else if(strs[1].equalsIgnoreCase("B")) {
			String str = "SELECT checkin, checkout FROM hilton_mb WHERE roomtype = 'double' and roomno ='" + strs[2] + "';";
			dm = new DataManage(str);
			return dm.queryVacancy();
		} else if(strs[1].equalsIgnoreCase("C")) {
			String str = "SELECT checkin, checkout FROM hilton_mb WHERE roomtype = 'standard' and roomno ='" + strs[2] + "';";
			dm = new DataManage(str);
			return dm.queryVacancy();
		}

		return null;
	}
	
	public String queryRoomId(String req) throws RemoteException {
		DataManage dm = null;
		String[] strs = req.split(":");

		if(strs[1].equalsIgnoreCase("A")) {
			String str = "SELECT roomno FROM hilton_m WHERE roomtype = 'single';";
			dm = new DataManage(str);
			return dm.queryRoomId();
		} else if(strs[1].equalsIgnoreCase("B")) {
			String str = "SELECT roomno FROM hilton_m WHERE roomtype = 'double';";
			dm = new DataManage(str);
			return dm.queryRoomId();
		} else if(strs[1].equalsIgnoreCase("C")) {
			String str = "SELECT roomno FROM hilton_m WHERE roomtype = 'standard';";
			dm = new DataManage(str);
			return dm.queryRoomId();
		}
		
		return null;
	}

	public String booking(String req) throws RemoteException {
		String[] strs = req.split(":");
		String sqlString = null;
		
		if(strs[1].equalsIgnoreCase("A")) {
			sqlString="insert into hilton_mb"+ "(roomtype,roomno,name,phone,credit,checkin,checkout) values('single','"+ strs[2] +"','" + strs[3]+"','"+strs[4]+"','"+strs[5]+"','"+strs[6]+"','"+strs[7]+"')";
		}else if(strs[1].equalsIgnoreCase("B")) {
			sqlString="insert into hilton_mb"+ "(roomtype,roomno,name,phone,credit,checkin,checkout) values('double','"+ strs[2] +"','" + strs[3]+"','"+strs[4]+"','"+strs[5]+"','"+strs[6]+"','"+strs[7]+"')";
		}else if(strs[1].equalsIgnoreCase("C")) {
			sqlString="insert into hilton_mb"+ "(roomtype,roomno,name,phone,credit,checkin,checkout) values('standard','"+ strs[2] +"','" + strs[3]+"','"+strs[4]+"','"+strs[5]+"','"+strs[6]+"','"+strs[7]+"')";
		}
		
		DataManage dm = new DataManage(sqlString);
		int i = dm.bookroom();
		if(i != 0) {
			return "you have book the room successfully";
		} else {
			return "Rebooking !";
		}
	}

	public String queryCity() throws RemoteException {
		return null;
	}

	public String queryBook(String req) throws RemoteException {
		String[] strs = req.split(":");
		String sqlString = "SELECT checkin,checkout FROM hilton_mb WHERE roomno =" + strs[2];
		DataManage dm = new DataManage(sqlString);
		return dm.queryBook();
	}
}
