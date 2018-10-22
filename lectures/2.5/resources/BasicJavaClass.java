/*
 * IMPORT STATEMENT(S).
 */

/**
 * ADD: HEADER COMMENT DESCRIBING THIS CLASS/YOUR PROGRAM.
 * 
 * GENERAL NOTES.
 * - Indent code further within each code block; use consistent indentation.
 *   (e.g., I use 1 tab (== 4 spaces) for each indent level).
 * - Capitalize class names. Use mixed case for class names w/ more than one word.
 * - Instance variables are often "private" -- use methods to expose an 
 *   interface for other objects if they need access to this classes's instance
 *   variables.
 * - A given line of code should not exceed 120 characters in length.
 * 
 * @author YOUR_NAME, CS 10 - Dartmouth College, Winter 2015.
 * @author Travis Peters, CS 10 - Dartmouth College, Winter 2015.
 */
public class BasicJavaClass {

    /*
     * INSTANCE VARIABLES.
     *  - constants should be in all CAPS.
     *  - variables names are often camelCase or use_underscores (either is fine; be consistent).
     */
    private String MY_STRING = "this is a string :)";
    private int my_var = 5;
    
    /*
     * CONSTRUCTOR(S).
     * - only include the bare minimum of what is needed to initialize an object as needed/desired.
     */

    /**
     * DESCRIPTION (if needed ).
     * 
     * @param PARAM1  BRIEF COMMENT ABOUT ANY/ALL PARAMS (IF ANY).
     */
    public BasicJavaClass() {
        // CONSTRUCTOR CODE HERE.
    }
    
    /*
     * PUBLIC METHODS.
     * - method names are often camelCase or use_underscores (either is fine; be consistent)
     * - method names are often *verbs* (e.g., move(), findX(), getY(), setZ(), ...)
     * - methods names are sometimes *questions* (e.g., isFound(), isInside, ...)
     */

    /**
     * DESCRIPTION.
     * 
     * @param PARAM1  BRIEF COMMENT ABOUT ANY/ALL PARAMS (IF ANY).
     */
    public int myPublicMethod(int x, int y) {
        // METHOD CODE HERE.
        return x + y;
    }
    
    /*
     * PRIVATE (AND PROTECTED) METHODS.
     * - same notes about public methods hold for private methods. 
     */

    /**
     * DESCRIPTION.
     * 
     * @param PARAM1  BRIEF COMMENT ABOUT ANY/ALL PARAMS (IF ANY).
     */
    private int myPrivateMethod(int z) {
        // METHOD CODE HERE
        return z;
    }
    
    /*
     * MAIN METHOD TYPICALLY IS THE BOTTOM-MOST METHOD DEFINED IN THE CLASS.
     */
    public static void main(String[] args) {
        // MAIN CODE HERE.
    }
    
}
