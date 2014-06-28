package org.games.sudoku.impl;

import org.games.algorithm.spec.SudokuSolvingAlgorithm;
import org.games.sudoku.SudokuGrid;
import org.games.sudoku.swingApp.models.Board;
import org.games.sudoku.swingApp.models.Column;
import org.games.sudoku.swingApp.models.MediumBox;
import org.games.sudoku.swingApp.models.Row;

/**
 * 
 * @author gagi <nberani@hotmail.com>
 * 
 */
public class SolveByElimination implements SudokuSolvingAlgorithm {

	public SudokuGrid solve(SudokuGrid sg) {
		// TODO Auto-generated method stub
		Board b = new Board(sg);
		int i = 0;
		while(i++ < 100){
			for(int j = 0; j < 9; j++){
				applyEliminationInRow(new Row(b, j));
				applyEliminationInColumn(new Column(b, j));
			}
				
		}
		return b.toSudokuGrid();
	}

	public void applyEliminationInRow(Row row) {
		for (int j = 0; j < 9; j++) {
			if (!row.cell[j].face.equals(new Integer(0))) {
				for (int k = 0; k < 9; k++) {
					if (k != j) {
						row.cell[k]
								.eliminateFromPossibilities(row.cell[j].face);
					}
				}
			}
		}
	}

	public void applyEliminationInColumn(Column col) {
		for (int j = 0; j < 9; j++) {
			if (!col.cell[j].face.equals(new Integer(0))) {
				for (int k = 0; k < 9; k++) {
					if (k != j) {
						col.cell[k]
								.eliminateFromPossibilities(col.cell[j].face);
					}
				}
			}
		}
	}

	public void applyEliminationInMediumBox(MediumBox mBox) {
		for (int j = 0; j < 9; j++) {
			if (!(mBox.cell[j].face.equals(new Integer(0)))) {
				for (int k = 0; k < 9; k++) {
					if (k != j) {
						mBox.cell[k].eliminateFromPossibilities(mBox.cell[j].face);
					}
				}
			}
		}
	}
}
