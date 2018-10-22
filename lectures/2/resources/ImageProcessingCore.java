import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 * A class demonstrating manipulation of image pixels.
 * This is the initial core program, to be expanded into ImageProcessing.java.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten for BufferedImage, Winter 2014
 */
public class ImageProcessingCore {
	private DrawingFrame gui;			// handles the image display
	private BufferedImage original;		// the unprocessed image, as read from a file
	private BufferedImage current;		// the version that's been processed
	
	/**
	 * @param image		the original
	 */
	public ImageProcessingCore(String filename) {
		// Create a GUI element to display the image.
		gui = new DrawingFrame("Image Processing", filename);

		// Hold on to a copy of the image (so can mess it up).
		current = gui.getImage();
		original = new BufferedImage(gui.getImage().getColorModel(), gui.getImage().copyData(null), gui.getImage().getColorModel().isAlphaPremultiplied(), null);

		// Listen to key presses (will discuss this next time)
		gui.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				process(e.getKeyChar());
			}
		});
	}

	/**
	 * Dispatches on user input as to how to modify the image.
	 * Note that there are some magic numbers here that you can play with.
	 * While that's generally bad practice, it's just for simplicity in this hodge-podge of examples.
	 */
	public void process(char op) {
		System.out.println("Processing key '"+op+"'");
		if (op=='o') { // revert to original
			current = new BufferedImage(original.getColorModel(), original.copyData(null), original.getColorModel().isAlphaPremultiplied(), null);
		}
		else if (op=='s') { // save a snapshot
			try {
				ImageIO.write(current, "jpg", new File("pictures/snapshot.jpg"));
				System.out.println("Saved a snapshot");
			}
			catch (Exception e) {
				System.err.println("Couldn't save snapshot.");
			}
		}
		else {
			System.out.println("Unknown operation");
		}
		gui.setImage(current);
	}

	/**
	 * Main method for the application
	 * @param args		command-line arguments (ignored)
	 */
	public static void main(String[] args) { 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Create an image processing object for the image.
				ImageProcessingCore proc = new ImageProcessingCore("pictures/baker.jpg");
			}
		});
	}
}
