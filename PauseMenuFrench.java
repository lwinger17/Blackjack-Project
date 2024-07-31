/*
 * Cliquez sur nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt pour modifier cette licence
 * Cliquez sur nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java pour modifier ce modèle
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
public class PauseMenuFrench extends JFrame {
    //==========================================================================
    // Propriétés
    //==========================================================================
    
    
    
    //==========================================================================
    // Constructeurs
    //==========================================================================
    /**
     * Constructeur par défaut
     */
    //public PauseMenu() {}
    
    
    //==========================================================================
    // Méthodes
    //==========================================================================
    
    static Object getInstance() {
        throw new UnsupportedOperationException("Pas encore pris en charge."); // Généré à partir de nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    public PauseMenuFrench() {

        
        setTitle("Paramètres");

        
        setSize(800, 600);
        
       
      
            JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Dark_Green);
       
      
            JLabel titleLabel = new JLabel("Pause");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

       
            JButton resumeButton = new JButton("Reprendre");
        resumeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resumeButton.setBounds(100,100,200,100);
        resumeButton.setFocusable(false);
         
          JButton settingsButton = new JButton("Paramètres");
        settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingsButton.setBounds(100,220,200,100);
        settingsButton.setFocusable(false);
        
        
          JButton menuButton = new JButton("Menu");
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.setBounds(100,340,200,100);
        menuButton.setFocusable(false);
        
            JButton quitButton = new JButton("Quitter");
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
              FrenchSettings settingsScreen = new FrenchSettings(); 
                  settingsScreen.setVisible(true);
                  dispose();
            }
        });
         
          menuButton.addActionListener(new ActionListener() {
            public void actionPerformed ( ActionEvent e) {
                  FrenchTitle titleScreen = new FrenchTitle(); 
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
        
        // Icone Image
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
