package org.games.sudoku.swingApp.buttons;

import javax.swing.*;


import org.games.sudoku.swingApp.models.Board;

//import java.awt.*;
import java.awt.event.*;

public class ResetButton extends JButton implements ActionListener {
	public Board board;

	public ResetButton(Board b) {
		super("Reseto");
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		board = new Board();
	}

}