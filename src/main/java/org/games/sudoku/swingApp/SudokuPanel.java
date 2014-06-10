package org.games.sudoku.swingApp;

import javax.swing.*;
import java.awt.*;

public class SudokuPanel extends JPanel {
	// public TextField[][] board = new TextField[9][9];
	// public JPanel[][] panelat = new JPanel[9][9];
	public MediumBox[][] board = new MediumBox[3][3];
	public Row[] rrr = new Row[9];
	public Column[] ccc = new Column[9];
	public ShortRow[][] shortrows = new ShortRow[9][3];
	public ShortColumn[][] shortcolumns = new ShortColumn[3][9];

	public SudokuPanel(Board b) {
		this.setLayout(new GridLayout(3, 3));
		setPreferredSize(new Dimension(270, 270));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = new MediumBox(b, i, j);
				add(board[i][j]);
			}
		}
		for (int i = 0; i < 9; i++) {
			rrr[i] = new Row(b, i);
			ccc[i] = new Column(b, i);
		}
		// ketu ndertohen rreshtat e shkurte dhe kolonat e shkurta
		// brenda teresise se tabeles se sudoku
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				shortrows[i][j] = new ShortRow();
				shortrows[i][j].shortrow[0] = b.board[i][3 * j + 0];
				shortrows[i][j].shortrow[1] = b.board[i][3 * j + 1];
				shortrows[i][j].shortrow[2] = b.board[i][3 * j + 2];
				shortcolumns[j][i] = new ShortColumn();
				shortcolumns[j][i].shortcolumn[0] = b.board[3 * j + 0][i];
				shortcolumns[j][i].shortcolumn[1] = b.board[3 * j + 1][i];
				shortcolumns[j][i].shortcolumn[2] = b.board[3 * j + 2][i];
			}
		}
		// brenda secilit rresht vendosi rreshtat e shkurte korrespondues
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				rrr[i].shorties[j] = shortrows[i][j];
			}
		}
		// brenda seciles kolone vendosi kolonat e shkurta korresponduese
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				ccc[j].shortcolumns[i] = shortcolumns[i][j];
			}
		}
		// brenda seciles kuti te mesme vendosi rreshtat e shkurte dhe kolonat
		// e shkurta korresponduese
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					board[i][j].shortCols[k] = shortcolumns[i][3 * j + k];
					board[i][j].shortRows[k] = shortrows[3 * j + k][i];
				}
			}
		}
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
	}

}