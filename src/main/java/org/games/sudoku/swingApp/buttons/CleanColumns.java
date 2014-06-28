package org.games.sudoku.swingApp.buttons;  
 import javax.swing.*;

import org.games.sudoku.swingApp.models.Column;

import java.awt.event.*;
   //import java.awt.*;

   public class CleanColumns extends JButton implements ActionListener
   {
      public Column[] rows;
      public CleanColumns(String lab, Column[] ar)
      {
         super("Pastroji Kolonat");
         rows = ar;
         addActionListener(this);
      }
   //ky eshte butoni qe ben pastrimin e kolonave sipas vlerave te fytyrave
      //te qelulave, fytyrat e te cilave jane percaktuar
      public void actionPerformed(ActionEvent e)
      {
      //   System.out.println("removing possibilities");
         for(int i = 0; i < rows.length; i++)
         {
            for(int j = 0; j < 9; j++)
            {
               if(!rows[i].cell[j].face.equals(new Integer(0)))
               {
                  for(int k = 0; k < 9; k++)
                  {
                     if(k != j)
                     {
                 //       System.out.println("clening");
                        rows[i].cell[k].eliminateFromPossibilities(rows[i].cell[j].face);
                 //       System.out.println("\t\t\tclening");
                     }
                  }
               }
            }
         }
      }
   
   }