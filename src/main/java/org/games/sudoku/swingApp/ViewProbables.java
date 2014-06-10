package org.games.sudoku.swingApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/*
 * kjo klase shfrytezohet si buton per te shikuar permbajtjen e probabileve te
 * kolonave te shkurta si dhe te rreshtave te shkurte
 */

public class ViewProbables extends JButton implements ActionListener {
	public ShortRow[][] shortrows;
	public ShortColumn[][] shortcolumns;

	public ViewProbables(ShortRow[][] s, ShortColumn[][] c) {
		super("shih probabilet");
		addActionListener(this);
		shortrows = s;
		shortcolumns = c;
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				shortcolumns[i][j].viewProbable();
			}
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				shortrows[j][i].viewProbable();
			}
		}
	}
}
