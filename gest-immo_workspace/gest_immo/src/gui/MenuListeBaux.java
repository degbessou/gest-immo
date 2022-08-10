package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import outils.Fonctions;
import outils.Json;
import system.Bail;
import system.Employe;
import system.Locataire;

public class MenuListeBaux extends JPanel{

	public MenuListeBaux() {
		fenetreMenuListeBaux();
	}
	
	public void fenetreMenuListeBaux() {
		setLayout(null);
		
		// affichage label
		JLabel affichageLbl = new JLabel("AFFICHAGE");
		affichageLbl.setBounds(393, 112, 89, 17); // dimension
		affichageLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); // font n height
		
		// affichage box
		JComboBox affichageBox = new JComboBox();
		affichageBox.setBounds(550, 111, 140, 20);
		affichageBox.setBackground(Color.WHITE);
		affichageBox.setBackground(null);
		
		// bouton prochain renouvellement
		JButton btnPR = new JButton("<html><font color = white>Prochain Renouvellement</font></html>");
		btnPR.setBounds(20, 49, 100, 25);
		btnPR.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10)); 
		btnPR.setBackground(new java.awt.Color(39, 170, 243));
		btnPR.setBorder(null);
		
		// bouton futures unités vacants
		JButton btnFUV = new JButton("<html><font color = white>Futures Unités Vacants</font></html>");
		btnFUV.setBounds(133, 49, 100, 25);
		btnFUV.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10)); 
		btnFUV.setBackground(new java.awt.Color(39, 170, 243));
		btnFUV.setBorder(null);
		
		// bouton Montant Bail À Modifier
		JButton btnMBAM = new JButton("<html><font color = white>Montant Bail À Modifier</font></html>");
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
		JTable tableListeBail = new JTable(Bail.afficherListeBail(), Bail.Colonne());
		JScrollPane ListeBail = new JScrollPane(tableListeBail);
		ListeBail.setBounds(15, 145, 680, 227);
		
		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.annuler)
				MainWindow.bail = new MenuGestionBail();
				MainWindow.ouvrePanel(MainWindow.bail);
			}
		});
		
		btnPR.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnPR )
				MainWindow.listePR = new MenuListePR();
				MainWindow.ouvrePanel(MainWindow.listePR);
			}
		});
		
		btnFUV.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnFUV )
				MainWindow.listeFV = new MenuListeFV();
				MainWindow.ouvrePanel(MainWindow.listeFV);
			}
		});
		
		btnMBAM.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnMBAM )
				MainWindow.listeMBAM = new MenuListeMBAM();
				MainWindow.ouvrePanel(MainWindow.listeMBAM);
			}
		});
		
		
		// ajout des différents composants du menu
		add(btnCollection);
		add(btnMBAM);
		add(btnFUV);
		add(btnPR);
		add(ListeBail);
		add(affichageBox);
		add(affichageLbl);
		
		add(Json.remplirFiltreAffichage(affichageBox));
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}
	
	

}
