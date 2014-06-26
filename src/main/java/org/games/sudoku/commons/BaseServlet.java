package org.games.sudoku.commons;

import javax.servlet.http.HttpServlet;

/**
 * This class will contain methods to build the string for common html elements since in the beginning we
 * want to make no se of any view technology. This will also contain methods like header and footer for
 * the corresponding sections of our pages.
 * @author bibiki <nberani@hotmail.com>
 *
 */
public class BaseServlet extends HttpServlet{

	final String QUOTE = "\"";
	protected String getHeader(){
		String rez = "";
		return null;
	}
	
	protected String getFooter(){
		String rez = "";
		return null;
	}
	
	protected String getInputElement(String type, String name, String id, String value, String[] classes, String style){
		String rez = "<input type=" + QUOTE;
		rez += type + QUOTE + " name=" + QUOTE;
		rez += name + QUOTE + " id=" + QUOTE;
		rez += id + QUOTE + " class=" + QUOTE;
		for(String c : classes){
			if(c.replaceAll(" ", "").length() > 0)
				rez += c + " ";
		}
		rez += QUOTE + " style=" + QUOTE + style + QUOTE;
		rez += " value=" + QUOTE + value + QUOTE + "/>";
		return rez;
	}
	
	protected String startForm(String method, String action, String id){
		return "<form method=" + QUOTE + method + QUOTE + " action=" + QUOTE + action + QUOTE + "id=" + QUOTE + id + QUOTE + "/>";
	}
	
	protected String endForm(){
		return "</form>";
	}
}
