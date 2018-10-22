/** 
 * Counter.java
 *
 * Defines a class of Counter objects. A Counter holds a single integer
 * in the range 0..(myLimit - 1). Each time tick is called the Counter's
 * value increases, wrapping back to 0 when it reaches myLimit.
 * 
 * @author Don Kreider, based on an example in Decker and Hirshfield
 * @author Scot Drysdale, converted to Java and made later modifications
 * @author Tom Cormen, also made modifications
 */
import java.text.DecimalFormat;

public class Counter {

    private int myLimit; // Upper limit on the counter
    private int myValue; // Current value
    private final static int DEFAULT_LIMIT = 12; // the default counter limit
    private final static String FORMAT = "00"; // Shows minimum number of digits

    /**
     * Constructor for the Counter class, with initial value 0 and limit 12.
     */
    public Counter() {
        myLimit = DEFAULT_LIMIT;
        myValue = 0;
    }

    /**
     * Constructor for the Counter class, with initial value 0 and given limit.
     * 
     * @param limit
     *            - the upper bound for the counter
     */
    public Counter(int limit) {
        myLimit = limit;
        myValue = 0;
    }

    /**
     * Increment the value of the Counter, wrapping back to 0 when it reaches
     * limit.
     */
    public void tick() {
        myValue++;
        if (myValue == myLimit) // Has it hit the limit?
            myValue = 0; // Wrap if it has
    }

    /**
     * Sets the value of the Counter to newValue. If newValue is too large or is
     * negative sets it to 0. (We will learn better ways to handle errors
     * later!)
     * 
     * @param newValue
     *            the value to reset the counter to
     */
    public void set(int newValue) {
        if (newValue >= 0 && newValue < myLimit)
            myValue = newValue;
        else
            myValue = 0;
    }

    /**
     * Resets the value of the Counter to 0
     */
    public void reset() {
        set(0);
    }

    /**
     * return the value of the Counter.
     * 
     * @return the current value of the counter.
     */
    public int getValue() {
        return myValue;
    }

    /**
     * returns a String representation with at least 2 digits, padding with a
     * leading 0 if necessary.
     * 
     * @return a String representation of the counter with at least 2 digits.
     */
    public String toString() {
        DecimalFormat fmt = new DecimalFormat(FORMAT); // Use at least 2 digits
        return fmt.format(myValue);
    }

    /**
     * A main program to test the counter. (Including such testing programs is a
     * good idea!)
     */

}