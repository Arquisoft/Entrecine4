package impl.entrecine4.business;

import impl.entrecine4.persistence.SimplePersistenceFactory;

import java.sql.SQLException;
import java.util.List;

import com.entrecine4.business.RoomService;
import com.entrecine4.model.Room;
import com.entrecine4.persistence.RoomDAO;

public class SimpleRoomService implements RoomService {
	
	private RoomDAO dao = new SimplePersistenceFactory()
	.createRoomDAO();

	@Override
	public List<Room> getRooms() {
		try {
			return dao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public Room findById(Long id) {
		try {
			return dao.get(id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void saveRoom(Room room) {
		try {
			dao.save(room);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void updateRoom(Room room) {
		try {
			dao.update(room);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteRoom(Room room) {
		try {
			dao.delete(room);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}


}
