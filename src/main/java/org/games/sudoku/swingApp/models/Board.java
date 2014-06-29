package org.games.sudoku.swingApp.models;

import org.games.sudoku.Cell;
import org.games.sudoku.SudokuGrid;
import org.games.sudoku.swingApp.SmallBox;
import org.games.sudoku.swingApp.SudokuSmallBoxKeyListener;

/*
 * kjo klase modelon matricen e Sudokus
 * ketu instancohen qelulat e Sudokus.
 * Qelulat jane te tipit SmallBox
 * Ketu shfrytezohet konstruktori i Small Box pa parametra
 * ne menyre qe t'i mundesohet shfrytezuesit te percaktoje
 * sudokun me te cilen deshiron ta sfidoje programin
 */

public class Board {
	public SmallBox[][] board = new SmallBox[9][9];

	public Board() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = new SmallBox();
				board[i][j].addKeyListener(new SudokuSmallBoxKeyListener(
						board[i][j]));
			}
		}
	}
	
	public boolean isSolved(){
		boolean rez = true;
		int colSum = 0;
		int rowSum = 0;
		for(int i = 0; i < 9; i++){
			colSum = 0;
			rowSum = 0;
			for(int j = 0; j < 9; j++){
				colSum += board[j][i].face;
				rowSum += board[i][j].face;
			}
			if(!(45 == colSum && colSum == rowSum))
					return false;
		}		
		return rez;
	}
	
	public Board(Board b){
		for (int i = 0; i < 9; i++) 
			for (int j = 0; j < 9; j++) 
				board[i][j] = new SmallBox(b.board[i][j].face);
	}
	
	public Board(SudokuGrid sg){
		Cell[][] cells = sg.get_matrix();
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				board[i][j] = new SmallBox(cells[i][j].get_value());
				if(board[i][j].face > 0)
					board[i][j].possibilities.clear();
			}
		}
	}

	// kjometode shfaqe vleren e fytyres se seciles qelule
	public void showBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j].face + "   ");
			}
			System.out.println();
		}
	}
	
	
	public SudokuGrid toSudokuGrid(){
		Cell[][] cells = new Cell[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				cells[i][j] = new Cell(this.board[i][j].face);
		SudokuGrid sg = new SudokuGrid();
		sg.set_matrix(cells);
		return sg;
	}
	public boolean hasChangedAsOpposedTo(Board b){
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				if(b.board[i][j] != this.board[i][j])
					return true;
		return false;
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o)
			return true;
		Board b = (Board)o;
		boolean rez = true;
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				if(!b.board[i][j].face.equals(this.board[i][j].face))
					return false;
		return rez;
	}
}