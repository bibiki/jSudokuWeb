package org.games.sudoku.swingApp;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;

public class IntegerColumnButton extends JButton implements ActionListener {
	public Column[] col;

	public IntegerColumnButton(Column[] c) {
		super("Kolone-numer");
		col = c;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			// System.out.println("Kolona: " + (i + 1));
			for (int j = 1; j <= 9; j++) {
				// System.out.println("\tInteger: " + new Integer(j));
				// shih me poshte cfare ben kjo metode
				checkIntegerInColumn(new Integer(j), col[i]);
			}
		}
	}

	// kjo metode kerkon nese nje kolone ka nje qelule te vetme qe mund
	// ta kete per fytyre te veten nje numer te caktuar
	// actionPerformed e ben kete per secilin numer ndaj kesaj kolone
	public void checkIntegerInColumn(Integer i, Column c) {
		int rez = 0;// kjo do ta mbaje numrin e qelulave qe mund ta permbajne
		// numrin i si fytyre, pra ne mesin e mundesive te veta

		for (int j = 0; j < 9; j++) {
			// System.out.println("\t\tShtylla: " + j);
			// nese qelula j brenda kolones e permbane ne mundesite e veta
			// numrin i, atehere rrite variablen rez per njo
			if (c.column[j].possibilities.indexOf(i) != -1) {
				rez++;
				// System.out.println("\t\t\tu gjet potenciali");
			}
		}
		// nese numri i qelulave qe permbajne numrin i si mundesi (pra nese rez)
		// eshte i barabarte me 1, atehere numri i eshte ne ate qelule ku
		// numri i gjindet brenda mundesive
		if (rez == 1) {
			for (int j = 0; j < 9; j++) {
				if (c.column[j].possibilities.indexOf(i) > -1) {
					c.column[j].setFace(i);
				}
			}
		}
	}

}