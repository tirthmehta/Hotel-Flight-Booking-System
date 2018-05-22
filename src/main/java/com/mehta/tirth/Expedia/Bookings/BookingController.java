package com.mehta.tirth.Expedia.Bookings;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mehta.tirth.Expedia.Flights.FlightService;
import com.mehta.tirth.Expedia.Hotels.HotelService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private FlightService flightService;
	@Autowired
	private HotelService hotelService;
	
	@RequestMapping("/expedia/bookings")
	public List<Booking> getAllBookings()
	{
		return this.bookingService.getAllBookings();
	}
	
	@RequestMapping("/expedia/bookings/{bookingid}")
	public Booking getBooking(@PathVariable String bookingid)
	{
		return this.bookingService.getBooking(bookingid);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/expedia/bookings")
	public void addBooking(@RequestBody Booking booking)
	{
		String flightid=booking.getFlightid();
		String hotelid=booking.getHotelid();
		if(flightid!=null) {
		boolean checkingFlightCapacityandUpdate=this.flightService.reflectChange(flightid,true);
		if(checkingFlightCapacityandUpdate)
			this.bookingService.addBooking(booking);
		}
		else
		{
			boolean checkingHotelCapacityandUpdate=this.hotelService.reflectChange(hotelid,true);
			if(checkingHotelCapacityandUpdate)
				this.bookingService.addBooking(booking);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/expedia/bookings/{bookingid}")
	public void updateBooking(@RequestBody Booking booking)
	{
		this.bookingService.updateBooking(booking);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/expedia/bookings/{bookingid}")
	public void deleteBooking(@PathVariable String bookingid)
	{
		String flightid=this.bookingService.getBooking(bookingid).getFlightid();
		boolean checkingFlightCapacityandUpdate=this.flightService.reflectChange(flightid,false);
		if(checkingFlightCapacityandUpdate)
			this.bookingService.deleteBooking(bookingid);
	}
	
	
}
