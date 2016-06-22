package client;
import java.rmi.*;
import java.security.Policy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

import common.HotelAction;
import common.MinimalPolicy;
import brokerserver.Constant;

public class Client {
	protected BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	protected StringBuilder sb;
	protected HotelAction broker;
	
	public Client() {
		try{
			broker = (HotelAction)Naming.lookup("rmi://localhost:15000/Broker");
		} catch (ConnectException conEx) {
			System.out.println("Unable to connect to Broker!");
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		
		System.out.println(
                "---------------------------------------------"+"\n"
               + "|"+"city: show the cities                      "+"|"+"\n"	
               +"---------------------------------------------"+"\n"
     	      +"|"+"hotel : show hotels                        "+"|"+"\n"
	    +"---------------------------------------------"+"\n"
               + "|"+"roomrate : show the roomrate               "+"|"+"\n"
               +"---------------------------------------------"+"\n"
               + "|"+"book: book a room                          "+"|"+"\n"
               +"---------------------------------------------"+"\n"
               + "|"+"query: query a room vacancy                "+"|"+"\n"
               +"---------------------------------------------"+"\n"
	     +"|"+"exit: exit                                 "+"|"+"\n"     
   	    +"---------------------------------------------"+"\n");

		client.loop();
	}
	
	public void loop() {
		while(true) {
			String line = null;
			
			try {
				System.out.println("Enter one of the following request :\n" + Constant.CITY + " - " + Constant.HOTEL + " - " + Constant.ROOMRATE + " - " + Constant.VACANCY + " - " + Constant.BOOK + " - " + Constant.EXIT + ".");
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
	
	public void queryCity() {
		String result = null;
		String[] cityList = null;

		try {
			result = broker.queryCity();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
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
	
	public void queryHotel() {
		String request = null, result = null;
		
		try {
			System.out.println("Please select a city you wanna live in: \n A. Melbourne");
			request = console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			result = broker.queryHotel(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
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
	
	public void queryRoomrate() {
		String request = null, result = null;

		try {
			System.out.println("Check out the roomrate of Hotels in the list: \n A. Hilton in Melbourne \t\t B. Windsor in Melbourne ");
			request = console.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}

		try {
			result = broker.queryRoomrate(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

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
	
	public void queryVacancy() {

		sb = new StringBuilder();

		try {
			System.out.println("Select one of the hotels in the list: \n A. Hilton in Melbourne \t\t B. Windsor in Melbourne ");
			String hotel = console.readLine();
			
			System.out.println("Select one roomtype:\n A. single \t\t B. double \t\t C. standard");
			String roomtype = console.readLine();
			sb.append(hotel).append(":").append(roomtype).append(":");
			
			System.out.println("The Room No:\n" + broker.queryRoomId(sb.toString()));
			System.out.println("Select one room:");
			String roomid = console.readLine();
			sb.append(roomid).append(":");
			System.out.println("The room booking condition:\n" + broker.queryBook(sb.toString()));
			
			System.out.println("Type one day you wanna live in (1-30):");
			String checkin = console.readLine();
			
			System.out.println("Type one day you leave (1-30):");
			String checkout = console.readLine();
			
			sb.append(checkin).append(":").append(checkout).append(":");
			System.out.println(broker.queryVacancy(sb.toString()));	
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Connection wrong !");
		}
		
	}
	
	public void bookRoom() { 

		sb = new StringBuilder();
		boolean flag = true;

		try {
			System.out.println("Select one of the hotels in the list: \n A. Hilton in Melbourne \t\t B. Windsor in Melbourne ");
			String hotel = console.readLine();
			sb.append(hotel).append(":");
			
			System.out.println("Select one roomtype:\n A. single \t\t B. double \t\t C. standard");
			String type = console.readLine();
			sb.append(type).append(":");
			
			System.out.println("the Room No:" + broker.queryRoomId(sb.toString()));
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
			System.out.println(broker.booking(sb.toString()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exit() {
		System.out.println("exit");
	}
}
