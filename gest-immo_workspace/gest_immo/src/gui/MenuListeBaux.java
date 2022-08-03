package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import outils.Fonctions;
import system.Employe;

public class MenuListeBaux extends JPanel{
	
	public MenuListeBaux() {
		fenetreMenuListeBaux();
	}
	
	public void fenetreMenuListeBaux() {
		setLayout(null);
		

//		// sélection d'un bail label nécessaire ??????
//		JLabel selectBailLbl = new JLabel("SELECT BAIL");
//		selectBailLbl.setBounds(30, 112, 69, 17); // dimension
//		selectBailLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// affichage label
		JLabel affichageLbl = new JLabel("AFFICHAGE");
		affichageLbl.setBounds(393, 112, 89, 17); // dimension
		affichageLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
//		// sélection d'un bail field nécessaire ????
//		JComboBox numUniteBox = new JComboBox();
//		numUniteBox.setBounds(143, 111, 140, 20);
//		numUniteBox.setBackground(Color.WHITE);
//		numUniteBox.setBorder(null);
		
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
				MainWindow.bail = new MenuGestionBail();
				MainWindow.ouvrePanel(MainWindow.bail);
			}
		});
		
		add(affichageBox);
		add(affichageLbl);
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "LISTE DES BAUX"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}
	
	

}
