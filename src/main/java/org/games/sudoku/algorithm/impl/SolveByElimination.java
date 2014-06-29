package org.games.sudoku.algorithm.impl;

import org.games.algorithm.spec.SudokuSolvingAlgorithm;
import org.games.sudoku.SudokuGrid;
import org.games.sudoku.swingApp.models.Board;
import org.games.sudoku.swingApp.models.Column;
import org.games.sudoku.swingApp.models.MediumBox;
import org.games.sudoku.swingApp.models.Row;

/**
 * It is very important that no two checkInteger* methods are invoked consecutively without first invoking
 * all applyElimination* methods in between their invocations. Although it looks like one set of two nested
 * for loops may handle all checkInteger* methods, it is not the case because of the aforementioned restriction.
 * If the above is not respected, the grid may end up with the same number twice or more in a row, column, or
 * medium box. The if(b.equals(snapShot)) between the invocations of checkInteger* methods makes sure that the
 * above is respected.
 * @author gagi <nberani@hotmail.com>
 * 
 */
public class SolveByElimination implements SudokuSolvingAlgorithm {

	public SudokuGrid solve(SudokuGrid sg) {
		Board b = new Board(sg);
		int i = 0;
		while(i++ < 100 && !b.isSolved()){//100 iterations must suffice. If every iteration finds exactly 1 number, then 81 iterations would be enough.
			//however, with a minimum of 17 already in place, the number of iterations necessary is even less. But, we'll do with 100.
			//If two consecutive iterations find nothing, then the grid can not be solved by this algorithm
			Board snapShot = new Board(b);
			for(int j = 0; j < 9; j++){
				applyEliminationInRow(new Row(b, j));//eliminate the found values from still empty cells in this row
				applyEliminationInColumn(new Column(b, j));//eliminate the found values from still empty cells in this column
				applyEliminationInMediumBox(new MediumBox(b, j/3, j%3));//eliminate the found values from still empty cells in this medium box
			}
			if(b.equals(snapShot)){//the row, column, medium box elimination has found nothing
				//if there is only one cell within this row that may contain k, then k must be its face
				for(int j = 0; j < 9; j++)
					for(int k = 1; k <= 9; k++)
						checkIntegerInRow(k, new Row(b, j));
				if(b.equals(snapShot)){
					//if there is only one cell within this column that may contain k, then k must be its face
					for(int j = 0; j < 9; j++)
						for(int k = 1; k <= 9; k++)
							checkIntegerInColumn(k, new Column(b, j));
				}
				if(b.equals(snapShot)){
					//if there is only one cell within this medium box that may contain k, then k must be its face
					for (int j = 0; j < 9; j++) {
						for (int k = 1; k <= 9; k++) {
							checkIntegerInMed(new Integer(k), new MediumBox(b, j/3, j%3));
						}
					}
				}
				if(b.equals(snapShot)){
					//a medium box, one 3x3 box, consists of 3 rows/columns or 1x3/3x1.
					//we want to find number that may possible be in one of the rows/columns,
					//but not on the other two rows/columns. The findProbably() method does that.
					//This should always be the last hope to find a number in the grid.
					for (int j = 0; j < 9; j++) {
						for (int k = 1; k <= 9; k++) {
//							new MediumBox(b, j/3, j%3).findProbably();
						}
					}
				}
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

	protected void applyEliminationInMediumBox(MediumBox mBox) {
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
	
	private void checkIntegerInRow(Integer i, Row row) {
		int rez = 0;
		for (int j = 0; j < 9; j++) {
			if (row.cell[j].possibilities.indexOf(i) != -1) {
				rez++;
			}
		}

		if (rez == 1) {
			for (int j = 0; j < 9; j++) {
				if (row.cell[j].possibilities.indexOf(i) > -1) {
					row.cell[j].setFace(i);
				}
			}
		}
	}
	
	private void checkIntegerInColumn(Integer i, Column col){
		int rez = 0;// kjo do ta mbaje numrin e qelulave qe mund ta permbajne
		// numrin i si fytyre, pra ne mesin e mundesive te veta

		for (int j = 0; j < 9; j++) {
			// nese qelula j brenda kolones e permbane ne mundesite e veta
			// numrin i, atehere rrite variablen rez per njo
			if (col.cell[j].possibilities.indexOf(i) != -1) {
				rez++;
			}
		}
		// nese numri i qelulave qe permbajne numrin i si mundesi (pra nese rez)
		// eshte i barabarte me 1, atehere numri i eshte ne ate qelule ku
		// numri i gjindet brenda mundesive
		if (rez == 1) {
			for (int j = 0; j < 9; j++) {
				if (col.cell[j].possibilities.indexOf(i) > -1) {
					col.cell[j].setFace(i);
				}
			}
		}
	}
	
	private void checkIntegerInMed(Integer i, MediumBox mmBox) {
		int rez = 0;
		for (int j = 0; j < 9; j++) {
			if (mmBox.cell[j].possibilities.indexOf(i) != -1) {
				rez++;
			}
		}
		if (rez == 1) {
			for (int j = 0; j < 9; j++) {
				if (mmBox.cell[j].possibilities.indexOf(i) > -1) {
					mmBox.cell[j].setFace(i);
				}
			}
		}
	}
}
