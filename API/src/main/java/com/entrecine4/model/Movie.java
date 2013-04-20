package com.entrecine4.model;

//TODO:No javadoc & JUnit yet
public class Movie
{
	private long id;
	private String name;
	private String synopsis;
	private String imgPath;
	private double morningPrice;
	private double dailyPrice;
	private double nightPrice;
	
	public Movie()
	{
	}
	
	public Movie(long id, String name, String synopsis, String imgPath,
			double morningPrice, double dailyPrice, double nightPrice)
	{
		this.id = id;
		this.name = name;
		this.synopsis = synopsis;
		this.imgPath = imgPath;
		this.morningPrice = morningPrice;
		this.dailyPrice = dailyPrice;
		this.nightPrice = nightPrice;
	}

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