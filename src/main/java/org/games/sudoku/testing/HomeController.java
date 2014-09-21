package org.games.sudoku.testing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "")
@Controller
public class HomeController {

	@RequestMapping("testing")
	public String assertThatItIsWorking(){
		System.out.println("assertThatItIsWorking()");
		return "akakunkaka";
	}
}
