package org.games.sudoku.swingApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ClearColumnProbablyBased extends JButton implements ActionListener {

	public Column[] ccc;

	public ClearColumnProbablyBased(Column[] c) {
		super("Kolone-probabil");
		addActionListener(this);
		ccc = c;
	}

	public void actionPerformed(ActionEvent e) {// per secilen kolone
		for (int i = 0; i < ccc.length; i++) {// per seilcen kolone te shkurte
			for (int j = 0; j < 3; j++) {// per secilen vlere brenda
											// probablyFound brenda nje kolone
											// te shkurte
				for (int k = 0; k < ccc[i].shortcolumns[j].probablyFound.size(); k++) {// per
																						// secilen
																						// nga
																						// kolonat
																						// e
																						// shkurta
																						// brenda
																						// kolones
																						// qe
																						// po
																						// lexohet...
					for (int l = 0; l < 3; l++) {// pervec asaj qe po lexohet
						if (l != j)
							for (int m = 0; m < 3; m++) {
								// elimino vlerat e probablyFound nga dy kolonat
								// e shkurta brenda
								// kolones qe po lexohet
								ccc[i].shortcolumns[l].shortcolumn[m]
										.eliminateFromPossibilities(ccc[i].shortcolumns[j].probablyFound
												.get(k));
							}
					}
				}
			}
		}
	}
}
