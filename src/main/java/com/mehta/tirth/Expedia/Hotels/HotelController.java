package com.mehta.tirth.Expedia.Hotels;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@RequestMapping("/expedia/hotels")
	public List<Hotel> getAllHotels()
	{
		return this.hotelService.getAllHotels();
	}
	
	@RequestMapping("/expedia/hotels/{hotelid}")
	public Hotel getHotel(@PathVariable String hotelid)
	{
		return this.hotelService.getHotel(hotelid);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/expedia/hotels")
	public void addHotel(@RequestBody Hotel hotel)
	{
		this.hotelService.addHotel(hotel);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/expedia/hotels/{hotelid}")
	public void updateHotel(@RequestBody Hotel hotel)
	{
		this.hotelService.updateHotel(hotel);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/expedia/hotels/{hotelid}")
	public void deleteHotel(@PathVariable String hotelid)
	{
		this.hotelService.deleteHotel(hotelid);
	}
}
