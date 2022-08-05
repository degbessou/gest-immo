package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import outils.Fonctions;
import system.Employe;
import system.Locataire;

public class MenuListeLocataire extends JPanel{
	JScrollPane tableListeLocataire;
	public MenuListeLocataire () {
		fenetreMenuListeLocataire ();
	}
	
	public void fenetreMenuListeLocataire() {
		setLayout(null);
		
		
		// affichage label
		JLabel affichageLbl = new JLabel("AFFICHAGE");
		affichageLbl.setBounds(393, 112, 89, 17); // dimension
		affichageLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// affichage box
		JComboBox affichageBox = new JComboBox();
		affichageBox.setBounds(550, 111, 140, 20);
		affichageBox.setBackground(Color.WHITE);
		affichageBox.setBackground(null);
		
		// tableau d'affichage de la liste des locataires
		tableListeLocataire = new JScrollPane(Locataire.afficherListeLocataire());
		tableListeLocataire.setBounds(30, 145, 660, 227);
		

		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == MainWindow.annuler)
					MainWindow.inscription = new MenuInscriptionLocataire();
				MainWindow.ouvrePanel(MainWindow.inscription);
			}
		});
		
//		affichageBox.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) { // ajouter la sauvegarde dans la base de donnée
//				if (e.getSource() == affichageBox)
//					//
//					tableListeLocataire = new JScrollPane(Locataire.afficherListeLocataireNbreAffichage(affichageBox));
//					tableListeLocataire.setBounds(30, 145, 660, 227);
//					add(tableListeLocataire);
//					
//			}
//		});

		add(affichageBox);
		add(affichageLbl);
		add(Locataire.remplirFiltreAffichage(affichageBox));
		add(tableListeLocataire);
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "LISTE DES BAUX"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}

}
