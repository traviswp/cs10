import java.util.*;

/**
 * Identifies unique words in a document, and their numbers of occurrences, via a map
 *
 * @author Haris Baig and Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012
 */
public class UniqueWordsCounts {
	public static void main(String[] args) {
		String page = "Pretend that this string was loaded from a web page.  We won't go to all that trouble here.  This string contains multiple words. And multiple copies of multiple words.  And multiple words with multiple copies.  It is to be used as a test to demonstrate how sets work in removing redundancy by keeping only one copy of each thing. Is it very very redundant in having more than one copy of some words?";
		String[] allWords = page.split("[ .,?!]+");
		
		Map<String,Integer> wordCounts = new TreeMap<String,Integer>(); // word -> count

		// Loop over all the words split out of the string, adding to map or incrementing count
		for (String s: allWords) {
			String word = s.toLowerCase();
			if (wordCounts.containsKey(word)) {
				// Increment the count
				wordCounts.put(word, wordCounts.get(word)+1);
			}
			else {
				// Add the new word
				wordCounts.put(word, 1);
			}
		}

		System.out.println(wordCounts);
	}
}
