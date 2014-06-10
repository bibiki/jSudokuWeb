package org.games.sudoku.swingApp;

import java.util.*;

/*
 * logjika eshte e njejte sikur per ShortColumn
 */
public class ShortRow {
	public SmallBox[] shortrow = new SmallBox[3];
	public ArrayList<Integer> notFound = new ArrayList<Integer>();
	public ArrayList<Integer> probablyFound = new ArrayList<Integer>();

	public ShortRow() {

	}

	public ShortRow(Board b, int medBoxCol, int row) {
		for (int i = 1; i <= 9; i++) {
			notFound.add(new Integer(i));
		}

		for (int i = 0; i < 3; i++) {
			shortrow[i] = b.board[(medBoxCol - 1) * 3 + i][row - 1];
		}
	}

	public void showShortRow() {
		for (int i = 0; i < 3; i++) {
			System.out.print(shortrow[i].face + " ");
		}
		System.out.println();
	}

	public void viewProbable() {
		for (int i = 0; i < probablyFound.size(); i++) {
			System.out.print("" + probablyFound.get(i) + " ");
		}
		System.out.println("----");
	}

	public void updateNotFound() {
		notFound.clear();
		for (int i = 0; i < 3; i++) {
			if (shortrow[i].face.equals(new Integer(0)))
				notFound = unifyArrayLists(notFound, shortrow[i].possibilities);
		}
	}

	public ArrayList<Integer> unifyArrayLists(ArrayList<Integer> first,
			ArrayList<Integer> second) {
		ArrayList<Integer> rez = new ArrayList<Integer>();
		for (int i = 0; i < first.size(); i++) {
			rez.add(first.get(i));
		}
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
			if (rez.indexOf(second.get(i)) != -1) {
				rez.remove(second.get(i));
			}
		}
		return rez;
	}

}