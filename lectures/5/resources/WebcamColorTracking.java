import java.awt.*;
import java.awt.event.*;

import javax.swing.SwingUtilities;

/**
 * Fun with the webcam, built on JavaCV
 * Tracks a color, as specified by mouse press
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten Winter 2014 for Webcam class
 */
public class WebcamColorTracking extends Webcam {
	private Color trackColor=null;		 	// point-tracking target color

	/**
	 * Determines which point is closest to the trackColor, puts it in this.where
	 */
	private Point track() {
		int cx = 0, cy = 0; // coordinates with best matching color
		int closest = 10000; // start with a too-high number so that everything will be smaller
		// Nested loop over every pixel
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				// Euclidean distance squared between colors
				Color c = new Color(image.getRGB(x,y));
				int d = (c.getRed() - trackColor.getRed()) * (c.getRed() - trackColor.getRed())
						+ (c.getGreen() - trackColor.getGreen()) * (c.getGreen() - trackColor.getGreen())
						+ (c.getBlue() - trackColor.getBlue()) * (c.getBlue() - trackColor.getBlue());
				if (d < closest) {
					closest = d;
					cx = x; cy = y;
				}
			}
		}
		return new Point(cx,cy);
	}

	/**
	 * Overrides the generic webcam mouse handler to set trackColor
	 */
	public void handleMousePress(MouseEvent event) {
		if (image != null) {
			trackColor = new Color(image.getRGB(event.getPoint().x, event.getPoint().y));
			System.out.println("tracking " + trackColor);
		}
	}

	/**
	 * Overrides the generic webcam drawing, to also show tracked color point
	 */
	public void draw(Graphics g) {
		super.draw(g);
		if (trackColor != null) {
			// Draw circle at tracked point, with border in the inverse color
			Point where = track();
			g.setColor(trackColor);
			g.fillOval(where.x, where.y, 15, 15);
			((Graphics2D)g).setStroke(new BasicStroke(4)); // thick border
			g.setColor(new Color(255-trackColor.getRed(), 255-trackColor.getGreen(), 255-trackColor.getBlue()));
			g.drawOval(where.x, where.y, 15, 15);
		}
	}

	/**
	 * Main method for the application
	 * @param args		command-line arguments (ignored)
	 */
	public static void main(String[] args) { 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WebcamColorTracking();
			}
		});
	}
}
