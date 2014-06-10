package org.games.sudoku.swingApp;

import javax.swing.*;

import java.awt.*;

public class TestMain {
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
		j.setLayout(new GridLayout(6, 2));
		ButtonT g = new ButtonT(s);
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
		ViewProbables views = new ViewProbables(s.shortrows, s.shortcolumns);
		ClearRowProbablyBased clrpb = new ClearRowProbablyBased(s.rrr);
		ClearColumnProbablyBased clcpb = new ClearColumnProbablyBased(s.ccc);
		j.add(spfes);
		j.add(g);
		j.add(rows);
		j.add(integbutton);
		j.add(columns);
		j.add(integCol);
		j.add(mediums);
		j.add(integMedi);
		j.add(prob);
		j.add(views);
		j.add(clrpb);
		j.add(clcpb);
		main.add(j);
		f.getContentPane().add(main);
		// f.setSize(500, 500);
		f.pack();
		f.setVisible(true);
	}
}