/*********************************************
*FoodDecider.java							 *
*James Beagle								 *
*Final Projext for Java 2 1531 SN			 *
*Novemeber 2010								 *
*Based off of xustomer M in class projext	 *
**********************************************/
/*********************************************
 *Was meant to be a GUI projext but xould not*
 *interlaxe the GUI with the xml application *
 *in time. Will work on it between classes   *
 *********************************************/
import java.util.*;
import java.text.*;
import java.io.*;
import javax.xml.stream.*;

public class FoodDecider	{


	private static RestaurantXMLFile restaurantDAO = null;
	private static Scanner sc = null;

	public static void main(String args[]) throws IOException {

		BeagleHeading.getHeading("Final Application 1.0");

		System.out.println("  Welcome to the Food Decider Application\n");


		// set the class variables
		restaurantDAO = new RestaurantXMLFile();
		sc = new Scanner(System.in);

		// display command menu
		displayMenu();

		// menu operation performance
		String action = "";
		while (!action.equalsIgnoreCase("exit"))	{
			// get the input from the user
			action = Validator.getString(sc,
				"  Enter Option or type Menu for more options: ");
			System.out.println();

			if (action.equalsIgnoreCase("list"))
				displayAllRestaurants();
			else if (action.equalsIgnoreCase("types"))
				displayType();
			else if (action.equalsIgnoreCase("add"))
				addRestaurant();
			else if (action.equalsIgnoreCase("Delete"))
				deleteRestaurant();
			/*else if (action.equalsIgnoreCase("Restaurants"))
				displayTypesVsRestaurant();*/
			else if (action.equalsIgnoreCase("Menu"))
				displayMenu();
			else if (action.equalsIgnoreCase("exit")){
				System.out.println("  Thank you for using the Food Decider. Good Bye!\n");
				System.out.printf("  Program ended by user on");
				BeagleDate.printfDate();
				BeagleDate.printfTime();}
			else
				System.out.println("  Error! Not a valid command.\n");
		}	// end WHILE
		System.exit(0);
	}	// end MAIN

	public static void displayMenu()		{
		System.out.println("  Menu:");
		System.out.println("   <Add> a restaurant");
		System.out.println("   <List> all restaurants");
		//System.out.println("   <Restaurants> vs types list");
		System.out.println("   List <types> of restaurants");
		System.out.println("   <Delete> a restaurant");
		System.out.println("   <Menu> - shows this menu");
		System.out.println("   <Exit> the program\n");
	}	// end displayMenu METHOD

	public static void displayAllRestaurants()	{
		System.out.println("  Restaurant List\n");

		ArrayList<Restaurant> restaurants = restaurantDAO.getRestaurant();
		Restaurant x = null;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < restaurants.size(); i++)	{
			x = restaurants.get(i);
			sb.append	(
				StringUtils.padWithSpaces("  " +
					x.getName(), 25) +
				StringUtils.padWithSpaces(
					x.getPrice(), 10) +
				StringUtils.padWithSpaces(
					x.getType(), 10) +
				StringUtils.padWithSpaces(
					x.getLocation(), 20) +"\n");	// end sb.append METHOD
		}	// end FOR

		System.out.println(sb.toString());
	}	// end displayAllRestaurants METHOD

	public static void displayType()	{
				System.out.println("  Types List\n");

		ArrayList<Restaurant> types = restaurantDAO.getRestaurant();
		Restaurant x = null;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < types.size(); i++)	{
			x = types.get(i);
			sb.append	(StringUtils.padWithSpaces("  " +
					x.getType(), 10) +"\n");	// end sb.append METHOD
		}	// end FOR

		System.out.println(sb.toString());
	}	// end displayAllTypes METHOD


	public static void addRestaurant()	{
		String name = Validator.getRequiredString(
			sc, "  Enter restaurant name: ");
		String price = Validator.getRequiredLine(
			sc, "  Enter price range of restaurant: ");
		String type = Validator.getRequiredLine(
			sc, "  Enter type of restaurant: ");
		String location = Validator.getRequiredLine(
			sc, "  Enter location: ");

		Restaurant restaurant = new Restaurant();
		restaurant.setName(name);
		restaurant.setPrice(price);
		restaurant.setType(type);
		restaurant.setLocation(location);
		restaurantDAO.addRestaurant(restaurant);

		System.out.println();
		System.out.println("  " + name + ", a " + type + " restaurant, was added to your list.\n");
	}	// end addxustomer METHOD

	public static void deleteRestaurant()		{
		String name = Validator.getRequiredString(sc,
			"  Enter restaurant name to delete: ");

		Restaurant x = restaurantDAO.getRestaurant(name);

		System.out.println();
		if(x != null)	{
			boolean isDeleted = restaurantDAO.deleteRestaurant(x);
			if (isDeleted)	{
				System.out.println("  " + x.getName()
					+ " was deleted from your list.\n");
			}	// end INNER IF
			else	{
				System.out.println("  Unable to delete: "
					+ x.getName() + " \n");
			}	// end INNER ELSE
		}	// end OUTER IF
		else	{
			System.out.println("  No restaurant matches that name.\n");
		}	// end OUTER ELSE

	}	// end deleteRestaurant METHOD


}	// end FoodDecider class