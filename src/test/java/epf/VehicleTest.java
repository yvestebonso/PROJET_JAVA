package epf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.epf.rentmanager.models.Client;
import com.epf.rentmanager.models.Vehicle;

public class VehicleTest {
	
	
	

	@Test
	  public void isLegal_should_return_true_when_numPlace_is_over_2() {
	       // Given
	       Vehicle legalUser = new Vehicle(1,"renault","seats",3);
	        
	       // Then
	       assertTrue(Vehicle.isLegal(legalUser));
	   }

	   @Test
	  public  void isLegal_should_return_false_when_id_is_under_0() {
	        // Given   
	        Vehicle illegaUser = new Vehicle (1,"renault","seats",1);
	       // Then
	       assertFalse(Vehicle.isLegal(illegaUser));
	   }

}
