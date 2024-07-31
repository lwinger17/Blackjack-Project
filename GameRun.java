/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;


import java.awt.*;


//Files that we imported to help store the cards in the players hand 

//To help with shuffling the deck of cards 

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameRun extends JFrame{
    // This is to create a representation of cards 
    // value are 1,2 .. type are C..
 private class Card {
String value ; 
String type ;

// Creating our cards constructor 
Card (String value,String type){
    this.value=value;
    this.type=type;
}
// Providing a String representation 
public String toString(){
    return value +"-"+ type; 
}
//Creating a get value to get the value of cards depending on the card
public int getValue(){
if ("AJQK".contains(value)){//for A,J,Q,K
    if (value=="A"){
    return 11;} 
   return 10;
}
return Integer.parseInt(value);// this is for cards 2-10
}
// isAce return A
public boolean isAce(){
return value == "A";
        }
//Image path of the cards 
public String getImagePath(){
return"./cards/"+ toString()+".png";
}

public String getImage(){
return".Background"+ toString()+".png";
}

}
 
 
 
/*   
******************************************************************************
////Creating an ArrayList to store all the cards 
***************************************************************************** 
*/    

// To build a deck of cards to we decided to use Array list to sort all the type of cards 
ArrayList<Card>deck;
//Setting my Random to shuffle the deck 
Random random =new Random();
//Dealer
Card hiddenCard;
ArrayList<Card> dealerHand;
int dealerSum; 
int dealerAceCount; 
 //player
ArrayList<Card> playerHand;
int playerSum; 
int playerAceCount; 
//Window variables defined
int boardWidth =700;
int boardHeight =boardWidth;
int cardWidth=110;
int cardHeight=154;


/*   
******************************************************************************
// We are using J frame here to make our code look pretier
// We watch a video : this one https://www.youtube.com/watch?v=GMdgjaDdOjI
***************************************************************************** 
*/    
JFrame frame =new JFrame ("Black Jack");
JPanel gamePanel = new JPanel(){

@Override
public void paintComponent (Graphics g){
super.paintComponent(g);

 
//drawing hidden card
try{
Image hiddenCardImg= new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
// If Stay Button is Enabled 
if(!stayButton.isEnabled()){
hiddenCardImg= new ImageIcon(getClass().getResource(hiddenCard.getImagePath())).getImage();
}

g.drawImage(hiddenCardImg, 30, 30,cardWidth,cardHeight,this);

//drawing dealer´s  hand
for ( int i=0; i< dealerHand.size();i++){
    Card card= dealerHand.get(i); 
    Image cardImg =new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
    g.drawImage(cardImg,cardWidth+35+(cardWidth +10)*i,30,cardWidth,cardHeight,this);}
  // Draw "Dealer" text
Font dealerFont = new Font("Arial", Font.BOLD, 20);
g.setFont(dealerFont);
g.setColor(Color.WHITE); // Set the color of the text
String dealerText = "Dealer";
int textX = 35; // X position for the text
int textY = 25; // Y position for the text (adjust as needed)
g.drawString(dealerText, textX, textY);
  //drawing player´s hand  
  for (int i =0; i< playerHand.size();i++){
  Card card= playerHand.get(i); 
  Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
  g.drawImage(cardImg,35+(cardWidth +10 )*i,330,cardWidth,cardHeight,this);
  }

Font playerFont = new Font("Arial", Font.BOLD, 20);
g.setFont(playerFont);
g.setColor(Color.WHITE); // Set the color of the text
String playerText = "Player";
g.drawString(playerText, 35, 325);
  
/*   
******************************************************************************
////Creating an ArrayList to store all the cards
// We watch this video : https://www.youtube.com/watch?v=GMdgjaDdOjI
***************************************************************************** 
*/    
  
//To allow people to win 
if(!stayButton.isEnabled()){
    dealerSum= reduceDealerAce();
    playerSum= reducePlayerAce();
    System.out.println("Stay");
    System.out.println(dealerSum);
    System.out.println(playerSum);

   String message ="";
    if( playerSum>21){
    message="You Lose!";
  playerBalance -= 10;
  balanceLabel.setText("Balance: $" + playerBalance);

   }
    else if (dealerSum>21){
    message= "You Win";
    playerBalance += 20;
  balanceLabel.setText("Balance: $" + playerBalance);
}
    //Both you and dealer <=21
    else if (playerSum==dealerSum){
    message= "Tie!";
    playerBalance += 10;
  balanceLabel.setText("Balance: $" + playerBalance);
}
    else if (playerSum>dealerSum){
    message= "You Win";
    playerBalance += 20;
  balanceLabel.setText("Balance: $" + playerBalance);
}
    else if (playerSum<dealerSum){
    message= "You Lose";
    playerBalance -= 10;
  balanceLabel.setText("Balance: $" + playerBalance);
  }
    g.setFont( new Font ("Arial",Font.PLAIN,30));
    g.setColor(Color.white);
    g.drawString(message, 220,250);  
}
}catch ( Exception e){
    e.printStackTrace();
}
}
};


/// This is to create buttons and set colors...
// Got inspiration from this video : https://www.youtube.com/watch?v=-IMys4PCkIA
JPanel buttonPanel =new JPanel();
JButton hitButton = new JButton("Hit");
JButton stayButton= new JButton("Stay");
JButton doubleButton = new JButton("Double");
JButton newRoundButton = new JButton("New Round");


JButton settingsButton = new JButton("Pause");

int playerBalance = 500;
 int betAmount = 10; // Fixed bet amount for each round
 int winAmount = 20;
 
 JLabel balanceLabel;
  
   GameRun (){
       
        startGame();
        frame.setVisible (true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(30, 60, 45));
        frame.add(gamePanel);
        
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
Color textColor = Color.BLACK;
        //----------------
        newRoundButton.setFocusable(false);
        buttonPanel.add(newRoundButton);
        newRoundButton.setBackground(new Color(139, 165, 147));
newRoundButton.setForeground(textColor);
newRoundButton.setFont(buttonFont);


        hitButton.setFocusable(false);
        buttonPanel.add(hitButton);
        hitButton.setBackground(new Color(112, 161, 178));
hitButton.setForeground(textColor);
hitButton.setFont(buttonFont);

        stayButton.setFocusable(false);
        buttonPanel.add(stayButton);
        stayButton.setBackground(new Color(192, 192, 147));
stayButton.setForeground(textColor);
stayButton.setFont(buttonFont);

        doubleButton.setFocusable(false);
        buttonPanel.add(doubleButton);
        doubleButton.setBackground(new Color(150, 111, 214));
doubleButton.setForeground(textColor);
doubleButton.setFont(buttonFont);

        
        
        
        settingsButton.setFocusable(false);
        buttonPanel.add(settingsButton);
        settingsButton.setBackground(new Color(184, 204, 193));
settingsButton.setForeground(textColor);
settingsButton.setFont(buttonFont);
        
        
        
        
        
        balanceLabel = new JLabel("Balance: $" + playerBalance);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        balanceLabel.setForeground(Color.black);
        buttonPanel.add(balanceLabel, BorderLayout.WEST);
        // balance 
      

        
        frame.add(buttonPanel,BorderLayout.SOUTH);
        hitButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        Card card = deck.remove(deck.size()-1);
        playerSum+= card.getValue();
        playerAceCount+=card.isAce()?1:0;
        playerHand.add(card);
        gamePanel.repaint();
        
        
        
        //This is to make the drawing of card stop when we reach 21; This will make the button unclickable 
        
        if (reducePlayerAce()>21){
            hitButton.setEnabled(false);}
        gamePanel.repaint();
        }
        });
        
            
        stayButton.addActionListener( new ActionListener(){
        public void actionPerformed( ActionEvent e){
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
            while(dealerSum<17){
                Card card = deck.remove(deck.size()-1);
                dealerSum+= card.getValue();
                dealerAceCount+=card.getValue();
                dealerAceCount+= card.isAce()?1:0;
                dealerHand.add(card);   
            
            }
            
            gamePanel.repaint();
        }
   });
        // REWORK
       doubleButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Check if the player has enough balance to double the bet
        if (playerBalance >= betAmount) {
            // Double the betAmount and winAmount
            betAmount *= 2;
            winAmount *= 2;

            // Deduct the new bet amount from the player's balance
            

            // Update the balance label
            balanceLabel.setText("Balance: $" + playerBalance);

            // Disable doubleButton for the current round
            doubleButton.setEnabled(false);

            // Continue with the game
            // Add your logic here...

            // Enable necessary buttons
            hitButton.setEnabled(true);
            stayButton.setEnabled(true);
             doubleButton.setEnabled(true);

            // Repaint the gamePanel
            gamePanel.repaint();
        } else {
            // Display a message if the player doesn't have enough balance
            JOptionPane.showMessageDialog(frame, "Not enough balance to double the bet.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
      newRoundButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Check if the player has enough balance to place a bet
        if (playerBalance >= betAmount) {
            // Reset the betAmount and winAmount to their original values
            betAmount = 10; // You can set it to your initial bet amount
            winAmount = 20; // You can set it to your initial win amount

            // Deduct the bet amount from the player's balance
            playerBalance -= betAmount;

            // Update the balance label
            balanceLabel.setText("Balance: $" + playerBalance);

            // Reset doubling button to enabled
            doubleButton.setEnabled(true);

            // Reset game state for a new round
            startGame();

            // Enable necessary buttons
            hitButton.setEnabled(true);
            stayButton.setEnabled(true);
            doubleButton.setEnabled(true);

            // Repaint the gamePanel
            gamePanel.repaint();
        } else {
            // Display a message if the player doesn't have enough balance
            JOptionPane.showMessageDialog(frame, "You are Broke, restart to get your money back.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
      
      
// Return to Settings
        settingsButton.addActionListener ( new ActionListener() {
              public void actionPerformed ( ActionEvent e) {
                  PauseMenu settingsScreen = new PauseMenu(); 
                  settingsScreen.setVisible(true);
                  dispose();
              }
              
        });
        
       //This is to call repaint within the constructor 
        gamePanel.repaint(); 
        
    }
   
  
   
   
   
/*   
******************************************************************************
//Greating our method start Game 
***************************************************************************** 
*/   
//Start Game Method 
   
    public void startGame(){
     //We need a deck first so that we can shuffle the deck and play 
     buildingDeck(); 
     // This is for shuffling the deck 
     shufflingDeck(); 
     
//dealer
     dealerHand=new ArrayList<Card>(); 
     dealerSum=0;
     dealerAceCount = 0;
     //Removing cards from the last index 
     //Hidden Card
     hiddenCard= deck.remove(deck.size()-1);
     dealerSum += hiddenCard.getValue();
     dealerAceCount+= hiddenCard.isAce()? 1:0;
    
     // We remove a card, We check and add the value(we check if Ace or not ), then add it to dealer hand
     Card card = deck.remove(deck.size()-1);
     dealerSum += card.getValue();
      dealerAceCount+= card.isAce()?1:0;
      dealerHand.add(card);
        System.out.println("Dealer:");
        System.out.println(hiddenCard);
        System.out.println(dealerHand);
        System.out.println(dealerSum);
        System.out.println(dealerAceCount);
        
//player: We are removing a card from the end of the array list then we add the card Value to the playet sum 
// Then we see if ther is an ace 
playerHand=new ArrayList<Card>(); 
     playerSum=0;
     playerAceCount = 0;
 for(int i=0 ;i<2;i++){
 card = deck.remove(deck.size()-1);
 playerSum+= card.getValue();
 playerAceCount+=card.isAce()?1:0;
 playerHand.add(card);
         }
 System.out.println("player:");
        System.out.println(playerHand);
        System.out.println(playerSum);
        System.out.println(playerAceCount);
        
        
        
}
     
// Here we are building our key method which is buildingDeck , Shuffle deck ..
       
//Build Deck Method : 
// Our array contains the values and type of the cards in a standard deck
// We are creating 2 for loops , the fist one to iterate through the types and the inner loop iterates though the "values" array representing each rank. 
// Then we created a card object using the value and type compination 
// We then added our card object to the deck
     public void  buildingDeck(){
     deck = new ArrayList<Card>();
     String [] values ={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
     String [] types ={"C","D","H","S"};
     for ( int i=0; i< types.length; i++){
     for (int j=0; j< values.length;j++){
     Card card = new Card(values[j],types[i]);
     deck.add(card);
    }
    }
     
         System.out.println("Build Deck: ");
         System.out.println(deck);
     }
     
     
     
//Creating our shuffle method with the help of a for loop and random
// To shuffle we are iterate through each card and then select a random card and swap it with 
// The for loop will iterate  through each card in the deck AND Generate a random card within the deck 
// We did Some research on Fisher-Yates shuffle 
 public void shufflingDeck(){
     Collections.shuffle(deck);
        System.out.println("Shuffled cards");
        System.out.println(deck);
 }
//This is only for the speacial case when the player sum is greater than 21
    public int reducePlayerAce(){
    while(playerSum>21 &&playerAceCount>0){
    playerSum-=10;
    playerAceCount-=1;
    }
    return playerSum;

}
    public int reduceDealerAce(){
    while (dealerSum>21&& dealerAceCount>0){
        dealerSum-=10;
        dealerAceCount-=1;
        
    }
    return dealerSum;
    }}
