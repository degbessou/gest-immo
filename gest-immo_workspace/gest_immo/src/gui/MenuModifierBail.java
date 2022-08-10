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

public class MenuModifierBail extends JPanel {
	public static JTextField [] infosBail;
	
	public MenuModifierBail() {
		fenetreMenuModificationBail();
	}
	
	public void fenetreMenuModificationBail() {
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
		JTextField numUniteField = new JTextField();
		numUniteField.setBounds(143, 111, 140, 20);
		numUniteField.setBackground(Color.WHITE);
		numUniteField.setBorder(null);

		// type unités field
		JTextField typeUnitesField = new JTextField(); // check jdatePicker
		typeUnitesField.setBounds(143, 158, 140, 20);
		typeUnitesField.setBackground(Color.WHITE);
		typeUnitesField.setBorder(null);

		// date entrée field
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
		//remisageField.setEditable(false);
		remisageField.setBounds(143, 299, 140, 20);
		remisageField.setBackground(Color.WHITE);
		remisageField.setBorder(null);
		
		// sélection box
		JComboBox selectBox = new JComboBox();
		selectBox.setBounds(143, 346, 140, 20);
		selectBox.setBackground(Color.WHITE);
		selectBox.setBorder(null);

		// locataire box
		JTextField locataireField = new JTextField();
		locataireField.setBounds(550, 111, 140, 20);
		locataireField.setBackground(Color.WHITE);
		locataireField.setBorder(null);
		
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
		
		infosBail = new JTextField [] {numUniteField, typeUnitesField, dateEntreeField, assuranceField, remisageField, locataireField, loyerField, dateSortieField, renouvField, stationnementField};
		
		// bouton renouveler action
		MainWindow.renouveler = Fonctions.bouttonPersonnalisable(MainWindow.renouveler, "Renouveler");
		MainWindow.renouveler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) { 
			if (e.getSource() == MainWindow.renouveler)
				Bail.RenouvelerBail(selectBox, infosBail); // renouvelle le bail
			}
		});

		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.annuler)
				MainWindow.bail = new MenuGestionBail();
				MainWindow.ouvrePanel(MainWindow.bail); // ouvre le menu bail
			}
		});
		
		// action bouton modifier
		MainWindow.modifier = Fonctions.bouttonModifier(MainWindow.modifier);
		MainWindow.modifier.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.modifier)
				Bail.modifierInfosBail(selectBox, infosBail); // modifie le bail
			}
		});
		
		selectBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				if (e.getSource() == selectBox)
					Bail.afficherInfosBail(selectBox, infosBail); // affiche les infos du bail
			}
		});
		
		// ajout des différents composants du menu
		
		add(numUniteLbl);
		add(numUniteField);
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
		add(locataireField);
		add(locataireLbl);
		add(loyerField);
		add(loyerLbl);
		add(dateSortieField);
		add(dateSortieLbl);
		add(renouvField);
		add(renouvLbl);
		add(stationnementField);
		add(stationnementLbl);
		
		add(Bail.remplirSelection(selectBox));
		add(MainWindow.renouveler);
		add(MainWindow.modifier); 
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "GESTION DE BAUX"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}
	
	

}
