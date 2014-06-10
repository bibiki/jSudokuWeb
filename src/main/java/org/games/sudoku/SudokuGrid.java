package org.games.sudoku;

/**
 * @author muzir
 * 
 */
public class SudokuGrid {
	public SudokuGrid() {
		this._initializeTable();
	}

	public SudokuGrid(SudokuGrid grid) {
		this._matrix = grid._matrix;
	}

	/**
	 * Main method to generate the sudoku solution
	 */
	public void generateSudoku() {
		staticRow = 0;
		staticColumn = 0;
		while (staticRow != 9) {
			if (!this._forward()) {
				// Clear current domain list
				this._matrix[staticRow][staticColumn].set_value(0);
				this._matrix[staticRow][staticColumn].clearDomainList();
				staticColumn = staticColumn - 1;
			} else {
				staticColumn = staticColumn + 1;
			}
			this._generateRowColumn();
		}
	}

	/**
	 * Arrange border according to 9x9 sudoku board
	 */
	private void _generateRowColumn() {
		// if column equal to -1
		if (staticColumn == -1) {
			staticRow--;
			staticColumn = 8;
		} else if (staticColumn == 9) {
			staticRow++;
			staticColumn = 0;
		}
	}

	/**
	 * If is there a conflict at row, column or square backtracking one column
	 * otherwise put the new value to cell and forward the next cell.
	 * 
	 * @return
	 */
	private Boolean _forward() {
		int row = staticRow;
		int column = staticColumn;
		Cell currentCell = this._matrix[row][column];
		Integer currentCellValue = currentCell.getRandomChoice();
		/*
		 * Check all choices are finished at currentcell domain list if
		 * currenctCellValue equal to -1 this means there is no value at cell
		 * domain list, backtracking should be done
		 */
		if (currentCellValue == -1) {
			return Boolean.FALSE;
		}
		if (_squareConflict(currentCellValue) || _rowConflict(currentCellValue)
				|| _columnConflict(currentCellValue)) {
			currentCell.get_domainList().remove(currentCellValue);
			return this._forward();
		} else {
			this._matrix[row][column].set_value(currentCellValue);
		}
		return Boolean.TRUE;
	}

	/**
	 * Check that is there any value which is equal to @param cellValue in the
	 * square(3x3)
	 * 
	 * @param cellValue
	 * @return
	 */
	private Boolean _squareConflict(Integer cellValue) {
		int row = staticRow;
		int column = staticColumn;

		/*
		 * Find the current cell starting point for both row and column. For
		 * example row,column (1,2) starting point of these (0,0).
		 */
		int rowStartingPoint = row - row % 3;
		int columnStartingPoint = column - column % 3;
		/* Find row and column end point for square */
		int rowEndPoint = rowStartingPoint + 3;
		int columnEndPoint = columnStartingPoint + 3;

		for (int i = rowStartingPoint; i < rowEndPoint; i++) {
			for (int j = columnStartingPoint; j < columnEndPoint; j++) {
				if (cellValue.equals(this._matrix[i][j].get_value())) {
					return Boolean.TRUE;
				}
			}// end of inner for loop
		}// end of outer for loop
		return Boolean.FALSE;
	}// end of method _squareConflict

	/**
	 * Check that is there any value which is equal to @param cellValue in the
	 * row
	 * 
	 * @param cellValue
	 * @return
	 */
	private Boolean _rowConflict(Integer cellValue) {
		int row = staticRow;
		int column = staticColumn;

		for (int j = 0; j < column; j++) {
			if (cellValue.equals(this._matrix[row][j].get_value())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Check that is there any value which is equal to @param cellValue in the
	 * column
	 * 
	 * @param cellValue
	 * @return
	 */
	private Boolean _columnConflict(Integer cellValue) {
		int row = staticRow;
		int column = staticColumn;

		for (int i = 0; i < row; i++) {
			if (cellValue.equals(this._matrix[i][column].get_value())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Initialize sudoku table, fill 81 cell to the matrix
	 */
	private void _initializeTable() {
		this._matrix = new Cell[9][9];
		int i = 0;
		int j = 0;
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				this._matrix[i][j] = new Cell();
			}// end of inner for loop
		}// end of outer for loop
	}// end of initializeTable method

	/*
	 * toString method of the SudokuGrid object
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String strRetVal = "**********************\n*";
		int i, j;
		Cell cell;

		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				cell = this._matrix[i][j];
				strRetVal = strRetVal + cell.toString() + " ";
				if (j % 3 == 2) {
					strRetVal = strRetVal + "*";
				}
			}// end of inner for loop
			if (i % 3 == 2) {
				strRetVal += "\n**********************";
			}
			strRetVal = strRetVal + "\n*";
		}// end of outer for loop
		return strRetVal;
	}// end of showMaatrix method

	public Cell[][] get_matrix() {
		return _matrix;
	}

	public void set_matrix(Cell[][] _matrix) {
		this._matrix = _matrix;
	}

	private Cell[][] _matrix;
	private static int staticRow = 0;
	private static int staticColumn = 0;
}