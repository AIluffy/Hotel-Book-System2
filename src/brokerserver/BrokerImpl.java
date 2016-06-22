package brokerserver;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;

import common.HotelAction;

public class BrokerImpl extends UnicastRemoteObject implements HotelAction {

	public BrokerHOPP hm = null;
	public HotelWMClient wm = null;
	private String[] args = null;
	
	public BrokerImpl() throws RemoteException {
		super();
		 wm = new HotelWMClient(args);
		try {
			hm = new BrokerHOPP();
		} catch (MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public String queryCity() throws RemoteException {
		String str = "SELECT cityid, cityname FROM city";
		DataManage dm = new DataManage(str);
		return dm.queryCity();
		
	}
	
	public String queryHotel(String request) throws RemoteException {
		if (request.equalsIgnoreCase("A")) {
			return hm.queryHotel(request);
		}
		return "Unable to connect to server!";
	}

	
	public String queryRoomrate(String request) throws RemoteException {
		if (request.equalsIgnoreCase("A")) {
			return hm.queryRoomrate(request);
		}else if (request.equalsIgnoreCase("B")) {
			return wm.queryRoomrate(request);
		}

		return "Unable to connect to server!";
	}

	
	public String queryVacancy(String request) throws RemoteException {
		String[] strs = request.split(":");
		String[] days = null;
		String result = null;
		
		if (strs[0].equalsIgnoreCase("A")) {
			result = hm.queryVacancy(request);
		}else if (strs[0].equalsIgnoreCase("B")) {
			result = wm.queryVacancy(request);
		}
		
		if(result != null) {
			if(result.equals("A")) {
				return "you can book this room";
			}else {
				days = result.split(":");
				int in = 0, in1 = 0, out = 0, out1 = 0, i = 0;
				for(int j = 0; j < days.length; j++){
					String[] duration = days[j].split("&");
					try {
						in = Integer.parseInt(duration[0]);
						in1 = Integer.parseInt(strs[3]);
						out = Integer.parseInt(duration[1]);
						out1 = Integer.parseInt(strs[4]);
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					if(in > in1 && in > out1) {
						i = i + 0;
					} else if (in1 > out) {
						i = i + 0;
					} else {
						i = i + 1;
					}
				}
				if(i == 0) {
					return "you can book this room";
				} else {
					return "this room has been booked";
				}				
			} 
		}
		
		return "you can't book this room";
	}
	
	public String queryRoomId(String request) throws RemoteException {
		String[] strs = request.split(":");

		if (strs[0].equalsIgnoreCase("A")) {
			return hm.queryRoomId(request);
		} else if (strs[0].equalsIgnoreCase("B")) {
			return wm.queryRoomId(request);
		}
		
		return "Unable to connect to server!";
	}
	
	public String booking(String request) throws RemoteException {
		String[] strs = request.split(":");

		if (strs[0].equalsIgnoreCase("A")) {
			return hm.booking(request);
		} else if (strs[0].equalsIgnoreCase("B")) {
			return wm.booking(request);
		}
		
		return "Unable to connect to server!";
	}

	public String queryBook(String request) throws RemoteException {
		String[] strs = request.split(":");
		
		if (strs[0].equalsIgnoreCase("A")) {
			return hm.queryBook(request);
		} else if (strs[0].equalsIgnoreCase("B")) {
			return wm.queryBook(request);
		}
		
		return "Unable to connect to server!";
	}
}
