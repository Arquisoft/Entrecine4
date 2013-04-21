package com.entrecine4.model;

public class Purchase {

	public long id, user_id, movie_id;
	public String ticket_id_code;
	public int paid, collected; // 0 if false, 1 if true

	/**
	 * constructor using all the fields
	 * @param user_id
	 * @param movie_id
	 * @param ticket_id_code
	 * @param paid
	 * @param collected
	 */
	

	/**
	 * Constructor without parameters
	 */
	public Purchase() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	public Purchase(long id, long user_id, long movie_id,
			String ticket_id_code, int paid, int collected) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.movie_id = movie_id;
		this.ticket_id_code = ticket_id_code;
		this.paid = paid;
		this.collected = collected;
	}

	/**
	 * @return the user_id
	 */
	public long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the movie_id
	 */
	public long getMovie_id() {
		return movie_id;
	}

	/**
	 * @param movie_id
	 *            the movie_id to set
	 */
	public void setMovie_id(long movie_id) {
		this.movie_id = movie_id;
	}

	/**
	 * @return the ticket_id_code
	 */
	public String getTicket_id_code() {
		return ticket_id_code;
	}

	/**
	 * @param ticket_id_code
	 *            the ticket_id_code to set
	 */
	public void setTicket_id_code(String ticket_id_code) {
		this.ticket_id_code = ticket_id_code;
	}

	/**
	 * @return the paid
	 */
	public int getPaid() {
		return paid;
	}

	/**
	 * @param paid
	 *            the paid to set
	 */
	public void setPaid(int paid) {
		this.paid = paid;
	}

	/**
	 * @return the collected
	 */
	public int getCollected() {
		return collected;
	}

	/**
	 * @param collected
	 *            the collected to set
	 */
	public void setCollected(int collected) {
		this.collected = collected;
	}

}
