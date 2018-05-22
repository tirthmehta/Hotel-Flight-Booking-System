package com.mehta.tirth.Expedia.Flights;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Flight {

	@Id
	@Column
	private String id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private int capacity;
	
	protected Flight() {
		
	}
	
	
	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public Flight(String id, String name, String description,int capacity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.capacity=capacity;
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
	
	
	
	
}
