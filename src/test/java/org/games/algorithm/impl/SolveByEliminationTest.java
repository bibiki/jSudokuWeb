package org.games.algorithm.impl;

import org.games.sudoku.Cell;
import org.games.sudoku.SudokuGrid;
import org.games.sudoku.impl.SolveByElimination;
/**
 * To run the test, please pass "-ea" to VM as an argument:
 * run configurations -> arguments -> in the VM box
 * @author gagi <nberani@hotmail.com>
 *
 */
public class SolveByEliminationTest {

	private SudokuGrid grid = null;
	private SolveByElimination algorithm = new SolveByElimination();
	
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
	}
	
	public void testingEliminationAlgorithm(){
		setGridUp();
		SudokuGrid g = algorithm.solve(grid);
		SudokuGrid solved = new SudokuGrid();
		Cell[][] _matrix = {{new Cell(1), new Cell(3), new Cell(2), new Cell(4), new Cell(7), new Cell(9), new Cell(8), new Cell(6), new Cell(5)},
							{new Cell(7), new Cell(6), new Cell(8), new Cell(5), new Cell(1), new Cell(3), new Cell(2), new Cell(4), new Cell(9)},
							{new Cell(5), new Cell(9), new Cell(4), new Cell(2), new Cell(8), new Cell(6), new Cell(1), new Cell(7), new Cell(3)},
							{new Cell(4), new Cell(2), new Cell(5), new Cell(7), new Cell(3), new Cell(8), new Cell(6), new Cell(9), new Cell(1)},
							{new Cell(6), new Cell(1), new Cell(7), new Cell(9), new Cell(5), new Cell(2), new Cell(4), new Cell(3), new Cell(8)},
							{new Cell(3), new Cell(8), new Cell(9), new Cell(1), new Cell(6), new Cell(4), new Cell(7), new Cell(5), new Cell(2)},
							{new Cell(2), new Cell(5), new Cell(3), new Cell(8), new Cell(4), new Cell(7), new Cell(9), new Cell(1), new Cell(6)},
							{new Cell(8), new Cell(4), new Cell(1), new Cell(6), new Cell(9), new Cell(5), new Cell(3), new Cell(2), new Cell(7)},
							{new Cell(9), new Cell(7), new Cell(6), new Cell(3), new Cell(2), new Cell(1), new Cell(5), new Cell(8), new Cell(4)}};
		solved.set_matrix(_matrix);
		assert solved.equals(g) : "your test is failing";
		System.out.println("your test SolveByEliminationTest.testingEliminationAlgorithm() passed successfully");
	}
	
	public static void main(String[] args){
		SolveByEliminationTest sbt = new SolveByEliminationTest();
		sbt.testingEliminationAlgorithm();
	}
}
