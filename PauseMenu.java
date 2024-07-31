/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import static blackjack.Title.Dark_Green;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author icway
 */
public class PauseMenu extends JFrame {
    //==========================================================================
    // Properties
    //==========================================================================
    
    
    
    //==========================================================================
    // Constructors
    //==========================================================================
    /**
     * Default Constructor
     */
    //public PauseMenu() {}
    
    
    //==========================================================================
    // Methods
    //==========================================================================
    
    static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    public PauseMenu() {

        
        setTitle("Settings");

        
        setSize(800, 600);
        
       
      
            JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Dark_Green);
       
      
            JLabel titleLabel = new JLabel("Pause");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

       
            JButton resumeButton = new JButton("Resume");
        resumeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resumeButton.setBounds(100,100,200,100);
        resumeButton.setFocusable(false);
         
          JButton settingsButton = new JButton("Settings");
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.setBounds(100,220,200,100);
        settingsButton.setFocusable(false);
        
        
          JButton menuButton = new JButton("Menu");
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.setBounds(100,340,200,100);
        menuButton.setFocusable(false);
        
            JButton quitButton = new JButton("Quit");
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setBounds(100,460,200,100);
        quitButton.setFocusable(false);
       
       
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             dispose();
            }
        });
        
         settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              Settings settingsScreen = new Settings(); 
                  settingsScreen.setVisible(true);
                  dispose();
            }
        });
         
          menuButton.addActionListener(new ActionListener() {
            public void actionPerformed ( ActionEvent e) {
                  Title titleScreen = new Title(); 
                  titleScreen.setVisible(true);
                  dispose();
            }
        });
          quitButton.addActionListener(new ActionListener() {
            public void actionPerformed ( ActionEvent e) {
                  System.exit(0);
            }
        });
          

        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(resumeButton);
        panel.add(settingsButton);
        panel.add(menuButton);
        panel.add(quitButton);
        panel.add(Box.createVerticalGlue());
        

     
        add(panel);

        
        setLocationRelativeTo(null);

    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // icon Image
 ImageIcon image = new ImageIcon("logo.png");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Title titleScreen = new Title();
                titleScreen.setVisible(true);
            }
        });
    }
}
