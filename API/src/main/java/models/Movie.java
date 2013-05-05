package models;

public class Movie
{
	private long id;
	private String name;
	private String synopsis;
	private String imgPath;
	private double morningPrice;
	private double dailyPrice;
	private double nightPrice;
	private String genre;
	
	/**
	 * Constructor without parameters
	 */
	public Movie()
	{
	}
	
	/**
	 * Constructor with parameters using all the fields
	 * 
	 * @param id Movie's identification number
	 * @param name Movie's name
	 * @param synopsis Movie's description
	 * @param imgPath Path of the movie's image to show in the billboard
	 * @param morningPrice Price of the ticket in the morning
	 * @param dailyPrice Price of the ticket in the afternoon
	 * @param nightPrice Price of the ticket in the night
	 * @param genre Movie's genre
	 */
	public Movie(long id, String name, String synopsis, String imgPath,
			double morningPrice, double dailyPrice, double nightPrice, String genre)
	{
		this.id = id;
		this.name = name;
		this.synopsis = synopsis;
		this.imgPath = imgPath;
		this.morningPrice = morningPrice;
		this.dailyPrice = dailyPrice;
		this.nightPrice = nightPrice;
		this.genre=genre;
	}

	/**
	 * Getter for the movie's identification number
	 * 
	 * @return The movie's identification number
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * Setter for the movie's identification number
	 * 
	 * @param id The new identification number
	 */
	public void setId(long id)
	{
		this.id = id;
	}
	
	/**
	 * Getter for the movie's name
	 * 
	 * @return The movie's title
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Setter for the movie's name
	 * 
	 * @param name New title for the movie
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Getter for the movie's description
	 * 
	 * @return The movie's description
	 */
	public String getSynopsis() 
	{
		return synopsis;
	}
	
	/**
	 * Setter for the movie's description
	 * 
	 * @param synopsis The new description
	 */
	public void setSynopsis(String synopsis)
	{
		this.synopsis = synopsis;
	}
	
	/**
	 * Getter for the path of the movie's image
	 * 
	 * @return The path of the image
	 */
	public String getImgPath() 
	{
		return imgPath;
	}
	
	/**
	 * Setter for the path of the movie's image
	 * 
	 * @param imgPath The new path of the movie's image
	 */
	public void setImgPath(String imgPath)
	{
		this.imgPath = imgPath;
	}
	
	/**
	 * Getter for the morning price of the tickets
	 * 
	 * @return The morning price
	 */
	public double getMorningPrice()
	{
		return morningPrice;
	}
	
	/**
	 * Setter to change the morning price of the tickets
	 * 
	 * @param morningPrice The new price of the ticket
	 */
	public void setMorningPrice(double morningPrice) 
	{
		this.morningPrice = morningPrice;
	}
	
	/**
	 * Getter for the daily price of the tickets
	 * 
	 * @return The daily price
	 */
	public double getDailyPrice() 
	{
		return dailyPrice;
	}
	
	/**
	 * Setter to change the daily price of the tickets
	 * 
	 * @param dailyPrice The new price
	 */
	public void setDailyPrice(double dailyPrice) 
	{
		this.dailyPrice = dailyPrice;
	}
	
	/**
	 * Getter for the night price of the tickets
	 * 
	 * @return The night price of the ticket
	 */
	public double getNightPrice() 
	{
		return nightPrice;
	}
	
	/**
	 * Setter to change the night price of the tickets
	 * 
	 * @param nightPrice The new price
	 */
	public void setNightPrice(double nightPrice)
	{
		this.nightPrice = nightPrice;
	}

	/**
	 * Getter for the movie's genre
	 * 
	 * @return The movie's genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Setter for the movie's genre
	 * 
	 * @param genre The new movie's genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
}