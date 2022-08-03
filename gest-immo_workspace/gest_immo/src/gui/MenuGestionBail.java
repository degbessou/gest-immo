package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import outils.Fonctions;

public class MenuGestionBail extends JPanel {
	
	public MenuGestionBail() {
		fenetreMenuBail();
	}
	
	public void fenetreMenuBail() {
		setLayout(null);

		// num�ro unit� label
		JLabel numUniteLbl = new JLabel("N� UNIT�");
		numUniteLbl.setBounds(30, 112, 69, 17); // dimension
		numUniteLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// type unit�s label
		JLabel typeUnitesLbl = new JLabel("TYPE UNIT�S");
		typeUnitesLbl.setBounds(30, 159, 100, 17); // dimension
		typeUnitesLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// date d'entr�e
		JLabel dateEntreeLbl = new JLabel("DATE D'ENTR�E");
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
		
		// s�lection
		JLabel selectLbl = new JLabel("S�LECTION");
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
		
		// renouvelabilit� label
		JLabel renouvLbl = new JLabel("RENOUVELABLE");
		renouvLbl.setBounds(393, 253, 126, 17); // dimension
		renouvLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height

		// stationnement label
		JLabel stationnementLbl = new JLabel("STATIONNEMENT");
		stationnementLbl.setBounds(393, 300, 132, 17); // dimension
		stationnementLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		
		// num�ro unit� box
		JComboBox numUniteBox = new JComboBox();
		numUniteBox.setBounds(143, 111, 140, 20);
		numUniteBox.setBackground(Color.WHITE);
		numUniteBox.setBorder(null);

		// type unit�s field
		JTextField typeUnitesField = new JTextField(); // check jdatePicker
		typeUnitesField.setBounds(143, 158, 140, 20);
		typeUnitesField.setBackground(Color.WHITE);
		typeUnitesField.setBorder(null);

		// date entr�e field
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
		
		// s�lection box
		JComboBox selectBox = new JComboBox();
		selectBox.setBounds(143, 346, 140, 20);
		selectBox.setBackground(Color.WHITE);
		selectBox.setBorder(null);

		// locataire box
		JComboBox locataireBox = new JComboBox();
		locataireBox.setBounds(550, 111, 140, 20);
		locataireBox.setBackground(Color.WHITE);
		locataireBox.setBackground(null);
		//assuranceBox.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		// loyer field
		JTextField loyerField = new JTextField(); // check jdatePicker
		loyerField.setBounds(550, 158, 140, 20);
		loyerField.setBackground(Color.WHITE);
		loyerField.setBorder(null);
		
		// DATE DE SORTIE field
		JTextField dateSortieField = new JTextField();
		dateSortieField.setBounds(550, 205, 140, 20);
		dateSortieField.setBackground(Color.WHITE);
		dateSortieField.setBorder(null);
		
		// renouvelabilit� field
		JTextField renouvField = new JTextField();
		renouvField.setBounds(550, 252, 140, 20);
		renouvField.setBackground(Color.WHITE);
		renouvField.setBorder(null);
		
		// stationnement field
		JTextField stationnementField = new JTextField();
		stationnementField.setBounds(550, 299, 140, 20);
		stationnementField.setBackground(Color.WHITE);
		stationnementField.setBorder(null);
		
//		// bouton liste des baux
//		JButton listeBauxBtn = new JButton("<html><font color = white>Liste Des Baux</font></html>");
//		listeBauxBtn.setBounds(540, 346, 150, 30);
//		listeBauxBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); 
//		listeBauxBtn.setBackground(new java.awt.Color(39, 170, 243));
//		listeBauxBtn.setBorder(null);
		
		// bouton liste des baux
		MainWindow.liste = Fonctions.bouttonListe(MainWindow.liste, "Liste Des Baux");
		MainWindow.liste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == MainWindow.liste )
					MainWindow.listeBail = new MenuListeBaux();
					MainWindow.ouvrePanel(MainWindow.listeBail);
			}
		});

//		// select car button action
//		choixVoiture.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) { // ajouter la sauvegarde dans la base de donn�e
//				if (e.getSource() == choixVoiture)
//					MainWindow.catalogue = new Catalogue();
//				MainWindow.ouvrePanel(MainWindow.catalogue);
//			}
//		});
//		
//		// bouton renouveler action
		MainWindow.renouveler = Fonctions.bouttonPersonnalisable(MainWindow.renouveler, "Renouveler");
		MainWindow.renouveler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) { // ajouter la sauvegarde dans la base de donn�e
			if (e.getSource() == MainWindow.quitter)
				MainWindow.menuPrincipal = new MenuPrincipal();
				MainWindow.ouvrePanel(MainWindow.menuPrincipal);
			}
		});

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
		add(MainWindow.liste);
		
		add(MainWindow.renouveler);
		add(Fonctions.bouttonModifier(MainWindow.modifier)); // � modifier une fois action du bouton r�aliser
		add(Fonctions.bouttonCr�er(MainWindow.creer)); // � modifier une fois action du bouton r�aliser
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "GESTION DE BAUX"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye));
	}

}
