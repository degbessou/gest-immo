package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import outils.Fonctions;

public class MenuListeLocataire extends JPanel{
	
	public MenuListeLocataire () {
		fenetreMenuListeLocataire ();
	}
	
	public void fenetreMenuListeLocataire() {
		setLayout(null);
		
		// filtre : type locataire label
		JLabel filtreTypeLocataireLbl = new JLabel("TYPE LOCATAIRE");
		filtreTypeLocataireLbl.setBounds(30, 112, 126, 17); // dimension
		filtreTypeLocataireLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// affichage label
		JLabel affichageLbl = new JLabel("AFFICHAGE");
		affichageLbl.setBounds(393, 112, 89, 17); // dimension
		affichageLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// filtre : type locataire box
		JComboBox filtreTypeLocataireBox = new JComboBox();
		filtreTypeLocataireBox.setBounds(143, 111, 140, 20);
		filtreTypeLocataireBox.setBackground(Color.WHITE);
		filtreTypeLocataireBox.setBorder(null);

		// affichage box
		JComboBox affichageBox = new JComboBox();
		affichageBox.setBounds(550, 111, 140, 20);
		affichageBox.setBackground(Color.WHITE);
		affichageBox.setBackground(null);

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
		add(filtreTypeLocataireBox);
		add(filtreTypeLocataireLbl);
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "LISTE DES BAUX"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye));
	}

}
