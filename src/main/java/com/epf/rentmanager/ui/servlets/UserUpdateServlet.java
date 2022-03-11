package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.sql.Date;
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
import com.epf.rentmanager.models.ResaVoiture;
import com.epf.rentmanager.service.ClientService;

//la servlet permet de lire les donnéers de la requete

@WebServlet("/users/editer") 

public class UserUpdateServlet extends HttpServlet {
	
	@Autowired
	ClientService clientService;
	
	protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
		
		//request: pour lire les données saisies par l'utilisateur
		//response: permeet d'envoyer une reponse provenant du serveur 
		//post:permet d'nvoyer les informations provenant du serveur
		//get : search,filtering,sorting
		
		int id= Integer.parseInt(request.getParameter("id")); //permet de creer une variable id de type int ,recuperer sa valeur(getParameter) et la lire grace a la requete http (en utilisant request)
		
		
		request.setAttribute ("idUser",id); // on passe la variable daans la reequete avec pour nom idUser en utilisant ke SetAttribute on l'envoie
		
		
		try {
			for (Client client: this.clientService.findAll()){
				
				
				
				if (id == client.getId()) {
					 // on recupere la marque  et le modèle (valeur) ayany par exemple pour id =?
					
					request.setAttribute ("lastname", client.getName());
					request.setAttribute ("firstname", client.getLastname());
					request.setAttribute ("email", client.getEmail());
					request.setAttribute ("birthdate", client.getBirthDate());
					
				
			RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/users/editer.jsp");
			
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
			String lastname= (String ) request.getParameter("last_name");  
			String first_name= (String ) request.getParameter("first_name");
			String email= (String ) request.getParameter("email");
		    String birthdate=(String) request.getParameter("datenaissance");
		    LocalDate birthday= LocalDate.parse(birthdate);
		
		    Client client = new Client ();
		    
		    //pour modifier les données de l'utilisaturs
		    
		
		    client.setName(first_name);
			client.setLastname(lastname);
			client.setEmail(email);
			client.setBirthDate(birthday);
		    
		    
		    
			this.clientService.update(client);
			
		response.sendRedirect(request.getContextPath()+"/users");
			
			
		}catch(ServiceException e) {
			e.printStackTrace();
		}
		
	}
	}


