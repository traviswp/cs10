import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.util.ArrayList;

/**
 * Presentation of a list of images.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten for BufferedImage, Winter 2014 
 */
public class Slideshow extends DrawingFrame {
	private static final int numSlides = 9;			// number of slides

	private BufferedImage[] slides;					// images to display
	private int curr = 0;							// current slide number

	public Slideshow(BufferedImage[] images) {
		super("Slideshow", images[0]);
		slides = images;

		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				advance();
			}
		});
	}

	/**
	 * Advances to the next slide.
	 */
	private void advance() {
		curr = (curr + 1) % numSlides; // use modular arithmetic to wrap around to 0
		System.out.println("slide "+curr);
		image = slides[curr];
		// Need to redraw since image is modified
		repaint();
	}

	/**
	 * Main method for the application
	 * @param args		command-line arguments (ignored)
	 */
	public static void main(String[] args) { 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Read the images, named dart0.jpg ... dart<numSlides>.jpg, and store in array.
				BufferedImage[] images = new BufferedImage[numSlides];
				try {
					for (int i = 0; i < numSlides; i++) {
						images[i] = ImageIO.read(new File("pictures/dart"+i+".jpg"));
					}
				}
				catch (Exception e) {
					System.err.println("Couldn't load image");
				}
				// Fire off the slideshow.
				new Slideshow(images);
			}
		});
	}
}
