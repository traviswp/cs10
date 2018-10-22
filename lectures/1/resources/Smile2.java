import javax.swing.*;

/**
 * A class demonstrating display of an image.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Winter 2014
 */
public class Smile2 {
	/**
	 * Main method for the application
	 * @param args		command-line arguments (ignored)
	 */
	public static void main(String[] args) { 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Create a GUI element to display it.
				DrawingFrame gui = new DrawingFrame("Hi!", "pictures/smiley.png");
			}
		});
	}
}
