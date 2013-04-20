package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entrecine4.model.Room;
import com.entrecine4.persistence.RoomDAO;

//TODO:No javadoc & JUnit yet
public class RoomJdbcDAO implements RoomDAO
{
	//Variables to use in the class and this way don't be defining all the time the same variables in each method
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;	
	
	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#get(long)
	 */
	@Override
	public Room get(long roomId) throws SQLException
	{
		Room result=null;
		
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, roomId);
		
		rs=pst.executeQuery();		
		if(rs.next())
		{
			result=new Room();
			result.setId(roomId);
			result.setRows(rs.getInt("FILAS"));
			result.setColumns(rs.getInt("COLUMNAS"));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#getAll()
	 */
	@Override
	public List<Room> getAll() throws SQLException 
	{
		List<Room> result=new ArrayList<Room>();
		
		pst=connection.prepareStatement("SQL using a .properties file");
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Room room=new Room();
			room.setId(rs.getLong("ID_SALA"));
			room.setRows(rs.getInt("FILAS"));
			room.setColumns(rs.getInt("COLUMNAS"));
			
			result.add(room);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#save(com.entrecine4.model.Room)
	 */
	@Override
	public void save(Room room) throws SQLException
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setInt(1, room.getRows());
		pst.setInt(2, room.getColumns());
		
		pst.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#update(com.entrecine4.model.Room)
	 */
	@Override
	public void update(Room room) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setInt(1, room.getRows());
		pst.setInt(2, room.getColumns());
		pst.setLong(3,room.getId());
		
		pst.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.RoomDAO#delete(com.entrecine4.model.Room)
	 */
	@Override
	public void delete(Room room) throws SQLException
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, room.getId());
		
		pst.executeUpdate();
	}
}