package com.mehta.tirth.Expedia.Flights;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> getAllFlights()
	{
		List<Flight> flights=new ArrayList<>();
		this.flightRepository.findAll().forEach(flights::add);
		return flights;
	}
	
	public boolean reflectChange(String flightid,boolean check)
	{
		if(check==true)
		{
			Flight f=this.flightRepository.findById(flightid).orElse(null);
			if(f!=null)
			{
				int currentCapacity=f.getCapacity();
				if(currentCapacity==0)
					return false;
				f.setCapacity(currentCapacity-1);
				this.updateFlight(f);
				return true;
			}
			else
				return false;
		}
		else
		{
			Flight f=this.flightRepository.findById(flightid).orElse(null);
			if(f!=null)
			{
				int currentCapacity=f.getCapacity();
				f.setCapacity(currentCapacity+1);
				this.updateFlight(f);
				return true;
			}
			else
				return false;
		}
	}
	
	public Flight getFlight(String flightid)
	{
		return this.flightRepository.findById(flightid).orElse(null);
	}
	
	public void addFlight(Flight flight)
	{
		this.flightRepository.save(flight);
	}
	
	public void updateFlight(Flight flight)
	{
		this.flightRepository.save(flight);
	}
	
	public void deleteFlight(String flightid)
	{
		this.flightRepository.deleteById(flightid);
	}
	
}
