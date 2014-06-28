package org.games.sudoku.swingApp.buttons;

import javax.swing.*;


import org.games.sudoku.swingApp.models.MediumBox;

//import java.awt.*;
import java.awt.event.*;

/*
 * teresia e logjikes se kesaj klase eshte identike me ate te klases
 * IntegerColumnButton
 */
public class IntegerMediButton extends JButton implements ActionListener {
	public MediumBox[] meds = new MediumBox[9];

	public IntegerMediButton(MediumBox[][] ar) {
		super("Medi-numer");
		for (int i = 0; i < 9; i++) {
			meds[i] = ar[i / 3][i % 3];
		}
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			System.out.println("Kolona: " + (i + 1));
			for (int j = 1; j <= 9; j++) {
//				System.out.println("\tInteger: " + new Integer(j));
				checkIntegerInMed(new Integer(j), meds[i]);
			}
		}
	}

	public void checkIntegerInMed(Integer i, MediumBox m) {
		int rez = 0;

		for (int j = 0; j < 9; j++) {
			System.out.println("\t\tShtylla: " + j);
			if (m.cell[j].possibilities.indexOf(i) != -1) {
				rez++;
				System.out.println("\t\t\tu gjet potenciali");
			}
		}

		if (rez == 1) {
			for (int j = 0; j < 9; j++) {
				if (m.cell[j].possibilities.indexOf(i) > -1) {
					m.cell[j].setFace(i);
				}
			}
		}
	}

}