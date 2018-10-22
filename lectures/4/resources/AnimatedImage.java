import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Custom rendering of an image, by animated agents.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten Winter 2014 for BufferedImage
 */
public class AnimatedImage extends DrawingFrame {
	private static final int radius = 5;				// setup: agent size
	private static final int numToMove = 1000;			// setup: how many agents to animate each frame

	private ArrayList<Agent> agents;					// the agents representing the picture
	private int width, height;							// size of window, based on image size and agent size
	
	public AnimatedImage(BufferedImage original) {
		// Size of the window is scaled up from the original image by the agent radius
		super("Animated Picture", original.getWidth()*radius, original.getHeight()*radius);
		
		// Create one agent per pixel.
		agents = new ArrayList<Agent>();
		// Nested loop over every pixel
		for (int y = 0; y < original.getHeight(); y++) {
			for (int x = 0; x < original.getWidth(); x++) {
				Color color = new Color((int) original.getRGB(x,y));
				agents.add(new WanderingPixel(x * radius, y * radius, (int) (1+Math.random()*radius), color));
			}
		}

		// Move some random agents every 100 milliseconds
		Timer timer = new Timer(100, new AbstractAction("update") {
			public void actionPerformed(ActionEvent e) {
				for (int a = 0; a < numToMove; a++) {
					// Pick a random agent and ask it to move.
					agents.get((int) (Math.random() * agents.size())).move();
				}
				repaint();
			}
		});
		timer.start();
	}

	/**
	 * Override method from DrawingFrame, in order to draw all the agents
	 */
	public void draw(Graphics g) {
		for (Agent agent : agents) {
			agent.draw(g);
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
					image = ImageIO.read(new File("pictures/baker-200-150.jpg")); // note: using downsampled version, to reduce computational expense
				}
				catch (Exception e) {
					System.err.println("Couldn't load image");
					return;
				}

				new AnimatedImage(image);
			}
		});
	}
}
