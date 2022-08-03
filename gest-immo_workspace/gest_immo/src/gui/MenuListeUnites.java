package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import outils.Fonctions;

public class MenuListeUnites extends JPanel {
	
	public MenuListeUnites () {
		fenetreMenuListeUnites ();
	}
	
	public void fenetreMenuListeUnites() {
		setLayout(null);
		
		// filtre : type Unités label
		JLabel filtreTypeUnitesLbl = new JLabel("TYPE UNITÉS");
		filtreTypeUnitesLbl.setBounds(440, 112, 126, 17); 
		filtreTypeUnitesLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 
		
		// affichage label
		JLabel affichageLbl = new JLabel("AFFICHAGE");
		affichageLbl.setBounds(440, 159, 100, 17); 
		affichageLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13)); 

		// filtre : type unités box
		JComboBox filtreTypeUnitesBox = new JComboBox();
		filtreTypeUnitesBox.setBounds(550, 111, 140, 20);
		filtreTypeUnitesBox.setBackground(Color.WHITE);
		filtreTypeUnitesBox.setBorder(null);

		// affichage box
		JComboBox affichageBox = new JComboBox();
		affichageBox.setBounds(550, 158, 140, 20);
		affichageBox.setBackground(Color.WHITE);
		affichageBox.setBackground(null);
		
		// bouton prochain renouvellement
		JButton btnPR = new JButton("<html><font color = white>Prochain Renouvellement</font></html>");
		btnPR.setBounds(440, 204, 250, 30);
		btnPR.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); 
		btnPR.setBackground(new java.awt.Color(39, 170, 243));
		btnPR.setBorder(null);
		
		// bouton futures unités vacants
		JButton btnFUV = new JButton("<html><font color = white>Futures Unités Vacants</font></html>");
		btnFUV.setBounds(440, 254, 250, 30);
		btnFUV.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); 
		btnFUV.setBackground(new java.awt.Color(39, 170, 243));
		btnFUV.setBorder(null);
		
		// bouton Montant Bail À Modifier
		JButton btnMBAM = new JButton("<html><font color = white>Montant Bail À Modifier</font></html>");
		btnMBAM.setBounds(440, 304, 250, 30);
		btnMBAM.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); 
		btnMBAM.setBackground(new java.awt.Color(39, 170, 243));
		btnMBAM.setBorder(null);
		
		// bouton Collection
		JButton btnCollection = new JButton("<html><font color = white>Collection</font></html>");
		btnCollection.setBounds(440, 354, 250, 30);
		btnCollection.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); 
		btnCollection.setBackground(new java.awt.Color(39, 170, 243));
		btnCollection.setBorder(null);
		
		add(btnPR);
		add(filtreTypeUnitesBox);
		add(filtreTypeUnitesLbl);
		add(affichageBox);
		add(affichageLbl);
		add(btnCollection);
		add(btnMBAM);
		add(btnFUV);
		add(btnPR);
		
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
		
		add(MainWindow.annuler);
		add(MainWindow.quitter);
		add(Fonctions.titre(MainWindow.titre, "LISTE DES UNITÉS EN LOCATION"));
		add(Fonctions.signature(MainWindow.copyright));
		add(Fonctions.tableaudebordPanel(MainWindow.dash));
		add(Fonctions.labelNomEmploye(MainWindow.identifiantEmploye));
	}
		

}
