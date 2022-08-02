package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import outils.Fonctions;

public class MenuBail extends JPanel {
	
	public MenuBail() {
		fenetreMenuBail();
	}
	
	public void fenetreMenuBail() {
		setLayout(null);
		
//		// select a car
//		JButton choixVoiture = new JButton("<html><font color = white>CHOISIR UNE VOITURE</font></html>");
//		choixVoiture.setBounds(20, 105, 300, 25); // dimension
//		choixVoiture.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); // font n height
//		choixVoiture.setBackground(new java.awt.Color(39, 170, 243));
//		choixVoiture.setBorder(null);
//
//		// select a client
//		JLabel client = new JLabel("CLIENT");
//		client.setBounds(20, 145, 250, 15); // dimension
//		client.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//
//		// starting date
//		JLabel dateDebut = new JLabel("DATE DE DEBUT");
//		dateDebut.setBounds(20, 185, 250, 15); // dimension
//		dateDebut.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//
//		// starting hour
//		JLabel heureDebut = new JLabel("HEURE DE PRISE");
//		heureDebut.setBounds(20, 225, 250, 15); // dimension
//		heureDebut.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//
//		// driver card number
//		JLabel numeroPermis = new JLabel("NUMÉRO DE PERMIS");
//		numeroPermis.setBounds(20, 265, 250, 15); // dimension
//		numeroPermis.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//
//		// kilometer to do
//		JLabel distance = new JLabel("DISTANCE À PARCOURIR");
//		distance.setBounds(20, 305, 250, 15); // dimension
//		distance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//		
//		// assurance
//		JLabel assurance = new JLabel("ASSURANCE");
//		assurance.setBounds(385, 145, 250, 15); // dimension
//		assurance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//		
//		// ending date
//		JLabel dateFin = new JLabel("DATE DE FIN");
//		dateFin.setBounds(385, 185, 250, 15); // dimension
//		dateFin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//		
//		// ending hour
//		JLabel heureFin = new JLabel("HEURE DE RETOUR");
//		heureFin.setBounds(385, 225, 250, 15); // dimension
//		heureFin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//		
//		// driver card expiration date
//		JLabel dateExpPermis = new JLabel("DATE D'EXPIRATION");
//		dateExpPermis.setBounds(385, 265, 250, 15); // dimension
//		dateExpPermis.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//
//		// extra distance
//		JLabel distanceSupp = new JLabel("DISTANCE SUPP");
//		distanceSupp.setBounds(385, 305, 250, 15); // dimension
//		distanceSupp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//		
//		
//		// clientbox
//		JComboBox clientBox = new JComboBox();
//		clientBox.setBounds(225, 140, 130, 20);
//		clientBox.setBackground(Color.WHITE);
//		clientBox.setBorder(null);
//
//		// starting date field
//		JTextField dateDebutField = new JTextField(); // check jdatePicker
//		dateDebutField.setBounds(225, 180, 130, 20);
//		dateDebutField.setBackground(Color.WHITE);
//		dateDebutField.setBorder(null);
//
//		// starting hour
//		JComboBox heureDebutBox = new JComboBox();
//		heureDebutBox.setBounds(225, 220, 130, 20);
//		heureDebutBox.setBackground(Color.WHITE);
//		heureDebutBox.setBorder(null);
//
//		// driver card number
//		JTextField numeroPermisField = new JTextField();
//		numeroPermisField.setBounds(225, 260, 130, 20);
//		numeroPermisField.setBackground(Color.WHITE);
//		numeroPermisField.setBorder(null);
//
//		// kilometer to do
//		JTextField distanceField = new JTextField();
//		distanceField.setEditable(false);
//		distanceField.setBounds(225, 300, 130, 20);
//		distanceField.setBackground(Color.WHITE);
//		distanceField.setBorder(null);
//
//		// assurance
//		JCheckBox assuranceBox = new JCheckBox();
//		assuranceBox.setBounds(555, 140, 25, 25);
//		assuranceBox.setBackground(null);
//		//assuranceBox.setBorder(BorderFactory.createLineBorder(Color.black, 2));
//		
//		// ending date field
//		JTextField dateFinField = new JTextField(); // check jdatePicker
//		dateFinField.setBounds(555, 180, 130, 20);
//		dateFinField.setBackground(Color.WHITE);
//		dateFinField.setBorder(null);
//		
//		// starting hour
//		JComboBox heureFinBox = new JComboBox();
//		heureFinBox.setBounds(555, 220, 130, 20);
//		heureFinBox.setBackground(Color.WHITE);
//		heureFinBox.setBorder(null);
//		
//		// driver card expiration date 
//		JTextField dateExpPermisField = new JTextField();
//		dateExpPermisField.setBounds(555, 260, 130, 20);
//		dateExpPermisField.setBackground(Color.WHITE);
//		dateExpPermisField.setBorder(null);
//		
//		// extra kilometer to do
//		JTextField distanceSuppField = new JTextField();
//		distanceSuppField.setBounds(555, 300, 130, 20);
//		distanceSuppField.setBackground(Color.WHITE);
//		distanceSuppField.setBorder(null);

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
//		// save button action
		JButton btnRenouveller = Fonctions.bouttonPersonnalisable(MainWindow.renouveller, "Enregistrer");
//		MainWindow.enregistrer.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) { // ajouter la sauvegarde dans la base de donnée
//				if (e.getSource() == MainWindow.enregistrer)
//					tarifLocation = new TarifLocation();
//				MainWindow.ouvrePanel(tarifLocation);
//			}
//		});
//
//		// cancel button action
//		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
//		MainWindow.annuler.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (e.getSource() == MainWindow.annuler)
//					MainWindow.location = new Location();
//				MainWindow.ouvrePanel(MainWindow.location);
//			}
//		});
//
//		// logout button action
//		MainWindow.quitter = Fonctions.bouttonQuitter(MainWindow.quitter);
//		MainWindow.quitter.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (e.getSource() == MainWindow.quitter)
//					MainWindow.accueil = new Accueil();
//				MainWindow.ouvrePanel(MainWindow.accueil);
//			}
//		});
//		
//		add(distance);
//		add(numeroPermis);
//		add(heureDebut);
//		add(dateDebut);
//		add(client);
//		add(clientBox);
//		add(choixVoiture);
//		add(distanceField);
//		add(dateDebutField);
//		add(heureDebutBox);
//		add(numeroPermisField);
//		add(distanceField);
//		add(distanceSupp);
//		add(dateExpPermis);
//		add(heureFin);
//		add(dateFin);
//		add(assurance);
//		add(dateFinField);
//		add(assuranceBox);
//		add(dateFinField);
//		add(heureFinBox);
//		add(dateExpPermisField);
//		add(distanceSuppField);
		
		add(btnRenouveller);
		add(Fonctions.bouttonCréer(MainWindow.creer));
		add(Fonctions.bouttonAnnuler(MainWindow.annuler));
		add(Fonctions.bouttonQuitter(MainWindow.quitter));
		add(Fonctions.titre(MainWindow.titre, "GESTION DE BAUX"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye));
	}

}
