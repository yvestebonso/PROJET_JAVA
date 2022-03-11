package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/vehicles")

public class VehicleListServlet extends HttpServlet {
	



        public static final long serialVersionUID= 1L;
        @Autowired
        VehicleService vehicleService;
        
   	 public void init() throws ServletException {
   		 super.init();
   		 SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   		 }
        

        protected void doGet(HttpServletRequest request,  HttpServletResponse response)
        		throws ServletException, IOException{
        	
        	
        	try {
        		

        		request.setAttribute ("listvehicles",this.vehicleService.findAll());
        		

        		RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/vehicles/list.jsp");
        		
        		r.forward(request, response);
        		
        	}catch(ServiceException e) {
        		e.printStackTrace();
        	}
        		
        }
        

        
        }

	
