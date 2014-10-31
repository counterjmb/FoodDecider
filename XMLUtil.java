/*XMLUtil.java
James Beagle
Final Project for Java 2 1531 SN
Novemeber 2010
Taken from In class Customer M project
*/


import org.w3c.dom.*;                   // for working with a DOM tree
import javax.xml.parsers.*;             // for reading a DOM tree from a file
import org.xml.sax.*;
import java.io.*;
import javax.xml.transform.*;           // for writing a DOM tree to a file
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class XMLUtil
{
	public static Document getNewDocument()
	throws ParserConfigurationException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db.newDocument();
	}

	public static Document getDocumentFromFile(String xmlFile)
	throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource in = new InputSource(xmlFile);
		return db.parse(in);
	}

	public static String getTextNodeValue(Element parent, String tagName)
	{
		NodeList list = parent.getElementsByTagName(tagName);
		Element element = (Element) list.item(0);
		Text text = (Text) element.getFirstChild();
		return text.getNodeValue();
	}

	public static void addTextNode(Document doc, Element parent,
	String elementName, String elementValue)
	{
		Element element = doc.createElement(elementName);
		parent.appendChild(element);
		Text text = doc.createTextNode(elementName);
		text.setNodeValue(elementValue);
		element.appendChild(text);
	}

	public static void writeDocumentToFile(String xmlFile, Document doc)
	throws TransformerException {
		DOMSource in = new DOMSource(doc);
		StreamResult out = new StreamResult(xmlFile);
		Transformer transformer =
			TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(in, out);
	}
}