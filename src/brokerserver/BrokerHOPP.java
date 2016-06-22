package brokerserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.security.Policy;
import common.MinimalPolicy;
import common.HotelAction;

public class BrokerHOPP implements HotelAction {
	private HotelAction proxy;
	
	public BrokerHOPP() throws MalformedURLException, NotBoundException, RemoteException {
		proxy = (HotelAction) Naming.lookup("rmi://localhost:15001/Hilton_Melbourne");
	}

	public String queryCity() throws RemoteException {
		return null;
	}

	public String queryHotel(String request) throws RemoteException {
		return proxy.queryHotel(request);
	}

	public String queryRoomrate(String request) throws RemoteException {
		return proxy.queryRoomrate(request);
	}

	public String queryVacancy(String request) throws RemoteException {
		return proxy.queryVacancy(request);
	}

	public String queryRoomId(String request) throws RemoteException {
		return proxy.queryRoomId(request);
	}

	public String queryBook(String request) throws RemoteException {
		return proxy.queryBook(request);
	}

	public String booking(String request) throws RemoteException {
		return proxy.booking(request);
	}
}
