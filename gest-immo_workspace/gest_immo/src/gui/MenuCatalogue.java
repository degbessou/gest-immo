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
import system.Bail;
import system.Employe;
import system.Unites;

public class MenuCatalogue extends JPanel{
	
	private JTextField[] infosUnites;

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
		JTextField numUniteField = new JTextField();
		numUniteField.setBounds(143, 111, 140, 20);
		numUniteField.setBackground(Color.WHITE);
		numUniteField.setBorder(null);

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

		// nbre Piece Field
		JTextField nbrePieceField = new JTextField();
		nbrePieceField.setBounds(550, 111, 140, 20);
		nbrePieceField.setBackground(Color.WHITE);
		nbrePieceField.setBorder(null);
		
		// condition field
		JTextField conditionField = new JTextField(); 
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
				
		infosUnites = new JTextField [] {numUniteField, typeUnitesField, adresseField, anneeField, superficieField, nbrePieceField, conditionField, dispoField, proprioField};
		
		// bouton liste des baux
		MainWindow.liste = Fonctions.bouttonListe(MainWindow.liste, "Liste Des Unités");
		MainWindow.liste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == MainWindow.liste )
					MainWindow.listeUnite = new MenuListeUnites();
					MainWindow.ouvrePanel(MainWindow.listeUnite); // ouvre le menu liste unités
			}
		});
		
		// action du bouton créer
		MainWindow.creer = Fonctions.bouttonCréer(MainWindow.creer);
		MainWindow.creer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				if (e.getSource() == MainWindow.creer)
					Unites.CreerUnites(infosUnites);
					
			}
		});
		
		// action bouton modifier
		MainWindow.modifier = Fonctions.bouttonModifier(MainWindow.modifier);
		MainWindow.modifier.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.modifier)
				MainWindow.modifierUnites = new MenuModifierUnites();
				MainWindow.ouvrePanel(MainWindow.modifierUnites); // ouvre le menu modifier unités
				
			}
		});

		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.annuler)
				MainWindow.menuPrincipal = new MenuPrincipal();
				MainWindow.ouvrePanel(MainWindow.menuPrincipal); // ouvre le menu principal
			}
		});

		// ajout des différents composants du menu
		add(numUniteLbl);
		add(numUniteField);
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
		
		add(MainWindow.liste);
		add(MainWindow.modifier);
		add(MainWindow.creer); 
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "GESTION DES UNITÉS"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}

}
