package org.games.sudoku.algorithm.impl;

import org.games.sudoku.Cell;
import org.games.sudoku.SudokuGrid;
import org.games.sudoku.algorithm.impl.SolveByElimination;
import org.games.sudoku.swingApp.models.Board;
import org.games.sudoku.swingApp.models.Column;
import org.games.sudoku.swingApp.models.MediumBox;
import org.games.sudoku.swingApp.models.Row;
import org.games.sudoku.swingApp.models.SmallBox;
/**
 * To run the test, please pass "-ea" to VM as an argument:
 * run configurations -> arguments -> in the VM box
 * @author gagi <nberani@hotmail.com>
 *
 */
public class SolveByEliminationTest {

	private SudokuGrid grid = null;
	private SudokuGrid easySudoku = new SudokuGrid();
	private Board board = null;
	private SolveByElimination algorithm = new SolveByElimination();
	private SudokuGrid mediumDifficulty1 = null;//this one requires the use of column elimination from number (instead of number from column)
	
	public void setMediumDifficultyGridUp1(){
		mediumDifficulty1 = new SudokuGrid();
		Cell[][] _matrix = {{new Cell(6), new Cell(0), new Cell(0), new Cell(0), new Cell(1), new Cell(0), new Cell(0), new Cell(7), new Cell(0)},
							{new Cell(8), new Cell(0), new Cell(5), new Cell(7), new Cell(0), new Cell(0), new Cell(0), new Cell(4), new Cell(0)},
							{new Cell(0), new Cell(2), new Cell(0), new Cell(5), new Cell(0), new Cell(0), new Cell(6), new Cell(0), new Cell(0)},
							{new Cell(0), new Cell(3), new Cell(0), new Cell(0), new Cell(0), new Cell(4), new Cell(7), new Cell(0), new Cell(0)},
							{new Cell(7), new Cell(0), new Cell(0), new Cell(3), new Cell(0), new Cell(8), new Cell(0), new Cell(0), new Cell(2)},
							{new Cell(0), new Cell(0), new Cell(9), new Cell(1), new Cell(0), new Cell(0), new Cell(0), new Cell(5), new Cell(0)},
							{new Cell(0), new Cell(0), new Cell(2), new Cell(0), new Cell(0), new Cell(1), new Cell(0), new Cell(8), new Cell(0)},
							{new Cell(0), new Cell(7), new Cell(0), new Cell(0), new Cell(0), new Cell(5), new Cell(3), new Cell(0), new Cell(6)},
							{new Cell(0), new Cell(6), new Cell(0), new Cell(0), new Cell(2), new Cell(0), new Cell(0), new Cell(0), new Cell(7)}};
		mediumDifficulty1.set_matrix(_matrix);
	}
	
	public void setEasySudokuUp(){
		/**
		 * this Sudoku CAN be solved only by applying
		 * the elimination on rows, columns, and medium boxes.
		 */
		easySudoku = new SudokuGrid();
		Cell[][] _matrix = {{new Cell(0), new Cell(7), new Cell(1), new Cell(3), new Cell(0), new Cell(8), new Cell(0), new Cell(0), new Cell(5)},
							{new Cell(0), new Cell(0), new Cell(6), new Cell(0), new Cell(5), new Cell(0), new Cell(4), new Cell(1), new Cell(0)},
							{new Cell(0), new Cell(5), new Cell(4), new Cell(0), new Cell(1), new Cell(0), new Cell(7), new Cell(8), new Cell(0)},
							{new Cell(0), new Cell(3), new Cell(0), new Cell(0), new Cell(0), new Cell(6), new Cell(0), new Cell(2), new Cell(4)},
							{new Cell(7), new Cell(0), new Cell(0), new Cell(5), new Cell(0), new Cell(2), new Cell(0), new Cell(0), new Cell(6)},
							{new Cell(6), new Cell(2), new Cell(0), new Cell(1), new Cell(0), new Cell(0), new Cell(0), new Cell(3), new Cell(0)},
							{new Cell(0), new Cell(1), new Cell(7), new Cell(0), new Cell(2), new Cell(0), new Cell(6), new Cell(5), new Cell(0)},
							{new Cell(0), new Cell(6), new Cell(3), new Cell(0), new Cell(9), new Cell(0), new Cell(2), new Cell(0), new Cell(0)},
							{new Cell(9), new Cell(0), new Cell(0), new Cell(7), new Cell(0), new Cell(5), new Cell(3), new Cell(4), new Cell(0)}};
		easySudoku.set_matrix(_matrix);
	}
	
