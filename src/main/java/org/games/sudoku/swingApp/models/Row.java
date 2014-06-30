package org.games.sudoku.swingApp.models;

import java.util.ArrayList;

public class Row extends AbstractSudokuBlock{// this class models a Sudoku row
	
	// these are three short rows that a Sudoku row contains
	public ShortRow[] shorties = new ShortRow[3];

	public Row(Board b, int r) {
		for (int i = 0; i < 9; i++) {
			cell[i] = b.board[r][i];
		}
	}
}