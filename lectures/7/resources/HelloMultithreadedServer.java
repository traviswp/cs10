import java.net.*;
import java.io.*;

/**
 * Multithreaded version of the hello server
 * Now lets multiple someones connect on port 4242; for each one,
 * it repeatedly asks for their name and greets them.
 * Connect either by "telnet localhost 4242" or by running HelloClient.java
 * (multiple times)
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; revised 2014 to split out HelloServerCommunicator
 * @author Travis Peters, Dartmouth CS 10, Winter 2015 (updated to use MyIPAddressHelper)
 */

public class HelloMultithreadedServer {	
	private ServerSocket listen;	// where clients initially connect

	public HelloMultithreadedServer(ServerSocket listen) {
		this.listen = listen;
	}

	/**
	 * Listens to listen and fires off new communicators to handle the clients
	 */
	public void getConnections() throws IOException {
        // Display your IP address so that you can tell others and they can connect to your server.
        System.out.println("HelloMultithreadedServer's IP Address INSIDE of the current network : " + MyIPAddressHelper.getMyLocalIP());
        System.out.println("HelloMultithreadedServer's IP Address OUTSIDE of the current network: " + MyIPAddressHelper.getMyGlobalIP());

        System.out.println("HelloMultithreadedServer: waiting for someone to connect");

		// Just keep accepting connections and firing off new threads to handle them.
		int num = 0;
		while (true) {
			HelloServerCommunicator client = new HelloServerCommunicator(listen.accept(), num++);
			client.setDaemon(true); // handler thread terminates when main thread does
			client.start();
		}

	}

	public static void main(String[] args) throws IOException {
		new HelloMultithreadedServer(new ServerSocket(4242)).getConnections();
	}
}