	private void setGridUp(){
		grid = new SudokuGrid();
		Cell[][] _matrix = {{new Cell(1), new Cell(3), new Cell(0), new Cell(0), new Cell(0), new Cell(9), new Cell(8), new Cell(0), new Cell(0)},
							{new Cell(7), new Cell(0), new Cell(0), new Cell(5), new Cell(0), new Cell(0), new Cell(0), new Cell(4), new Cell(0)},
							{new Cell(5), new Cell(0), new Cell(0), new Cell(2), new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(3)},
							{new Cell(4), new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(8), new Cell(6), new Cell(0), new Cell(0)},
							{new Cell(0), new Cell(1), new Cell(0), new Cell(9), new Cell(0), new Cell(2), new Cell(0), new Cell(3), new Cell(0)},
							{new Cell(0), new Cell(0), new Cell(9), new Cell(1), new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(2)},
							{new Cell(2), new Cell(0), new Cell(0), new Cell(0), new Cell(0), new Cell(7), new Cell(0), new Cell(0), new Cell(6)},
							{new Cell(0), new Cell(4), new Cell(0), new Cell(0), new Cell(0), new Cell(5), new Cell(0), new Cell(0), new Cell(7)},
							{new Cell(0), new Cell(0), new Cell(6), new Cell(3), new Cell(0), new Cell(0), new Cell(0), new Cell(8), new Cell(4)}};
		grid.set_matrix(_matrix);
	}
	
	private void setBoardUp(){
		if(null == grid)
			setGridUp();
		board = new Board();
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				board.board[i][j] = new SmallBox(grid.get_matrix()[i][j].get_value());
	}
	
	public void testingEliminationAlgorithm(){
		setGridUp();
		SudokuGrid g = algorithm.solve(grid);
		SudokuGrid preSolved = new SudokuGrid();
		Cell[][] _matrix = {{new Cell(1), new Cell(3), new Cell(2), new Cell(4), new Cell(7), new Cell(9), new Cell(8), new Cell(6), new Cell(5)},
							{new Cell(7), new Cell(6), new Cell(8), new Cell(5), new Cell(1), new Cell(3), new Cell(2), new Cell(4), new Cell(9)},
							{new Cell(5), new Cell(9), new Cell(4), new Cell(2), new Cell(8), new Cell(6), new Cell(1), new Cell(7), new Cell(3)},
							{new Cell(4), new Cell(2), new Cell(5), new Cell(7), new Cell(3), new Cell(8), new Cell(6), new Cell(9), new Cell(1)},
							{new Cell(6), new Cell(1), new Cell(7), new Cell(9), new Cell(5), new Cell(2), new Cell(4), new Cell(3), new Cell(8)},
							{new Cell(3), new Cell(8), new Cell(9), new Cell(1), new Cell(6), new Cell(4), new Cell(7), new Cell(5), new Cell(2)},
							{new Cell(2), new Cell(5), new Cell(3), new Cell(8), new Cell(4), new Cell(7), new Cell(9), new Cell(1), new Cell(6)},
							{new Cell(8), new Cell(4), new Cell(1), new Cell(6), new Cell(9), new Cell(5), new Cell(3), new Cell(2), new Cell(7)},
							{new Cell(9), new Cell(7), new Cell(6), new Cell(3), new Cell(2), new Cell(1), new Cell(5), new Cell(8), new Cell(4)}};
		preSolved.set_matrix(_matrix);
		assert preSolved.equals(g) : "your test SolveByEliminationTest.testingEliminaionAlgorithm() is failing";
		System.out.println("your test SolveByEliminationTest.testingEliminationAlgorithm() passed successfully");
	}
	
