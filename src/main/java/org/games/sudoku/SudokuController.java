package org.games.sudoku;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author muzir
 *
 */
@Controller
public class SudokuController {
	@Autowired
	private SudokuGrid grid;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest req, Model model) {
		grid.generateSudoku();
		ModelAndView modelAndView = new ModelAndView("GetStarter");
		modelAndView.addObject("sudokuGrid", grid.toString());
		return modelAndView;
	}
}
