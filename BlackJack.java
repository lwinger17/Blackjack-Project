/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author lucaswinger
 */


public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
  
                
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Title title = new Title();
                title.setVisible(true);
                
            }
        });

        
    }
}
    
    

