package com.mehta.tirth.Expedia.Hotels;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> getAllHotels()
	{
		List<Hotel> hotels=new ArrayList<>();
		this.hotelRepository.findAll().forEach(hotels::add);
		return hotels;
	}
	
	public Hotel getHotel(String hotelid)
	{
		return this.hotelRepository.findById(hotelid).orElse(null);
	}
	
	public void addHotel(Hotel hotel)
	{
		this.hotelRepository.save(hotel);
	}
	
	public void updateHotel(Hotel hotel)
	{
		this.hotelRepository.save(hotel);
	}
	
	public void deleteHotel(String hotelid)
	{
		this.hotelRepository.deleteById(hotelid);
	}
	
}
