import java.net.*;
import java.io.*;

/**
 * Illustration of explicit catching of all errors in getting a URL
 * (compare WWWGet.java, which just passes the buck)
 *
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012
 */
public class WWWGetTry {
	public static void main(String[] args) {
		try {
			// Create the URL; can throw MalformedURL
	        URL url = new URL("http://www.cs.dartmouth.edu/~traviswp/cs10/lectures/6/6.html");
			System.out.println("*** getting " + url);

			// Create the reader for the stream; can throw IO
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			// Read the lines; can throw IO
			try {
				String line;
				while ((line = in.readLine()) != null) {
					System.out.println(line);
				}
			}
			// Be sure to close the reader, whether or not reading was successful
			finally {
				// Even closing can throw IO
				in.close();
			}
		}
		catch (MalformedURLException e) {
			System.err.println("bad URL");
		}
		catch (IOException e) {
			System.err.println("problem opening/reading/closing");
		}

		System.out.println("*** done");
	}
}
