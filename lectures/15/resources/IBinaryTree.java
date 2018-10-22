import java.util.*;
import java.io.*;

/**
 * Generic binary tree, storing data of a parametric data in each node
 * Now with iterator
 *
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012
 */

public class IBinaryTree<E> {
	private IBinaryTree<E> left, right;	// children; can be null
	E data;

	private class PreorderBinaryTree implements SimpleIterator<E> {
		Stack<IBinaryTree<E>> toVisit;

		PreorderBinaryTree(IBinaryTree<E> t) {
			toVisit = new Stack<IBinaryTree<E>>();
			toVisit.push(t);
		}

		public boolean hasNext() {
			return !toVisit.isEmpty();
		}

		public E next() throws Exception {
			if (toVisit.isEmpty()) throw new Exception("no more elements");
			IBinaryTree<E> next = toVisit.pop();
			// After next, will visit its left child and then its right, so push in opposite order
			if (next.hasRight()) toVisit.push(next.right);
			if (next.hasLeft()) toVisit.push(next.left);
			return next.data;
		}
	}

	public SimpleIterator<E> newPreorder() {
		return new PreorderBinaryTree(this);
	}

	/**
	 * Constructs leaf node -- left and right are null
	 */
	public IBinaryTree(E data) {
		this.data = data; this.left = null; this.right = null;
	}

	/**
	 * Constructs inner node
	 */
	public IBinaryTree(E data, IBinaryTree<E> left, IBinaryTree<E> right) {
		this.data = data; this.left = left; this.right = right;
	}

	/**
	 * Is it an inner node?
	 */
	public boolean isInner() {
		return left != null || right != null;
	}

	/**
	 * Is it a leaf node?
	 */
	public boolean isLeaf() {
		return left == null && right == null;
	}

	/**
	 * Does it have a left child?
	 */
	public boolean hasLeft() {
		return left != null;
	}

	/**
	 * Does it have a right child?
	 */
	public boolean hasRight() {
		return right != null;
	}

	/**
	 * Number of nodes (inner and leaf) in tree
	 */
	public int size() {
		// Now let the iterator handle the tree-walking
		int num = 0;
		try {
			for (SimpleIterator<E> iter = newPreorder(); iter.hasNext(); iter.next()) {
				num++;
			}
		}
		catch (Exception e) {
			// we check hasNext() so the next() exception shouldn't happen
			// (would be better if it had a distinct type that we could catch)
		}
		return num;
	}


	/**
	 * Very simplistic binary tree parser based on Newick representation
	 * Assumes that each node is given a label; that becomes the data
	 * Any distance information (following the colon) is stripped
	 * <tree> = "(" <tree> ["," <tree> ]")" <label> [":"<dist>]
	 *        | <label> [":"<dist>]
	 * No effort at all to handle malformed trees or those not following these strict requirements
	 */
	public static IBinaryTree<String> parseNewick(String s) {
		IBinaryTree<String> t = parseNewick(new StringTokenizer(s, "(,)", true));
		// Get rid of the semicolon
		t.data = t.data.substring(0,t.data.length()-1);
		return t;
	}

	/**
	 * Does the real work of parsing, now given a tokenizer for the string
	 */
	public static IBinaryTree<String> parseNewick(StringTokenizer st) {
		String token = st.nextToken();
		if (token.equals("(")) {
			// Inner node
			IBinaryTree<String> left = parseNewick(st);
			String comma = st.nextToken();
			IBinaryTree<String> right = null;
			if (comma.equals(",")) {
				right = parseNewick(st);	
				String close = st.nextToken();
			}
			String label = st.nextToken();
			String[] pieces = label.split(":");
			return new IBinaryTree<String>(pieces[0], left, right);
		}
		else {
			// Leaf
			String[] pieces = token.split(":");
			return new IBinaryTree<String>(pieces[0]);
		}
	}

	/**
	 * Some tree testing
	 */
	public static void main(String[] args) throws IOException {
		IBinaryTree<String> t = parseNewick("((a,b)c,(d,e)f)g;");		
		System.out.println(t.size());
	}
}
