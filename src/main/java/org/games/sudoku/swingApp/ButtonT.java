package org.games.sudoku.swingApp;

import javax.swing.*;
// import java.awt.*;
import java.awt.event.*;

public class ButtonT extends JButton implements ActionListener {
	public SudokuPanel sud;

	public ButtonT(SudokuPanel sudoku) {
		super("shih cfare eshte gjetur");
		sud = sudoku;
		addActionListener(this);
	}

	// ky buton percakton numrat qe nuk jane gjete ne secilen kuti te mesme
	// si dhe ben afishimin e vlerave qe nuk jane gjete ne nje kuti te mesme
	// ne buton shenon 'shih cfare eshte gjetur', por ne afishim dalin ato
	// qe s'jane gjetur. pra, cfare nuk shihet ne standard output, ajo eshte
	// gjetur
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sud.board[i][j].registerFound();
			}
		}
	}

}