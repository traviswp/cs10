import java.awt.Color;
import java.awt.Graphics;

import javax.swing.SwingUtilities;

/**
 * Fun with the webcam, built on JavaCV
 * Just applies one of our image processing methods to the webcam image
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten Winter 2014 for simplified Webcam class
 */
public class WebcamRendering extends Webcam {
	private static final int pixelSize = 20;	// size of the objects representing the image

	/**
	 * Override in order to render image our own way.
	 */
	public void draw(Graphics g) {
		if (image!=null) mosaic(g);
	}

	/**
	 * Code from Render.java to render the image as a set of rectangles.
	 */
	private void mosaic(Graphics g) {
		// Usual loops, but step by "pixel" size and draw a rectangle of the appropriate color.
		// Also note <=, to get that last rectangle.
		// Nested loop over every pixel
		for (int y = 0; y <= image.getHeight() - pixelSize; y += pixelSize) {
			for (int x = 0; x <= image.getWidth() - pixelSize; x += pixelSize) {
				g.setColor(new Color(image.getRGB(x,y)));
				g.fillRect(x, y, pixelSize, pixelSize);										
				g.setColor(Color.black);
				g.drawRect(x, y, pixelSize, pixelSize);
			}
		}
	}
	
	/**
	 * Main method for the application
	 * 
	 * @param args	ignored
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WebcamRendering();
			}
		});
	}
}
