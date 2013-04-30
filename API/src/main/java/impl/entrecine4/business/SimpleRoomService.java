package impl.entrecine4.business;

import impl.entrecine4.persistence.SimplePersistenceFactory;

import java.sql.SQLException;
import java.util.List;

import models.Room;

import com.entrecine4.business.RoomService;
import com.entrecine4.persistence.RoomDAO;

public class SimpleRoomService implements RoomService {
	
	private RoomDAO dao = new SimplePersistenceFactory()
	.createRoomDAO();

	/* (non-Javadoc)
	 * @see com.entrecine4.business.RoomService#getRooms()
	 */
	@Override
	public List<Room> getRooms() {
		try {
			return dao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.RoomService#findById(java.lang.Long)
	 */
	@Override
	public Room findById(Long id) {
		try {
			return dao.get(id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.RoomService#saveRoom(com.entrecine4.model.Room)
	 */
	@Override
	public void saveRoom(Room room) {
		try {
			dao.save(room);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.RoomService#updateRoom(com.entrecine4.model.Room)
	 */
	@Override
	public void updateRoom(Room room) {
		try {
			dao.update(room);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.RoomService#deleteRoom(com.entrecine4.model.Room)
	 */
	@Override
	public void deleteRoom(Room room) {
		try {
			dao.delete(room);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}


}
