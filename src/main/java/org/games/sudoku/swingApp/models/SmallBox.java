package org.games.sudoku.swingApp.models;

import java.util.ArrayList;

public class SmallBox {
	// ajo vlere qe paraqitet si fytyra e qelules
	public Integer face;
	public ArrayList<Integer> possibilities = new ArrayList<Integer>();

	// konstruktori i qelules me nje vlere per fytyren e saj
	public SmallBox(Integer f) {
		face = f;
		for (int i = 1; i <= 9; i++) {
			if (i != face)
				possibilities.add(i);
		}
	}

	// konstruktori i nje qelule te zbrazet
	public SmallBox() {
		face = new Integer(0);
		for (int i = 1; i <= 9; i++) {
			possibilities.add(i);
		}
	}

	// kjo metode ben percaktimin e fytyres se nje qelule me rastin e futjes se
	// numrit nga ana e perdoruesit
	public void setFace(Integer f) {
		face = f;
		possibilities.clear();
	}

	// kjometode ben eliminimin e numrit i nga mundesite e kesaj qelule
	public void eliminateFromPossibilities(Integer i) {
		// System.out.println("eliminateFromPossibilities is actually being invoked");
		// System.out.println(face + " " + new Integer(0) + (face == new
		// Integer(0)) + " " + (face.equals(new Integer(0))));
		if (face.equals(new Integer(0))) {
			// System.out.println("---");
			if (possibilities.indexOf(i) > -1) {
				// System.out.println("\t\tRemoving " + i);
				possibilities.remove(i);
			}
		}
		// secilen here qe nje mundesi eliminohet, shiko nese numri i mundesive
		// eshte saktesisht nje, dhe nese po, vendose ate mundesi si fytyre
		// te qelules
		if (possibilities.size() == 1) {
			setFace(new Integer(possibilities.get(0)));
		}
	}

	// kjo metode tregon se cfare ka brenda mundesive qelula
	public void whatMightBe(int i, int j) {
		System.out.println("Fytyra = " + face);
		System.out.println("Kutia :" + (i + 1) + ", " + (j + 1));
		System.out.print("\t");
		for (int k = 0; k < possibilities.size(); k++) {
			System.out.print(possibilities.get(k) + " ");
		}
		System.out.println();
	}

}