import java.awt.*;
import java.awt.event.*;

import javax.swing.SwingUtilities;

import java.util.ArrayList;

/**
 * Animated agents.
 * This is just the core functionality upon which we will build
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; revised Fall 2014 for DrawingFrame and independent Agent files
 */
public class AgentsCore extends DrawingFrame {
	private static final int width=800, height=600;		// setup: size of the world

	private ArrayList<Agent> agents;					// list of all the agents to handle
	private char agentType = 'a';						// what type of agent to create
	
	public AgentsCore() {
		super("Animated Agents", width, height);
		
		// Initialize empty list of agents. What happens if we forget to do this?
		// (You will run into that situation in the future, I guarantee.)
		agents = new ArrayList<Agent>();
		
		// Listen for mouse presses.
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				int x = event.getPoint().x, y = event.getPoint().y;
				if (agentType=='a') {
					agents.add(new Agent(x,y));
				}
				else {
					System.err.println("Unknown agent type "+agentType);
				}
				// Need to redraw since agents may be modified
				repaint();
			}
		});

		// Listen for key presses.
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				agentType = e.getKeyChar();
			}
		});
	}
	
	/**
	 * Override method from DrawingFrame, in order to draw all the agents
	 */
	public void draw(Graphics g) {
		for (Agent agent : agents) {
			agent.draw(g);
		}		
	}
	
	/**
	 * Main method for the application
	 * 
	 * @param args	ignored
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AgentsCore();
			}
		});
	}
}
