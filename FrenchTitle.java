/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class FrenchTitle extends JFrame {

    static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

public static final Color Dark_Green = new Color(0,102,0);
 
    public FrenchTitle() {

        setTitle("Blackjack");
        setSize(800, 600);

      JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Dark_Green);
       
        
        JLabel titleLabel = new JLabel("BlackJack");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
  
       
        JButton startButton = new JButton("Jouer");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
          JButton HowToPlayfrenchButton = new JButton("Comment Jouer");
        HowToPlayfrenchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
          JButton settingsButton = new JButton("Parametre");
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
          JButton quitButton = new JButton("Arreter");
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
       
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              GameRunFrench frGameRunScreen = new GameRunFrench();    
                  dispose();
            }
        });
        
         HowToPlayfrenchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              HowToPlayfrench HowToPlayScreen = new HowToPlayfrench(); 
                  HowToPlayScreen.setVisible(true);
               
                JOptionPane.showMessageDialog(null, "Starting the tutorial.");
            }
        });
         
          settingsButton.addActionListener ( new ActionListener() {
              public void actionPerformed ( ActionEvent e) {
                   FrenchSettings settingsScreen = new FrenchSettings(); 
                  settingsScreen.setVisible(true);
              }
              
        });
          // help from https://blog.arrowhitech.com/java-stop-program-how-to-end-the-program-in-java/#:~:text=Firstly%2C%20we%20can%20use%20the,program%20that%20we%20are%20running.
          
           quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
               System.exit(0);
            }
        });

        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(startButton);
        panel.add(HowToPlayfrenchButton);
        panel.add(settingsButton);
        panel.add(quitButton);
       panel.add(Box.createVerticalGlue());


     
        add(panel);

        
        setLocationRelativeTo(null);

    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
   

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               Title titleScreen = new Title();
                titleScreen.setVisible(true);
            }
        });
    }
    
    
   
    
    Object getstartButton() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    

