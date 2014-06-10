package org.games.sudoku.swingApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ClearRowProbablyBased extends JButton implements ActionListener {

	public Row[] rrr;

	public ClearRowProbablyBased(Row[] r) {
		super("Rresht-probabil");
		addActionListener(this);
		rrr = r;
	}

	public void actionPerformed(ActionEvent e) { // per secilin rresht
		for (int i = 0; i < rrr.length; i++) { // per secilin rresht te shkurte
												// brenda rreshtit
			for (int j = 0; j < 3; j++) {// per secilen vlere vrenda
											// probablyFound brenda rreshtit te
											// shkurte
				for (int k = 0; k < rrr[i].shorties[j].probablyFound.size(); k++) {// per
																					// secilin
																					// rresht
																					// te
																					// shkurte
																					// brenda
																					// rreshtit...
					for (int l = 0; l < 3; l++) {// pervec asaj qe po lexohet
						if (l != j)
							for (int m = 0; m < 3; m++) {// elimino vlerat e
															// probablyFound nga
															// dy rreshtat e
															// shkurte brenda
															// rreshtit qe po
															// lexohet
								rrr[i].shorties[l].shortrow[m]
										.eliminateFromPossibilities(rrr[i].shorties[j].probablyFound
												.get(k));
							}
					}
				}
			}
		}
	}
}
