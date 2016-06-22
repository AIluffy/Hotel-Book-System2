package client;

import java.rmi.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

import org.apache.axis2.AxisFault;

import brokerserver.*;
import broker.*;

public class ClientWS {
	protected BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	protected StringBuilder sb;
	protected broker.BrokerImpl broker = null;
	
	public ClientWS() {
		try {
			broker = new broker.BrokerImplStub();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws RemoteException, BrokerImplRemoteExceptionException {
		ClientWS client = new ClientWS();
		
		System.out.println(
                "---------------------------------------------"+"\n"
     	      +"|"+"hotel : show hotels                        "+"|"+"\n"
	    +"---------------------------------------------"+"\n"
               + "|"+"roomrate : show the roomrate               "+"|"+"\n"
               +"---------------------------------------------"+"\n"
               + "|"+"book: book a room                          "+"|"+"\n"
               +"---------------------------------------------"+"\n"
               + "|"+"query: query a room vacancy                "+"|"+"\n"
               +"---------------------------------------------"+"\n"
	     +"|"+"exit: exit                                 "+"|"+"\n"    );

		client.loop();
	}
	
	public void loop() throws RemoteException, BrokerImplRemoteExceptionException {
		while(true) {
			String line = null;
			
			try {
				System.out.println("Enter one of the following request :\n" + Constant.HOTEL + " - " + Constant.ROOMRATE + " - " + Constant.VACANCY + " - " + Constant.BOOK + " - " + Constant.EXIT + ".");
				line = console.readLine();

				if (line == null) {
					break;
				}
				System.out.println("Request was " + line);
			} catch (IOException e) {
				System.out.println("Fatal error in the client");
				e.printStackTrace();
			}
			
			if(line.equalsIgnoreCase(Constant.CITY)) {
				queryCity();
			} else if(line.toUpperCase().startsWith(Constant.HOTEL)) {
				queryHotel();
			} else if(line.toUpperCase().startsWith(Constant.ROOMRATE)) {
				queryRoomrate();
			} else if(line.toUpperCase().startsWith(Constant.VACANCY)) {
				queryVacancy();
			} else if(line.toUpperCase().startsWith(Constant.BOOK)) {
				bookRoom();
			} else if(line.equalsIgnoreCase(Constant.EXIT)) {
				exit();
				System.exit(0);
			} else {
				System.out.println("Unrecognised Command");
			}
		}
	}
	
	public void queryCity() throws RemoteException, BrokerImplRemoteExceptionException {
		String result = null;
		String[] cityList = null;

		QueryCity queryCity = new QueryCity();
		QueryCityResponse queryCityResponse = broker.queryCity(queryCity);
		result = queryCityResponse.get_return();

		
		cityList = result.split(":");
		
		if(cityList.length == 0) {
			System.out.println("Querying city fail !");
		} else {
			System.out.println("City list:");
			for(int i = 0; i < cityList.length; i++) {
				System.out.println(cityList[i]);
			}
		}	
	}
	
	public void queryHotel() throws RemoteException, BrokerImplRemoteExceptionException {
		String request = null, result = null;
		
		try {
			System.out.println("Please select a city you wanna live in: \n A. Melbourne");
			request = console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		QueryHotel queryHotel = new QueryHotel();
		queryHotel.setRequest(request);
		QueryHotelResponse queryHotelResponse = broker.queryHotel(queryHotel);
		result = queryHotelResponse.get_return();
		
		String[] hotelList = result.split(":");
		
		if(hotelList.length == 0) {
			System.out.println("Querying hotel fail !");
		} else {
			System.out.println("hotel list:");
			for(int i = 0; i < hotelList.length; i++) {
				System.out.println(hotelList[i]);
			}
		}		
	}
	
	public void queryRoomrate() throws RemoteException, BrokerImplRemoteExceptionException {
		String request = null, result = null;

		try {
			System.out.println("Check out the roomrate of Hotels in the list: \n A. Hilton in Melbourne \t\t B. Windsor in Melbourne ");
			request = console.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}

		QueryRoomrate queryRoomrate = new QueryRoomrate();
		queryRoomrate.setRequest(request);
		QueryRoomrateResponse queryRoomrateResponse = broker.queryRoomrate(queryRoomrate);
		result = queryRoomrateResponse.get_return();

		String[] roomrateList = result.split(":");
		
		if(roomrateList.length == 0) {
			System.out.println("Querying roomrate fail !");
		} else {
			System.out.println("roomrate list:");
			for(int i = 0; i < roomrateList.length; i++) {
				System.out.println(roomrateList[i]);
			}
		}
	}
	
	public void queryVacancy() throws BrokerImplRemoteExceptionException {
		String id = null, book = null, vac = null;
		sb = new StringBuilder();

		try {
			System.out.println("Select one of the hotels in the list: \n A. Hilton in Melbourne \t\t B. Windsor in Melbourne ");
			String hotel = console.readLine();
			
			System.out.println("Select one roomtype:\n A. single \t\t B. double \t\t C. standard");
			String roomtype = console.readLine();
			sb.append(hotel).append(":").append(roomtype).append(":");
			
			QueryRoomId queryRoomId = new QueryRoomId();
			queryRoomId.setRequest(sb.toString());
			QueryRoomIdResponse queryRoomIdResponse = broker.queryRoomId(queryRoomId);
			id = queryRoomIdResponse.get_return();
			
			System.out.println("The Room No :\n" + id);
			System.out.println("Select one room:");
			String roomid = console.readLine();
			sb.append(roomid).append(":");
			
			QueryBook queryBook = new QueryBook();
			queryBook.setRequest(sb.toString());
			QueryBookResponse queryBookResponse = broker.queryBook(queryBook);
			book = queryBookResponse.get_return();
			
			System.out.println("The room booking condition:\n" + book);
			
			System.out.println("Type one day you wanna live in (1-30):");
			String checkin = console.readLine();
			
			System.out.println("Type one day you leave (1-30):");
			String checkout = console.readLine();
			
			sb.append(checkin).append(":").append(checkout).append(":");
			
			QueryVacancy queryVacancy = new QueryVacancy();
			queryVacancy.setRequest(sb.toString());
			QueryVacancyResponse queryVacancyResponse = broker.queryVacancy(queryVacancy);
			vac = queryVacancyResponse.get_return();
			System.out.println(vac);	
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Connection wrong !");
		}
		
	}
	
	public void bookRoom() throws BrokerImplRemoteExceptionException { 
		String id = null, result = null;
		sb = new StringBuilder();
		boolean flag = true;

		try {
			System.out.println("Select one of the hotels in the list: \n A. Hilton in Melbourne \t\t B. Windsor in Melbourne ");
			String hotel = console.readLine();
			sb.append(hotel).append(":");
			
			System.out.println("Select one roomtype:\n A. single \t\t B. double \t\t C. standard");
			String type = console.readLine();
			sb.append(type).append(":");
			
			QueryRoomId queryRoomId = new QueryRoomId();
			queryRoomId.setRequest(sb.toString());
			QueryRoomIdResponse queryRoomIdResponse = broker.queryRoomId(queryRoomId);
			id = queryRoomIdResponse.get_return();
			
			System.out.println("the Room No:" + id);
			
			System.out.println("Choose room no:");
			String roomid = console.readLine();
			sb.append(roomid).append(":");
			
			System.out.println("Enter your name:");
			String name = console.readLine();
			sb.append(name).append(":");
			
			System.out.println("Enter your phone:");
			String phone = null;
			while(true) {
				phone = console.readLine();
				String regExp = "^[1][0-9]{10}$";
				Pattern p = Pattern.compile(regExp);
				Matcher m = p.matcher(phone);
				flag = m.find();
				if(flag == true) {
					break;
				} else {
					System.out.println("Please type a correct phone number(11 bit) again:");
				}
			}
			sb.append(phone).append(":");
			
			System.out.println("Enter your credit card number:");
			String credit = null;
			while(true) {
				credit = console.readLine();
				String regExp = "^[0-9]{18}$";
				Pattern p = Pattern.compile(regExp);
				Matcher m = p.matcher(credit);
				flag = m.find();
				if(flag == true) {
					break;
				} else {
					System.out.println("Please type a correct creidt number(18 bit) again:");
				}
			}
			sb.append(credit).append(":");
			
			System.out.println("Enter one day in May 2015 to check in (1-31):");
			String checkin = console.readLine();
			sb.append(checkin).append(":");
			
			System.out.println("Enter one day in May 2015 to check out (1-31):");
			String checkout = console.readLine();
			sb.append(checkout);
			
			Booking booking = new Booking();
			booking.setRequest(sb.toString());
			BookingResponse bookingResponse = broker.booking(booking);
			result = bookingResponse.get_return();
			System.out.println(result);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exit() {
		System.out.println("exit");
	}
}
