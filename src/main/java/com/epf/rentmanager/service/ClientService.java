package com.epf.rentmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.models.Client;
import com.epf.rentmanager.dao.ClientDao;

@Service

public class ClientService {

	
	private ClientDao clientDao;
	
private ClientService(ClientDao clientDao) {
		
		this.clientDao = clientDao;
	}
	
	
	public long create(Client client) throws ServiceException {
	
		
		try {
			
			return this.clientDao.create(client);
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException();
		}
		// TODO: créer un client   
		
	}
	
	// Suppression d'un client 
	
	public long delete( int id ) throws  ServiceException {
		
		try {
			 
			return this.clientDao.delete(id);
			
		}catch(DaoException e) {
			
			e.printStackTrace();
		
			
		}
		return 0;
		
	}
	
	
	public long update (Client client) throws ServiceException{
		
		try {
			 
			return this.clientDao.update(client);
			
		}catch(DaoException e) {
			
			e.printStackTrace();
		}
		
			return 0;
	
		
	}
	
 public int count () throws ServiceException{
		
		try {
			 
			return this.clientDao.count();
			
		}catch(DaoException e) {
			
			e.printStackTrace();
		}
		
			return 0;
	
		
	}
	

	
		
	public Client findById(long id) throws ServiceException {
		
		try {
			
			return this.clientDao.findById(id).get();
			
		} catch(DaoException e){
			
			e.printStackTrace();
			
		}
		return null;
		// TODO: récupérer un client par son id
		
	}

	public List<Client> findAll() throws ServiceException {
		try {
		
		return this.clientDao.findAll();
		
		// TODO: récupérer tous les clients
		
	} catch (DaoException e){
		
	
		e.printStackTrace();
		
	}
	return null;
	
}
}
