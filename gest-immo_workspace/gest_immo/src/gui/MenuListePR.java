package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import outils.Fonctions;
import system.Bail;
import system.Employe;

public class MenuListePR extends JPanel {
	
	public MenuListePR () {
		fenetreMenuListePR ();
	}
	
	public void fenetreMenuListePR() {
		setLayout(null);
		
		// table qui contient la liste
		JTable listePR = new JTable(Bail.ListeRenouvProchain(), Bail.Colonne());
		JScrollPane tableListePR = new JScrollPane(listePR);
		tableListePR.setBounds(15, 145, 680, 227);
		
		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.annuler)
				MainWindow.listeBail = new MenuListeBaux();
				MainWindow.ouvrePanel(MainWindow.listeBail); // ouvre le menu liste bail
			}
		});
		
		// ajout des différents composants du menu
		add(tableListePR);
		
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "PROCHAINS RENOUVELLEMENT"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
		
	}

}
