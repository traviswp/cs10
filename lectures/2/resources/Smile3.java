import javax.swing.*;
import java.awt.event.*;

/**
 * Another class demonstrating display of an image.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Winter 2014
 */
public class Smile3 {
	private String name;			// name of this one
	private int numVotes;			// how many key presses this one got

	/**
	 * Initializes the instance
	 * 
	 * @param name			for the title bar
	 * @param filename		the image to display
	 */
	public Smile3(String name, String filename) {
		this.name = name;
		numVotes = 0;

		// Create a GUI element to display the image.
		DrawingFrame gui = new DrawingFrame(name, filename);
		// Listen to key presses and call vote() for each one (will discuss the wrapping later)
		gui.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				vote();
			}
		});
	}

	/**
	 * Casts another vote for this smiley
	 */
	public void vote() {
		numVotes++;
		System.out.println(name + " has " + numVotes + " votes!");
	}

	/**
	 * Main method for the application
	 * @param args		command-line arguments (ignored)
	 */
	public static void main(String[] args) { 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Smile3 smileyA = new Smile3("Choice A", "pictures/smiley.png");
				Smile3 smileyB = new Smile3("Choice B", "pictures/smiley2.jpg");
				
				// Give smileyA a head-start
				smileyA.vote();
				smileyA.vote();
			}
		});
	}
}
