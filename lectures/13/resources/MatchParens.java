import java.util.*;

/**
 * Simple stack-based parenthesis matching
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012
 */
public class MatchParens {
	public static String opens = "({[<";	// opening parens
	public static String closes = ")}]>";	// closing parens, in same order as their partners in opens

	/**
	 * Checks whether s is properly parenthesized and prints an appropriate message
	 */
	public static boolean check(String s) {
		System.out.println("checking "+s);
		Stack<Integer> opened = new Stack<Integer>();	// all the opened but not yet close parens, represented as their indexes into opens
		for (int i = 0; i<s.length(); i++) {
			// Look at each character's index in opens and closes to see if it's a paren and what kind
			char c = s.charAt(i);
			int idx;
			if ((idx = opens.indexOf(c)) >= 0) {
				opened.push(idx);
			}
			else if ((idx = closes.indexOf(c)) >= 0) {
				if (opened.isEmpty()) {
					System.out.println("unopened at position "+i);
					return false;
				}
				if (opened.pop() != idx) {
					System.out.println("mismatched at position "+i);
					return false;
				}
			}
			else {
				System.out.println("not a paren at position "+i);
				return false;
			}
		}

		if (!opened.isEmpty()) {
			System.out.println(opened.size() + " unclosed");
			return false;
		}

		System.out.println("passed");
		return true;
	}

	public static void main(String args[]) {
		check("()");
		check("({{}})[<>]");
		check("()(())((()))(((())))");
		check("(");
		check(")");
		check("(ok)");
		check("<<<<<<>>>>>");
		check("<<<<>>>>>");
	}
}
