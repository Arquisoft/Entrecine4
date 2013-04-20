package com.entrecine4.model;

//TODO: No javadoc yet
public class Room
{
	private long id;
	private int rows;
	private int columns;
	
	//TODO: Constructor using all fields, or use the default constructor without parameters and set the variable values with setters.
	
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