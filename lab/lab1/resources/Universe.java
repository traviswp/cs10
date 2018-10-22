import java.awt.*;
import java.awt.image.*;
import java.util.*;

/**
 * Universe for PS-1 Catch game.
 * Holds the fliers and the background image.
 * Also finds and holds the regions in the background image.
 * Each region is a list of contiguous points with colors similar to a target color.
 * Sample solution to Lab 1, Dartmouth CS 10, Winter 2015
 * 
 * @author Chris Bailey-Kellogg, Winter 2014 (based on a very different structure from Fall 2012)
 * @author Travis W. Peters, Dartmouth CS 10, Updated Winter 2015
 */
public class Universe {
    private static final int maxColorDiff = 20;				// how similar a pixel color must be to the target color, to belong to a region
    private static final int minRegion = 50; 				// how many points in a region to be worth considering

    private BufferedImage image;                            // a reference to the background image for the universe
    private Color trackColor;                               // color of regions of interest (set by mouse press)

    private ArrayList<ArrayList<Point>> regions;			// a region is a list of points
    // so the identified regions are in a list of lists of points

    private ArrayList<Flier> fliers;                        // all of the fliers

    /**
     * New universe with a background image and an empty list of fliers
     * @param image
     */
    public Universe(BufferedImage image) {
        this.image = image;		
        fliers = new ArrayList<Flier>();
    }

    /**
     * Set the image (from the webcam) that makes up the universe's background
     * @param image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Allow others to ask about the state of the trackColor in the universe
     * @return
     */
    public Color getTrackingColor() {
        return trackColor;
    }

    /**
     * Setting the color from an explicitly defined Color object 
     * as opposed to getting input from the player.
     * @param color
     */
    public void setTrackingColor(Color color) {
        trackColor = color;
    }

    /**
     * Allow others to ask about the size of the universe (width)
     * @return
     */
    public int getWidth() {
        return image.getWidth();
    }

    /**
     * Allow others to ask about the size of the universe (height)
     * @return
     */
    public int getHeight() {
        return image.getHeight();
    }

    /**
     * Accesses the currently-identified regions.
     * @return
     */
    public ArrayList<ArrayList<Point>> getRegions() {
        return regions;
    }

    /**
     * Set the universe's regions.
     * @return
     */
    public void setRegions(ArrayList<ArrayList<Point>> regions) {
        this.regions = regions;
    }

    /**
     * Adds the flier to the universe
     * @param f
     */
    public void addFlier(Flier f) {
        fliers.add(f);
    }

    /**
     *  Move the flier and detect catches and misses
     */
    public void moveFliers() {
        // TODO: YOUR CODE HERE
    }

    /**
     * Draw the fliers
     */
    public void drawFliers(Graphics g) {
        // TODO: YOUR CODE HERE
    }

    /**
     * Sets regions to the flood-fill regions in the image, similar enough to the trackColor.
     */
    public void findRegions() {
        // TODO: YOUR CODE HERE
    }

    /**
     * Tests whether the two colors are "similar enough" (your definition, subject to the static threshold).
     * @param c1
     * @param c2
     * @return
     */
    private static boolean colorMatch(Color c1, Color c2) {
        // TODO: YOUR CODE HERE
        return false; // CHANGE ME (I needed to supply this value to make eclipse happy -- change as needed).
    }

    /**
     * Recolors image so that each region is a random uniform color, so we can see where they are
     */
    public void recolorRegions() {
        // TODO: YOUR CODE HERE
    }
}
