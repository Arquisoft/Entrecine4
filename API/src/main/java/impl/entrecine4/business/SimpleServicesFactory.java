package impl.entrecine4.business;

import com.entrecine4.business.IncidenceService;
import com.entrecine4.business.MoviesService;
import com.entrecine4.business.ReservationService;
import com.entrecine4.business.RoomService;
import com.entrecine4.business.ServicesFactory;
import com.entrecine4.business.StaffService;
import com.entrecine4.infraestructure.UserService;
import impl.entrecine4.infraestructure.SimpleUserService;

public class SimpleServicesFactory implements ServicesFactory {

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ServicesFactory#createIncidenceService()
	 */
	@Override
	public IncidenceService createIncidenceService() {
		return new SimpleIncidenceService();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ServicesFactory#createMoviesService()
	 */
	@Override
	public MoviesService createMoviesService() {
		return new SimpleMoviesService();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ServicesFactory#createReservationService()
	 */
	@Override
	public ReservationService createReservationService() {
		return new SimpleReservationService();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ServicesFactory#createRoomService()
	 */
	@Override
	public RoomService createRoomService() {
		return new SimpleRoomService();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ServicesFactory#createStaffService()
	 */
	@Override
	public StaffService createStaffService() {
		return new SimpleStaffService();
	}

    /* (non-Javadoc)
     * @see com.entrecine4.business.ServicesFactory#createUserService()
     */
    @Override
    public UserService createUserService() {
        return new SimpleUserService();
    }
}
