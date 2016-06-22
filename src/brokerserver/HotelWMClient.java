package brokerserver;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class HotelWMClient {
	static corba.hotelbooking.HotelWM hotelRef;
	
	public HotelWMClient(String args[]) {
		setup(args);
	}
	
	public void setup(String args[]) {
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objectRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objectRef);
			hotelRef = corba.hotelbooking.HotelWMHelper.narrow(ncRef.resolve_str("Windsor"));
		} catch (Exception e) {
			System.out.println("*** Client error! ***");
			e.printStackTrace();
		}
	}
	
	public String queryHotel(String req) {
		return hotelRef.queryHotel(req);
	}
	
	public String queryRoomrate(String req) {
		return hotelRef.queryRoomrate(req);
	}
	
	public String queryVacancy(String req) {
		return hotelRef.queryVacancy(req);
	}
	
	public String queryRoomId(String req) {
		return hotelRef.queryRoomId(req);
	}
	
	public String booking(String req) {
		return hotelRef.booking(req);
	}
	
	public String queryBook(String req) {
		return hotelRef.queryBook(req);
	}
}
