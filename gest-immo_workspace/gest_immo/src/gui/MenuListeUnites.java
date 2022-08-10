package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import outils.Fonctions;
import outils.Json;
import system.Bail;
import system.Employe;
import system.Locataire;
import system.Unites;

public class MenuListeUnites extends JPanel {


	public MenuListeUnites () {
		fenetreMenuListeUnites ();
	}
	
	public void fenetreMenuListeUnites() {
		setLayout(null);

		
		// affichage label
		JLabel affichageLbl = new JLabel("AFFICHAGE");
		affichageLbl.setBounds(25, 408, 91, 17); 
		affichageLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 

		// affichage box
		JComboBox affichageBox = new JComboBox();
		affichageBox.setBounds(137, 407, 140, 20);
		affichageBox.setBackground(Color.WHITE);
		affichageBox.setBackground(null);
		
		// tableau d'affichage de la liste
		JTable tableListeUnites = new JTable(Unites.AfficherListeUnites(), Unites.Colonne());
		JScrollPane ListeUnites = new JScrollPane(tableListeUnites);
		ListeUnites.setBounds(15, 145, 680, 227);
		
		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.annuler)
				MainWindow.catalogue = new MenuCatalogue();
				MainWindow.ouvrePanel(MainWindow.catalogue); // ouvre le menu catalogue
			}
		});
		
		// ajout des différents composants du menu
		add(affichageBox);
		add(affichageLbl);
		add(ListeUnites);
		
		add(Json.remplirFiltreAffichage(affichageBox));
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "LISTE DES UNITÉS"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}
		

}
