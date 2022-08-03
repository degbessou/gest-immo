package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import outils.Fonctions;
import system.Employe;

public class MenuPaiement extends JPanel {
	
	public MenuPaiement() {
		fenetrMenuPaiement();
	}
	
	public void fenetrMenuPaiement() {
		setLayout(null);

		// locataire label
		JLabel LocataireLbl = new JLabel("LOCATAIRE");
		LocataireLbl.setBounds(30, 112, 100, 17); // dimension
		LocataireLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// mois label
		JLabel moisLbl = new JLabel("MOIS");
		moisLbl.setBounds(30, 159, 100, 17); // dimension
		moisLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// SOLDE label
		JLabel soldeLbl = new JLabel("SOLDE");
		soldeLbl.setBounds(30, 206, 107, 17); // dimension
		soldeLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 
		
		
		// choix bail label
		JLabel choixBailLbl = new JLabel("BAIL");
		choixBailLbl.setBounds(393, 111, 126, 17); // dimension
		choixBailLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// loyer payé label
		JLabel loyerPayeLbl = new JLabel("LOYER PAYÉ");
		loyerPayeLbl.setBounds(393, 158, 126, 17); // dimension
		loyerPayeLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		
		
		// locataire box
		JComboBox LocataireBox = new JComboBox();
		LocataireBox.setBounds(143, 111, 140, 20);
		LocataireBox.setBackground(Color.WHITE);
		LocataireBox.setBorder(null);

		// mois box
		JComboBox moisBox = new JComboBox(); 
		moisBox.setBounds(143, 158, 140, 20);
		moisBox.setBackground(Color.WHITE);
		moisBox.setBorder(null);

		// solde field
		JTextField soldeField = new JTextField();
		soldeField.setEditable(false);
		soldeField.setBounds(143, 205, 140, 20);
		soldeField.setBackground(Color.WHITE);
		soldeField.setBorder(null);		

		// choix bail box
		JComboBox choixBailBox = new JComboBox();
		choixBailBox.setBounds(550, 111, 140, 20);
		choixBailBox.setBackground(Color.WHITE);
		choixBailBox.setBorder(null);
		
		// loyer payé field
		JTextField loyerPayeField = new JTextField(); 
		loyerPayeField.setBounds(550, 158, 140, 20);
		loyerPayeField.setBackground(Color.WHITE);
		loyerPayeField.setBorder(null);
		

//		// select car button action
//		choixVoiture.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) { // ajouter la sauvegarde dans la base de donnée
//				if (e.getSource() == choixVoiture)
//					MainWindow.catalogue = new Catalogue();
//				MainWindow.ouvrePanel(MainWindow.catalogue);
//			}
//		});
//		


		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.annuler)
				MainWindow.menuPrincipal = new MenuPrincipal();
				MainWindow.ouvrePanel(MainWindow.menuPrincipal);
			}
		});

		add(loyerPayeField);
		add(loyerPayeLbl);
		add(choixBailBox);
		add(choixBailLbl);
		add(LocataireBox);
		add(LocataireLbl);
		add(moisBox);
		add(moisLbl);
		add(soldeField);
		add(soldeLbl);

		add(Fonctions.bouttonCréer(MainWindow.creer)); // à modifier une fois action du bouton réaliser
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "PAIEMENT"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}

}
