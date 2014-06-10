package org.games.sudoku.swingApp;

public class TestShortRows {
	public static void main(String[] args) {
		ShortRow[][] shortrows = new ShortRow[9][3];
		ShortColumn[][] shortcolumns = new ShortColumn[3][9];
		Board b = new Board();
		System.out.println("-------------------");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				shortrows[i][j] = new ShortRow();
				shortrows[i][j].shortrow[0] = b.board[i][3 * j + 0];
				shortrows[i][j].shortrow[1] = b.board[i][3 * j + 1];
				shortrows[i][j].shortrow[2] = b.board[i][3 * j + 2];
				shortcolumns[j][i] = new ShortColumn();
				shortcolumns[j][i].shortcolumn[0] = b.board[3 * j + 0][i];
				shortcolumns[j][i].shortcolumn[1] = b.board[3 * j + 1][i];
				shortcolumns[j][i].shortcolumn[2] = b.board[3 * j + 2][i];
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				shortrows[i][j].showShortRow();
			}
		}

		System.out.println();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.println("---");
				shortcolumns[i][j].showShortColumn();
				System.out.println("-----");
			}
		}
		b.showBoard();
	}
}