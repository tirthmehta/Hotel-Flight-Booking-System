package com.mehta.tirth.Expedia.Hotels;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehta.tirth.Expedia.Flights.Flight;

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
	
	public boolean reflectChange(String hotelid,boolean check)
	{
		if(check==true)
		{
			Hotel h=this.hotelRepository.findById(hotelid).orElse(null);
			if(h!=null)
			{
				int currentCapacity=h.getCapacity();
				if(currentCapacity==0)
					return false;
				h.setCapacity(currentCapacity-1);
				this.updateHotel(h);
				return true;
			}
			else
				return false;
		}
		else
		{
			Hotel h=this.hotelRepository.findById(hotelid).orElse(null);
			if(h!=null)
			{
				int currentCapacity=h.getCapacity();
				h.setCapacity(currentCapacity+1);
				this.updateHotel(h);
				return true;
			}
			else
				return false;
		}
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
