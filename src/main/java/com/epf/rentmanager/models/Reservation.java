package com.epf.rentmanager.models;

import java.time.LocalDate;

public class Reservation {
	
	
	
	private int id;
	private int idClient;
	private int idVehicule;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	
	
	public Reservation() {
		super();
	}
	
	
	


	public Reservation(int id,int idClient, int idVehicule, LocalDate dateStart, LocalDate dateEnd) {
		super();
		this.id=id;
		this.idClient = idClient;
		this.idVehicule = idVehicule;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	


	public Reservation(LocalDate dateStart, LocalDate dateEnd) {
		super();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}






	public Reservation(int idClient, int idVehicule, LocalDate dateStart, LocalDate dateEnd) {
		super();
		this.idClient = idClient;
		this.idVehicule = idVehicule;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	
	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public int getIdVehicule() {
		return idVehicule;
	}


	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}


	public LocalDate getDateStart() {
		return dateStart;
	}


	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}


	public LocalDate getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	

}
