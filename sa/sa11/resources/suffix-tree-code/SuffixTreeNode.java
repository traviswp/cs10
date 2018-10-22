import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Adapted from CTCI problem 18.8.
 * 
 * Given a string, s, and an array of smaller strings T, design 
 * an algorithm to search S for each small string in T. Return 
 * the starting indices where the substring is found within the 
 * string that was used to construct the suffix tree.
 */
public class SuffixTreeNode {
    // A list of all of this SuffixTreeNode's children.
    Map<Character, SuffixTreeNode> children = new TreeMap<Character, SuffixTreeNode>();
    
    // A list which stores the starting index of this string in the suffix tree.
    ArrayList<Integer> indexes = new ArrayList<Integer>();
    
    // The character value at this SuffixTreeNode.
    char value;
    
    // An indicator for whether or not this is the root of the 
    // suffix tree (used for printing the tree).
    boolean isRoot = false;

    /**
     * Complete this method to insert suffix strings into a suffix tree.
     */
    public void insertString(String s, int index) {
        indexes.add(index);
        
        // TODO: YOUR CODE HERE.

    }

    /**
     * Complete this method to search for a given string in the suffix tree.
     */
    public ArrayList<Integer> search(String s) {
        // TODO: YOUR CODE HERE.        

    }
    
    /**
     * Print a string representation of the suffix tree.
     */
    public String toString() {
        return toStringHelper("  ");
    }

    private String toStringHelper(String indent) {
        String result = "";
        if (isRoot)
            result += "*\n";
        
        for (Character c : children.keySet()) {
            // Print self
            result += indent + c + "\n";
            // Print child
            result += children.get(c).toStringHelper(indent+"  ");
        }
        return result;        
    }    
}

