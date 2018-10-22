import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Custom rendering of an image, by drawing "pixels"
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten Winder 2014 for BufferedImage
 */
public class Render extends DrawingFrame {
	private static final int pixelSize = 10;	// size of the objects representing the image

	private BufferedImage original;				// the underlying image to render
	
	public Render(BufferedImage original) {
		super("Render", original.getWidth(), original.getHeight());
		this.original = original;
	}

	/**
	 * Override method from DrawingFrame, in order to render image our own way.
	 */
	public void draw(Graphics g) {
		// Uncomment one or the other.
		//mosaic(g);
		pointillism(g);
	}

	/**
	 * Renders the image as a set of rectangles tiling the window.
	 * @param g
	 */
	private void mosaic(Graphics g) {
		// Usual loops, but step by "pixel" size and draw a rectangle of the appropriate color.
		// Also note <=, to get that last rectangle.
		// Nested loop over every pixel
		for (int y = 0; y <= original.getHeight() - pixelSize; y += pixelSize) {
			for (int x = 0; x <= original.getWidth() - pixelSize; x += pixelSize) {
				g.setColor(new Color(original.getRGB(x,y)));
				g.fillRect(x, y, pixelSize, pixelSize);										
				g.setColor(Color.black);
				g.drawRect(x, y, pixelSize, pixelSize);
			}
		}
	}

	/**
	 * Renders the image as a set of ellipses at random positions.
	 * @param g
	 */
	private void pointillism(Graphics g) {
		// Draw some random number of points determined by the image and "pixel" sizes.
		int numPoints = original.getWidth() * original.getHeight() * 5 / pixelSize;
		for (int p=0; p<numPoints; p++) {
			// Pick a random position and size
			int x = (int) (Math.random() * original.getWidth());
			int y = (int) (Math.random() * original.getHeight());
			int s = (int) (Math.random() * pixelSize) + 1;

			// Draw an ellipse there, colored by the pixel's color
			g.setColor(new Color(original.getRGB(x,y)));
			g.fillOval(x, y, s, s);										
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
				// Read an image.
				BufferedImage image = null;
				try {
					image = ImageIO.read(new File("pictures/baker.jpg"));
				}
				catch (Exception e) {
					System.err.println("Couldn't load image");
					return;
				}

				new Render(image);
			}
		});
	}
}
