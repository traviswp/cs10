import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * Simple puzzle of rectangular fragments from an image. Click on a pair of pieces to swap.
 * Input is now from webcam rather than an image
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012; rewritten Winter 2014 for Webcam class
 */
public class WebcamPuzzle extends Webcam {
	private static final int prows = 3, pcols = 4;	// puzzle setup: number of pieces per row and column

	private int pieceWidth, pieceHeight; 			// size of pieces (computed)
	private int[][] pieceR, pieceC;					// which underlying piece is currently at the row, column
	private BufferedImage[][] pieces;				// the small images broken out from the whole thing
	private int selectedR = -1, selectedC = -1; 	// selected piece; -1 for none

	public WebcamPuzzle() {
		// Create holders for pieces and piece ordering
		pieces = new BufferedImage[prows][pcols];
		pieceR = new int[prows][pcols];
		pieceC = new int[prows][pcols];

		// Shuffle the order of the pieces.
		shufflePieceOrder();
	}

	/**
	 * Creates the pieces list, fragments from the image.
	 * Just copied from Puzzle.java (else might have not used the pieces[][] instance variable).
	 */
	private void createPieces(BufferedImage original) {
		// Compute piece size according to how many have to fit in image and image's size.
		pieceWidth = original.getWidth() / pcols;
		pieceHeight = original.getHeight() / prows;
		// Create and fill up the array, iterating by piece row and piece column.
		pieces = new BufferedImage[prows][pcols];
		for (int r = 0; r < prows; r++) {
			for (int c = 0; c < pcols; c++) {
				// Note that now use pieceR and pieceC to get which piece should be here.
				pieces[r][c] = original.getSubimage(pieceC[r][c]*pieceWidth, pieceR[r][c]*pieceHeight, pieceWidth, pieceHeight);
			}
		}
	}

	/**
	 * Shuffles the pieces row and column order arrays
	 */
	private void shufflePieceOrder() {
		// Initialize the order with the initial row,column layout
		for (int r = 0; r < prows; r++) {
			for (int c = 0; c < pcols; c++) {
				pieceR[r][c] = r;
				pieceC[r][c] = c;
			}
		}
		// Simple shuffle: swap each piece with some other one
		for (int r = 0; r < prows; r++) {
			for (int c = 0; c < pcols; c++) {
				int r2 = (int)(Math.random() * prows);
				int c2 = (int)(Math.random() * pcols);
				int pr2 = pieceR[r2][c2];
				int pc2 = pieceC[r2][c2];
				pieceR[r2][c2] = pieceR[r][c];
				pieceC[r2][c2] = pieceC[r][c];
				pieceR[r][c] = pr2;
				pieceC[r][c] = pc2;
			}
		}
	}

	/**
	 * Overrides the generic webcam mouse handler, selecting/deselecting/swapping
	 */
	public void handleMousePress(MouseEvent event) {
		// Determine which piece it was.
		int x = event.getPoint().x;
		int y = event.getPoint().y;
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
			int pr2 = pieceR[r][c];
			int pc2 = pieceC[r][c];
			pieceR[r][c] = pieceR[selectedR][selectedC];
			pieceC[r][c] = pieceC[selectedR][selectedC];
			pieceR[selectedR][selectedC] = pr2;
			pieceC[selectedR][selectedC] = pc2;
			selectedC = -1;
		}
	}


	/**
	 * Draws this component, by asking the superclass to do its part and then
	 * doing the drawing we want to do.
	 */
	public void draw(Graphics g) {
		if (image == null) return;

		((Graphics2D) g).setStroke(new BasicStroke(4)); // thick border
		// Lay out the pieces in a 2d array.
		createPieces(image);
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
				new WebcamPuzzle();
			}
		});
	}
}
