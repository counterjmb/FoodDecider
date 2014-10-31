/*Restaurant.java
James Beagle
Final Project for Java 2 1531 SN
Novemeber 2010
Based off of Customer M in class project
*/


public class Restaurant
{
	private String name;
	private String price;
	private String type;
	private String location;

	public Restaurant()
	{
		name = "";
		price = "";
		type = "";
		location = "";
	}

	public Restaurant(String name, String price, String type, String location)
	{
		this.name = name;
		this.price = price;
		this.type = type;
		this.location = location;
	}

	public void setName(String name)
	{	this.name = name;		}

	public String getName()
	{	return name;		}

	public void setPrice(String price)
	{	this.price = price;		}

	public String getPrice()
	{	return price;		}

	public void setType(String type)
	{	this.type = type;		}

	public String getType()
	{	return type;		}

	public void setLocation(String location)
	{	this.location = location; 			}

	public String getLocation()
	{ return location;		}

	public boolean equals(Object object)
	{
		if (object instanceof Restaurant)
		{
			Restaurant Restaurant2 = (Restaurant) object;
			if(this.name.equals(Restaurant2.getName()))
			{
				return true;
			}
		}
		return false;
	}
}