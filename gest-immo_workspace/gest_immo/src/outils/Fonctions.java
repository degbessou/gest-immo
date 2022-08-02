package outils;

import java.awt.*;
import javax.swing.*;
import gui.MainWindow;

public class Fonctions {
	
	public static JFrame frame;
	
	// signature text
	public static JLabel signature (JLabel sign) {
		sign = new JLabel("GEST-IMMO : agence de location d’unités résidentiels et commerciaux");
		sign.setBounds(10, 453, 426, 17); // dimension
		sign.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // police et taille
		return sign;
	}
	
	// dashboard panel
	public static JPanel tableaudebordPanel (JPanel dash) {
		dash = new JPanel();
		dash.setBounds(10, 40, 700, 400);
		dash.setBackground(new java.awt.Color(217, 217, 217));
		dash.setBorder(BorderFactory.createLineBorder(Color.black, 2)); // bordure
		return dash;
	}
	
	public static JButton bouttonQuitter (JButton btn) {
		// login button
		btn = new JButton("<html><font color= white>Quitter</font></html>");
		btn.setBounds(648, 15, 50, 16);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14)); 
		btn.setBackground(new java.awt.Color(57, 108, 240));
		btn.setBorder(null);
		return btn;		
	}
	
	public static JLabel labelNomEmploye (JLabel label) {
		// login button
		label = new JLabel("<html><font color= #396CF0>nomEmploye</font></html>"); // faire un get pour obtenir l'identifiant de l'employé connecté
		label.setBounds(30, 15, 85, 17); 
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14)); 
		return label;
	}
	
//	public static JLabel labelNomClient (JLabel label) {
//		// login button
//		label = new JLabel("<html><font color= #396CF0>identifiantClient</font></html>"); // faire un get pour obtenir l'identifiant du client connecté
//		label.setBounds(30, 385, 100, 17); // dimension
//		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // font n height
//		return label;
//	}
	
	public static JButton bouttonAnnuler (JButton btn) {
		btn = new JButton("<html><font color = white>Annuler</font></html>");
		btn.setBounds(540, 385, 150, 30);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); 
		btn.setBackground(new java.awt.Color(39, 170, 243));
		btn.setBorder(null);
		return btn;
	}
	
	public static JButton bouttonModifier (JButton btn) {
		btn = new JButton("<html><font color = white>Modifier</font></html>");
		btn.setBounds(200, 385, 150, 30);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); 
		btn.setBackground(new java.awt.Color(39, 170, 243));
		btn.setBorder(null);
		return btn;
	}
	
	public static JButton bouttonCréer (JButton btn) {
		btn = new JButton("<html><font color = white>Enregistrer</font></html>");
		btn.setBounds(30, 385, 150, 30);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); 
		btn.setBackground(new java.awt.Color(39, 170, 243));
		btn.setBorder(null);
		return btn;
	}
	
	public static JButton bouttonPersonnalisable (JButton btn, String nom) {
		btn = new JButton("<html><font color = white>"+nom+"</font></html>");
		btn.setBounds(370, 385, 150, 30);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); 
		btn.setBackground(new java.awt.Color(39, 170, 243));
		btn.setBorder(null);
		return btn;
	}
	
	public static JLabel titre (JLabel titre, String text) {
		// title
		titre = new JLabel(text);
		titre.setBounds(152, 64, 416, 26); // dimension
		titre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25)); 
		return titre;
	}
}
//	public static JButton boutton (JButton btn) {
//		// login button
//		btn = new JButton("<html><font color= white>Quitter</font></html>");
//		btn.setBounds(621, 15, 52, 17);
//		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10)); // font n height
//		btn.setBackground(new java.awt.Color(39, 170, 243));
//		btn.setBorder(null);
//		return btn;
//		
//	}
