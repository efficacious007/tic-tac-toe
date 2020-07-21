/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.pkg2;



import javax.swing.JFrame;

/**
 *
 * @author DOSAJH
 */
public class TicTacToe2 {
 static JFrame jf = new JFrame();
  static tic_tac_menu m = new tic_tac_menu();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // TODO code application logic here
        jf.setUndecorated(true);
        jf.add(m);
        jf.pack();
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
}
