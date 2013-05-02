package impl.entrecine4.business;

import com.entrecine4.infraestructure.Jdbc;
import impl.entrecine4.persistence.SimplePersistenceFactory;

import java.sql.Connection;
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
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            return dao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.RoomService#findById(java.lang.Long)
	 */
	@Override
	public Room findById(Long id) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            return dao.get(id);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.RoomService#saveRoom(com.entrecine4.model.Room)
	 */
	@Override
	public void saveRoom(Room room) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.save(room);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.RoomService#updateRoom(com.entrecine4.model.Room)
	 */
	@Override
	public void updateRoom(Room room) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.update(room);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.RoomService#deleteRoom(com.entrecine4.model.Room)
	 */
	@Override
	public void deleteRoom(Room room) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.delete(room);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}


}
