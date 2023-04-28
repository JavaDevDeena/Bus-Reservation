package bus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {

	String name;
	int busno;
	Date date;
	
	Booking(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		name = sc.next();
		System.out.println("Enter bus No");
		busno = sc.nextInt();
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = sc.next();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateInput);
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
		int capacity =0;
		for(Bus b: buses) {
			if(b.getBusno() == busno) {
				capacity = b.getCapacity();
			}
		}
		int booked =0;
		for(Booking book: bookings) {
			if(book.busno == busno && book.date.equals(date)) {
				booked++;
			}
		}
	
		return booked<capacity?true:false;
	}
	
	
}
