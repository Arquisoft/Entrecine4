package impl.entrecine4.business;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.infraestructure.Log;

import impl.entrecine4.persistence.SimplePersistenceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Incidence;

import com.entrecine4.business.IncidenceService;
import com.entrecine4.persistence.IncidenceDAO;

public class SimpleIncidenceService implements IncidenceService {

	private IncidenceDAO dao = new SimplePersistenceFactory()
			.createIncidenceDAO();

	/* (non-Javadoc)
	 * @see com.entrecine4.business.IncidenceService#getIncidences()
	 */
	@Override
	public List<Incidence> getIncidences()  {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            return dao.getAll();
        } catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.IncidenceService#findById(java.lang.Long)
	 */
	@Override
	public Incidence findById(Long id) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            return dao.get(id);
        } catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.IncidenceService#saveIncidence(com.entrecine4.model.Incidence)
	 */
	@Override
	public void saveIncidence(Incidence incidence) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.save(incidence);
        } catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.IncidenceService#updateIncidence(com.entrecine4.model.Incidence)
	 */
	@Override
	public void updateIncidence(Incidence incidence) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.update(incidence);
        } catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.IncidenceService#deleteIncidence(com.entrecine4.model.Incidence)
	 */
	@Override
	public void deleteIncidence(Incidence incidence) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.delete(incidence);
        } catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

}
