package com.epf.rentmanager.models;


public class Vehicle {
	private int id;
	private String constructor;
	private String model;
	private int numPlace;
	
	public Vehicle() {
		
	}
	
	public Vehicle(int id, String constructor, String model, int numPlace) {
		super();
		this.id = id;
		this.constructor = constructor;
		this.model = model;
		this.numPlace = numPlace;
	}
	
	
	
	public Vehicle(String constructor, String model, int numPlace) {
		super();
		this.constructor = constructor;
		this.model = model;
		this.numPlace = numPlace;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConstructor() {
		return constructor;
	}
	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getNumPlace() {
		return numPlace;
	}
	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}
	
	 public static boolean isLegal(Vehicle vehicle) {
	      return vehicle.getNumPlace() >2;
	   }
	}



