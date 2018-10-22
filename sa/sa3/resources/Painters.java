import java.awt.event.*;
import java.util.ArrayList;
import java.awt.image.*;
import javax.swing.*;

/**
 * Custom rendering of an image, by animated agents.
 * SA-3, Dartmouth CS 10, Winter 2014
 * @author YOUR NAME HERE
 */
public class Painters extends DrawingFrame {
	private static final int nagents = 100;        // setup: how many agents to create

	private BufferedImage source;                  // to be drawn
	private ArrayList<Agent> agents;               // the agents representing the picture
	
	public Painters(String filename) {
		super("Painters", filename);

		// Store the source image and create "image" as a new blank one to be filled in and drawn
		source = image;
		image = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());

		// Create some agents and set up a timer so that they'll fill in the image from the source.
		// YOUR CODE HERE
	}

	/**
	 * Main method for the application
	 * @param args		command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Painters("pictures/baker.jpg");
			}
		});
	}
}
