package org.games.sudoku.swingApp.buttons;

import javax.swing.*;

import org.games.sudoku.swingApp.models.Row;

import java.awt.event.*;

//import java.awt.*;

public class CleanRows extends JButton implements ActionListener {
	public Row[] rows;

	public CleanRows(String lab, Row[] ar) {
		super("Pastroji rreshtat");
		rows = ar;
		addActionListener(this);
	}

	// ky eshte butoni qe ben pastrimin e rreshtave sipas vlerave te fytyrave
	// te qelulave, fytyrat e te cilave jane percaktuar
	public void actionPerformed(ActionEvent e) {
		// System.out.println("removing possibilities");
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < 9; j++) {
				if (!rows[i].row[j].face.equals(new Integer(0))) {
					for (int k = 0; k < 9; k++) {
						if (k != j) {
							// System.out.println("clening");
							rows[i].row[k]
									.eliminateFromPossibilities(rows[i].row[j].face);
							// System.out.println("\t\t\tclening");
						}
					}
				}
			}
		}
	}

}