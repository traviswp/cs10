import java.io.File;

import javax.imageio.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 * Some interaction with images.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten for BufferedImage, Winter 2014
 */
public class ImageInteraction extends DrawingFrame {
	private static final int squareRadius = 5;	// for drawing squares
	private static final int lensRadius = 50;	// for lens effect

	private char action = 'd';					// how to interpret mouse press
	private Color grabbedColor = Color.black;	// from 'g' action mouse press
	
	public ImageInteraction(String filename) {
		super("Image Interaction", filename);

		// Listen for mouse motion.
		canvas.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent event) {
				// Print out color at position
				Color currentColor = new Color(image.getRGB(event.getPoint().x, event.getPoint().y));
				System.out.println(currentColor);
			}
		});
		
		// Listen for mouse presses.
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				if (action=='d') { // Drawing squares
					drawSquare(event.getPoint().x, event.getPoint().y);
				}
				else if (action=='g') { // Grabbing color					
					grabbedColor = new Color(image.getRGB(event.getPoint().x, event.getPoint().y));
					System.out.println("grabbed color "+grabbedColor);
				}
				else if (action=='l') { // Lens effect
					lens(event.getPoint().x, event.getPoint().y);					
				}
				// Need to redraw since image may be modified
				repaint();
			}
		});

		// Listen for key presses.
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent event) {
				char key = event.getKeyChar();
				System.out.println("Processing key '"+key+"'");
				if (key=='d' || key=='g' || key=='l') { // remember action
					action = key;
				}
				else {
					System.out.println("Unknown operation");
				}
			}
		});
	}

	/**
	 * Updates the image with a square at the location, colored the current grabbedColor.
	 * 
	 * @param cx	center x of square
	 * @param cy	center y of square
	 */
	private void drawSquare(int cx, int cy) {
		// Nested loop over nearby pixels
		for (int y = Math.max(0, cy-squareRadius); y < Math.min(image.getHeight(), cy+squareRadius); y++) {
			for (int x = Math.max(0, cx-squareRadius); x < Math.min(image.getWidth(), cx+squareRadius); x++) {
				image.setRGB(x, y, grabbedColor.getRGB());
			}
		}
	}
	
	/**
	 * Returns a value that is one of val (if it's between min or max) or min or
	 * max (if it's outside that range).
	 * 
	 * @param val
	 * @param min
	 * @param max
	 * @return constrained value
	 */
	private static double constrain(double val, double min, double max) {
		if (val < min) {
			return min;
		}
		else if (val > max) {
			return max;
		}
		return val;
	}

	/**
	 * Updates the image with a lens magnifying effect
	 * 
	 * @param cx		center x of lens
	 * @param cy		center y of lens
	 */
	private void lens(int cx, int cy) {
		// Create a new image into which the resulting pixels will be stored.
		BufferedImage result = new BufferedImage(image.getColorModel(), image.copyData(null), image.getColorModel().isAlphaPremultiplied(), null);
		// Nested loop over every pixel
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				// Only do lens out to specified radius.
				double dist = Math.sqrt((x - cx) * (x - cx) + (y - cy) * (y - cy)) / lensRadius;
				if (dist <= 1) {
					// Determine neighbor pixels by lens function, but constrain to image size.
					int nx = (int) constrain(x + ((x - cx) * dist), 0, image.getWidth() - 1);
					int ny = (int) constrain(y + ((y - cy) * dist), 0, image.getHeight() - 1);
					result.setRGB(x, y, image.getRGB(nx, ny));
				}
			}
		}
		// Update the image to be the modified one.
		image = result;
	}
	
	/**
	 * Main method for the application
	 * 
	 * @param args	ignored
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ImageInteraction("pictures/baker.jpg");
			}
		});
	}
}
