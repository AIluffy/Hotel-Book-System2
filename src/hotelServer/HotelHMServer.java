package hotelServer;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.HotelAction;

public class HotelHMServer {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(15001);
			HotelHMImpl temp = new HotelHMImpl();
			String rmiObjectName = "rmi://localhost:15001/Hilton_Melbourne";
			Naming.rebind(rmiObjectName, temp);
			System.out.println("Hilton in m is ready...");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}

