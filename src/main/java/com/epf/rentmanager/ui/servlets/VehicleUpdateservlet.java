package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.models.Client;
import com.epf.rentmanager.models.Vehicle;
import com.epf.rentmanager.service.VehicleService;


@WebServlet("/vehicles/editer") 
public class VehicleUpdateservlet extends HttpServlet  {
	
	@Autowired
	VehicleService vehicleService;

	
protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
		
		//request: pour lire les données saisies par l'utilisateur
		//response: permeet d'envoyer une reponse provenant du serveur 
		//post:permet d'nvoyer les informations provenant du serveur
		//get : search,filtering,sorting
		
		int id= Integer.parseInt(request.getParameter("id")); //permet de creer une variable id de type int ,recuperer sa valeur(getParameter) et la lire grace a la requete http (en utilisant request)
		
		
		try {
			for (Vehicle vehicle: this.vehicleService.findAll()){
				
				
				
				if (id == vehicle.getId()) {
					 // on recupere la marque  et le modèle (valeur) ayany par exemple pour id =?
					
					request.setAttribute ("marque", vehicle.getConstructor());
					request.setAttribute ("modele", vehicle.getModel());
					request.setAttribute ("NumPlaces",  vehicle.getNumPlace());
				
			
			
			
			
			
			RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/vehicles/editer.jsp");
			
			r.forward(request, response);
				}
				
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	 public void init() throws ServletException {
	 super.init();
	 SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	 }

protected void doPost (HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
	
	
	
	try {
		
		//pour recuperer et lire les données saisies apr l'utilisateur
		int id= Integer.parseInt(request.getParameter("id"));
		String constructor=  (String) request.getParameter("manufacturer");
		String Model=  (String) request.getParameter("modele");
	    int Numplace= Integer.parseInt(request.getParameter("seats"));
	    
	   
		
	Vehicle vehicle = new Vehicle ();
	    
	    //pour modifier les données de l'utilisaturs
	   
	
	    vehicle.setId(id);
	    vehicle.setConstructor(constructor);
	    vehicle.setModel(Model);
	    vehicle.setNumPlace(Numplace);
	    
	    
		this.vehicleService.update(vehicle);
		
	response.sendRedirect(request.getContextPath()+"/vehicles");
		
	
		
	}catch(ServiceException e) {
		e.printStackTrace();
	}
	
}



}
