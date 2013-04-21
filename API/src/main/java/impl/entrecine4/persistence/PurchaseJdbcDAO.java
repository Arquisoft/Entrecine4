package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entrecine4.model.Purchase;
import com.entrecine4.persistence.PurchaseDAO;

public class PurchaseJdbcDAO implements PurchaseDAO {
	
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/*
	 * (non-Javadoc)
	 * @see com.entrecine4.persistence.PurchaseDAO#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection con) {
		this.connection = con;
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.entrecine4.persistence.PurchaseDAO#get(long)
	 */
	@Override
	public Purchase get(long ID) throws SQLException {
		Purchase result = null;

		pst = connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, ID);

		rs = pst.executeQuery();
		if (rs.next()) {
			result = new Purchase();
			result.setId(ID);
			result.setMovie_id(rs.getLong("ID_PELICULA"));
			result.setUser_id(rs.getLong("ID_USUARIO"));
			result.setTicket_id_code(rs.getString("CODIGO_IDENTIFICADOR_ENTRADA"));
			result.setPaid(rs.getInt("PAGADO"));
			result.setCollected(rs.getInt("RECOGIDO"));
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see com.entrecine4.persistence.PurchaseDAO#getAll()
	 */
	@Override
	public List<Purchase> getAll() throws SQLException {
		List<Purchase> result = new ArrayList<Purchase>();

		pst = connection.prepareStatement("SQL using a .properties file");

		rs = pst.executeQuery();

		while (rs.next()) {
			Purchase p = new Purchase();
			p.setId(rs.getLong("ID"));
			p.setMovie_id(rs.getLong("ID_PELICULA"));
			p.setUser_id(rs.getLong("ID_USUARIO"));
			p.setTicket_id_code(rs.getString("CODIGO_IDENTIFICADOR_ENTRADA"));
			p.setPaid(rs.getInt("PAGADO"));
			p.setCollected(rs.getInt("RECOGIDO"));

			// Finally we add the temporal purchase to the list that will be
			// returned.
			result.add(p);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see com.entrecine4.persistence.PurchaseDAO#save(com.entrecine4.model.Purchase)
	 */
	@Override
	public void save(Purchase purchase) throws SQLException {
		pst = connection.prepareStatement("SQL using a .properties file");

		pst.setLong(1, purchase.getUser_id());
		pst.setLong(2, purchase.getMovie_id());
		pst.setString(3, purchase.getTicket_id_code());
		pst.setInt(4, purchase.getPaid());
		pst.setInt(5, purchase.getCollected());

		pst.executeUpdate();
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.entrecine4.persistence.PurchaseDAO#update(com.entrecine4.model.Purchase)
	 */
	@Override
	public void update(Purchase purchase) throws SQLException {
		pst = connection.prepareStatement("SQL using a .properties file");

		pst.setLong(1, purchase.getUser_id());
		pst.setLong(2, purchase.getMovie_id());
		pst.setString(3, purchase.getTicket_id_code());
		pst.setInt(4, purchase.getPaid());
		pst.setInt(5, purchase.getCollected());
		pst.setLong(6, purchase.getId());

		pst.executeUpdate();
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.entrecine4.persistence.PurchaseDAO#delete(com.entrecine4.model.Purchase)
	 */
	@Override
	public void delete(Purchase purchase) throws SQLException {
		pst = connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, purchase.getId());

		pst.executeUpdate();
		
	}

}
