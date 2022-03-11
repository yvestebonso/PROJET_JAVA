package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.models.Client;
import com.epf.rentmanager.service.ClientService;

@WebServlet("/users/create")

public class UserCreateServlet extends HttpServlet {
	
	 @ Autowired
     ClientService clientService;
	 
	 public void init() throws ServletException {
	 super.init();
	 SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	 
	 }
	
	
	
	protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
			
	    LocalDate todaysDate = LocalDate.now();
	    
	    int d = todaysDate.getDayOfMonth() ;
	    int m = todaysDate.getMonthValue() ;
	    int y = todaysDate.getYear() ;
	    
	    int anne = y-18;

	    String annee = String.valueOf(anne);
	    String mois = String.valueOf(m);
	    String day = String.valueOf(d);
	    

	    if(m<=9 & d<=9) {
	    	String date_now = annee+"-0"+mois+"-0"+day;
	    	request.setAttribute("date_now",date_now);
	    }
	    if(m<=9 & d>9) {
	    	String date_now = annee+"-0"+mois+"-"+day;
	    	request.setAttribute("date_now",date_now);
	    }
	    if(m>9 & d<=9) {
	    	String date_now = annee+"-"+mois+"-0"+day;
	    	request.setAttribute("date_now",date_now);
	    }
	    if(m>9 & d>9) {
	    	String date_now = annee+"-"+mois+"-"+day;
	    	request.setAttribute("date_now",date_now);
	    }
	    
	    
	    
		RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/users/create.jsp");
		
		r.forward(request, response);
		
	
	}
	
	
	
	protected void doPost (HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
		
		
	
	try {
		
		
		String lastname= (String ) request.getParameter("last_name");
		String first_name= (String ) request.getParameter("first_name");
		String email= (String ) request.getParameter("email");
	    String birthdate=(String) request.getParameter("dateajout");
	    LocalDate birthday= LocalDate.parse(birthdate);
	    
	    int cnt=0;
	    for(Client client: this.clientService.findAll() ) {
	    	
	    	if(client.getEmail().compareToIgnoreCase(email) == 0) {
	    		cnt++;
	    	}
	    }
	    
	    if(cnt==0) {
	    	this.clientService.create(new Client(lastname,first_name,email,birthday));
	    	response.sendRedirect(request.getContextPath()+"/users");
	    }else {
	    	
	    	response.sendRedirect(request.getContextPath()+"/users/create");
	    }
	   
		
	}catch(ServiceException e) {
		e.printStackTrace();
	}
	
	
	

 
}}