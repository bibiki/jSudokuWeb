package org.games.sudoku.swingApp.models;

import java.util.ArrayList;

/**
 * Rows, Columns, and Medium Boxes are three different blocks of a Sudoku.
 * So, the classes Row, Column, MediumBox will extends this class.
 * This class is going to contain that wich all of the above mentioned
 * blocks have in common.
 * @author gagi <nberani@hotmail.com>
 *
 */
public abstract class AbstractSudokuBlock {

	//the cells in this block, whether this is a row, column, or medium box
	public SmallBox[] cell = new SmallBox[9];
	// this will contain the numbers that are yet not found within this block
	public ArrayList<Integer> notFound = new ArrayList<Integer>();
	
	// kjo metode ndihmon gjate zhvillimit te aplikacionit duke mundesu
	// pamje ne perberjen e rreshtit
	public void printCellContents() {
		for (int i = 0; i < 9; i++) {
			System.out.println(cell[i].face);
		}
	}
}
