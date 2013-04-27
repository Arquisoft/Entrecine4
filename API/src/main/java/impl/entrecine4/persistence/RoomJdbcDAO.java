package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.infraestructure.PropertiesReader;
import com.entrecine4.model.Room;
import com.entrecine4.persistence.RoomDAO;

public class RoomJdbcDAO implements RoomDAO
{
	//Variables to use in the class and this way don't be defining all the time the same variables in each method
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;	
	
	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection connection)
	{
		this.connection=connection;
		PropertiesReader.setFile("sql.properties");
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#get(long)
	 */
	@Override
	public Room get(long roomId) throws SQLException
	{
		Room result=null;
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_ROOM_BY_ID"));
		pst.setLong(1, roomId);
		
		rs=pst.executeQuery();		
		if(rs.next())
		{
			result=new Room();
			result.setId(roomId);
			result.setRows(rs.getInt("FILAS"));
			result.setColumns(rs.getInt("COLUMNAS"));
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#getAll()
	 */
	@Override
	public List<Room> getAll() throws SQLException 
	{
		List<Room> result=new ArrayList<Room>();
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_ALL_ROOMS"));
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Room room=new Room();
			room.setId(rs.getLong("ID_SALA"));
			room.setRows(rs.getInt("FILAS"));
			room.setColumns(rs.getInt("COLUMNAS"));
			
			result.add(room);
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#save(com.entrecine4.model.Room)
	 */
	@Override
	public void save(Room room) throws SQLException
	{
		pst=connection.prepareStatement(PropertiesReader.get("INSERT_ROOM"));
		pst.setInt(1, room.getRows());
		pst.setInt(2, room.getColumns());
		
		pst.executeUpdate();
		
		Jdbc.close(pst);
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#update(com.entrecine4.model.Room)
	 */
	@Override
	public void update(Room room) throws SQLException 
	{
		pst=connection.prepareStatement(PropertiesReader.get("UPDATE_ROOM"));
		pst.setInt(1, room.getRows());
		pst.setInt(2, room.getColumns());
		pst.setLong(3,room.getId());
		
		pst.executeUpdate();
		
		Jdbc.close(pst);
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#delete(com.entrecine4.model.Room)
	 */
	@Override
	public void delete(Room room) throws SQLException
	{
		pst=connection.prepareStatement(PropertiesReader.get("DELETE_ROOM"));
		pst.setLong(1, room.getId());
		
		pst.executeUpdate();
		
		Jdbc.close(pst);
	}
}