package org.games.sudoku.swingApp;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;

public class ShowPossibilitiesForEachSmallBox extends JButton implements
		ActionListener {
	public Board board;

	public ShowPossibilitiesForEachSmallBox(Board b) {
		super("mundesite e seciles kuti");
		board = b;
		addActionListener(this);
	}

	// ky buton tregon mundesite per secilen qelule.
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board.board[i][j].whatMightBe(i, j);
			}
		}
	}

}