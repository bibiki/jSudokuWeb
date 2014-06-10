package org.games.sudoku.swingApp;

import java.util.*;

public class ShortColumn {
	// ketu vendosen qelulat qe perbjne kete kolone te shkurte
	public SmallBox[] shortcolumn = new SmallBox[3];
	// ketu vendosen te gjithe numrat 1 deri 9 si mundesi te ekzistojne
	// brenda kesaj kolone te shkurte
	public ArrayList<Integer> notFound = new ArrayList<Integer>();
	// ketu vendosen ata numra qe mund te ekzistojne vetem ne kete kolone
	// te shkurte brenda kutise se mesme qe permbane kete kolone te shkurte
	public ArrayList<Integer> probablyFound = new ArrayList<Integer>();

	public ShortColumn() {

	}

	public ShortColumn(Board b, int medBoxRow, int col) {
		// ketu vendosejn qelulat perkatese ne ket ekolone te shkurte
		// kjo behet sipas kutise se mesme te ciles kjo kolone e shkurte
		// i takon dhe sipas kolones se ciles kjokolone e shkurte i takon
		for (int i = 0; i < 3; i++) {
			shortcolumn[i] = b.board[(medBoxRow - 1) * 3 + i][col - 1];
		}
	}

	// kjo metode eshte shfrytezu gjate zhvillimit per te treguar permbajtjen e
	// e qelulave te kolones se shurte
	public void showShortColumn() {
		for (int i = 0; i < 3; i++) {
			System.out.print(shortcolumn[i].face + " ");
		}
		System.out.println();
	}

	// kjo metode ben rifreskimin e numrave qe ende nuk jane gjete
	// faktikisht, ne momentin kur kjo metode perfundon ekzekutimin
	// ne notFound mund te gjenden numra qe jane gjete brenda kutise
	// se mesme, por kjo nuk paraqet problem sepse kjo shfrytezohet vetem
	// pasi te jene largu ato mundesi nga variabla notFound me rastin
	// e klikimit te butonit Gjeji probabilet

	public void updateNotFound() {
		notFound.clear();
		for (int i = 0; i < 3; i++) {
			if (shortcolumn[i].face.equals(new Integer(0))) {
				// ketu unifikohen ArrayListat qe mbajne mundesite e
				// seciles qelule brenda kesaj kolone te shkurte
				notFound = unifyArrayLists(notFound,
						shortcolumn[i].possibilities);
			}
		}
	}

	// kjo metode tregon vlerat qe gjinden ne probabilet e kesaj kolone
	// te shkurte
	public void viewProbable() {
		for (int i = 0; i < probablyFound.size(); i++) {
			System.out.print("" + i + " " + probablyFound.get(i) + " ");
		}
		System.out.println("-----------------");
	}

	// kjo metode kryen unionin e dy arraylistave (si unioni i bashkesive)
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

	// kjo metode kryen diferencen e dy arraylistave, si diference bashkesish
	// kjo metode dhe ajo unifyArrayLists do te mund te largoheshin nga kjo
	// klase
	// sepse perdoren edhe ne klasen MediumBox
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