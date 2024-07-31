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


class RulesWindow extends JFrame{
   RulesWindow(){
       
   this.setTitle("Rules");
    // Creating a split pane to display rules on the right and cards on the left
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
   
   this.setLayout(new BorderLayout());
   
   //JText Area is here to display the rules
   // JPanel for displaying rules
        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new BorderLayout());
   
   JTextArea rulesTextArea =new JTextArea();
   rulesTextArea.setText("Objective: The goal is to beat the dealer by having a hand value closer to or exactly 21 than the dealer's hand without going over 21. \n" +
"\n" +
"Card Values: \n" +
"\n" +
"Number cards (2-10) are worth their face value. \n" +
"\n" +
"Face cards (Jack, Queen, King) are each worth 10 points. \n" +
"\n" +
"Aces can be worth 1 or 11 points, depending on which value benefits your hand more. \n" +
"\n" +
"Gameplay: \n" +
"\n" +
"Initial Deal: You and the dealer are each dealt two cards. Both of your cards are usually face-up, while the dealer has one face-up card (known as the \"upcard\") and one face-down card (the \"hole card\"). \n" +
"\n" +
"Player's Turn: You can choose to \"hit\" (take another card) to increase your hand value or \"stand\" (keep your current hand). You can continue to hit as many times as you like, but be careful not to go over 21, which results in a \"bust,\" and you lose the round. \n" +
"\n" +
"Dealer's Turn: After you finish your turn, the dealer reveals their hole card. The dealer must follow specific rules: usually, they must hit until they have at least 17 points or more. However, the rules may vary in different casinos. \n" +
"\n" +
"Winning: If your hand is closer to 21 than the dealer's hand without busting, you win and are paid out based on your bet. If the dealer busts and you don't, you win. If you both have the same hand value, it's a \"push,\" and you get your bet back. \n" +
"\n" +
"Blackjack: If you are dealt an Ace and a 10-value card (10, Jack, Queen, King) as your first two cards, you have a \"Blackjack\" and usually win 1.5 times your bet, unless the dealer also has a Blackjack, in which case it's a push. \n" +
"\n" +
"Splitting and Doubling Down: You may have the option to split pairs (if your initial two cards are of the same rank) or double down (double your bet after receiving your initial two cards). \n" +
"\n" +
"End of Round: After the round is over, you can place a new bet for the next round, and the game continues. \n" +
"\n" +
"That's the basic overview of American Blackjack. The game is easy to understand but offers strategic depth as you learn when to hit, stand, double down, or split pairs to maximize your chances of winning. "); 
   
   rulesTextArea.setEditable(false);
   rulesTextArea.setMargin(new Insets(10, 10, 10, 10));
   JScrollPane scrollPane = new JScrollPane(rulesTextArea);
   
   
   JLabel ruleLabel = new JLabel("Rule");
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
