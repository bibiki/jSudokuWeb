package org.games.sudoku.swingApp.models;

import java.util.ArrayList;

public class Column extends AbstractSudokuBlock {

	// these are the three short columns a Sudoku column contains
	public ShortColumn[] shortColumns = new ShortColumn[3];

	public Column(Board b, int col) {
		// vendosi qelulat korresponduese ne kete kolone
		for (int i = 0; i < 9; i++) {
			cell[i] = b.board[i][col];
		}
	}
}