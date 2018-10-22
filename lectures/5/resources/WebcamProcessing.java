import java.awt.Color;
import java.awt.Graphics;

import javax.swing.SwingUtilities;

/**
 * Fun with the webcam, built on JavaCV
 * Just applies one of our image processing methods to the webcam image
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten Winter 2014 for simplified Webcam class
 */
public class WebcamProcessing extends Webcam {
	/**
	 * Override in order to process image our way.
	 */
	public void processImage() {
		gray();
	}

	/**
	 * Computes the luminosity of an rgb value by one standard formula.
	 * @param r		red value (0-255)
	 * @param g		green value (0-255)
	 * @param b		blue value (0-255)
	 * @return		luminosity (0-255)
	 */
	private static int luminosity(int r, int g, int b) {
		return (int)(0.299 * r + 0.587 * g + 0.114 * b);
	}

	/**
	 * Code from ImageProcessing.java to make the current image look grayscale (though still represented as RGB).
	 */
	private void gray() {
		// Nested loop over every pixel
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				// Get current color; set each channel to luminosity
				Color color = new Color(image.getRGB(x, y));
				int gray = luminosity(color.getRed(), color.getGreen(), color.getBlue());
				// Put new color
				Color newColor = new Color(gray, gray, gray);
				image.setRGB(x, y, newColor.getRGB());
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
				new WebcamProcessing();
			}
		});
	}
}
