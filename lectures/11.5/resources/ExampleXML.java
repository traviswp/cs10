import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * Some example XML manipulation, based on the DOM representation
 *
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012
 */

public class ExampleXML {
	/**
	 * Counts the number of <student> elements
	 */
	public static int numStudents(Node n) {
		int total = 0;
		// is this a student?
		if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("student")) total++;
		// recurse for children
		for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
			total += numStudents(child);
		}
		return total;
	}

	/**
	 * Prints an indented representation of the tree
	 */
	public static void printTree(Node n) {
		printTree(n, "");
	}

	public static void printTree(Node n, String indent) {
		switch (n.getNodeType()) {
		case Node.DOCUMENT_NODE:
			// root
			System.out.println(indent + '<' + n.getNodeName() + '>');
			break;
		case Node.ELEMENT_NODE:
			// an element: print it and its attribute list
			System.out.print(indent + '<' + n.getNodeName() + '>');
			NamedNodeMap atts = n.getAttributes();
			for (int i = 0; i < atts.getLength(); i++) {
				Node att = atts.item(i);
				System.out.print("  "+att.getNodeName()+"="+att.getNodeValue());
			}
			System.out.println();
			break;
		case Node.TEXT_NODE:
			// print the text node only if its not just whitespace
			String value = n.getNodeValue();
			if (value != null && !value.trim().equals("")) {
				System.out.println(indent + '"' + value.trim() + '"');
			}
			break;
		default:
			System.out.println(indent + + '<' + n.getNodeName() + '>');
		}
		// recurse
		for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
			printTree(child, indent + "  ");
		}
	}

	/**
	 * Illustrates how to propagate info for rendering an HTML document, e.g., whether to SHOUT,
	 * how to handle headers and paragraphs
	 */
	public static void render(Node n) {
		render(n, false);
	}

	public static void render(Node n, boolean shout) {
		int type = n.getNodeType();
		String name = n.getNodeName();
		if (type == Node.TEXT_NODE) {
			// Print text node if not just whitespace, SHOUTING if so instructed
			String value = n.getNodeValue();
			if (value != null && !value.trim().equals("")) {
				value = value.trim() + " "; // replace all trailing whitespace with a single space
				if (shout) value = value.toUpperCase();
				System.out.print(value);
			}
		}
		else if (type == Node.ELEMENT_NODE && ("b".equals(name) || "h1".equals(name))) {
			// Children should SHOUT
			shout = true;
		}
		// Recurse
		for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
			render(child, shout);
		}
		// End of paragraph or header
		if (type == Node.ELEMENT_NODE) {
			if ("p".equals(name)) System.out.println();
			else if ("h1".equals(name)) System.out.println("\n-----");
		}
	}

	/**
	 * Extracts all the url values from the src attributes of <img>s
	 */
	public static ArrayList<String> getImages(Node n) {
		ArrayList<String> urls = new ArrayList<String>();
		getImages(n, urls);
		return urls;
	}

	public static void getImages(Node n, ArrayList<String> urls) {
		if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("img")) {
			// It's an img; look for src attribute and add value
			NamedNodeMap atts = n.getAttributes();
			for (int i = 0; i < atts.getLength(); i++) {
				Node att = atts.item(i);
				if (att.getNodeName().equals("src")) urls.add(att.getNodeValue());
			}
		}
		// Recurse
		for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
			getImages(child, urls);
		}
	}

	/**
	 * Example driver
	 */
	public static void main(String[] args) throws Exception {
		// Parser stuff, following Oracle example
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// XML file of students in courses
		System.out.println("***XML");
		Document doc = builder.parse(new File("inputs/test.xml"));
		printTree(doc);
		System.out.println();
		System.out.println("# students:" + numStudents(doc));

		// HTML file
		System.out.println();
		System.out.println("***HTML");
		Document doc2 = builder.parse(new File("inputs/test.html"));
		printTree(doc2);
		System.out.println();
		ArrayList<String> images = getImages(doc2);
		System.out.println("images:" + images);
		System.out.println();
		render(doc2);
	}	
}
