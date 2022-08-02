package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import outils.Fonctions;

public class MenuConnexion extends JPanel {

	public MenuConnexion () {
		start();
	}
	public void start() {
		setLayout(null);
		
		// connexion panel 
		JPanel connexion = new JPanel();
		connexion.setBounds(185, 65, 350, 300);
		connexion.setBackground(new java.awt.Color(217, 217, 217));
		
		// nom d'utilisateur text
		JLabel nomUtilisateurLbl = new JLabel("NOM D'UTILISATEUR");
		nomUtilisateurLbl.setBounds(200, 82, 156, 17); // dimension
		nomUtilisateurLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); // font n height
		
		// nom d'utilisateur case
		JTextField nomUtilisateur = new JTextField();
		nomUtilisateur.setBounds(210, 107, 300, 35);
		nomUtilisateur.setBackground(Color.WHITE);
		nomUtilisateur.setBorder(null);
		
		// mot de passe text
		JLabel mdpLbl = new JLabel("MOT DE PASSE");
		mdpLbl.setBounds(200, 187, 120, 17); // dimension
		mdpLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); // font n height
		
		// mot de passe case
		JTextField mdp = new JTextField();
		mdp.setBounds(210, 212, 300, 35);
		mdp.setBackground(Color.WHITE);
		mdp.setBorder(null);
		
		// mot de passe oublié text
		JLabel mdpOublie = new JLabel("Mot de passe oublié ?");
		mdpOublie.setBounds(405, 257, 110, 11); // dimension
		mdpOublie.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10)); // font n height
		mdpOublie.setForeground(new java.awt.Color(57, 108, 240));
		
		// connexion button
		JButton btnConnecter = new JButton("<html><font color = white> Se connecter </font></html>");
		btnConnecter.setBounds(200, 300, 150, 35);
		btnConnecter.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15)); // font n height
		btnConnecter.setBackground(new java.awt.Color(39, 170, 243));
		btnConnecter.setBorder(null);
		
		// login action
		MainWindow.menuPrincipal = new MenuPrincipal ();
		btnConnecter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnConnecter)
					MainWindow.ouvrePanel(MainWindow.menuPrincipal);
			}
		});
		
		add(Fonctions.signature(MainWindow.copyright));
		add(btnConnecter);
		add(mdpOublie);
		add(mdpLbl);
		add(mdp);
		add(nomUtilisateurLbl);
		add(nomUtilisateur);
		add(connexion);
		
	}
}
