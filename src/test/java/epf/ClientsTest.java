package epf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.epf.rentmanager.models.Client;

public class ClientsTest {
	
	
	@Test
	  public void isLegal_should_return_true_when_id_is_over_1() {
	       // Given
	       Client legalUser = new Client(1,"John", "Doe", "john.doe@ensta.fr", LocalDate.of(1995, 07 , 14));
	        
	       // Then
	       assertTrue(Client.isLegal(legalUser));
	   }

	   @Test
	  public  void isLegal_should_return_false_when_id_is_under_0() {
	        // Given   
	        Client illegaUser = new Client (0,"John", "Doe", "john.doe@ensta.fr", LocalDate.of(1995, 07 , 14));
	       // Then
	       assertFalse(Client.isLegal(illegaUser));
	   }


}
