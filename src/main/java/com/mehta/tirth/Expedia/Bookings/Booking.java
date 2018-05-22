package com.mehta.tirth.Expedia.Bookings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Booking {

	@Id
	@Column
	private String id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private String flightid;
	
	
	public Booking(String id, String name, String description, String flightid) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.flightid = flightid;
	}

	protected Booking()
	{
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}
	
//	private String hotelid;
	
	
	
	
}
