package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import outils.Fonctions;
import system.Bail;
import system.Employe;

public class MenuListeMBAM extends JPanel {
	
	public MenuListeMBAM () {
		fenetreMenuMBAM ();
	}
	
	public void fenetreMenuMBAM() {
		setLayout(null);
		
		JTable listeMBAM = new JTable(Bail.ListeModification(), Bail.Colonne());
		JScrollPane tablelisteMBAM = new JScrollPane(listeMBAM);
		tablelisteMBAM.setBounds(15, 145, 680, 227);
		
		// bouton annuler action
		MainWindow.annuler = Fonctions.bouttonAnnuler(MainWindow.annuler);
		MainWindow.annuler.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == MainWindow.annuler)
				MainWindow.listeBail = new MenuListeBaux();
				MainWindow.ouvrePanel(MainWindow.listeBail);
			}
		});
		
		// ajout des différents composants du menu
		add(tablelisteMBAM);
		
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "BAIL À MODIFIER"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye, Employe.getNomEmployer(MenuConnexion.nomUtilisateur)));
		
	}

}
