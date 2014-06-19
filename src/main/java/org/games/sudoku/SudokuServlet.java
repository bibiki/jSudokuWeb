package org.games.sudoku;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SudokuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("controller controller");
		SudokuGrid grid = new SudokuGrid();
		grid.generateSudoku();
		try {
			res.getOutputStream().print(grid.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
