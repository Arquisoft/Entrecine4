package models;

public class Room
{
	private long id;
	private int rows;
	private int columns;
	
	/**
	 * Constructor without parameters
	 */
	public Room()
	{
	}
	
	/**
	 * Constructor with parameters that uses all the fields
	 * 
	 * @param id Room's identification number
	 * @param rows Number of rows of seats
	 * @param columns Number of columns of seats
	 */
	public Room(long id, int rows, int columns) {
		super();
		this.id = id;
		this.rows = rows;
		this.columns = columns;
	}

	/**
	 * Getter for the room's identification number
	 * 
	 * @return The room's identification number
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * Setter for the room's identification number
	 * 
	 * @param id The new room's identification number
	 */
	public void setId(long id) 
	{
		this.id = id;
	}
	
	/**
	 * Getter for the number of rows of seats
	 * 
	 * @return The number of rows
	 */
	public int getRows() 
	{
		return rows;
	}
	
	/**
	 * Getter for the number of seat's rows of the room
	 * 
	 * @param rows The new number of rows
	 */
	public void setRows(int rows) 
	{
		this.rows = rows;
	}
	
	/**
	 * Getter for the number of columns of seats
	 * 
	 * @return The number of columns
	 */
	public int getColumns() 
	{
		return columns;
	}
	
	/**
	 * Setter for the number of columns of seats
	 * 
	 * @param columns The new number of columns
	 */
	public void setColumns(int columns) 
	{
		this.columns = columns;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.id;
	}
}