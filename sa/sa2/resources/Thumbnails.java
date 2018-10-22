import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Thumbnail display of a set of slides.
 * SA-2, Dartmouth CS 10, Winter 2014
 * @author YOUR NAME HERE
 */
public class Thumbnails extends DrawingFrame {
	private static final int trows = 3, tcols = 3; 	// setup: number of thumbnails per row and column

	private BufferedImage[][] slides; 				// the slides
	private BufferedImage[][] thumbs;			 	// thumbnail versions
	private int zoomedR = -1, zoomedC = -1; 		// selected slide; -1 for none
	private int thumbWidth, thumbHeight; 			// scaled size of thumbnails (computed)

	public Thumbnails(BufferedImage[][] images) {
		super("Thumbnails", images[0][0].getWidth(), images[0][0].getHeight());
		slides = images;		

		// Separate method handles thumbnail creation.
		createThumbs();

		// Listen for mouse presses.
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				click(event.getPoint().x, event.getPoint().y);
			}
		});
	}

	/**
	 * Creates the thumbnails as scaled-down versions of the images.
	 */
	private void createThumbs() {		
		thumbs = new BufferedImage[trows][tcols];
		thumbWidth = slides[0][0].getWidth()/tcols;
		thumbHeight = slides[0][0].getHeight()/trows;
		for (int i=0; i<trows; i++) {
			for (int j=0; j<tcols; j++) {
				thumbs[i][j] = scaleTo(slides[i][j], thumbWidth, thumbHeight);
			}
		}
	}
	
	/**
	 * Crude scaling down of an image to a width and height
	 * @param image		image to scale
	 * @param width		scaled down width
	 * @param height	scaled down height
	 * @return			scaled image
	 */
	private static BufferedImage scaleTo(BufferedImage image, int width, int height) {
		BufferedImage result = new BufferedImage(width, height, image.getType());
		// YOUR CODE HERE
		return result;
	}

	/**
	 * Handle click on image, either selecting a thumbnail or going back to the thumbnails
	 * @param x
	 * @param y
	 */
	private void click(int x, int y) {
		if (zoomedR != -1) {
			// Zoom back out
			zoomedR = -1;
		}
		else {
			// Zoom in to whichever thumbnail it was
			// YOUR CODE HERE
		}
		canvas.repaint();
	}

	/**
	 * Draws either the grid of images or the selected thumbnail.
	 */
	public void draw(Graphics g) {
		if (zoomedR != -1) {
			// Show the selected slide.
			g.drawImage(slides[zoomedR][zoomedC], 0, 0, null);
		}
		else {
			// Lay out the thumbnails
			// YOUR CODE HERE
		}
	}

	/**
	 * Main method for the application
	 * @param args		command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Read the images, named dart0.jpg ... dart<numSlides>.jpg, and store in array.
				BufferedImage[][] images = new BufferedImage[trows][tcols];
				try {
					for (int i=0; i<trows; i++) {
						for (int j=0; j<tcols; j++) {
							images[i][j] = ImageIO.read(new File("pictures/dart"+(i*tcols+j)+".jpg"));
						}
					}
				}
				catch (Exception e) {
					System.err.println("Couldn't load image");
				}
				// Fire off the tbumbnail viewer.
				new Thumbnails(images);
			}
		});
	}
}
