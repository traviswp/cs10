/**
 * Puts messages in the box for ProducerConsumer
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; revised Winter 2014 to separate out helper classes
 */
public class Producer extends Thread {
	private MessageBox box;

	public Producer(MessageBox box) {
		this.box = box;
	}

	/**
	 * Wait for a while then puts a message
	 * Puts "EOF" when # messages have been put
	 */
	public void run() {
		try {
			for (int i = 0; i < ProducerConsumer.numMessages; i++) {
				sleep((int)(Math.random()*5000));
				box.put("message #" + i);
			}
			box.put("EOF");
		}
		catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}