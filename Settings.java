/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import static blackjack.Title.Dark_Green;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lucaswinger
 */

public class Settings extends JFrame {

 
    
    
    static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    public Settings() {     
        setTitle("Settings");
   setSize(800, 600);  
            JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(30, 60, 45));
       JLabel titleLabel = new JLabel("Settings");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    JButton rulesButton = new JButton("Rules");
        rulesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rulesButton.setBounds(100,100,200,100);
        rulesButton.setFocusable(false);
         
          JButton languageButton = new JButton("Language");
        languageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        languageButton.setBounds(100,220,200,100);
        languageButton.setFocusable(false);
        languageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             LanguageWindow languageScreen = new LanguageWindow(); 
                  languageScreen.setVisible(true);
        }
        });
          JButton returnButton = new JButton("Return");
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.setBounds(100,340,200,100);
        returnButton.setFocusable(false);  
        rulesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             RulesWindow rulesScreen = new RulesWindow(); 
                  rulesScreen.setVisible(true);
            }
        });
        
         languageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              LanguageWindow languageScreen = new LanguageWindow(); 
                  languageScreen.setVisible(true);
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
          // help from https://blog.arrowhitech.com/java-stop-program-how-to-end-the-program-in-java/#:~:text=Firstly%2C%20we%20can%20use%20the,program%20that%20we%20are%20running.
          

        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(rulesButton);
        panel.add(languageButton);
        panel.add(returnButton);
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
