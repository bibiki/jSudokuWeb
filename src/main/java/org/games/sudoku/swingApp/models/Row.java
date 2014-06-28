package org.games.sudoku.swingApp.models;

import java.util.ArrayList;

import org.games.sudoku.swingApp.SmallBox;

public class Row {// kjo klase modelon rreshtin dhe permbane nente qelulat qe i
					// perkasin
					// ketij rreshti
	public SmallBox[] cell = new SmallBox[9];
	// ketu vendosen ata numra qe ende nuk jane gjet brenda ketij rreshti
	public ArrayList<Integer> notFound = new ArrayList<Integer>();
	// keto jane tri rreshtat e shkurte qe perbejne kete rresht
	public ShortRow[] shorties = new ShortRow[3];

	public Row(Board b, int r) {
		for (int i = 0; i < 9; i++) {
			cell[i] = b.board[r][i];
		}
	}

	// kjo metode ndihmon gjate zhvillimit te aplikacionit duke mundesu
	// pamje ne perberjen e rreshtit
	public void affishojeRreshtin() {
		for (int i = 0; i < 9; i++) {
			System.out.println(cell[i].face);
		}
	}

}