/*
 * Cliquez sur nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt pour changer cette licence
 * Cliquez sur nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java pour modifier ce modèle
 */
package blackjack;


import java.awt.*;


// Fichiers que nous avons importés pour aider à stocker les cartes dans la main des joueurs 

// Pour aider à mélanger le jeu de cartes 

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


public class GameRunFrench extends JFrame{
    // Ceci est pour créer une représentation des cartes 
    // Les valeurs sont 1, 2 ... les types sont C...
 private class Card {
String value ; 
String type ;

// Création de notre constructeur de cartes 
Card (String value,String type){
    this.value=value;
    this.type=type;
}
// Fournir une représentation String 
public String toString(){
    return value +"-"+ type; 
}
//Créer une méthode pour obtenir la valeur des cartes en fonction de la carte
public int getValue(){
if ("AJQK".contains(value)){//pour A, J, Q, K
    if (value=="A"){
    return 11;} 
   return 10;
}
return Integer.parseInt(value);// ceci est pour les cartes 2-10
}
// isAce retourne A
public boolean isAce(){
return value == "A";
        }
//Chemin d'image des cartes 
public String getImagePath(){
return"./cards/"+ toString()+".png";
}

public String getImage(){
return".Background"+ toString()+".png";
}

}
 
 
 
/*   
******************************************************************************
////Création d'un ArrayList pour stocker toutes les cartes 
***************************************************************************** 
*/    

// Pour construire un jeu de cartes, nous avons décidé d'utiliser un ArrayList pour trier tous les types de cartes 
ArrayList<Card>deck;
// Réglage de mon Random pour mélanger le jeu de cartes 
Random random =new Random();
//Dealer
Card hiddenCard;
ArrayList<Card> dealerHand;
int dealerSum; 
int dealerAceCount; 
 //joueur
ArrayList<Card> playerHand;
int playerSum; 
int playerAceCount; 
//Variables de fenêtre définies
int boardWidth =700;
int boardHeight =boardWidth;
int cardWidth=110;
int cardHeight=154;


/*   
******************************************************************************
// Nous utilisons Jframe ici pour rendre notre code plus joli
// Nous avons regardé une vidéo : celle-ci https://www.youtube.com/watch?v=GMdgjaDdOjI
***************************************************************************** 
*/    
JFrame frame =new JFrame ("Black Jack");
JPanel gamePanel = new JPanel(){

@Override
public void paintComponent (Graphics g){
super.paintComponent(g);

 
//dessiner la carte cachée
try{
Image hiddenCardImg= new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
// Si le bouton Stay est activé 
if(!stayButton.isEnabled()){
hiddenCardImg= new ImageIcon(getClass().getResource(hiddenCard.getImagePath())).getImage();
}

g.drawImage(hiddenCardImg, 30, 30,cardWidth,cardHeight,this);

//dessiner la main du croupier
for ( int i=0; i< dealerHand.size();i++){
    Card card= dealerHand.get(i); 
    Image cardImg =new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
    g.drawImage(cardImg,cardWidth+35+(cardWidth +10)*i,30,cardWidth,cardHeight,this);}
  // Dessiner le texte "Le Groupier"
Font dealerFont = new Font("Arial", Font.BOLD, 20);
g.setFont(dealerFont);
g.setColor(Color.WHITE); // Définir la couleur du texte
String dealerText = "Le Groupier";
int textX = 35; // Position X pour le texte
int textY = 25; // Position Y pour le texte (ajuster si nécessaire)
g.drawString(dealerText, textX, textY);
  //dessiner la main du joueur  
  for (int i =0; i< playerHand.size();i++){
  Card card= playerHand.get(i); 
  Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
  g.drawImage(cardImg,35+(cardWidth +10 )*i,330,cardWidth,cardHeight,this);
  }

Font playerFont = new Font("Arial", Font.BOLD, 20);
g.setFont(playerFont);
g.setColor(Color.WHITE); // Définir la couleur du texte
String playerText = "Vous";
g.drawString(playerText, 35, 325);
  
/*   
******************************************************************************
////Création d'un ArrayList pour stocker toutes les cartes
// Nous avons regardé cette vidéo : https://www.youtube.com/watch?v=GMdgjaDdOjI
***************************************************************************** 
*/    
  
//Pour permettre aux gens de gagner 
if(!stayButton.isEnabled()){
    dealerSum= reduceDealerAce();
    playerSum= reducePlayerAce();
    System.out.println("Stay");
    System.out.println(dealerSum);
    System.out.println(playerSum);

   String message ="";
    if( playerSum>21){
    message="Vous avez perdu !";
  playerBalance -= 10;
  balanceLabel.setText("Solde : $" + playerBalance);

   }
    else if (dealerSum>21){
    message= "Vous avez gagné";
    playerBalance += 20;
  balanceLabel.setText("Solde : $" + playerBalance);
}
    //Les deux joueurs et le croupier <=21
    else if (playerSum==dealerSum){
    message= "Égalité !";
    playerBalance += 10;
  balanceLabel.setText("Solde : $" + playerBalance);
}
    else if (playerSum>dealerSum){
    message= "Vous avez gagné";
    playerBalance += 20;
  balanceLabel.setText("Solde : $" + playerBalance);
}
    else if (playerSum<dealerSum){
    message= "Vous avez perdu";
    playerBalance -= 10;
  balanceLabel.setText("Solde : $" + playerBalance);
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


/// Création de boutons et définition des couleurs...
// Inspiration tirée de cette vidéo : https://www.youtube.com/watch?v=-IMys4PCkIA
JPanel buttonPanel =new JPanel();
JButton hitButton = new JButton("Tirer");
JButton stayButton= new JButton("Rester");
JButton doubleButton = new JButton("Double");
JButton newRoundButton = new JButton("Nouveau tour");


JButton settingsButton = new JButton("Pause");

int playerBalance = 500;
int betAmount = 10; // Fixed bet amount for each round
int winAmount = 20;
 
 JLabel balanceLabel;
  
   GameRunFrench (){
       
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
                  PauseMenuFrench settingsScreen = new PauseMenuFrench(); 
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
