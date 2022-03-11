package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.epf.rentmanager.service.ClientService;


@WebServlet("/users/search")

public class FindUserServlet extends HttpServlet {
	
	
	 
	 @ Autowired
     ClientService clientService;
	 public void init() throws ServletException {
	 super.init();
	 SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	 }

protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
	 
	
	
	
    try {
   	 
    	String search= (String ) request.getParameter("search"); //on recupere le mot entré pour la recherche(nom ou prenom)
  
    	List<Client> listClient1 = this.clientService.findAll(); //on recupere la liste de tous les utilisateurs en bd 
    	List<Client> listClient = new ArrayList<Client>();       //on crée la liste des utilisateurs qui sera envoyée comme résultat de la recherche
    	
    	
    	/**
    	 *  on parcour la liste des utilsateurs et si la valeur du mot entré correspond en minuscule à tout ou partie du nom ou prenom alors on l'ajoute dans la liste de clients qui se renvoyée comme résultat de recherche
    	 */
    	
    	for (Client client : listClient1) {
    		if ((client.getLastname().toLowerCase().contains(search)) || (client.getName().toLowerCase().contains(search)) ){
    			listClient.add(client);
    		}
    	}
    	
    	request.setAttribute ("listUsers",listClient); //on affiche l'objet listeuser avec pour listClient
    	RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/users/list.jsp"); //recupére les information de la vue
    	r.forward(request, response); // envoie la reponse au serveur
		
	} catch (ServiceException e) {
		// TODO Auto-generated catch blocks
		e.printStackTrace();
	}
	
   
 
 
 
}

}
