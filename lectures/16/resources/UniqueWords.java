import java.util.*;

/**
 * Identifies unique words in a document, via a set
 *
 * @author Haris Baig and Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012
 */
public class UniqueWords {
	public static void main(String[] args) {
		String page = "Pretend that this string was loaded from a web page.  We won't go to all that trouble here.  This string contains multiple words. And multiple copies of multiple words.  And multiple words with multiple copies.  It is to be used as a test to demonstrate how sets work in removing redundancy by keeping only one copy of each thing. Is it very very redundant in having more than one copy of some words?";
		String[] allWords = page.split("[ .,?!]+"); // split on punctuation and white space

		Set<String> uniqueWords = new TreeSet<String>();

		// Loop over all the words split out of the string, adding to set
		for (String s: allWords) {
			uniqueWords.add(s.toLowerCase());
		}

		System.out.println(allWords.length + " words");
		System.out.println(uniqueWords.size() + " unique words");
		System.out.println(uniqueWords);
	}
}
