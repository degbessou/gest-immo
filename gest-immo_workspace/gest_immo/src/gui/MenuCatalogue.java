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

public class MenuCatalogue extends JPanel{
	
	public MenuCatalogue() {
		fenetreMenuCatalogue();
	}
	
	public void fenetreMenuCatalogue() {
		setLayout(null);

		// numéro unité label
		JLabel numUniteLbl = new JLabel("N° UNITÉ");
		numUniteLbl.setBounds(30, 112, 126, 17); 
		numUniteLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 

		// type unités label
		JLabel typeUnitesLbl = new JLabel("TYPE UNITÉS");
		typeUnitesLbl.setBounds(30, 159, 100, 17); 
		typeUnitesLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 

		// adresse unités label
		JLabel adresseLbl = new JLabel("ADRESSE");
		adresseLbl.setBounds(30, 206, 107, 17); 
		adresseLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 

		// année de construction
		JLabel anneeLbl = new JLabel("ANNÉE");
		anneeLbl.setBounds(30, 253, 100, 17); 
		anneeLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 

		// superficie
		JLabel superficieLbl = new JLabel("SUPERFICIE");
		superficieLbl.setBounds(30, 300, 126, 17); 
		superficieLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 
		
		// sélection
		JLabel selectLbl = new JLabel("SÉLECTION");
		selectLbl.setBounds(30, 347, 88, 17); 
		selectLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 
		
		// nbre pièces label
		JLabel nbrePieceLbl = new JLabel("NOMBRE DE PIÈCES");
		nbrePieceLbl.setBounds(393, 112, 150, 17); 
		nbrePieceLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 
		
		// condition label
		JLabel conditionLbl = new JLabel("CONDITION");
		conditionLbl.setBounds(393, 159, 100, 17); 
		conditionLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 
		
		// disponibilité label
		JLabel dispoLbl = new JLabel("DISPONIBILITÉ");
		dispoLbl.setBounds(393, 206, 126, 17); 
		dispoLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 
		
		// propriétaire label
		JLabel proprioLbl = new JLabel("PROPRIÉTAIRE");
		proprioLbl.setBounds(393, 253, 126, 17); 
		proprioLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 
		
		
		// numéro unité box
		JTextField numUniteBox = new JTextField();
		numUniteBox.setBounds(143, 111, 140, 20);
		numUniteBox.setBackground(Color.WHITE);
		numUniteBox.setBorder(null);

		// type unités field
		JTextField typeUnitesField = new JTextField(); 
		typeUnitesField.setBounds(143, 158, 140, 20);
		typeUnitesField.setBackground(Color.WHITE);
		typeUnitesField.setBorder(null);

		// adresse field
		JTextField adresseField = new JTextField();
		adresseField.setBounds(143, 205, 140, 20);
		adresseField.setBackground(Color.WHITE);
		adresseField.setBorder(null);

		// année field
		JTextField anneeField = new JTextField();
		anneeField.setBounds(143, 252, 140, 20);
		anneeField.setBackground(Color.WHITE);
		anneeField.setBorder(null);

		// superficie
		JTextField superficieField = new JTextField();
		superficieField.setBounds(143, 299, 140, 20);
		superficieField.setBackground(Color.WHITE);
		superficieField.setBorder(null);
		
		// sélection box
		JComboBox selectBox = new JComboBox();
		selectBox.setBounds(143, 346, 140, 20);
		selectBox.setBackground(Color.WHITE);
		selectBox.setBorder(null);

		// nbre Piece Field
		JTextField nbrePieceField = new JTextField();
		nbrePieceField.setBounds(550, 111, 140, 20);
		nbrePieceField.setBackground(Color.WHITE);
		nbrePieceField.setBorder(null);
		
		// condition field
		JTextField conditionField = new JTextField(); // check jdatePicker
		conditionField.setBounds(550, 158, 140, 20);
		conditionField.setBackground(Color.WHITE);
		conditionField.setBorder(null);
		
		// disponibilité field
		JTextField dispoField = new JTextField();
		dispoField.setBounds(550, 205, 140, 20);
		dispoField.setBackground(Color.WHITE);
		dispoField.setBorder(null);
		
		// propriétaire field
		JTextField proprioField = new JTextField();
		proprioField.setBounds(550, 252, 140, 20);
		proprioField.setBackground(Color.WHITE);
		proprioField.setBorder(null);
		
		// bouton liste des baux
		MainWindow.liste = Fonctions.bouttonListe(MainWindow.liste, "Liste Des Unités");
		MainWindow.liste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == MainWindow.liste )
					MainWindow.listeUnite = new MenuListeUnites();
					MainWindow.ouvrePanel(MainWindow.listeUnite);
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

		add(numUniteLbl);
		add(numUniteBox);
		add(typeUnitesField);
		add(typeUnitesLbl);
		add(adresseField);
		add(adresseLbl);
		add(anneeField);
		add(anneeLbl);
		add(superficieField);
		add(superficieLbl);
		add(nbrePieceField);
		add(nbrePieceLbl);
		add(conditionField);
		add(conditionLbl);
		add(dispoField);
		add(dispoLbl);
		add(proprioField);
		add(proprioLbl);
		add(selectLbl);
		add(selectBox);

		add(MainWindow.liste);
		add(Fonctions.bouttonModifier(MainWindow.modifier)); // à modifier une fois action du bouton réaliser
		add(Fonctions.bouttonCréer(MainWindow.creer)); // à modifier une fois action du bouton réaliser
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "GESTION DES UNITÉS EN LOCATION"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye));
	}

}
