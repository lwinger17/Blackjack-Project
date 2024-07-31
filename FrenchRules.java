/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

/**
 *
 * @author User
 */

class FrenchRules  extends JFrame{
   FrenchRules(){
       
   this.setTitle("Règles");
    // Creating a split pane to display rules on the right and cards on the left
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
   
   this.setLayout(new BorderLayout());
   
   //JText Area is here to display the rules
   // JPanel for displaying rules
        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new BorderLayout());
   
   JTextArea rulesTextArea =new JTextArea();
   rulesTextArea.setText("Objectif : Le but est de battre le croupier en ayant une valeur de main plus proche de ou exactement 21 que celle du croupier, sans dépasser 21.   \n" +
"\n" +
"Valeurs des cartes :  \n" +
"\n" +
"Les cartes numérotées (2-10) valent leur valeur faciale.  \n" +
"\n" +
"Les cartes à face (Valet, Dame, Roi) valent chacune 10 points.  \n" +
"\n" +
"Les As peuvent valoir 1 ou 11 points, en fonction de la valeur qui profite le plus à votre main.  \n" +
"\n" +
"Déroulement du jeu :  \n" +
"\n" +
"Distribution initiale : Vous et le croupier recevez chacun deux cartes. Vos cartes sont généralement visibles, tandis que le croupier a une carte visible (appelée \"carte ouverte\") et une carte face cachée \n" +
"Tour du joueur : Vous pouvez choisir de \"tirer\" (prendre une autre carte) pour augmenter la valeur de votre main ou de \"rester\" (conserver votre main actuelle). Vous pouvez tirer autant de fois que vous le souhaitez, mais faites attention à ne pas dépasser 21, ce qui entraînerait une \"perte\", et vous perdriez la manche. \n" +
"Tour du croupier : Après avoir terminé votre tour, le croupier révèle sa carte trouée. Le croupier doit suivre des règles spécifiques : en général, il doit tirer jusqu'à atteindre au moins 17 points ou plus. \n" +
"Victoire : Si votre main est plus proche de 21 que celle du croupier sans dépasser 21, vous gagnez et êtes payé en fonction de votre mise. Si le croupier dépasse 21 et que vous ne le faites pas, vous gagnez également. Si vous avez tous les deux la même valeur de main, c'est une \"égalité\", et vous récupérez votre mise. \n" +
"Blackjack : Si vous recevez un As et une carte de valeur 10 (10, Valet, Dame, Roi) comme vos deux premières cartes, vous avez un \"Blackjack\" et gagnez généralement 1,5 fois votre mise, sauf si le croupier a également un Blackjack, auquel cas c'est une égalité. \n" +
"\n" +
"Fin de la manche : Après la manche, vous pouvez placer une nouvelle mise pour la manche suivante, et le jeu continue. Voilà un aperçu de base du Blackjack américain. Le jeu est facile à comprendre mais offre une profondeur stratégique lorsque vous apprenez quand tirer, rester, doubler ou diviser les paires pour maximiser vos chances de gagner. " +
"C'est l'aperçu de base du Blackjack américain. Le jeu est facile à comprendre mais offre une profondeur stratégique à mesure que vous apprenez quand frapper, rester debout, doubler ou diviser des paires pour maximiser vos chances de gagner."); 
   
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


