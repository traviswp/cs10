/**
 * Holds a pair of strings, which can be tested for equality
 * 
 * @author Scot Drysdale
 */
public class StringPair {

    private String s1, s2; // The pair of strings

    /**
     * Contruct a new pair
     * 
     * @param str1 the first string
     * @param str2 the second string
     */
    public StringPair(String str1, String str2) {
        s1 = str1;
        s2 = str2;
    }

    public boolean equals(Object other) {
        StringPair otherPair = (StringPair) other;
        return s1.equals(otherPair.s1) && s2.equals(otherPair.s2);
    }

    public int hashCode() {
        return s1.hashCode() + 31 * s2.hashCode();
    }
}
