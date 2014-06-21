package org.games.sudoku.swingApp.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.games.sudoku.swingApp.models.MediumBox;

public class ProbableButton extends JButton implements ActionListener {
	public MediumBox[][] med;

	public ProbableButton(MediumBox[][] m) {
		super("Gjeji probabilet");
		med = m;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < med.length; i++) {
			for (int j = 0; j < med[0].length; j++) {
				// shih ne klasen MediumBox per specifikat e kesaj metode
				med[i][j].findProbably();
			}
		}
	}
}
