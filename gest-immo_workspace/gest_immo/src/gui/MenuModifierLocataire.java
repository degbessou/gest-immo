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
import system.Employe;
import system.Locataire;

public class MenuModifierLocataire extends JPanel {
	public static JTextField [] infosLocataire;
	public MenuModifierLocataire () {
		fenetreModifierLocataire ();
	}
	
	public void fenetreModifierLocataire() {
		setLayout(null);
		
		// nom locataire label
		JLabel nomLocataireLbl = new JLabel("NOM");
		nomLocataireLbl.setBounds(30, 112, 69, 17); // dimension
		nomLocataireLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// pr�nom locataire label
		JLabel prenomLocataireLbl = new JLabel("PR�NOM");
		prenomLocataireLbl.setBounds(30, 159, 100, 17); // dimension
		prenomLocataireLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// adresse locataire label
		JLabel adresseLbl = new JLabel("ADRESSE");
		adresseLbl.setBounds(30, 206, 107, 17); // dimension
		adresseLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// t�l�phone label
		JLabel telLbl = new JLabel("T�L�PHONE");
		telLbl.setBounds(30, 253, 100, 17); // dimension
		telLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// type locataire label
		JLabel typeLocataireLbl = new JLabel("TYPE LOCATAIRE");
		typeLocataireLbl.setBounds(393, 112, 126, 17); // dimension
		typeLocataireLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// type unit�s label
		JLabel typeUnitesLbl = new JLabel("TYPE UNIT�S");
		typeUnitesLbl.setBounds(393, 159, 126, 17); // dimension
		typeUnitesLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// cote de cr�dit label
		JLabel coteCreditLbl = new JLabel("COTE DE CR�DIT");
		coteCreditLbl.setBounds(393, 206, 126, 17); // dimension
		coteCreditLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// s�lection
		JLabel selectLbl = new JLabel("S�LECTION");
		selectLbl.setBounds(30, 347, 88, 17); // dimension
		selectLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// nom locataire box
		JTextField nomLocataireField = new JTextField();
		nomLocataireField.setBounds(143, 111, 140, 20);
		nomLocataireField.setBackground(Color.WHITE);
		nomLocataireField.setBorder(null);

		// pr�nom field
		JTextField prenomField = new JTextField(); // check jdatePicker
		prenomField.setBounds(143, 158, 140, 20);
		prenomField.setBackground(Color.WHITE);
		prenomField.setBorder(null);

		// adresse field
		JTextField adresseField = new JTextField();
		adresseField.setBounds(143, 205, 140, 20);
		adresseField.setBackground(Color.WHITE);
		adresseField.setBorder(null);

		// t�l�phone field
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

		// cote de cr�dit field
		JTextField coteCreditField = new JTextField();
		coteCreditField.setBounds(550, 205, 140, 20);
		coteCreditField.setBackground(Color.WHITE);
		coteCreditField.setBorder(null);

		// s�lection box
		JComboBox selectBox = new JComboBox();
		selectBox.setBounds(143, 346, 140, 20);
		selectBox.setBackground(Color.WHITE);
		selectBox.setBorder(null);

		infosLocataire = new JTextField[] { nomLocataireField, prenomField, adresseField, telField, typeLocataireField,
				typeUnitesField, coteCreditField };

		// action de la selection d'un �l�ment du box
		selectBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == selectBox)
					Locataire.afficherInfosLocataire(selectBox, infosLocataire); // affiche les informations de
																					// l'�l�ment s�lectionn�
			}
		});

		// action bouton modifier
		MainWindow.modifier = Fonctions.bouttonModifier(MainWindow.modifier);
		MainWindow.modifier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == MainWindow.modifier)
					Locataire.modifierInfosLocataire(selectBox, infosLocataire); // modifie les donn�es de l'�l�ment
																					// s�lectionn�

			}
		});

		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == MainWindow.annuler)
					MainWindow.inscription = new MenuInscriptionLocataire(); // retour au menu inscrition
					MainWindow.ouvrePanel(MainWindow.inscription);
			}
		});

		// ajout des diff�rents composants du menu
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
		add(selectBox);
		add(selectLbl);

		add(Locataire.remplirSelection(selectBox));
		add(MainWindow.modifier);
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "MODIFICATION DU LOCATAIRE"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye,
				Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
		
		
	}

}
