/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
  
/**
 *
 * @author lucaswinger
 */

public class Title extends JFrame {

    static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

public static final Color Dark_Green = new Color(0,102,0);
 
    public Title() {

        setTitle("Blackjack");
        setSize(800, 600);

      JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(30, 60, 45));
       
        
        JLabel titleLabel = new JLabel("BlackJack");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
  
       
// Create buttons
JButton startButton = new JButton("Start");
JButton HowToPlayButton = new JButton("HowToPlayButton");
JButton settingsButton = new JButton("Settings");
JButton quitButton = new JButton("Quit");

// Set alignment (if needed)
startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
HowToPlayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

// Set preferred size for the buttons
Dimension buttonSize = new Dimension(200, 50); // Adjust the dimensions as needed
startButton.setPreferredSize(buttonSize);
HowToPlayButton.setPreferredSize(buttonSize);
settingsButton.setPreferredSize(buttonSize);
quitButton.setPreferredSize(buttonSize);

// Increase font size
Font buttonFont = new Font(startButton.getFont().getName(), Font.PLAIN, 18); // Adjust the font size as needed
startButton.setFont(buttonFont);
HowToPlayButton.setFont(buttonFont);
settingsButton.setFont(buttonFont);
quitButton.setFont(buttonFont);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              GameRun GameRunScreen = new GameRun(); 
                  GameRunScreen.setVisible(true);
                  dispose();
            }
        });
        
      HowToPlayButton.addActionListener(new ActionListener() {
              public void actionPerformed ( ActionEvent e) {
                  HowToPlay HowToPlayScreen = new HowToPlay(); 
                  HowToPlayScreen.setVisible(true);
               
              }
        });
         
          settingsButton.addActionListener ( new ActionListener() {
              public void actionPerformed ( ActionEvent e) {
                  Settings settingsScreen = new Settings(); 
                  settingsScreen.setVisible(true);
                  dispose();
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
        panel.add(HowToPlayButton);
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
