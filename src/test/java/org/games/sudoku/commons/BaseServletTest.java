package org.games.sudoku.commons;

/**
 * 
 * @author gagi <nberani@hotmail.com>
 *
 */
public class BaseServletTest {

	BaseServlet baseServlet = new BaseServlet();
	
	public void testingGetInputElement(){
		String expected = "<input type=\"text\" name=\"name\" id=\"id\" class=\"\" style=\"\" value=\"5\"/>";
		String rez = baseServlet.getInputElement("text", "name", "id", "5", new String[]{""}, "");
		assert expected.equals(rez) : "your test is failing - expected: " + expected + " but it was: " + rez;
		System.out.println("your test: BaseServletTest.testingGetInputElement() passed successfully");
	}
	
	public static void main(String[] args){
		BaseServletTest bs = new BaseServletTest();
		bs.testingGetInputElement();
	}
}
