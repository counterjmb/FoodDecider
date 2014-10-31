/**	BowersHeading.java  William Bowers (c) 2007, 2008, 2009, 2010
	Display various on-demand information
	SOLUTION FILE
	Modified by James Beagle
	March 2010

*/

import java.util.*;	// for Date class
import java.text.*;	// for Date & DateFormat class

public class BeagleHeading	{
	private static String firstName = "James";
	private static String lastName = "Beagle";

	// Assignment requirement to add null constructor
	public BeagleHeading() { }

	public static void main(String [] args)	{
		getHeading("Program accessed at: " + getTime());
	}	// end main

	public static void getHeading(String x)	{
		String fromAssignment = x;
		System.out.println("\n\n  " + getName());
		System.out.println("  " + fromAssignment);
		System.out.println("  " + getDate());
		System.out.println();
	}	// end getHeading()

	public static String getName()	{
		return getFirstName() + " " + getLastName();
	}

	public static String getFirstName()	{
		return firstName;
	}	// end getFirstName()

	public static String getLastName()	{
		return lastName;
	}	// end getLastName()

	public static String getDate()	{
		String date;
		Date now = new Date();
		DateFormat longDate = DateFormat.getDateInstance(DateFormat.LONG);
		return date = longDate.format(now);
	}	// end getDate()

	public static String getTime()	{
		String time;
		Date nowTime = new Date();
		DateFormat longTime = DateFormat.getTimeInstance(DateFormat.SHORT);
		return time = longTime.format(nowTime);
	}	// end getTime()

}	// end BeagleHeading

