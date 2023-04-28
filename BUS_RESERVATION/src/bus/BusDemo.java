package bus;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {

	public static void main(String[] args) {

		ArrayList<Bus> buses = new ArrayList<Bus>();
		
		buses.add(new Bus(1,true,2));
		buses.add(new Bus(2,true,22));

		ArrayList<Booking> bookings = new ArrayList<Booking>();

		for(Bus b: buses) {
			b.displaybusInfo();
		}
		
		Scanner sc = new Scanner(System.in);
		
		int userOpt=1;
		
		while(userOpt == 1) {
			System.out.println("If you want booking press '1' exit press '2'");
			userOpt = sc.nextInt();
			if(userOpt == 1) {

				Booking booking = new Booking();
				
				if(booking.isAvailable(bookings,buses)) {
					bookings.add(booking);
					System.out.println("Ypur Booking is Confirm");
				}else {
					System.out.println("Sorry , Bus is full , Try another bus or date");
				}
				
			}
			
			
		}
		
	}

}
