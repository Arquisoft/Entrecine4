package models;

import com.entrecine4.business.SessionStateService;
import com.entrecine4.infraestructure.Factories;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Herminio
 * Date: 4/05/13
 * Time: 1:01
 */
public class SessionStateHelper {
    private SessionStateService sss;

    public SessionStateHelper() {
        sss = Factories.services.createSessionStateService();
    }

    public boolean checkFreeSeat(long session, long room, int row, int column) {
        return sss.checkFreeSeat(session, room, row, column);
    }
}
