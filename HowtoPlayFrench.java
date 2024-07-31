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


class HowToPlayfrench extends JFrame{
   HowToPlayfrench(){
       
   this.setTitle("How To Play");
    // Creating a split pane to display rules on the right and cards on the left
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
   
   this.setLayout(new BorderLayout());
   
   //JText Area is here to display the rules
   // JPanel for displaying rules
        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new BorderLayout());
   
   JTextArea rulesTextArea =new JTextArea();
   rulesTextArea.setText("Ceci est une page pour vous expliquer les fonctions des boutons, les règles du Blackjack.\n" +
"\n" +
"*Les règles peuvent être trouvées dans les paramètres.* \n" +
"\n" +
"Comment jouer :\n" +
"\n" +
"Pour jouer chaque tour, assurez-vous d'appuyer sur Rester pour confirmer les cartes avec lesquelles vous allez parier.\n" +
"\n" +
"Votre solde actuel est affiché en bas à droite.\n" +
"\n" +
"Si vous perdez, vous perdez 10 $. \n" +
"\n" +
"Si vous gagnez, vous gagnez 20 $. \n" +
"\n" +
"Si vous et le croupier faites match nul, vous ne gagnez et/ou ne perdez rien. \n" +
"\n" +
"Fonctions des boutons : \n" +
"\n" +
"Nouveau Tour : Lance un nouveau tour après avoir perdu ou gagné.\n" +
"\n" +
"Carte : Vous permet d'obtenir une autre carte si vous estimez que la valeur de votre carte est trop faible. \n" +
"\n" +
"Rester : Déclare que vous êtes satisfait de vos cartes et permet au croupier de tirer ses cartes. \n" +
"\n" +
"Doubler : Double votre mise actuelle. (Au cas où vous vous sentiriez chanceux). \n" +
"\n" +
"Pause : Vous amène au menu des paramètres si vous souhaitez changer quelque chose."); 
   
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
