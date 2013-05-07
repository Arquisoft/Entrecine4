package test.entrecine.business;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import models.Incidence;

import org.junit.Test;

import com.entrecine4.business.IncidenceService;
import com.entrecine4.infraestructure.Factories;

public class IncidenceServiceTest 
{
	private IncidenceService service = Factories.services.createIncidenceService();
	 
	/**
	 * Method that tests the recovering of all the incidences stored in the database
	 */
	@Test
	public void testGetAllIncidences() 
	{
		List<Incidence> inc = service.getIncidences();
		
		assertEquals(27, inc.get(0).getId());
	}
	
	/**
	 * Method that tests the recovering of an incidence using its identification number
	 */
	@Test
	public void testFindByID()
	{
		Incidence inc = service.findById(27L);
		
		assertEquals("instalando nuevo proyector", inc.getDescription());
		assertEquals(Date.valueOf("2013-05-04"), inc.getDay());
		assertEquals(20, inc.getSessionId());
		assertEquals(3, inc.getRoomId());
	}
	
	/**
	 * Method that tests the saving of an incidence into the database, checks if the
	 * saving was correct, and finally deletes it from the database
	 */
	@Test
	public void testSaveDeleteIncidence()
	{
		Incidence incidence = new Incidence(0, 4, Date.valueOf("2013-05-04"),
				2, "pintando sala");
		service.saveIncidence(incidence);
		
		List<Incidence> inc = service.getIncidences();
		Long id = inc.get(inc.size()-1).getId();
		
		Incidence savedIncidence = service.findById(id);
		
		assertEquals(incidence.getRoomId(), savedIncidence.getRoomId());
		assertEquals(incidence.getDay(), savedIncidence.getDay());
		assertEquals(incidence.getDescription(), savedIncidence.getDescription());
		assertEquals(incidence.getSessionId(), savedIncidence.getSessionId());
		
		service.deleteIncidence(savedIncidence);
		
		Incidence deletedIncidence = service.findById(id);
		assertEquals(null, deletedIncidence);
	}
	
	/**
	 * Method that tests the updating of incidence's data, checks if the updating
	 * was correct and finally updates it back to the initial data
	 */
	@Test
	public void testUpdateIncidence()
	{
		Incidence incidence = service.findById(27L);
		
		assertEquals("instalando nuevo proyector", incidence.getDescription());
		assertEquals(Date.valueOf("2013-05-04"), incidence.getDay());
		assertEquals(20, incidence.getSessionId());
		assertEquals(3, incidence.getRoomId());
		
		incidence.setDescription("desinstalando butacas");
		incidence.setRoomId(1);
		
		service.updateIncidence(incidence);
		Incidence updatedIncidence = service.findById(27L);
		
		assertEquals(incidence.getDescription(), updatedIncidence.getDescription());
		assertEquals(incidence.getRoomId(), updatedIncidence.getRoomId());
		
		incidence.setDescription("instalando nuevo proyector");
		incidence.setRoomId(3);
		service.updateIncidence(incidence);
	}

}
