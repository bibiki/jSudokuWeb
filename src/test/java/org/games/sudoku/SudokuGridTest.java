package org.games.sudoku;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SudokuGridTest {

	SudokuGrid sudokuGrid;
	List<Integer> numbers;
	Cell[][] generatedGrid;

	@Before
	public void setUp() throws Exception {
		initializeNumberList();
		sudokuGrid = new SudokuGrid();
		sudokuGrid.generateSudoku();
		generatedGrid = sudokuGrid.get_matrix();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldEachNumberExistOneOnColoumn() {
		int i, j = 0;
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				Integer value = generatedGrid[j][i].get_value();
				numbers.remove(value);
			}
			String missingValues = numbers.toString();
			Assert.assertTrue("These values are not exist at this coloumn : "
					+ j + " values : " + missingValues, numbers.isEmpty());
			initializeNumberList();
		}

	}

	@Test
	public void shouldEachNumberExistOneOnRow() {
		int i, j = 0;
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				Integer value = generatedGrid[i][j].get_value();
				numbers.remove(value);
			}
			String missingValues = numbers.toString();
			Assert.assertTrue("These values are not exist at this row : " + i
					+ " values : " + missingValues, numbers.isEmpty());
			initializeNumberList();
		}
	}

	private void initializeNumberList() {
		numbers = new ArrayList<Integer>(10);
		for (int i = 1; i < 10; i++) {
			numbers.add(i);
		}
	}
}