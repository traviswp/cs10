import java.awt.Color;
import java.awt.Graphics;

/**
 * An agent that moves randomly.
 */
public class WanderingPixel extends Wanderer {
	private Color color;
	
	public WanderingPixel(int x, int y, int r, Color c) {
		super(x, y);
		this.r = r;
		this.color = c;
	}
	
	/**
	 * Override draw method to set color.
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
	}
}
