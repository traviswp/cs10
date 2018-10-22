import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

import com.googlecode.javacv.*;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;

/**
 * Class to handle webcam capture and processing, packaging up JavaCV stuff.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Winter 2014
 *
 */
public class WebcamTest extends JFrame {
	protected double scale = 1.0;					// to downsize the image (for speed), set this to a fraction < 1
	protected boolean mirror = true;				// make true in order to mirror left<->right so your left hand is on the left side of the image

	protected int width, height;					// the size of the grabbed images (scaled if so specified)
	protected BufferedImage image;					// image grabbed from webcam (if any)

	private Grabby grabby;							// handles webcam grabbing
	private JComponent canvas;						// handles graphics display

	private FrameGrabber grabber;					// JavaCV

	public WebcamTest() {
		super("Webcam");

		// Create our graphics-handling component.
		canvas = new JComponent() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, null);
			}
		};

		// Set up webcam
		grabber = new OpenCVFrameGrabber(0); 
		// Repeated attempts following discussion on javacv forum, fall 2013 (might be fixed internally in future versions)
		final int MAX_ATTEMPTS = 60;
		int attempt = 0;
		System.out.print("Initializing camera");
		while (attempt < MAX_ATTEMPTS) {
			System.out.print('.');
			attempt++;
			try {
				grabber.start();
				break;
			} 
			catch (Exception e) { }
		}
		if (attempt == MAX_ATTEMPTS) {
			System.err.println("Failed after "+attempt+" attempts");
			return;
		}
		System.out.println("done");

		// Get size and figure out scaling
		width = grabber.getImageWidth();
		height = grabber.getImageHeight();
		System.out.println("Native camera size "+width+"*"+height);
		if (scale != 1) {
			width = (int)(width*scale);
			height = (int)(height*scale);
			System.out.println("Scaled to "+width+"*"+height);
		}

		// Set the size as determined by the grabber.
		setSize(width, height);		

		// Boilerplate to finish initializing the GUI.
		canvas.setPreferredSize(new Dimension(getWidth(), getHeight()));
		getContentPane().add(canvas);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

		// Spawn a separate thread to handle grabbing.
		grabby = new Grabby();
		grabby.execute();
	}

	/**
	 * Handles grabbing an image from the webcam (following JavaCV examples)
	 * storing it in image, and telling the canvas to repaint itself.
	 */
	private class Grabby extends SwingWorker<Void, Void> {
		protected Void doInBackground() throws Exception {
			while (!isCancelled()) {
				IplImage grabbed = null;
				while (grabbed == null) {
					try {
						grabbed = grabber.grab();
					}	
					catch (Exception e) {
						Thread.sleep(100); // wait a bit
					}
				}
				if (mirror) {
					cvFlip(grabbed, grabbed, 1);
				}
				if (scale != 1) {
					IplImage resized = IplImage.create(width, height, grabbed.depth(), grabbed.nChannels());
					cvResize(grabbed, resized);
					grabbed = resized;
				}
				image = grabbed.getBufferedImage();
				canvas.repaint();
				Thread.sleep(100); // slow it down
			}
			// All done; clean up
			grabber.stop();
			grabber.release();
			grabber = null;
			return null;
		}
	}

	/**
	 * Main method for the webcam test application
	 * 
	 * @param args	ignored
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WebcamTest();
			}
		});
	}
}
