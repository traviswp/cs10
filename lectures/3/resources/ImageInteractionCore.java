import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Some interaction with images.
 * This is the initial core program, to be expanded into ImageInteraction.java.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten for BufferedImage, Winter 2014
 */
public class ImageInteractionCore extends DrawingFrame {
	public ImageInteractionCore(String filename) {
		super("Image Interaction", filename);

		System.out.println("image size: " + image.getWidth() + "*" + image.getHeight());
	}

	/**
	 * Main method for the application
	 * 
	 * @param args	ignored
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ImageInteractionCore("pictures/baker.jpg");
			}
		});
	}
}