	public void testEliminationByRow(){
		/* 7, 5, and 4 should be removed from cells 2, 3, 4, 5, 6, and 8*/
		setBoardUp();
		Row r = new Row(board, 1);
		algorithm.applyEliminationInRow(r);
		boolean condition = true;
		condition &= !r.cell[1].possibilities.contains(4) && !r.cell[1].possibilities.contains(5) && !r.cell[1].possibilities.contains(7);
		condition &= !r.cell[2].possibilities.contains(4) && !r.cell[2].possibilities.contains(5) && !r.cell[2].possibilities.contains(7);
		condition &= !r.cell[4].possibilities.contains(4) && !r.cell[4].possibilities.contains(5) && !r.cell[4].possibilities.contains(7);
		condition &= !r.cell[5].possibilities.contains(4) && !r.cell[5].possibilities.contains(5) && !r.cell[5].possibilities.contains(7);
		condition &= !r.cell[6].possibilities.contains(4) && !r.cell[6].possibilities.contains(5) && !r.cell[6].possibilities.contains(7);
		condition &= !r.cell[8].possibilities.contains(4) && !r.cell[8].possibilities.contains(5) && !r.cell[8].possibilities.contains(7);
		
		assert condition : "Your test SolveByEliminationTest.testEliminationByRow() is failing";
		System.out.println("Your test SolveByEliminationTest.testEliminationByRow() has passed successfully");
	}
	
	public void testEliminationByColumn(){
		/* 1, 3, and 4 should be removed from cells 2, 3, 4, 6, 7, and 9*/
		setBoardUp();
		Column col = new Column(board, 1);
		int[] toBeRemoved = {1, 3, 4};
		int[] fromCesll = {1, 2, 3, 5, 6, 8};
		algorithm.applyEliminationInColumn(col);
		boolean condition = true;
		for(int i = 0; i < toBeRemoved.length; i++)
			for(int j = 0; j < fromCesll.length; j++)
				condition &= !col.cell[fromCesll[j]].possibilities.contains(toBeRemoved[i]);		
		assert condition : "Your test SolveByEliminationTest.testEliminationByColumn() is failing";
		System.out.println("Your test SolveByEliminationTest.testEliminationByColumn() has passed successfully");
	}
	
	public void testEliminationByMediumBox(){
		/* 1, 2, 8, and 9 should be removed from cells 1, 2, 5, 8 and 9*/
		setBoardUp();
		MediumBox mBox = new MediumBox(board, 1, 1);
		algorithm.applyEliminationInMediumBox(mBox);
		int[] toBeRemoved = {1, 2, 8, 9};
		int[] fromCells = {0, 1, 4, 7, 8};
		boolean condition = true;
		for(int i = 0; i < toBeRemoved.length; i++)
			for(int j = 0; j < fromCells.length; j++)
				condition &= !mBox.cell[fromCells[j]].possibilities.contains(toBeRemoved[i]);		
		
		assert condition : "Your test SolveByEliminationTest.testEliminationByMediumBox() is failing";
		System.out.println("Your test SolveByEliminationTest.testEliminationByMediumBox() has passed successfully");
	}
	
	public void testTheAlgorithmWithEasySudoku(){
		setEasySudokuUp();
		SudokuGrid preSolved = new SudokuGrid();
		Cell[][] _matrix = {{new Cell(2),   new Cell(7),   new Cell(1),   new Cell(3),   new Cell(4),   new Cell(8),   new Cell(9),   new Cell(6),   new Cell(5)},
							{new Cell(8),   new Cell(9),   new Cell(6),   new Cell(2),   new Cell(5),   new Cell(7),   new Cell(4),   new Cell(1),   new Cell(3)},
							{new Cell(3),   new Cell(5),   new Cell(4),   new Cell(6),   new Cell(1),   new Cell(9),   new Cell(7),   new Cell(8),   new Cell(2)},
							{new Cell(1),   new Cell(3),   new Cell(5),   new Cell(9),   new Cell(7),   new Cell(6),   new Cell(8),   new Cell(2),   new Cell(4)},
							{new Cell(7),   new Cell(4),   new Cell(8),   new Cell(5),   new Cell(3),   new Cell(2),   new Cell(1),   new Cell(9),   new Cell(6)},
							{new Cell(6),   new Cell(2),   new Cell(9),   new Cell(1),   new Cell(8),   new Cell(4),   new Cell(5),   new Cell(3),   new Cell(7)},
							{new Cell(4),   new Cell(1),   new Cell(7),   new Cell(8),   new Cell(2),   new Cell(3),   new Cell(6),   new Cell(5),   new Cell(9)},
							{new Cell(5),   new Cell(6),   new Cell(3),   new Cell(4),   new Cell(9),   new Cell(1),   new Cell(2),   new Cell(7),   new Cell(8)},
							{new Cell(9),   new Cell(8),   new Cell(2),   new Cell(7),   new Cell(6),   new Cell(5),   new Cell(3),   new Cell(4),   new Cell(1)}};
		preSolved.set_matrix(_matrix);
		SudokuGrid sg = algorithm.solve(easySudoku);
		assert sg.equals(preSolved) : "Your test SolveByEliminationTest.testTheAlgorithmWithEasySudoku() is failling";
		System.out.println("Your test SolveByEliminationTest.testTheAlgorithmWithEasySudoku() passed successfully");
	}
	
