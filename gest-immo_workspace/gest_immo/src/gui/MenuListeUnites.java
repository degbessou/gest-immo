package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import outils.Fonctions;
import outils.Json;
import system.Employe;
import system.Locataire;
import system.Unites;

public class MenuListeUnites extends JPanel {
	
	private JScrollPane tableListeLocataire;

	public MenuListeUnites () {
		fenetreMenuListeUnites ();
	}
	
	public void fenetreMenuListeUnites() {
		setLayout(null);
		
//		// filtre : type Unit�s label
//		JLabel filtreTypeUnitesLbl = new JLabel("TYPE UNIT�S");
//		filtreTypeUnitesLbl.setBounds(440, 112, 126, 17); 
//		filtreTypeUnitesLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 
		
		// affichage label
		JLabel affichageLbl = new JLabel("AFFICHAGE");
		affichageLbl.setBounds(25, 408, 91, 17); 
		affichageLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 

//		// filtre : type unit�s box
//		JComboBox filtreTypeUnitesBox = new JComboBox();
//		filtreTypeUnitesBox.setBounds(550, 111, 140, 20);
//		filtreTypeUnitesBox.setBackground(Color.WHITE);
//		filtreTypeUnitesBox.setBorder(null);

		// affichage box
		JComboBox affichageBox = new JComboBox();
		affichageBox.setBounds(137, 407, 140, 20);
		affichageBox.setBackground(Color.WHITE);
		affichageBox.setBackground(null);
		
		// bouton prochain renouvellement
		JButton btnPR = new JButton("<html><font color = white>Prochain Renouvellement</font></html>");
		btnPR.setBounds(20, 49, 100, 25);
		btnPR.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10)); 
		btnPR.setBackground(new java.awt.Color(39, 170, 243));
		btnPR.setBorder(null);
		
		// bouton futures unit�s vacants
		JButton btnFUV = new JButton("<html><font color = white>Futures Unit�s Vacants</font></html>");
		btnFUV.setBounds(133, 49, 100, 25);
		btnFUV.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10)); 
		btnFUV.setBackground(new java.awt.Color(39, 170, 243));
		btnFUV.setBorder(null);
		
		// bouton Montant Bail � Modifier
		JButton btnMBAM = new JButton("<html><font color = white>Montant Bail � Modifier</font></html>");
		btnMBAM.setBounds(246, 49, 100, 25);
		btnMBAM.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10)); 
		btnMBAM.setBackground(new java.awt.Color(39, 170, 243));
		btnMBAM.setBorder(null);
		
		// bouton Collection
		JButton btnCollection = new JButton("<html><font color = white>Collection</font></html>");
		btnCollection.setBounds(359, 49, 100, 25);
		btnCollection.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10)); 
		btnCollection.setBackground(new java.awt.Color(39, 170, 243));
		btnCollection.setBorder(null);
		

		
		// tableau d'affichage de la liste des locataires
		tableListeLocataire = new JScrollPane(Unites.AfficherListeUnites());
		tableListeLocataire.setBounds(20, 87, 680, 300);
		
		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.annuler)
				MainWindow.catalogue = new MenuCatalogue();
				MainWindow.ouvrePanel(MainWindow.catalogue);
			}
		});
		
		add(btnPR);
//		add(filtreTypeUnitesBox);
//		add(filtreTypeUnitesLbl);
		add(affichageBox);
		add(affichageLbl);
		add(btnCollection);
		add(btnMBAM);
		add(btnFUV);
		add(btnPR);
		
		add(Json.remplirFiltreAffichage(affichageBox));
		add(tableListeLocataire);
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		//add(Fonctions.titre(MainWindow.titre, "LISTE DES UNIT�S EN LOCATION"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}
		

}
