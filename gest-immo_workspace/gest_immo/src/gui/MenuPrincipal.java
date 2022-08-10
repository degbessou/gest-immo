package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import outils.Fonctions;
import system.Employe;

public class MenuPrincipal extends JPanel{
	
	public static JFrame frame;
	
	public MenuPrincipal () {
		fenetreMenuPrincipal ();
	}
	
	public void fenetreMenuPrincipal() {
		setLayout(null);
		
		// inscription locataire bouton
		JButton btnInscription = new JButton("<html><font color= white>INSCRIRE UN LOCATAIRE</font></html>");
		btnInscription.setBounds(225, 80, 270, 40);
		btnInscription.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); // font n height
		btnInscription.setBackground(new java.awt.Color(0, 0, 0));
		btnInscription.setBorder(null);
		
		//bail bouton
		JButton btnBail = new JButton("<html><font color= white>BAIL</font></html>");
		btnBail.setBounds(225, 170, 270, 40);
		btnBail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); // font n height
		btnBail.setBackground(new java.awt.Color(0, 0, 0));
		btnBail.setBorder(null);
		
		// catalogue bouton
		JButton btnCatalogue = new JButton("<html><font color= white>CATALOGUE</font></html>");
		btnCatalogue.setBounds(225, 265, 270, 40);
		btnCatalogue.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); // font n height
		btnCatalogue.setBackground(new java.awt.Color(0, 0, 0));
		btnCatalogue.setBorder(null);
		
		// Paiement bouton
		JButton btnPaiement = new JButton("<html><font color= white>PAIEMENT</font></html>");
		btnPaiement.setBounds(225, 360, 270, 40);
		btnPaiement.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); // font n height
		btnPaiement.setBackground(new java.awt.Color(0, 0, 0));
		btnPaiement.setBorder(null);
		
		// inscription locataire action
		btnInscription.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnInscription)
				MainWindow.inscription = new MenuInscriptionLocataire ();
				MainWindow.ouvrePanel(MainWindow.inscription); // ouvre le menu inscription
		}
	});
		
		// paiement bouton action
		btnPaiement.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnPaiement)
				MainWindow.paiement = new MenuPaiement ();
				MainWindow.ouvrePanel(MainWindow.paiement); // ouvre le menu paiement
		}
	});
		
		// bail bouton action
		btnBail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnBail)
					MainWindow.bail = new MenuGestionBail();
				MainWindow.ouvrePanel(MainWindow.bail); // ouvre le menu bail
			}
		});
		
		// catalog button action
		btnCatalogue.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCatalogue)
				MainWindow.catalogue = new MenuCatalogue();
				MainWindow.ouvrePanel(MainWindow.catalogue); // ouvre le menu catalogue
			}
		});
		
		// bouton quitter action
		MainWindow.quitter = Fonctions.bouttonQuitter(MainWindow.quitter);
		MainWindow.quitter.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.quitter)
				MainWindow.pageAccueil = new PageAccueil ();
				MainWindow.ouvrePanel(MainWindow.pageAccueil); // ouvre le menu page accueil
			}
		});
		
		// ajout des différents composants du menu
		
		add(btnPaiement);
		add(btnCatalogue);
		add(btnBail);
		add(btnInscription);
		
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
		add(MainWindow.quitter);
	}

}
