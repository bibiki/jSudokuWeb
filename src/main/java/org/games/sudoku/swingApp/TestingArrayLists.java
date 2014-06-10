package org.games.sudoku.swingApp;

import java.util.*;

public class TestingArrayLists {

	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();

		for (int i = 1; i < 5; i++) {
			x.add(new Integer(i));
			System.out.print("" + x.get(i - 1) + " ");
		}
		System.out.println();
		for (int i = 4; i < 10; i++) {
			y.add(new Integer(i));
			System.out.print("" + y.get(i - 4) + " ");
		}
		System.out.println("\t\ty - x");
		ArrayList<Integer> z = unifyArrayLists(y, x);

		for (int i = 0; i < z.size(); i++) {
			System.out.println(z.get(i));
		}
		System.out.println();

		for (int i = 0; i < z.size(); i++) {
			// System.out.println(z.get(i));
		}

		System.out.println("--------------");
		z.clear();
		z = subtractArrayLists(y, x);
		System.out.println("\t\ty - x");
		for (int i = 0; i < z.size(); i++) {
			System.out.println(z.get(i));
		}
		for (int i = 0; i < x.size(); i++) {
			System.out.print(x.get(i));
		}
		System.out.println();
		for (int i = 0; i < y.size(); i++) {
			System.out.print(y.get(i));
		}
		System.out.println("--------------");
		System.out.println("\t\tx - y");
		z = subtractArrayLists(x, y);
		for (int i = 0; i < z.size(); i++) {
			System.out.println(z.get(i));
		}

	}

	public static ArrayList<Integer> unifyArrayLists(ArrayList<Integer> first,
			ArrayList<Integer> second) {
		ArrayList<Integer> rez = first;
		for (int i = 0; i < second.size(); i++) {
			if (rez.indexOf(second.get(i)) < 0) {
				rez.add(second.get(i));
			}
		}
		return rez;
	}

	// this method subtracts one ArrayList from Another. Specifically,
	// this method will subtract ArrayList second from ArrayList first.
	// What that means is that at the end of this method's execution,
	// ArrayList first will contain only those elements that are not in
	// ArrayList second
	public static ArrayList<Integer> subtractArrayLists(
			ArrayList<Integer> first, ArrayList<Integer> second) {
		ArrayList<Integer> rez = new ArrayList<Integer>();
		for (int i = 0; i < first.size(); i++) {
			rez.add(first.get(i));
		}
		for (int i = 0; i < second.size(); i++) {
			if (rez.indexOf(second.get(i)) >= 0) {
				rez.remove(second.get(i));
			}
		}
		return rez;
	}

}
