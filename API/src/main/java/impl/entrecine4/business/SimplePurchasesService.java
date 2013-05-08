package impl.entrecine4.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Purchase;

import com.entrecine4.business.PurchasesService;
import com.entrecine4.infraestructure.Factories;
import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.infraestructure.Log;
import com.entrecine4.persistence.PurchaseDAO;

public class SimplePurchasesService implements PurchasesService 
{
	private PurchaseDAO dao=Factories.persistence.createPurchaseDAO();
	
	/* (non-Javadoc)
	 * @see com.entrecine4.business.PurchasesService#getPurchases()
	 */
	@Override
	public List<Purchase> getPurchases() 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.getAll();
		} catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.PurchasesService#findPurchaseById(long)
	 */
	@Override
	public Purchase findPurchaseById(long id) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.get(id);
		} catch (SQLException e) 
		{
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.PurchasesService#findPurchasesUser(long)
	 */
	@Override
	public List<Purchase> findPurchasesUser(long userId) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.getByUser(userId);
		} catch (SQLException e) 
		{
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.PurchasesService#findByTicketCode(java.lang.String)
	 */
	@Override
	public Purchase findByTicketCode(String ticketCode) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.get(ticketCode);
		} catch (SQLException e) 
		{
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.PurchasesService#savePurchase(models.Purchase)
	 */
	@Override
	public void savePurchase(Purchase purchase) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			dao.save(purchase);
		} catch (SQLException e) 
		{
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.PurchasesService#updatePurchase(models.Purchase)
	 */
	@Override
	public void updatePurchase(Purchase purchase) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			dao.update(purchase);
		} catch (SQLException e) 
		{
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.PurchasesService#deletePurchae(models.Purchase)
	 */
	@Override
	public void deletePurchase(Purchase purchase) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			dao.delete(purchase);
		} catch (SQLException e) 
		{
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}
}