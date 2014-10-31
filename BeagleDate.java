/**	BowersDate.java  William Bowers (c) 2007, 2008, 2009, 2010
	Display date and time using printf
	SOLUTION FILE
	Modified by James Beagle
	March 2010
*/

import java.text.*;	// for Date
import java.util.*;	// for Date

public class BeagleDate	{

	static Date now = new Date();

	public static void main(String [] args)	{
		System.out.printf("\n\n  James Beagle\n");
		System.out.printf("  The date and time are...\n");
		printfDate();
		printfTime();
	}	// end main METHOD

	public static void printfDate()	{
		System.out.printf("  %tA, %tB %te, %tY", now, now, now, now);
	}	// end getPrintfDate METHOD

	public static void printfTime()	{
		System.out.printf("  %tl:%tM:%tS%tp\n\n", now, now, now, now);
	}	// end getPrintfDate METHOD

}	// end BeagleDate CLASS