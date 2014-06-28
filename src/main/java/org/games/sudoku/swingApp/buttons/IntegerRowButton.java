package org.games.sudoku.swingApp.buttons;

import javax.swing.*;


import org.games.sudoku.swingApp.models.Row;

//import java.awt.*;
import java.awt.event.*;

/*
 * teresia e logjikes se kesaj klase eshte identike me ate te klases
 * IntegerColumnButton
 */
public class IntegerRowButton extends JButton implements ActionListener {
	public Row[] row;

	public IntegerRowButton(Row[] r) {
		super("Rresht-numer");
		row = r;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			System.out.println("Rreshti: " + (i + 1));
			for (int j = 1; j <= 9; j++) {
//				System.out.println("\tInteger: " + new Integer(j));
				checkIntegerInRow(new Integer(j), row[i]);
			}
		}
	}

	public void checkIntegerInRow(Integer i, Row r) {
		int rez = 0;
		for (int j = 0; j < 9; j++) {
			System.out.println("\t\tShtylla: " + j);
			if (r.cell[j].possibilities.indexOf(i) != -1) {
				rez++;
				System.out.println("\t\t\tu gjet potenciali");
			}
		}

		if (rez == 1) {
			for (int j = 0; j < 9; j++) {
				if (r.cell[j].possibilities.indexOf(i) > -1) {
					// r.row[j].possibilities.get(j);
					r.cell[j].setFace(i);
				}
			}
		}
	}
}