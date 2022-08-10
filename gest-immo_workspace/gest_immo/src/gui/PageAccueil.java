package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import outils.Fonctions;

public class PageAccueil extends JPanel {
	
	public static JFrame frame;
	
	public PageAccueil () {
		fenetreAccueil ();
	}
	
	public void fenetreAccueil() {
		setLayout(null);
		
		// welcome panel 
        JPanel PageAccueil = new JPanel();
        PageAccueil.setBounds(110, 63, 500, 200);
        PageAccueil.setBackground(new java.awt.Color(217, 217, 217));
        PageAccueil.setBorder(BorderFactory.createLineBorder(Color.black, 2)); // border
        
		// welcome text
		JLabel msgBienvenu = new JLabel("<html>Bienvenue sur GEST-IMMO <br/> Veuillez vous connecter", SwingConstants.CENTER);
		msgBienvenu.setBounds(136, 125, 448, 76); // dimension
		msgBienvenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30)); // font n height
		
		// login button
		JButton btnConnexion = new JButton("<html><font color = white> Connectez-vous </font></html>");
		btnConnexion.setBounds(260, 285, 200, 50);
		btnConnexion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // font n height
		btnConnexion.setBackground(new java.awt.Color(39, 170, 243));
		btnConnexion.setBorder(null);
		
		// connexion action
		MainWindow.connexion = new MenuConnexion ();
		btnConnexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnConnexion)
					MainWindow.ouvrePanel(MainWindow.connexion); // ouvre le menu connexion
			}
		});
		
		// ajout des différents composants du menu
		
		add(Fonctions.signature(MainWindow.copyright));
		add(btnConnexion);
		add(msgBienvenu);
        add(PageAccueil);
        
	}

}
