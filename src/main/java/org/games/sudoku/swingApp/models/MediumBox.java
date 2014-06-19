package org.games.sudoku.swingApp.models;

import java.util.ArrayList;

import javax.swing.*;

import org.games.sudoku.swingApp.SmallBox;

import java.awt.*;

public class MediumBox extends JPanel {
	public ArrayList<Integer> notFound = new ArrayList<Integer>();
	public SmallBox[][] mediumBox = new SmallBox[3][3];
	public SmallBox[] med = new SmallBox[9];
	public ShortColumn[] shortCols = new ShortColumn[3];
	public ShortRow[] shortRows = new ShortRow[3];

	public TextField[][] mediumBoxInput = new TextField[3][3];

	// Konstruktori: percakton layoutin, dimensionet, kufizon panelin
	// vendose te gjithe numrat ne variablen notFound, e cila i mbane
	// pra numrat qe ende nuk jane gjet ne ate mediumbox
	// me pas, nga variabla b e tipit Board, nderton nje MediumBox
	// pra nje kuti prej nente kutish te vogla, 3x3
	// row dhe col percaktojne se per cilen kuti te mesme eshte fjala
	public MediumBox(Board b, int row, int col) {

		setLayout(new GridLayout(3, 3));
		setSize(new Dimension(90, 90));
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		// se pari asnje numer nuk dihet ku eshte brenda kutise se mesme
		for (int num = 1; num <= 9; num++) {
			notFound.add(num);
		}
		// ketu percaktohen cilat qelula nga board i takojne kesaj kutie te
		// mesme
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (r / 3 == row && c / 3 == col) {
					mediumBox[r % 3][c % 3] = b.board[r][c];
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			med[i] = mediumBox[i / 3][i % 3];
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				add(mediumBox[i][j]);
			}
		}
	}

	public void registerFound() {
		// ketu vendosen numrat 1 deri ne 9 ne ArrayList qe mbane numrat qe
		// nukjane gjete brenda kesaj kutie te mesme
		for (int i = 1; i <= 9; i++) {
			if (!notFound.contains(new Integer(i))) {
				notFound.add(new Integer(i));
			}
		}
		// ketu largohen te gjithe ata numra qe jane gjete ne qelulat e kesaj
		// kutie te mesme
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(mediumBox[i][j].face.intValue() < 1 || mediumBox[i][j].face
						.intValue() > 9)) {
					notFound.remove(mediumBox[i][j].face);
				}
			}
		}

		/*
		 * kjo pjese e metodes i tregon vlerat qe nuk jane gjete ende per kutine
		 * e mesme ne fjale
		 */
		System.out.println("kutia e mesme me pozite---------------------");
		for (int i = 0; i < notFound.size(); i++) {
			System.out.print(notFound.get(i).intValue() + " ");
		}
		System.out.println("------------------------------");

	}

	// metode ndihmese gjate ndertimit te klases MediumBox - kuti e mesme
	public void afishojeBoxin() {
		for (int i = 0; i < mediumBox.length; i++) {
			for (int j = 0; j < mediumBox[0].length; j++) {
				System.out.print(mediumBox[i][j].face + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// kjo metode ben unionin e dy ArrayListave. Unioni si veprim bashkesish
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
	// kjo metode ben diferencen e bashkesive ne mes dy ArrayList-ave
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

	// kjo metode gjen probabilet e secilit rresht te shkurte, dhe seciles
	// kolone te shkurte brenda nje MediumBox - kuti e mesme
	public void findProbably() {
		for (int i = 0; i < 3; i++) {
			shortCols[i].updateNotFound();
			shortRows[i].updateNotFound();
		}
		shortCols[0].probablyFound = subtractArrayLists(shortCols[0].notFound,
				unifyArrayLists(shortCols[1].notFound, shortCols[2].notFound));
		shortCols[1].probablyFound = subtractArrayLists(shortCols[1].notFound,
				unifyArrayLists(shortCols[0].notFound, shortCols[2].notFound));
		shortCols[2].probablyFound = subtractArrayLists(shortCols[2].notFound,
				unifyArrayLists(shortCols[0].notFound, shortCols[1].notFound));
		shortRows[0].probablyFound = subtractArrayLists(shortRows[0].notFound,
				unifyArrayLists(shortRows[1].notFound, shortRows[2].notFound));
		shortRows[1].probablyFound = subtractArrayLists(shortRows[1].notFound,
				unifyArrayLists(shortRows[0].notFound, shortRows[2].notFound));
		shortRows[2].probablyFound = subtractArrayLists(shortRows[2].notFound,
				unifyArrayLists(shortRows[0].notFound, shortRows[1].notFound));
	}
}