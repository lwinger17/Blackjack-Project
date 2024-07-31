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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author lucaswinger
 */
class LanguageWindow extends JFrame {
    LanguageWindow(){
        this.setTitle("Select Your Languages");
        setSize(900, 700);

      JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(30, 60, 45));
        JLabel titleLabel = new JLabel("Select Your Languages");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
  
       
        JButton FrenchButton = new JButton("French");
        FrenchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
       FrenchButton.setBounds(100,100,200,100);
       FrenchButton.setFocusable(false);
          JButton EnglishButton = new JButton("English");
        EnglishButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        EnglishButton.setBounds(100,220,200,100);
        EnglishButton.setFocusable(false);
        
        
        JButton returnButton = new JButton("Return");
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.setBounds(100,340,200,100);
        returnButton.setFocusable(false);  
        
       
       FrenchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              FrenchTitle FrenchTitleScreen = new FrenchTitle(); 
                 FrenchTitleScreen.setVisible(true);
                  dispose();
            }
        });
  
          EnglishButton.addActionListener ( new ActionListener() {
              public void actionPerformed ( ActionEvent e) {
                  Settings EnglishScreen = new Settings(); 
               EnglishScreen.setVisible(true);
                  dispose();
              }
              
        });
    returnButton.addActionListener(new ActionListener() {
            public void actionPerformed ( ActionEvent e) {
                  Title titleScreen = new Title(); 
                  titleScreen.setVisible(true);
                  dispose();
            }
        });
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(FrenchButton);
        panel.add(EnglishButton);
        panel.add(returnButton);
        panel.add(Box.createVerticalGlue());
        add(panel);

        
        setLocationRelativeTo(null);

    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
  
  
    
}
