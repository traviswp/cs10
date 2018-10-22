import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Webcam-based catch game
 * Sample solution to Lab 1, Dartmouth CS 10, Winter 2015
 * 
 * @author Chris Bailey-Kellogg, Winter 2014 (based on a very different structure from Fall 2012)
 * @author Travis W. Peters, Dartmouth CS 10, Updated Winter 2015
 */
public class Catch extends Webcam {
    private Universe universe;			       // handles finding regions
    private static final int numFliers = 5;    // the # of fliers to create

    /**
     * Overrides Webcam method to do the region finding the flier stuff.
     */
    public void processImage() {
        if (universe != null) {
            // Set the image in universe
            // TODO: YOUR CODE HERE

            // Detect regions and recolor
            // TODO: YOUR CODE HERE

            // Move the fliers and detect catches and misses
            // TODO: YOUR CODE HERE
        }
    }

    /**
     * Overrides the Webcam method to also draw the flier.
     */
    public void draw(Graphics g) {
        super.draw(g);

        // Draw fliers
        if(universe != null) {
            universe.drawFliers(g);
        }
    }

    /**
     * Overrides the Webcam method to create the universe, set the track 
     * color and start the flier.
     */
    public void handleMousePress(MouseEvent event) {
        // Create universe
        // TODO: YOUR CODE HERE

        // Set tracking color
        // TODO: YOUR CODE HERE

        // Create fliers and start them flying
        // TODO: YOUR CODE HERE
    }

    /**
     * Main method for the application
     * @param args      command-line arguments (ignored)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Catch();
            }
        });
    }
}
