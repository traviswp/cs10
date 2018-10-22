import java.util.ArrayList;

/**
 * Adapted from CTCI problem 18.8.
 * 
 * Given a string, s, and an array of smaller strings T, design 
 * an algorithm to search S for each small string in T. Return 
 * the starting indices where the substring is found within the 
 * string that was used to construct the suffix tree.
 */
public class SuffixTree {
    SuffixTreeNode root = new SuffixTreeNode();
    
    /**
     * Build a suffix tree.
     * 
     * @param s  The input string used to construct a suffix tree.
     */
    public SuffixTree(String s) {
        root.isRoot = true;
        // TODO: YOUR CODE HERE.
        
    }
    
    /**
     * Search the suffix tree starting at the root.
     * 
     * @param s  The input string to search for in the suffix tree.
     * @return   A list of indices.
     */
    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }
    
    /**
     * Print a string representation of the SuffixTree
     */
    public String toString() {
        return root.toString();
    }
    
    public static void main(String[] args) {
//        String s = "mississippi";
//        String[] T = {"mi", "iss", "ippi", "s", "t"};
        String s = "bibs";
        String[] T = {"b", "ibs", "bs", "s"};
        
        SuffixTree tree = new SuffixTree(s);
        System.out.println("word: " + s);
        System.out.println("suffix tree:\n" + tree);
        for (String t : T) {
            System.out.println("found '" + t + "' @ " + tree.search(t));
        }
    }
}