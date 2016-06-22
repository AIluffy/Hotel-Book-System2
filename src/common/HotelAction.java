package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HotelAction extends Remote {
	public String queryCity() throws RemoteException;
	
	public String queryHotel(String request) throws RemoteException;
	
	public String queryRoomrate(String request) throws RemoteException;
	
	public String queryVacancy(String request) throws RemoteException;
	
	public String queryRoomId(String request) throws RemoteException;
	
	public String queryBook(String request) throws RemoteException;

	public String booking(String request) throws RemoteException;	
}
