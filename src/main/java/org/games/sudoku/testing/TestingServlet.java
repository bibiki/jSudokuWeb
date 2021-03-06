package org.games.sudoku.testing;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.games.algorithm.spec.SudokuSolvingAlgorithm;
import org.games.sudoku.Cell;
import org.games.sudoku.SudokuGrid;
import org.games.sudoku.algorithm.impl.SolveByElimination;
import org.games.sudoku.commons.BaseServlet;
import org.games.sudoku.swingApp.models.Board;

public class TestingServlet extends BaseServlet {

	private SudokuSolvingAlgorithm algorithm = new SolveByElimination();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			resp.getOutputStream().print("<html>");
			resp.getOutputStream().print(
					startForm("post",
							"/jSudokuWeb/testing",
							"sudoku"));
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					// build the grid for UI
					resp.getOutputStream()
							.print(getInputElement("text", "cell" + i + "" + j, "cell" + i + "" + j, "", new String[] { "" },
									"width: 25px;" + ((i/3 + j/3)%2 == 0 ? "" : "background-color: #72A4D2;")) + " ");
				}
				resp.getOutputStream().print("<br>");
			}
			resp.getOutputStream().print(
					getInputElement("submit", "submit", "sudoku", "Solve",
							new String[] {}, ""));
			resp.getOutputStream().print(endForm());
			resp.getOutputStream().print("</html>");
		} catch (IOException ioe) {

		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		Enumeration<String> names = req.getParameterNames();
		String getUrl = req.getScheme() + req.getServerName() + ":" + req.getServerPort() + "/" + req.getRequestURL();
		getUrl = getUrl.replaceAll("/*", "testing");
		SudokuGrid sg = new SudokuGrid();
		Cell[][] _matrix = new Cell[9][9];
		while(names.hasMoreElements()){
			String name = names.nextElement();
			if(name.contains("cell")){
				name = name.replaceAll("cell", "");
				int i = new Integer("" + name.charAt(0)).intValue();
				int j = new Integer("" + name.charAt(1)).intValue();
				_matrix[i][j] = new Cell(new Integer("".equals(req.getParameter("cell" + name)) ? "0" : req.getParameter("cell" + name)));
			}
		}
		sg.set_matrix(_matrix);
		sg = algorithm.solve(sg);
		Board board = new Board(sg);
		boolean notSolved = !board.isSolved();
		boolean conflict = board.isThereConflict();
		_matrix = sg.get_matrix();
		try{
			resp.getOutputStream().print("<html>");
			if(notSolved){
				if(conflict) resp.getOutputStream().print("There seems to be some conflict in the grid. Please check for the same number twice in a row, column, or medium box.<br>");
				else resp.getOutputStream().print("I need some more help to solve this one. Tell me one cell.");
				resp.getOutputStream().print(startForm("post", "/jSudokuWeb/testing", "sudoku"));
			}
			else{
				resp.getOutputStream().print("Here is your solved Sudoku.<br>");
			}
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					// build the grid for UI
					resp.getOutputStream()
							.print(getInputElement("text", "cell" + i + "" + j, "cell" + i + "" + j, "" + _matrix[i][j].get_value(), new String[] { "" },
									"width: 25px;" + ((i / 3 == j / 3 || (i / 3 == 0 && j / 3 == 2) || (i / 3 == 2 && j / 3 == 0)) ? "" : "background-color: #72A4D2;")) + " ");
				}
				resp.getOutputStream().print("<br>");
			}
			if(notSolved){
				resp.getOutputStream().print(getInputElement("submit", "submit", "sudoku", "Solve", new String[] {}, ""));
				endForm();
			}
			resp.getOutputStream().print("<a href='/jSudokuWeb/testing'>Try another sudoku</a>");
			resp.getOutputStream().print("</html>");
		}
		catch(IOException ioe){
			
		}
	}
}
