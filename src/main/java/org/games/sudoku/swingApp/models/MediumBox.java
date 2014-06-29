package org.games.sudoku.swingApp.models;

import java.awt.TextField;
import java.util.ArrayList;

public class MediumBox extends AbstractSudokuBlock{
	public ArrayList<Integer> notFound = new ArrayList<Integer>();
	public SmallBox[][] mediumBox = new SmallBox[3][3];
	public ShortColumn[] shortCols = new ShortColumn[3];
	public ShortRow[] shortRows = new ShortRow[3];

	public TextField[][] mediumBoxInput = new TextField[3][3];

	// row and col determine wich MediumBox within the Sudoku grid
	// is being built
	public MediumBox(Board b, int row, int col) {
		// no number is assumed found
		for (int num = 1; num <= 9; num++) {
			notFound.add(num);
		}
		// this part determines what cells from the Board belong to this MediumBox
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (r / 3 == row && c / 3 == col) {
					mediumBox[r % 3][c % 3] = b.board[r][c];
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			cell[i] = mediumBox[i / 3][i % 3];
			if(i < 3){
				shortRows[i] = new ShortRow();
				shortCols[i] = new ShortColumn();
			}
			shortRows[i/3].shortrow[i%3] = cell[i];
			shortCols[i%3].shortcolumn[i/3] = cell[i];
		}
	}

	public void registerFound() {
		// putting all numbers in the notFound list before removing those that were found
		for (int i = 1; i <= 9; i++) {
			if (!notFound.contains(new Integer(i))) {
				notFound.add(new Integer(i));
			}
		}
		// here we remove all numbers that have been found in this MediumBox from the notFound list
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(mediumBox[i][j].face.intValue() < 1 || mediumBox[i][j].face
						.intValue() > 9)) {
					notFound.remove(mediumBox[i][j].face);
				}
			}
		}
	}

	// this method performs the intersection operation on two ArrayLists
	// TODO: Will need to use Set
	public ArrayList<Integer> unifyArrayLists(ArrayList<Integer> first,
			ArrayList<Integer> second) {
		ArrayList<Integer> rez = new ArrayList<Integer>();
		for (int i = 0; i < first.size(); i++) {
			rez.add(first.get(i));
		}
		for (int i = 0; i < second.size(); i++) {
			if (rez.indexOf(second.get(i)) < 0) {
				rez.add(second.get(i));
			}
		}
		return rez;
	}

	// this method subtracts one ArrayList from Another. Specifically,
	// this method will subtract ArrayList second from ArrayList first.
	// What that means is that at the end of this method's execution,
	// ArrayList first will contain only those elements that are not in
	// ArrayList second
	public static ArrayList<Integer> subtractArrayLists(
			ArrayList<Integer> first, ArrayList<Integer> second) {
		ArrayList<Integer> rez = new ArrayList<Integer>();
		for (int i = 0; i < first.size(); i++) {
			rez.add(first.get(i));
		}
		for (int i = 0; i < second.size(); i++) {
			if (rez.indexOf(second.get(i)) != -1) {
				rez.remove(second.get(i));
			}
		}
		return rez;
	}

	// this finds the number that may be in one short row/column but not in the other two within this MediumBox
	public void findProbably() {
		for (int i = 0; i < 3; i++) {
			shortCols[i].updateNotFound();
			shortRows[i].updateNotFound();
		}
		shortCols[0].probablyFound = subtractArrayLists(shortCols[0].notFound,
				unifyArrayLists(shortCols[1].notFound, shortCols[2].notFound));
		shortCols[1].probablyFound = subtractArrayLists(shortCols[1].notFound,
				unifyArrayLists(shortCols[0].notFound, shortCols[2].notFound));
		shortCols[2].probablyFound = subtractArrayLists(shortCols[2].notFound,
				unifyArrayLists(shortCols[0].notFound, shortCols[1].notFound));
		shortRows[0].probablyFound = subtractArrayLists(shortRows[0].notFound,
				unifyArrayLists(shortRows[1].notFound, shortRows[2].notFound));
		shortRows[1].probablyFound = subtractArrayLists(shortRows[1].notFound,
				unifyArrayLists(shortRows[0].notFound, shortRows[2].notFound));
		shortRows[2].probablyFound = subtractArrayLists(shortRows[2].notFound,
				unifyArrayLists(shortRows[0].notFound, shortRows[1].notFound));
	}
}