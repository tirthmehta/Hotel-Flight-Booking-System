package com.mehta.tirth.Expedia.Bookings;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getAllBookings()
	{
		List<Booking> bookings=new ArrayList<>();
		this.bookingRepository.findAll().forEach(bookings::add);
		return bookings;
	}
	
	public Booking getBooking(String bookingid)
	{
		return this.bookingRepository.findById(bookingid).orElse(null);
	}
	
	public void addBooking(Booking booking)
	{
		this.bookingRepository.save(booking);
	}
	
	public void updateBooking(Booking booking)
	{
		this.bookingRepository.save(booking);
	}
	
	public void deleteBooking(String bookingId)
	{
		this.bookingRepository.deleteById(bookingId);
	}
}
