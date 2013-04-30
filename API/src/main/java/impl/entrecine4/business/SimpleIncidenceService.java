package impl.entrecine4.business;

import impl.entrecine4.persistence.SimplePersistenceFactory;

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
		try {
			return dao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.IncidenceService#findById(java.lang.Long)
	 */
	@Override
	public Incidence findById(Long id) {
		try {
			return dao.get(id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.IncidenceService#saveIncidence(com.entrecine4.model.Incidence)
	 */
	@Override
	public void saveIncidence(Incidence incidence) {
		try {
			dao.save(incidence);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.IncidenceService#updateIncidence(com.entrecine4.model.Incidence)
	 */
	@Override
	public void updateIncidence(Incidence incidence) {
		try {
			dao.update(incidence);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.IncidenceService#deleteIncidence(com.entrecine4.model.Incidence)
	 */
	@Override
	public void deleteIncidence(Incidence incidence) {
		try {
			dao.delete(incidence);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
