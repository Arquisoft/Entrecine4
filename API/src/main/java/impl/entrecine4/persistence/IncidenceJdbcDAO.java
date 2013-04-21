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

//TODO:No JUnit yet
public class IncidenceJdbcDAO implements IncidenceDAO
{
	//Variables to use in the class and this way don't be defining all the time the same variables in each method
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	@Override
	public Incidence get() throws SQLException{
		// TODO:Not implemented yet 
		return null;
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
			tempIncidence.setRoomId(rs.getLong("ID_SALA"));
			tempIncidence.setDay(rs.getDate("DIA"));
			//TODO:How are we going to save the session in the database?? tempIncidence.setSession()
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
		//TODO:How to save session
		pst.setString(4, incidence.getDescription());
		
		pst.executeUpdate();
	}

	@Override
	public void update(Incidence incidence) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, incidence.getRoomId());
		pst.setDate(2, (Date) incidence.getDay());
		//TODO:How to update session
		pst.setString(4, incidence.getDescription());
		
		pst.executeUpdate();
	}

	@Override
	public void delete(Incidence incidence) throws SQLException
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		//TODO:How to select an incidence from the database
		
		pst.executeUpdate();
	}

}