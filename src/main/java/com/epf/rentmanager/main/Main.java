package com.epf.rentmanager.main;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.rentmanager.configuration.AppConfiguration;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.models.Client;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ResaVoitureService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

public class Main {
	
	public static void main(String[]args) {
		
		
		
		/*
		 * ApplicationContext context = new
		 * AnnotationConfigApplicationContext(AppConfiguration.class); ClientService
		 * clientService = context.getBean(ClientService.class); VehicleService
		 * vehicleService = context.getBean(VehicleService.class); ReservationService
		 * reservationService= context.getBean(ReservationService.class);
		 * ResaVoitureService resaVoitureService=
		 * context.getBean(ResaVoitureService.class);
		 */
				/*
				 * try { System.out.println(ClientService.getInstance().findById(1));
				 * //System.out.println(ClientService.getInstance().findAll());
				 * 
				 * Client client = new Client ( "Andy",
				 * "yves","yvestebons@gmail.com",LocalDate.of(1999, 06, 12));
				 * ClientService.getInstance().create(client);
				 * System.out.println(ClientService.getInstance().findAll());
				 * 
				 * 
				 * 
				 * System.out.println(ClientService.getInstance().delete(2));
				 * 
				 * Scanner sc = new Scanner(System.in);
				 * System.out.println("Veuillez saisir votre nom");
				 * System.out.println("Veuillez saisir votre prenom");
				 * System.out.print("Veuillez saisir votre mail: "); String email = sc.next(
				 * "[\\w.-]+@[\\w.-]+\\.[a-z]{2,}" ); System.out.println(email +
				 * " : Email valide !");
				 * System.out.println("Veuillez saisir votre date de naissance");
				 * 
				 * 
				 * // System.out.println(ClientService.getInstance().create(cLient); }
				 * 
				 * 
				 * catch (ServiceException e) { e.printStackTrace(); }
				 * 
				 */
		
      
			

}
}