package epf;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.epf.rentmanager.dao.ClientDao;
import com.epf.rentmanager.dao.VehicleDao;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.VehicleService;

public class VehicleServiceTest {
	
	
		
		@RunWith(MockitoJUnitRunner.class)
		public class vehicleServiceTest {
		   @InjectMocks
		   private VehicleService vehicleService;

		   @Mock
		   private VehicleDao vehicleDao;

		   @Test
		   void findAll_should_fail_when_dao_throws_exception() throws DaoException {
		       // When
		       when(this.vehicleDao.findAll()).thenThrow(DaoException.class);

		       // Then
		       assertThrows(ServiceException.class, ()-> vehicleService.findAll());
		   }
		}


	}

