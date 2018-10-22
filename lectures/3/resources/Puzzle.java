import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.util.ArrayList;

/**
 * Simple puzzle of rectangular fragments from an image. Click on a pair of pieces to swap.
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten for BufferedImage, Winter 2014 
 */
public class Puzzle extends DrawingFrame {
	private static final int prows = 3, pcols = 4;	// puzzle setup: number of pieces per row and column

	private int pieceWidth, pieceHeight; 			// size of pieces (computed)
	private BufferedImage[][] pieces;				// the small images broken out from the whole thing
	private int selectedR = -1, selectedC = -1; 	// selected piece; -1 for none

	public Puzzle(String filename) {
		super("Puzzle", filename);

		// Make and shuffle the pieces.
		createPieces(image);
		shufflePieces();

		// Listen for mouse presses.
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				clickPiece(event.getPoint().x, event.getPoint().y);
			}
		});

	}

	/**
	 * Creates the pieces list, fragments from the image.
	 */
	private void createPieces(BufferedImage original) {
		// Compute piece size according to how many have to fit in image and image's size.
		pieceWidth = original.getWidth() / pcols;
		pieceHeight = original.getHeight() / prows;
		// Create and fill up the array, iterating by piece row and piece column.
		pieces = new BufferedImage[prows][pcols];
		for (int r = 0; r < prows; r++) {
			for (int c = 0; c < pcols; c++) {
				pieces[r][c] = getSubimage(original, c*pieceWidth, r*pieceHeight, pieceWidth, pieceHeight);
			}
		}
	}

	/**
	 * Gets a sub-image of an image, starting at (x0,y0) and extending (dx,dy)
	 * (There's a Java method of BufferedImage that does exactly this, so this is for illustration.)
	 * @param image
	 * @param x0
	 * @param y0
	 * @param dx
	 * @param dy
	 * @return the subimage
	 */
	private static BufferedImage getSubimage(BufferedImage image, int x0, int y0, int dx, int dy) {
		// Create a new empty image of the right size and type to hold the result.
		BufferedImage result = new BufferedImage(dx, dy, image.getType());
		// The usual pattern.
		for (int y = 0; y < dy; y++) {
			for (int x = 0; x < dx; x++) {
				// The (x,y) point comes from (x+x0, y+y0)
				result.setRGB(x, y, image.getRGB(x+x0, y+y0));
			}
		}
		return result;
	}
	
	/**
	 * Shuffles the pieces array
	 */
	private void shufflePieces() {
		// Simple shuffle: swap each piece with some other one
		for (int r = 0; r < prows; r++) {
			for (int c = 0; c < pcols; c++) {
				int r2 = (int)(Math.random() * prows);
				int c2 = (int)(Math.random() * pcols);
				BufferedImage piece2 = pieces[r2][c2];
				pieces[r2][c2] = pieces[r][c];
				pieces[r][c] = piece2;
			}
		}
	}

	/**
	 * Handles clicking on a piece, by selecting/deselecting/swapping
	 * @param x		x coordinate of click
	 * @param y		y coordinate of click
	 */
	private void clickPiece(int x, int y) {
		// Determine which piece it was.
		int c = x / pieceWidth;
		int r = y / pieceHeight;
		if (selectedC == -1) {
			// First piece to be selected -> remember
			selectedC = c;
			selectedR = r;
		}
		else if (selectedC == c && selectedR == r) {
			// Same piece -> deselect
			selectedC = -1;
		}
		else {
			// Second piece -> swap
			BufferedImage piece2 = pieces[r][c];
			pieces[r][c] = pieces[selectedR][selectedC];
			pieces[selectedR][selectedC] = piece2;			
			selectedC = -1;
		}
		canvas.repaint();
	}


	/**
	 * Draws the puzzle
	 */
	public void draw(Graphics g) {
		((Graphics2D) g).setStroke(new BasicStroke(4)); // thick border
		// Lay out the pieces in a matrix.
		for (int r = 0; r < prows; r++) {
			for (int c = 0; c < pcols; c++) {
				g.drawImage(pieces[r][c], c * pieceWidth, r * pieceHeight, null);
				// Border -- green for selected, black for others
				if (c == selectedC && r == selectedR) {
					g.setColor(Color.green);
				}
				else {
					g.setColor(Color.black);
				}
				g.drawRect(c * pieceWidth, r * pieceHeight, pieceWidth - 2, pieceHeight - 2);
			}
		}
	}

	/**
	 * Main method for the application
	 * @param args		command-line arguments (ignored)
	 */
	public static void main(String[] args) { 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Fire off the puzzle.
				new Puzzle("pictures/baker.jpg");
			}
		});
	}
}
