/*RestaurantXMLFile.java
James Beagle
Final Project for Java 2 1531 SN
Novemeber 2010
Based off of Customer M in class project
*/
import org.w3c.dom.*;
import java.util.*;

public class RestaurantXMLFile
{
    private String restaurantsFile = null;
    private Document doc = null;
    private Element root = null;
    private NodeList Restaurant = null;

    public RestaurantXMLFile()
    {
        restaurantsFile = "Restaurants.xml";
        doc = this.getDocument();
        root = doc.getDocumentElement();
        Restaurant = doc.getElementsByTagName("Restaurant");
    }

    private Document getDocument()
    {
        try
        {
            // read XML document from XML file
            doc = XMLUtil.getDocumentFromFile(restaurantsFile);
            return doc;
        }
        // catch ParserConfigurationException, SAXException, IOException
        catch(Exception e)
        {
            return null;
        }
    }

    public ArrayList<Restaurant> getRestaurant()
    {
        // declare the customers array list
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

        // create Customer objects from the Customer elements
        for (int i = 0; i < Restaurant.getLength(); i++)
        {
            Element restaurantElement = (Element) Restaurant.item(i);

            String name = restaurantElement.getAttribute("Name");
            String price =
                XMLUtil.getTextNodeValue(restaurantElement, "Price");
            String type =
                XMLUtil.getTextNodeValue(restaurantElement, "Type");
            String location =
            	 XMLUtil.getTextNodeValue(restaurantElement, "Location");

            Restaurant c = new Restaurant(name, price, type, location);
            restaurants.add(c);
        }
        return restaurants;
    }

    public Restaurant getRestaurant(String name)
    {
        // loop through Customer nodes and return Customer object if found
        for (int i = 0; i < Restaurant.getLength(); i++)
        {
            Element restaurantElement = (Element) Restaurant.item(i);

            String restaurantName = restaurantElement.getAttribute("Name");
            if (name.equals(restaurantName))
            {
                String price =
                    XMLUtil.getTextNodeValue(restaurantElement, "Price");
                String type =
                    XMLUtil.getTextNodeValue(restaurantElement, "Type");
                String location =
                    XMLUtil.getTextNodeValue(restaurantElement, "Location");

                Restaurant restaurant = new Restaurant(name, price, type, location);
                return restaurant;
            }
        }
        return null;
    }

    private int getRestaurantIndex(String name)
    {
        // loop through Customer nodes and return Customer index if found
        for (int i = 0; i < Restaurant.getLength(); i++)
        {
            Element restaurantElement = (Element) Restaurant.item(i);

            String restaurantName = restaurantElement.getAttribute("Name");
            if (name.equals(restaurantName))
            {
                return i;
            }
        }
        return -1;
    }

    private boolean saveRestaurant()
    {
        try
        {
            // write the XML document to the XML file
            XMLUtil.writeDocumentToFile(restaurantsFile, doc);
            return true;
        }
        // catch ParserConfigurationException, TransformerException
        catch(Exception e)
        {
            return false;
        }
    }

    private Element getElementFromRestaurant(Restaurant c)
    {
        Element ce = doc.createElement("Restaurant");
        ce.setAttribute("Name", c.getName());
        XMLUtil.addTextNode(doc, ce, "Price", c.getPrice());
        XMLUtil.addTextNode(doc, ce, "Type", c.getType());
        XMLUtil.addTextNode(doc, ce, "Location", c.getLocation());
        return ce;
    }

    public boolean addRestaurant(Restaurant c)
    {
        Element ce = this.getElementFromRestaurant(c);
        root.appendChild(ce);
        return this.saveRestaurant();
    }

    public boolean deleteRestaurant(Restaurant c)
    {
        int i = this.getRestaurantIndex(c.getName());
        if (i != -1)
        {
            // update the XML document
            Element ce = (Element) Restaurant.item(i);
            root.removeChild(ce);
            return this.saveRestaurant();
        }
        else
            return false;
    }

}