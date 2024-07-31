/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author lucaswinger
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


class HowToPlay extends JFrame{
   HowToPlay(){
       
   this.setTitle("How To Play");
    // Creating a split pane to display rules on the right and cards on the left
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
   
   this.setLayout(new BorderLayout());
   
   //JText Area is here to display the rules
   // JPanel for displaying rules
        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new BorderLayout());
   
   JTextArea rulesTextArea =new JTextArea();
   rulesTextArea.setText("This is a page to tell you the functions of the buttons, the rules of Blackjack.\n" +
"\n" +
"*The Rules can be found in the Settings.* \n" +
"\n" +
"How To Play:\n" +
"\n" +
"To play each round make sure to press Stay in order to confirm the cards you will bet with.\n" +
"\n" +
"Your current Balance is shown on the bottom right.\n" +
"\n" +
"If you lose you lose $10.\n" +
"\n" +
"If you win you gain $20. \n" +
"\n" +
"If you and the dealer Tie you gain and/or lose nothing. \n" +
"\n" +
"Button functions: \n" +
"\n" +
"New Round: Starts a new round after you have lost or won.\n" +
"\n" +
"Hit: Allows you to gain another card if you believe your card value is too low. \n" +
"\n" +
"Stay: Declares that you're content with your cards and lets the dealer draw his cards. \n" +
"\n" +
"Double: Doubles your current bet. (In case you feel lucky). \n" +
"\n" +
"Pause: Brings you to the settings menu in case you want to change anything."); 
   
   rulesTextArea.setEditable(false);
   rulesTextArea.setMargin(new Insets(10, 10, 10, 10));
   JScrollPane scrollPane = new JScrollPane(rulesTextArea);
   
   
   JLabel ruleLabel = new JLabel("How To Play");
   ruleLabel.setFont(new Font("Arial", Font.BOLD, 20));
   
   // JPanel for adding card images and values next to the rules Will need to finish taht later
   
        JPanel cardsPanel = new JPanel();
        // Add actual card images and their values here
        
        // Adding components to the window to make it preaty 
         rulesPanel.add(ruleLabel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER); // Rules displayed in scrollable text area
        this.add(cardsPanel, BorderLayout.EAST);   // Panel for card images and values

        // JFrame configurations
        this.setSize(800, 400);
        this.setVisible(false); // Initially set to not visible
   
   
   } 
    
}
