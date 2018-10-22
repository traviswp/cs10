/**
 * An agent that moves randomly and pulsates (radius increases/decreases).
 */
public class WanderingPulsar extends Wanderer {
	private int dr = 1;
	
	public WanderingPulsar(double x, double y) {
		super(x, y);
		r = (int)(Math.random()*10);
	}
	
	public void move() {
		// First wander.
		super.move();
		// Now pulsate.
		r += dr;
		if (r == 0 || r == 10) {
			dr = -dr;
		}
	}
}
