package system;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import outils.Json;

public class Employe {
	private static JSONArray listeNomUtilisateur = Json.LireData("D:\\coding\\app\\inf1163 projet\\gest-immo_workspace\\gest_immo\\Target\\employer.json"); // chemin d'accés à modifier selon le répertoire du projet chez l'utilisateur
	private static String nom;
	private String prenom;
	private String nomUtilisateur;
	private String motDePasse;
	
	public static boolean Connexion (JTextField pseudo, JTextField mdp) {
		
		for (int i = 0; i < listeNomUtilisateur.size(); i++) { 
			JSONObject object = (JSONObject) listeNomUtilisateur.get(i);
			if (object.get("nomUtilisateur").equals(pseudo.getText()) && object.get("motDePasse").equals(mdp.getText())) {
				return true;
			} else if(i == listeNomUtilisateur.size()-1){
				JOptionPane.showMessageDialog(null, "<html>Échec de l'authentification <br/> Éssayer de nouveau");
			}
		}
		return false;
	}
	
	public static String getNomEmployer (JTextField pseudo) {
		int index = 0;
		for (int i = 0; i < listeNomUtilisateur.size(); ++i) {
		    String nomU = (String) ((JSONObject) listeNomUtilisateur.get(i)).get("nomUtilisateur");
		    if (nomU.equals(pseudo.getText())) {
		        index = i;
		        break;
		    }
		}
		return nom = (String) ((JSONObject) listeNomUtilisateur.get(index)).get("nom");
	}
	
	

}
