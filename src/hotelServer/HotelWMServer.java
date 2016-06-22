package hotelServer;

import org.omg.CosNaming.*;
import corba.hotelbooking.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;;

public class HotelWMServer {
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			
			HotelWMServant wm = new HotelWMServant();
			wm.setORB(orb);
			
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(wm);
			HotelWM href = HotelWMHelper.narrow(ref);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			
			String name = "Windsor";
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, href);
			
			System.out.println("Windsor is running");
			orb.run();
		}catch (Exception e) {
			System.err.println (" Server error " + e);
			e.printStackTrace();
		}
	}
	
	
}
