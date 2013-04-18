package com.entrecine4.model;

//TODO:This is a sample implementation of a DTO, there's no javadoc until this is a final implementation
public class Movie
{
	private long id;
	private String name;
	private String synopsis;
	private String imgPath;
	private double morningPrice;
	private double dailyPrice;
	private double nightPrice;
	
	//TODO: Constructor using all fields, or use the default constructor without parameters and set the variable values with setters. I will use setters in this sample
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSynopsis() 
	{
		return synopsis;
	}
	
	public void setSynopsis(String synopsis)
	{
		this.synopsis = synopsis;
	}
	
	public String getImgPath() 
	{
		return imgPath;
	}
	
	public void setImgPath(String imgPath)
	{
		this.imgPath = imgPath;
	}
	
	public double getMorningPrice()
	{
		return morningPrice;
	}
	
	public void setMorningPrice(double morningPrice) 
	{
		this.morningPrice = morningPrice;
	}
	
	public double getDailyPrice() 
	{
		return dailyPrice;
	}
	
	public void setDailyPrice(double dailyPrice) 
	{
		this.dailyPrice = dailyPrice;
	}
	
	public double getNightPrice() 
	{
		return nightPrice;
	}
	
	public void setNightPrice(double nightPrice)
	{
		this.nightPrice = nightPrice;
	}
}