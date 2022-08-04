package system;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import outils.Json;

public class Employe {
	private static JSONArray listeNomUtilisateur = Json.LireData(Json.path("employer.json")); 
	private static String nom;
	private String prenom;
	private String nomUtilisateur;
	private String motDePasse;
	
    /**
     * m�thode qui v�rifie les identifiants d'un utilisateur 
     * en v�rifiant le nom d'utilisateur et le mot de passe
     * et le connecte au logiciel. Affiche un message d'erreur si 
     * les identifiants ne sont pas reconnus.
     */
	public static boolean Connexion (JTextField pseudo, JTextField mdp) {
		// parcours le fichier json � la recherche des identifiants entr�s par l'utilisateur
		for (int i = 0; i < listeNomUtilisateur.size(); i++) { 
			JSONObject object = (JSONObject) listeNomUtilisateur.get(i);
			if (object.get("nomUtilisateur").equals(pseudo.getText()) && object.get("motDePasse").equals(mdp.getText())) {   
				return true;
			} else if(i == listeNomUtilisateur.size()-1){
				JOptionPane.showMessageDialog(null, "<html>�chec de l'authentification <br/> �ssayer de nouveau"); 
			}
		}
		return false;
	}
	
    /**
     * m�thode qui retourne le nom de l'utilisateur
     * connect� au logiciel.
     */
	public static String getNomEmployer (JTextField pseudo) {
		int index = 0;
		// r�cup�re l'indice des identifiants de l'utilisateur
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
