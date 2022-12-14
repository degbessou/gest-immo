package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import outils.Fonctions;
import outils.Json;
import system.Employe;
import system.Paiement;
import system.Unites;

public class MenuHistoriquePaiement extends JPanel{
	
	private JScrollPane tableHistoriquePaiement;

	public MenuHistoriquePaiement () {
		fenetreMenuHistoriquePaiement ();
	}
	
	public void fenetreMenuHistoriquePaiement() {
		setLayout(null);
		
		// affichage label
		JLabel affichageLbl = new JLabel("AFFICHAGE");
		affichageLbl.setBounds(25, 408, 91, 17); 
		affichageLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 

		// affichage box
		JComboBox affichageBox = new JComboBox();
		affichageBox.setBounds(137, 407, 140, 20);
		affichageBox.setBackground(Color.WHITE);
		affichageBox.setBackground(null);
		
		// tableau d'affichage de la liste des locataires
		JTable tableHistoriquePaiement = new JTable(Paiement.AfficherHistoriquePaiement(), Paiement.Colonne());
		JScrollPane HistoriquePaiement = new JScrollPane(tableHistoriquePaiement);
		HistoriquePaiement.setBounds(20, 87, 680, 300);

		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.annuler)
				MainWindow.catalogue = new MenuCatalogue();
				MainWindow.ouvrePanel(MainWindow.catalogue); // ouvre le menu catalogue
			}
		});
		
		
		// ajout des différents composants du menu
		add(affichageBox);
		add(affichageLbl);
		add(HistoriquePaiement);
		
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "HISTORIQUE DE PAIEMENT"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
	}

}
