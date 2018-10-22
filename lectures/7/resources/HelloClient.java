import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Client to connect to HelloServer
 * Start the server first
 *
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012
 */
public class HelloClient {
	public static void main(String[] args) throws Exception {
		Scanner console = new Scanner(System.in);

		// Open the socket with the server, and then the writer and reader
		System.out.println("connecting...");
		Socket sock = new Socket("localhost", 4242);
		PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		System.out.println("...connected");

		// Now listen and respond
		String line;
		while ((line = in.readLine()) != null) {
            // Output what you read
		    System.out.println(line);

            // Get some more input (from the user) to write to the open socket (server)
			String name = console.nextLine();
			out.println(name);
		}
		System.out.println("server hung up");

		// Clean up shop
		out.close();
		in.close();
		sock.close();
	}
}
