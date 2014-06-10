package org.games.sudoku.swingApp;
/*
 * kjo klase modelon matricen e Sudokus
 * ketu instancohen qelulat e Sudokus.
 * Qelulat jane te tipit SmallBox
 * Ketu shfrytezohet konstruktori i Small Box pa parametra
 * ne menyre qe t'i mundesohet shfrytezuesit te percaktoje
 * sudokun me te cilen deshiron ta sfidoje programin
 */

   public class Board
   {
      public SmallBox[][] board = new SmallBox[9][9];
   
      public Board()
      {
         for(int i = 0; i < 9; i++)
         {
            for(int j = 0; j < 9; j++)
            {
            	board[i][j] = new SmallBox();
            	board[i][j].addKeyListener(new SudokuSmallBoxKeyListener(board[i][j]));
            }
         }
      }
      //kjometode shfaqe vleren e fytyres se seciles qelule
   public void showBoard()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				System.out.print(board[i][j].face + "   ");
			}
			System.out.println();
		}
	}
   }