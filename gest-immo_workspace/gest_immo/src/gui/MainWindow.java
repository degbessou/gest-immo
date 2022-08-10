package gui;

import java.awt.*;
import javax.swing.*;

public class MainWindow {
	public static JFrame frame;
	protected static MenuConnexion connexion;
	protected static JLabel copyright; // signature gest-immo
	protected static PageAccueil pageAccueil;
	public static MenuPrincipal menuPrincipal;
	protected static MenuGestionBail bail;
	protected static MenuListeBaux listeBail;
	protected static MenuListeLocataire listeLocataire;
	protected static MenuInscriptionLocataire inscription;
	protected static MenuCatalogue catalogue;
	protected static MenuListeUnites listeUnite;
	protected static MenuHistoriquePaiement hPaiement;
	protected static MenuPaiement paiement;
	protected static MenuListePR listePR;
	protected static MenuListeFV listeFV;
	protected static MenuListeMBAM listeMBAM;
	protected static MenuModifierLocataire modifierLocataire;
	protected static MenuModifierBail modifierBail;
	protected static MenuModifierUnites modifierUnites;
	protected static JPanel dash;

	protected static JButton quitter;
	protected static JLabel identifiantEmploye;
	protected static JButton annuler;
	protected static JButton creer;
	protected static JButton modifier;
	protected static JButton renouveler;
	protected static JButton liste;

	protected static JLabel titre;
//	protected static CreerLocation creerLocation;
//	protected static ListeLocation listeLocation;
//	protected static JLabel identifiantClient;

//	protected static AjoutVoiture ajoutVoiture;
	
	public MainWindow () {
		
	}
	
	public static void ouvrePanel (JPanel myPanel) {
		frame.setContentPane(myPanel);
		frame.repaint();
		frame.revalidate();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// fenêtre principale
		frame = new JFrame();
		frame.setSize(new Dimension(735, 520));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setBackground(new java.awt.Color(246, 245, 245));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		pageAccueil = new PageAccueil ();
		MainWindow.ouvrePanel(pageAccueil);

	}

}
