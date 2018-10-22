import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;

/**
 * Animated agents.
 * This is just the core functionality upon which we will build
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; revised Fall 2014 for DrawingFrame and independent Agent files
 */
public class Agents extends DrawingFrame {
	private static final int width=800, height=600;		// setup: size of the world

	private ArrayList<Agent> agents;					// list of all the agents to handle
	private char agentType = 'a';						// what type of agent to create
	
	public Agents() {
		super("Animated Agents", width, height);
		
		// Initialize empty list of agents. What happens if we forget to do this?
		// (You will run into that situation in the future, I guarantee.)
		agents = new ArrayList<Agent>();
		
		// Listen for mouse presses.
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				int x = event.getPoint().x, y = event.getPoint().y;

				for (Agent agent : agents) {
					if (agent.contains(x, y)) {
						System.out.println("back off!");
						// Dangerous! What happens if we click on something that isn't a Teleporter?
						// Better to use generics to catch the possible mistake at compile time.
						// ((Teleporter)agent).teleport();
						return;
					}
				}
				
				if (agentType=='a') {
					agents.add(new Agent(x,y));
				}
				else if (agentType=='b') {
					agents.add(new Bouncer(x,y,width,height));
				}
				else if (agentType=='p') {
					agents.add(new WanderingPulsar(x,y));
				}
				else if (agentType=='t') {
					agents.add(new Teleporter(x,y,width,height));
				}
				else if (agentType=='w') {
					agents.add(new Wanderer(x,y));
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

		// Move every 100 milliseconds.
		Timer timer = new Timer(100, new AbstractAction("update") {
			public void actionPerformed(ActionEvent e) {
				// Ask all the agents to draw themselves.
				for (Agent agent : agents) {
					agent.move();
				}
				canvas.repaint();
			}
		});
		timer.start();
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
				new Agents();
			}
		});
	}
}
