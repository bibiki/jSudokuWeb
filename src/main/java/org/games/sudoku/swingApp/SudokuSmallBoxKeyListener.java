package org.games.sudoku.swingApp;

import java.awt.event.*;

/*
 * kjo klase me sa duket degjone per tri ngjarje: pressed, typed, edhe released
 * me rastin e pressed, fshihet fytyra e butonit
 * me rastin e typed nuk behet asgje
 * me rastin e released, shih ne metoden keyReleased per komente
 */
public class SudokuSmallBoxKeyListener implements KeyListener {
	public SmallBox small;

	public SudokuSmallBoxKeyListener(SmallBox sb) {
		small = sb;
	}

	public void keyTyped(KeyEvent e) {
		System.out.println("typed");

	}

	/** Handle the key pressed event from the text field. */
	public void keyPressed(KeyEvent e) {
		small.setText("");
		System.out.println("pressed");

	}

	/** Handle the key released event from the text field. */
	public void keyReleased(KeyEvent e) {
		// String temp = small.getText();
		System.out.println(((int) (e.getKeyChar())));
		// nese tasti qe eshte shtype nuk eshte numer mes 1 dhe 9, inkluziv
		if (((int) (e.getKeyChar()) > 57) || ((int) (e.getKeyChar()) < 49)) {// nese
																				// fytyra
																				// e
																				// kesaj
																				// qelule
																				// tashme
																				// eshte
																				// e
																				// caktuar,
																				// mos
																				// e
																				// ndrysho
			if (small.face.intValue() > 0)
				small.setText("" + small.face);
			else
				// perndryshe, vendose fytyren te zbrazet
				small.setText("");
		} else {// perndryshe, vendose numrin e dhene si fytyre te kesaj qelule
			small.setFace(new Integer("" + e.getKeyChar()));
		}
		// System.out.println("Face: " + small.face + " getText: " +
		// small.getText() + "released");
		if ((int) (e.getKeyChar()) == 127) {
			small.setFace(new Integer(0));
			small.setText("");
		}
	}

}