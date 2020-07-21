/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.pkg2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author DOSAJH
 */
public class GameController {
   private int count;
   int row;
   private int turn;
   JLabel l4;
   game_continue gcont;
   private ImageIcon img1;
   private ImageIcon img2;
   private int arr2 [][] = new int [3][9];
   private int arr [] = new int [10];
   
    ActionListener taskperform = new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           gcont= new game_continue(TicTacToe2.jf, true);
           gcont.setVisible(true);
       }
   };
    
   ActionListener t2 = new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
         l4.setText("");
       }
   };
   
    public GameController(){
        
        img2 = new ImageIcon("C:\\Users\\Dosajh\\Documents\\NetBeansProjects\\tic tac toe 2\\src\\tic\\tac\\toe\\pkg2\\x.png");
        img1 = new ImageIcon("C:\\Users\\Dosajh\\Documents\\NetBeansProjects\\tic tac toe 2\\src\\tic\\tac\\toe\\pkg2\\o.png");
        
        for (int i = 0; i < 10; i++) {
            arr[i]=0;
        }
        for(int i=0; i<3;i++){
        for(int j=0;j<9;j++){
        arr2[i][j]=0;
        }
        }
        turn=1;
        count=9;
    }
    boolean checkOverwritting(int id,JButton b){
         if(arr[id]==1){
         return false;
         }
         return true;
    }
    
    void setValue(JButton b,int id,JLabel l,JLabel l2){
    l4=l2;
        boolean flag = checkOverwritting(id, b);
        if(flag){
                 arr[id]=1;
                 enter_choice(id);
                 if(turn==1){
                 b.setIcon(img1);
                 }
                 else{
                 b.setIcon(img2);
                 }
                 String a  = check_winner();
                 count--;
                 if(count==0 && "draw".equals(a)){
                 l.setText("Game Draw");
                 //provoke JDIALOG HERE
                  Play_area.play.buttondisable();
                 Timer timer = new Timer(1800,taskperform);
                 timer.setRepeats(false);
                 timer.start();
                
                 }
                 else if("win1".equals(a)) {
                                  Play_area.play.buttondisable();
                                    Play_area.play.colourChange(row);
                l.setText("Player 1 Wins");
                Timer timer = new Timer(1800,taskperform);
                 timer.setRepeats(false);
                 timer.start();
 //provoke Jdialog here
                 }
                 else if("win2".equals(a)){
                      Play_area.play.buttondisable();
                      Play_area.play.colourChange(row);
                 l.setText("Player 2 Wins");
                 //Provoke Jdialog
                 Timer timer = new Timer(1500,taskperform);
                 timer.setRepeats(false);
                 timer.start();
                 }
                 else{
                 player_turn(l);
                 }
                 
              
        }
        else {
            l4.setText("error you cannot overwrite !"); 
            Timer t3 = new Timer(1100,t2);
            t3.setRepeats(false);
            t3.start();
           
        }
    }
    
    void player_turn(JLabel l){
        if(turn==1){
            l.setText("Player 2 Turn");
            turn=2;
        }
        else{
        l.setText("Player 1 Turn");
        turn=1;
        }
    
    }
    void enter_choice(int id){
   
     if(id==1){
     arr2[turn][1]++;
     arr2[turn][4]++;
     arr2[turn][7]++;
     }
     else if(id==2){
     arr2[turn][1]++;
     arr2[turn][5]++;
     }
     else if(id==3){
     arr2[turn][1]++;
     arr2[turn][6]++;
     arr2[turn][8]++;}
     else if(id==4){
     arr2[turn][2]++;
     arr2[turn][4]++;
     }
     else if(id==5){
     arr2[turn][2]++;
     arr2[turn][5]++;
     arr2[turn][8]++;
     arr2[turn][7]++;
     }
     else if(id==6){
     arr2[turn][2]++;
     arr2[turn][6]++;
     }
     else if(id==7){
     arr2[turn][3]++;
     arr2[turn][4]++;
     arr2[turn][8]++;
     }
     else if(id==8){
     arr2[turn][3]++;
     arr2[turn][5]++;
     }
     else if(id==9){    
     arr2[turn][3]++;
     arr2[turn][6]++;
     arr2[turn][7]++;}
     
    }
    
    String check_winner(){
    
        for(int i=1;i<3;i++){
    for(int j=0;j<9;j++){
    if(arr2[i][j]>=3){
       row=j;
        return "win"+i;
        
    }
    }
    }
    
    return "draw";
    }
    
}
