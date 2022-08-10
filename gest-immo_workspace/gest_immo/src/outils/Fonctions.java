package outils;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.*;
import gui.MainWindow;
import system.Bail;

public class Fonctions {
	
	public static JFrame frame;
	
	/**
	 * Cette methode renvoie la signature GEST-IMMO
	 * @param sign
	 * @return sign
	 */
	public static JLabel signature (JLabel sign) {
		sign = new JLabel("GEST-IMMO : agence de location d’unités résidentiels et commerciaux");
		sign.setBounds(10, 453, 426, 17); // dimension
		sign.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); // police et taille
		return sign;
	}
	
	/**
	 * Cette methode renvoie le panel principal
	 * @param sign
	 * @return sign
	 */
	public static JPanel tableaudebordPanel (JPanel dash) {
		dash = new JPanel();
		dash.setBounds(10, 40, 700, 400);
		dash.setBackground(new java.awt.Color(217, 217, 217));
		dash.setBorder(BorderFactory.createLineBorder(Color.black, 2)); // bordure
		return dash;
	}
	
	/**
	 * Cette methode renvoie l'interface du bouton quitter
	 * @param btn
	 * @return btn
	 */
	public static JButton bouttonQuitter (JButton btn) {
		// login button
		btn = new JButton("<html><font color= white>Quitter</font></html>");
		btn.setBounds(648, 15, 50, 16);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14)); 
		btn.setBackground(new java.awt.Color(57, 108, 240));
		btn.setBorder(null);
		return btn;		
	}
	
	/**
	 * Cette methode renvoie le nom de l'employé connecté
	 * @param label
	 * @param nomEmploye
	 * @return label
	 */
	public static JLabel labelNomEmploye (JLabel label, String nomEmploye) {
		// login button
		label = new JLabel("<html><font color= #396CF0>"+nomEmploye+"</font></html>"); 
		label.setBounds(30, 15, 85, 17); 
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14)); 
		return label;
	}
	
	/**
	 * Cette methode renvoie l'interface du bouton annuler
	 * @param btn
	 * @return btn
	 */
	public static JButton bouttonAnnuler (JButton btn) {
		btn = new JButton("<html><font color = white>Annuler</font></html>");
		btn.setBounds(540, 400, 150, 30);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); 
		btn.setBackground(new java.awt.Color(39, 170, 243));
		btn.setBorder(null);
		return btn;
	}
	
	/**
	 * Cette methode renvoie l'interface du bouton modifier
	 * @param btn
	 * @return btn
	 */
	public static JButton bouttonModifier (JButton btn) {
		btn = new JButton("<html><font color = white>Modifier</font></html>");
		btn.setBounds(200, 400, 150, 30);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); 
		btn.setBackground(new java.awt.Color(39, 170, 243));
		btn.setBorder(null);
		return btn;
	}
	
	/**
	 * Cette methode renvoie l'interface du bouton créer
	 * @param btn
	 * @return btn
	 */
	public static JButton bouttonCréer (JButton btn) {
		btn = new JButton("<html><font color = white>Créer</font></html>");
		btn.setBounds(30, 400, 150, 30);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); 
		btn.setBackground(new java.awt.Color(39, 170, 243));
		btn.setBorder(null);
		return btn;
	}
	
	/**
	 * Cette methode renvoie l'interface d'un bouton personnalisable par le nom
	 * @param btn
	 * @param nom
	 * @return btn
	 */
	public static JButton bouttonPersonnalisable (JButton btn, String nom) {
		btn = new JButton("<html><font color = white>"+nom+"</font></html>");
		btn.setBounds(370, 400, 150, 30);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); 
		btn.setBackground(new java.awt.Color(39, 170, 243));
		btn.setBorder(null);
		return btn;
	}
	
	/**
	 * Cette methode renvoie le titre de l'interface
	 * @param titre
	 * @param text
	 * @return titre
	 */
	public static JLabel titre (JLabel titre, String text) {
		titre = new JLabel(text, SwingConstants.CENTER);
		titre.setBounds(152, 64, 416, 26); // dimension
		titre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25)); 
		return titre;
	}
	
	/**
	 * Cette methode renvoie l'interface du bouton liste
	 * @param btn
	 * @param nom
	 * @return btn
	 */
	public static JButton bouttonListe (JButton btn, String nom) {
		btn = new JButton("<html><font color = white>"+nom+"</font></html>");
		btn.setBounds(440, 346, 250, 30);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); 
		btn.setBackground(new java.awt.Color(39, 170, 243));
		btn.setBorder(null);
		return btn;
	}
	
	/**
	 *  Cette methode permet de convertir une date de type LocalDate en String
	 * @param date
	 * @return String
	 */
	public static String DateEnString (LocalDate date ) {
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formatDate);
	}
	
	/*
	 * Cette methode permet de convertir une date 
	 * (Cette date doit etre au format dd/mm/aaaa) au format jj/mm/aaaa en LocalDate
	 * @param date 
	 * @return LocalDate
	 */
	public static LocalDate stringEnDate (String date ) {
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(date, formatDate);
	}
	
}
