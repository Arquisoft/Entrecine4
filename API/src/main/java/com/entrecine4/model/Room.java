package com.entrecine4.model;

//TODO:No javadoc & JUnit yet
public class Room
{
	private long id;
	private int rows;
	private int columns;
	
	public Room()
	{
	}
	
	public Room(long id, int rows, int columns) {
		super();
		this.id = id;
		this.rows = rows;
		this.columns = columns;
	}

	public long getId()
	{
		return id;
	}
	
	public void setId(long id) 
	{
		this.id = id;
	}
	
	public int getRows() 
	{
		return rows;
	}
	
	public void setRows(int rows) 
	{
		this.rows = rows;
	}
	
	public int getColumns() 
	{
		return columns;
	}
	
	public void setColumns(int columns) 
	{
		this.columns = columns;
	}
}