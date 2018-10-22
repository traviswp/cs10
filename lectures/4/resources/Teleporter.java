/**
 * An agent with a new method to jump to a random position.
 */
public class Teleporter extends Agent {
	private int xmax, ymax;	// size of bouncing area

	public Teleporter(double x, double y, int xmax, int ymax) {
		super(x, y);
		this.xmax = xmax; this.ymax = ymax;
	}
	
	public void teleport() {
		x = Math.random()*xmax;
		y = Math.random()*ymax;			
	}
}