	public void testTheAlgorithmWithMediumDifficultySudoku1(){
		setMediumDifficultyGridUp1();
		SudokuGrid preSolved = new SudokuGrid();
		Cell[][] _matrix = {{new Cell(6), new Cell(9), new Cell(3), new Cell(4), new Cell(1), new Cell(2), new Cell(8), new Cell(7), new Cell(5)},
							{new Cell(8), new Cell(1), new Cell(5), new Cell(7), new Cell(3), new Cell(6), new Cell(2), new Cell(4), new Cell(9)},
							{new Cell(4), new Cell(2), new Cell(7), new Cell(5), new Cell(8), new Cell(9), new Cell(6), new Cell(3), new Cell(1)},
							{new Cell(5), new Cell(3), new Cell(1), new Cell(2), new Cell(9), new Cell(4), new Cell(7), new Cell(6), new Cell(8)},
							{new Cell(7), new Cell(4), new Cell(6), new Cell(3), new Cell(5), new Cell(8), new Cell(1), new Cell(9), new Cell(2)},
							{new Cell(2), new Cell(8), new Cell(9), new Cell(1), new Cell(6), new Cell(7), new Cell(4), new Cell(5), new Cell(3)},
							{new Cell(3), new Cell(5), new Cell(2), new Cell(6), new Cell(7), new Cell(1), new Cell(9), new Cell(8), new Cell(4)},
							{new Cell(1), new Cell(7), new Cell(8), new Cell(9), new Cell(4), new Cell(5), new Cell(3), new Cell(2), new Cell(6)},
							{new Cell(9), new Cell(6), new Cell(4), new Cell(8), new Cell(2), new Cell(3), new Cell(5), new Cell(1), new Cell(7)}};
		preSolved.set_matrix(_matrix);
		SudokuGrid sg = algorithm.solve(mediumDifficulty1);
		assert sg.equals(preSolved) : "Your test SolveByEliminationTest.testTheAlgorithmWithMediumDifficultySudoku1() failed.";
		System.out.println("Your test SolveByEliminationTest.testTheAlgorithmWithMediumDifficultySudoku1() passed successfully.");
		
	}
	
	public void testIsSolved(){
		setEasySudokuUp();
		Board board = new Board(easySudoku);
		assert false == board.isSolved() : "Your test SolveByEliminationTest.testIsSolved() failed.";
		board = new Board(algorithm.solve(easySudoku));
		assert board.isSolved() : "Your test SolveByEliminationTest.testIsSolved() failed.";
		System.out.println("Your test SolveByEliminationTest.testIsSolved() passed successfully.");
	}
	
	public static void main(String[] args){
		SolveByEliminationTest sbt = new SolveByEliminationTest();
		sbt.testTheAlgorithmWithEasySudoku();
		sbt.testingEliminationAlgorithm();
		sbt.testEliminationByRow();
		sbt.testEliminationByColumn();
		sbt.testEliminationByMediumBox();
		sbt.testTheAlgorithmWithMediumDifficultySudoku1();
		sbt.testIsSolved();
	}
}
