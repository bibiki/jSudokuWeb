package org.games.sudoku.swingApp;

import javax.swing.*;
import java.awt.event.*;

//import java.awt.*;

public class CleanMeds extends JButton implements ActionListener {
	public MediumBox[] meds = new MediumBox[9];

	public CleanMeds(String lab, MediumBox[][] ar) {
		super("Pastroji Medat");
		for (int i = 0; i < 9; i++) {
			meds[i] = ar[i / 3][i % 3];
		}
		addActionListener(this);
	}

	// ky eshte butoni qe ben pastrimin e kutive te mesme sipas vlerave te
	// fytyrave te qelulave, fytyrat e te cilave jane percaktuar
	public void actionPerformed(ActionEvent e) {
		System.out.println("removing possibilities");
		for (int i = 0; i < meds.length; i++) {
			for (int j = 0; j < 9; j++) {
				// System.out.println(!(meds[i].med[j].face.equals(new
				// Integer(0))));
				if (!(meds[i].med[j].face.equals(new Integer(0)))) {
					for (int k = 0; k < 9; k++) {
						if (k != j) {
							// System.out.println("clening");
							meds[i].med[k]
									.eliminateFromPossibilities(meds[i].med[j].face);
							// System.out.println("\t\t\tclening");
						}
					}
				}
			}
		}
	}

}