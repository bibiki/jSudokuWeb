package org.games.sudoku.testing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.games.sudoku.commons.BaseServlet;

public class TestingServlet extends BaseServlet{

//	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try{
			resp.getOutputStream().print("<input type=\"tex\" id=\"cell\"/>");	
		}
		catch(IOException ioe){
			
		}
		
//		super.doGet(req, resp);
	}
}
