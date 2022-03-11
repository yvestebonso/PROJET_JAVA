package com.epf.rentmanager.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.ReservationDao;
import com.epf.rentmanager.dao.VehicleDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.models.Client;
import com.epf.rentmanager.models.ResaVoiture;
import com.epf.rentmanager.models.Reservation;
import com.epf.rentmanager.models.Vehicle;


@Service
public class ResaVoitureService {
	
	private ClientDao clientDao;
	private ReservationDao reservationDao;
	private VehicleDao vehicleDao;
	
	
 private ResaVoitureService (ClientDao clientDao, ReservationDao  reservationDao, VehicleDao vehicleDao) {
		
		this.clientDao = clientDao;
		this.reservationDao =reservationDao;
		this.vehicleDao = vehicleDao;
	}
 


	

	public List<ResaVoiture> findAll() throws ServiceException {
		
		try {
		
			List<Reservation> reservations = this.reservationDao.findAll(); // On crée une liste de reservations dans laquelle on recupére les donnnées de la méthode findAll de la classe reseravtionDao
			List<Client>  clients = this.clientDao.findAll();
			List<Vehicle> voitures = this.vehicleDao.findAll();
			List<ResaVoiture> resavoitures = new ArrayList<ResaVoiture>() ; //on crée une liste dans laquelle on va récupérer les information surla reservation
		 
			HashMap<Integer, String> customer = new HashMap(); //on crée une Map nous permerttant de récupérer la clé et la valeur de ce qu'on veut afficher
			HashMap<Integer, String> vehicle = new HashMap();
			
			// on parcourr la liste client et on récupére le nom et le prenom (valeur) l'id (clé)
			for (Client client: clients) {
				customer.put(client.getId(), client.getLastname()+" "+client.getName());
			}
			
			for (Vehicle voiture: voitures) {
				vehicle.put(voiture.getId(), voiture.getConstructor()+" "+voiture.getModel());
			}	
			
			for (Reservation reservation: reservations) {
				String clientName = null;
				String vehicleName = null;
				
				for (Vehicle voiture: voitures) {
					if (voiture.getId() == reservation.getIdVehicule()) {
						vehicleName = vehicle.get(voiture.getId());  // on recupere la marque  et le modèle (valeur) ayany par exemple pour id =?
					}
					
				}
				
				for (Client client: clients) {
					if (client.getId() == reservation.getIdClient()) {  //on vérifie que les id sont identitiques
						clientName = customer.get(client.getId());
					}
				}
				ResaVoiture resa = new ResaVoiture(reservation.getId(), vehicleName, clientName, reservation.getDateStart(), reservation.getDateEnd()); //on crée un objet de type resa qui contient les informations sur une reservation
				resavoitures.add(resa);// on ajoute les information de l'objet resa à la liste resavoitures
			}	
			
			return resavoitures;
		// TODO: récupérer tous les clients
		
	} catch (DaoException e){
		
	
		e.printStackTrace();
		
	}
	return null;
	
}







	
	
	

}
