package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entrecine4.model.Incidence;
import com.entrecine4.persistence.IncidenceDAO;

public class IncidenceJdbcDAO implements IncidenceDAO
{
	//Variables to use in the class and this way don't be defining all the time the same variables in each method
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.IncidenceDAO#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection connection) 
	{
		this.connection=connection;
	}

	@Override
	public Incidence get(long incidenceId) throws SQLException
	{
		Incidence result=null;
		
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, incidenceId);
		
		rs=pst.executeQuery();
		
		if(rs.next())
		{
			result=new Incidence();
			result.setId(incidenceId);
			result.setRoomId(rs.getLong("ID_SALA"));
			result.setDay(rs.getDate("DIA"));
			result.setSessionId(rs.getLong("SESION"));
			result.setDescription(rs.getString("MOTIVO"));
		}
		
		return result;
	}

	@Override
	public List<Incidence> getAll() throws SQLException 
	{
		List<Incidence> result=new ArrayList<Incidence>();
		
		pst=connection.prepareStatement("SQL using a .properties file");
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Incidence tempIncidence=new Incidence();
			tempIncidence.setId(rs.getLong("ID"));
			tempIncidence.setRoomId(rs.getLong("ID_SALA"));
			tempIncidence.setDay(rs.getDate("DIA"));
			tempIncidence.setSessionId(rs.getLong("SESION"));
			tempIncidence.setDescription(rs.getString("MOTIVO"));
			
			result.add(tempIncidence);
		}
		
		return result;
	}

	@Override
	public void save(Incidence incidence) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, incidence.getRoomId());
		pst.setDate(2, (Date) incidence.getDay());
		pst.setLong(3, incidence.getSessionId());
		pst.setString(4, incidence.getDescription());
		
		pst.executeUpdate();
	}

	@Override
	public void update(Incidence incidence) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, incidence.getRoomId());
		pst.setDate(2, (Date) incidence.getDay());
		pst.setLong(3, incidence.getSessionId());
		pst.setString(4, incidence.getDescription());
		pst.setLong(5, incidence.getId());
		
		pst.executeUpdate();
	}

	@Override
	public void delete(Incidence incidence) throws SQLException
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, incidence.getId());
		
		pst.executeUpdate();
	}

}