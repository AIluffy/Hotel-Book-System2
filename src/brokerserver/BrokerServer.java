package brokerserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class BrokerServer {	
	public static void main(String[] args) {	
		try {
			BrokerImpl temp = new BrokerImpl();
			LocateRegistry.createRegistry(15000);
			String rmiObjectName = "rmi://localhost:15000/Broker";
			Naming.rebind(rmiObjectName, temp);
			System.out.println("The middle server is ready...");
		} catch (RemoteException e) {
			System.out.println("Remote Exception");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}



		
		

