import java.util.*;
import java.awt.*;

/**
 * An animated object flying across the scene in a fixed direction
 * Sample solution to Lab 1, Dartmouth CS 10, Winter 2015
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; revised Winter 2014
 * @author Travis W. Peters, Dartmouth CS 10, Updated Winter 2015
 */
public class Flier extends Agent {

    /* 
     * TODO: YOUR CODE HERE
     * 
     * The Flier class should have AT LEAST the following attributes 
     * in addition to what we've defined for you:
     *  - speed
     *  - direction of flight
     */

    private Universe universe;         // the universe that a flier exists within

    public Flier(Universe universe) {
        super(0,0);

        this.universe = universe;
        universe.addFlier(this);
    }

    /**
     * Overrides Agent.move() to step by dx, dy
     */
    public void move() {
        // TODO: YOUR CODE HERE
    }

    /**
     * Detect hitting the region (and restart)
     */
    public void checkWin() {
        // TODO: YOUR CODE HERE
    }

    /**
     * Detect exiting the window (and restart)
     */
    public void checkLose() {
        // TODO: YOUR CODE HERE
    }

    /**
     * Puts the object at a random point on one of the four borders, 
     * flying in to the window at a random speed.
     */
    public void toss() {
        // TODO: YOUR CODE HERE	    
    }
}
