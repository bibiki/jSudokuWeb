package org.games.sudoku.swingApp;

import java.util.ArrayList;

public class Column {
	// teresia e qelulave qe kjo kolone permbane
	public SmallBox[] column = new SmallBox[9];
	// numrat qe ende nuk jane gjete brenda kesaj kolone
	public ArrayList<Integer> notFound = new ArrayList<Integer>();
	// tri kolonat e shkurta qe e ndertojne kete kolone
	public ShortColumn[] shortcolumns = new ShortColumn[3];

	public Column(Board b, int col) {
		// vendosi qelulat korresponduese ne kete kolone
		for (int i = 0; i < 9; i++) {
			column[i] = b.board[i][col];
		}
	}

	// per ndihme gjate zhvillimit, kjo afishon fytyrat e qelulave te kolones
	public void afishojeKolonen() {
		for (int i = 0; i < 9; i++) {
			System.out.println(column[i].face);
		}
	}
}