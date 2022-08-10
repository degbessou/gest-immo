package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import outils.Fonctions;
import outils.Json;
import system.Bail;
import system.Employe;
import system.Locataire;

public class MenuListeLocataire extends JPanel{
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
		
		
		JTable tableListeLocataire = new JTable(Locataire.afficherListeLocataire(), Locataire.Colonne());
		JScrollPane ListeLocataire = new JScrollPane(tableListeLocataire);
		ListeLocataire.setBounds(15, 145, 680, 227);
		

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
		

		add(affichageBox);
		add(affichageLbl);
		add(Json.remplirFiltreAffichage(affichageBox));
		add(ListeLocataire);
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "LISTE DES LOCATAIRES"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}

}
