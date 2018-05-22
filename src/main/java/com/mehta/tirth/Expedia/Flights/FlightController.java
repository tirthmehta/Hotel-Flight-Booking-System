package com.mehta.tirth.Expedia.Flights;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

	@Autowired
	private FlightService hotelService;
	
	@RequestMapping("/expedia/flights")
	public List<Flight> getAllHotels()
	{
		return this.hotelService.getAllFlights();
	}
	
	@RequestMapping("/expedia/flights/{flightid}")
	public Flight getHotel(@PathVariable String flightid)
	{
		return this.hotelService.getFlight(flightid);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/expedia/flights")
	public void addHotel(@RequestBody Flight flight)
	{
		this.hotelService.addFlight(flight);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/expedia/flights/{flightid}")
	public void updateHotel(@RequestBody Flight flight)
	{
		this.hotelService.updateFlight(flight);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/expedia/flights/{flightid}")
	public void deleteHotel(@PathVariable String flightid)
	{
		this.hotelService.deleteFlight(flightid);
	}
}
