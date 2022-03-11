package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.models.Client;
import com.epf.rentmanager.models.Vehicle;
import com.epf.rentmanager.service.VehicleService;



@WebServlet("/vehicles/create")

public class VehicleCreateServlet extends HttpServlet {
	
	
	@Autowired
	VehicleService vehicleService;
	 public void init() throws ServletException {
	 super.init();
	 SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	 }
	
	protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
			
		
		RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/vehicles/create.jsp");
		
		r.forward(request, response);

	}
	
	
	protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		try {
			
			String constructor=  (String) request.getParameter("manufacturer");
			String Model=  (String) request.getParameter("modele");
		    int Numplace= Integer.parseInt(request.getParameter("seats"));
		    
		   
		    	this.vehicleService.create(new Vehicle(constructor,Model,Numplace));
		    	response.sendRedirect(request.getContextPath()+"/vehicles ");

		    
		    	
		    
		}
		    
		    
		catch(Exception e){
		
		e.printStackTrace();
			
		}
	
	
	
}
}
