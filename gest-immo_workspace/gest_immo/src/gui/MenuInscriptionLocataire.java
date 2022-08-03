package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import outils.Fonctions;

public class MenuInscriptionLocataire extends JPanel {
	
	public MenuInscriptionLocataire() {
		fenetreMenuInscriptionLocataire();
	}
	
	public void fenetreMenuInscriptionLocataire() {
		setLayout(null);

		// nom locataire label
		JLabel nomLocataireLbl = new JLabel("NOM");
		nomLocataireLbl.setBounds(30, 112, 69, 17); // dimension
		nomLocataireLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// prénom locataire label
		JLabel prenomLocataireLbl = new JLabel("PRÉNOM");
		prenomLocataireLbl.setBounds(30, 159, 100, 17); // dimension
		prenomLocataireLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// adresse locataire label
		JLabel adresseLbl = new JLabel("ADRESSE");
		adresseLbl.setBounds(30, 206, 107, 17); // dimension
		adresseLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// téléphone label
		JLabel telLbl = new JLabel("TÉLÉPHONE");
		telLbl.setBounds(30, 253, 100, 17); // dimension
		telLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		
		
		// type locataire label
		JLabel typeLocataireLbl = new JLabel("TYPE LOCATAIRE");
		typeLocataireLbl.setBounds(393, 112, 126, 17); // dimension
		typeLocataireLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// type unités label
		JLabel typeUnitesLbl = new JLabel("TYPE UNITÉS");
		typeUnitesLbl.setBounds(393, 159, 126, 17); // dimension
		typeUnitesLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// cote de crédit label
		JLabel coteCreditLbl = new JLabel("COTE DE CRÉDIT");
		coteCreditLbl.setBounds(393, 206, 126, 17); // dimension
		coteCreditLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		
		
		// nom locataire box
		JTextField nomLocataireField = new JTextField();
		nomLocataireField.setBounds(143, 111, 140, 20);
		nomLocataireField.setBackground(Color.WHITE);
		nomLocataireField.setBorder(null);

		// prénom field
		JTextField prenomField = new JTextField(); // check jdatePicker
		prenomField.setBounds(143, 158, 140, 20);
		prenomField.setBackground(Color.WHITE);
		prenomField.setBorder(null);

		// adresse field
		JTextField adresseField = new JTextField();
		adresseField.setBounds(143, 205, 140, 20);
		adresseField.setBackground(Color.WHITE);
		adresseField.setBorder(null);

		// téléphone field
		JTextField telField = new JTextField();
		telField.setBounds(143, 252, 140, 20);
		telField.setBackground(Color.WHITE);
		telField.setBorder(null);

		

		// type locataire box
		JTextField typeLocataireField = new JTextField();
		typeLocataireField.setBounds(550, 111, 140, 20);
		typeLocataireField.setBackground(Color.WHITE);
		typeLocataireField.setBorder(null);
		
		// loyer field
		JTextField typeUnitesField = new JTextField(); 
		typeUnitesField.setBounds(550, 158, 140, 20);
		typeUnitesField.setBackground(Color.WHITE);
		typeUnitesField.setBorder(null);
		
		// cote de crédit field
		JTextField coteCreditField = new JTextField();
		coteCreditField.setBounds(550, 205, 140, 20);
		coteCreditField.setBackground(Color.WHITE);
		coteCreditField.setBorder(null);
		
		
		// bouton liste des Locataires
		MainWindow.liste = Fonctions.bouttonListe(MainWindow.liste, "Liste Des Locataires");
		MainWindow.liste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == MainWindow.liste )
					MainWindow.listeLocataire = new MenuListeLocataire();
					MainWindow.ouvrePanel(MainWindow.listeLocataire);
			}
		});

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
//
		// bouton quitter action
		MainWindow.quitter = Fonctions.bouttonQuitter(MainWindow.quitter);
		MainWindow.quitter.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.quitter)
				MainWindow.pageAccueil = new PageAccueil ();
				MainWindow.ouvrePanel(MainWindow.pageAccueil);
			}
		});

		add(nomLocataireLbl);
		add(prenomLocataireLbl);
		add(adresseLbl);
		add(telLbl);
		add(typeUnitesLbl);
		add(typeLocataireLbl);
		add(coteCreditLbl);
		add(coteCreditField);
		add(typeUnitesField);
		add(typeLocataireField);
		add(telField);
		add(adresseField);
		add(prenomField);
		add(nomLocataireField);
		
		add(MainWindow.liste);
		
		//add(Fonctions.bouttonModifier(MainWindow.modifier)); // à implenter si reste du tempsà modifier une fois action du bouton réaliser
		add(Fonctions.bouttonCréer(MainWindow.creer)); // à modifier une fois action du bouton réaliser
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "INSCRIPTION DU LOCATAIRE"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye));
	}

}
