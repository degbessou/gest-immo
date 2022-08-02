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
		


		// numéro unité label
		JLabel numUniteLbl = new JLabel("N° UNITÉ");
		numUniteLbl.setBounds(30, 112, 69, 17); // dimension
		numUniteLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// type unités label
		JLabel typeUnitesLbl = new JLabel("TYPE UNITÉS");
		typeUnitesLbl.setBounds(30, 159, 100, 17); // dimension
		typeUnitesLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// date d'entrée
		JLabel dateEntreeLbl = new JLabel("DATE D'ENTRÉE");
		dateEntreeLbl.setBounds(30, 206, 107, 17); // dimension
		dateEntreeLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// assurance
		JLabel assuranceLbl = new JLabel("ASSURANCE");
		assuranceLbl.setBounds(30, 253, 100, 17); // dimension
		assuranceLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// remisage
		JLabel remisageLbl = new JLabel("REMISAGE");
		remisageLbl.setBounds(30, 300, 82, 17); // dimension
		remisageLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// sélection
		JLabel selectLbl = new JLabel("SÉLECTION");
		selectLbl.setBounds(30, 347, 88, 17); // dimension
		selectLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// locataire label
		JLabel locataireLbl = new JLabel("LOCATAIRE");
		locataireLbl.setBounds(393, 112, 89, 17); // dimension
		locataireLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// loyer label
		JLabel loyerLbl = new JLabel("LOYER");
		loyerLbl.setBounds(393, 159, 54, 17); // dimension
		loyerLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// date de sortie label
		JLabel dateSortieLbl = new JLabel("DATE DE SORTIE");
		dateSortieLbl.setBounds(393, 206, 126, 17); // dimension
		dateSortieLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// renouvelabilité label
		JLabel renouvLbl = new JLabel("RENOUVELABLE");
		renouvLbl.setBounds(393, 253, 126, 17); // dimension
		renouvLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// stationnement label
		JLabel stationnementLbl = new JLabel("STATIONNEMENT");
		stationnementLbl.setBounds(393, 300, 132, 17); // dimension
		stationnementLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		
		// numéro unité box
		JComboBox numUniteBox = new JComboBox();
		numUniteBox.setBounds(143, 111, 140, 20);
		numUniteBox.setBackground(Color.WHITE);
		numUniteBox.setBorder(null);

		// type unités field
		JTextField typeUnitesField = new JTextField(); // check jdatePicker
		typeUnitesField.setBounds(143, 158, 140, 20);
		typeUnitesField.setBackground(Color.WHITE);
		typeUnitesField.setBorder(null);

		// starting hour
		JTextField dateEntreeField = new JTextField();
		dateEntreeField.setBounds(143, 205, 140, 20);
		dateEntreeField.setBackground(Color.WHITE);
		dateEntreeField.setBorder(null);

		// assurance
		JTextField assuranceField = new JTextField();
		assuranceField.setBounds(143, 252, 140, 20);
		assuranceField.setBackground(Color.WHITE);
		assuranceField.setBorder(null);

		// remisage
		JTextField remisageField = new JTextField();
		remisageField.setEditable(false);
		remisageField.setBounds(143, 299, 140, 20);
		remisageField.setBackground(Color.WHITE);
		remisageField.setBorder(null);
		
		// sélection box
		JComboBox selectBox = new JComboBox();
		selectBox.setBounds(143, 346, 140, 20);
		selectBox.setBackground(Color.WHITE);
		selectBox.setBorder(null);

		// locataire box
		JComboBox locataireBox = new JComboBox();
		locataireBox.setBounds(550, 111, 140, 20);
		selectBox.setBackground(Color.WHITE);
		locataireBox.setBackground(null);
		//assuranceBox.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		// loyer field
		JTextField loyerField = new JTextField(); // check jdatePicker
		loyerField.setBounds(550, 158, 140, 20);
		loyerField.setBackground(Color.WHITE);
		loyerField.setBorder(null);
		
		// DATE DE SORTIE field
		JTextField dateSortieField = new JTextField();
		dateSortieField.setBounds(555, 205, 140, 20);
		dateSortieField.setBackground(Color.WHITE);
		dateSortieField.setBorder(null);
		
		// renouvelabilité field
		JTextField renouvField = new JTextField();
		renouvField.setBounds(550, 252, 140, 20);
		renouvField.setBackground(Color.WHITE);
		renouvField.setBorder(null);
		
		// stationnement field
		JTextField stationnementField = new JTextField();
		stationnementField.setBounds(550, 299, 140, 20);
		stationnementField.setBackground(Color.WHITE);
		stationnementField.setBorder(null);

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
		JButton btnRenouveler = Fonctions.bouttonPersonnalisable(MainWindow.renouveler, "Renouveler");
//		MainWindow.enregistrer.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) { // ajouter la sauvegarde dans la base de donnée
//				if (e.getSource() == MainWindow.enregistrer)
//					tarifLocation = new TarifLocation();
//				MainWindow.ouvrePanel(tarifLocation);
//			}
//		});
//
		// cancel button action
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

		add(numUniteLbl);
		add(numUniteBox);
		add(typeUnitesField);
		add(typeUnitesLbl);
		add(dateEntreeField);
		add(dateEntreeLbl);
		add(assuranceLbl);
		add(assuranceField);
		add(remisageLbl);
		add(remisageField);
		add(selectLbl);
		add(selectBox);
		add(locataireBox);
		add(locataireLbl);
		add(loyerField);
		add(loyerLbl);
		add(dateSortieField);
		add(dateSortieLbl);
		add(renouvField);
		add(renouvLbl);
		add(stationnementField);
		add(stationnementLbl);
		
		add(btnRenouveler);
		add(Fonctions.bouttonModifier(MainWindow.modifier));
		add(Fonctions.bouttonCréer(MainWindow.creer));
		add(Fonctions.bouttonAnnuler(MainWindow.annuler));
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "GESTION DE BAUX"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye));
	}

}
