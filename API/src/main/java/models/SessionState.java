package models;

import java.util.Date;

/**
 * Session model class, this class will also work as DTO
 * @author Arquisoft - Entrecine4
 *
 */
public class SessionState {
	
	private long roomId;
	private int row;
	private int column;
	private Date date;
	private long session;
	
	/**
	 * Constructor without parameters
	 */
	public SessionState() {}
	
	/**
	 * Constructor with all parameters
	 * @param roomId
	 * @param row
	 * @param column
	 * @param date
	 * @param session
	 */
	public SessionState(long roomId, int row, int column,
			Date date, long session) {
		this.roomId = roomId;
		this.row = row;
		this.column = column;
		this.date = date;
		this.session = session;
	}

	/**
	 * Getter for room's id
	 * @return the room_id
	 */
	public long getRoomId() {
		return roomId;
	}

	/**
	 * Setter for room's id
	 * @param room_id the room_id to set
	 */
	public void setRoomId(long room_id) {
		this.roomId = room_id;
	}

	/**
	 * Getter for row in use
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Setter for row in use
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Getter for column in use
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Setter for column in use
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * Getter for session's date
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter for session's date
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Getter for session
	 * @return the session
	 */
	public long getSession() {
		return session;
	}

	/**
	 * Setter for session
	 * @param session the session to set
	 */
	public void setSession(long session) {
		this.session = session;
	}
}