import java.net.*;
import java.io.*;

public class WWWGet {
    
	public static void main(String[] args) throws Exception  {
		// Open a stream reader for processing the response from the URL
		URL url = new URL("http://www.cs.dartmouth.edu/~traviswp/cs10/lectures/6/6.html");
		System.out.println("*** getting " + url);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
		// Read lines from the stream
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
		
		System.out.println("*** done");
	}
	
}
