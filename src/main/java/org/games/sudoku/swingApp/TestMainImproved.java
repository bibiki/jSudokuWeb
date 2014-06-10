package org.games.sudoku.swingApp;

import javax.swing.*;
import java.awt.*;

public class TestMainImproved {
	public static void main(String[] args) {
		Board b = new Board();
		SudokuPanel s = new SudokuPanel(b);
		JFrame f = new JFrame();
		JPanel main = new JPanel();
		main.add(s);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		// f.getContentPane().add(main, BorderLayout.CENTER);
		JPanel j = new JPanel();
		j.setLayout(new GridLayout(10, 1));
		TextField foe = new TextField();
		ButtonT g = new ButtonT(s);
		foe.setText("text");
		foe.setSize(20, 20);
		CleanRows rows = new CleanRows("pastroji rreshtat", s.rrr);
		CleanColumns columns = new CleanColumns("pastroji kolonat", s.ccc);
		CleanMeds mediums = new CleanMeds("pastroji kutite", s.board);
		ShowPossibilitiesForEachSmallBox spfes = new ShowPossibilitiesForEachSmallBox(
				b);
		IntegerRowButton integbutton = new IntegerRowButton(s.rrr);
		IntegerColumnButton integCol = new IntegerColumnButton(s.ccc);
		IntegerMediButton integMedi = new IntegerMediButton(s.board);
		// ResetButton reset = new ResetButton(b);
		ProbableButton prob = new ProbableButton(s.board);
		j.add(spfes);
		j.add(rows);
		j.add(columns);
		j.add(mediums);
		j.add(g);
		j.add(foe);
		j.add(integbutton);
		j.add(integCol);
		j.add(integMedi);
		// j.add(reset);
		j.add(prob);
		main.add(j);
		f.getContentPane().add(main);
		f.setSize(500, 500);
		// f.pack();
		f.setVisible(true);
		System.out.print("gagi");
	}
}