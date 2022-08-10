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
	
	
	public Employe() {
		super();
	}

	public Employe(String prenom, String nomUtilisateur, String motDePasse) {
		super();
		this.prenom = prenom;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	/**
	 * m�thode qui v�rifie les identifiants d'un utilisateur en v�rifiant le nom d'utilisateur 
	 * et le mot de passe et le connecte au logiciel. Affiche un message d'erreur 
	 * si les identifiants ne sont pas reconnus.
	 * 
	 * @param pseudo
	 * @param mdp
	 * @return boolean
	 */
	public static boolean Connexion (JTextField pseudo, JTextField mdp) {
		// parcours le fichier json � la recherche des identifiants entr�s par l'utilisateur
		for (int i = 0; i < listeNomUtilisateur.size(); i++) { 
			JSONObject object = (JSONObject) listeNomUtilisateur.get(i);
			if (object.get("nomUtilisateur").equals(pseudo.getText()) && object.get("motDePasse").equals(mdp.getText())) { 
				return true; // si le nom d'utilisateur et le mot de passe correspondent aux donn�es du JSON
			} else if(i == listeNomUtilisateur.size()-1){
				JOptionPane.showMessageDialog(null, "<html>�chec de l'authentification <br/> �ssayer de nouveau"); 
			}
		}
		return false;
	}
	
	/**
	 * m�thode qui retourne le nom de l'utilisateur connect� au logiciel.
	 * @param pseudo
	 * @return
	 */
	public static String getNomEmployer (JTextField pseudo) {
		int index = 0;
		// r�cup�re l'indice des identifiants de l'utilisateur
		for (int i = 0; i < listeNomUtilisateur.size(); ++i) {
		    String nomU = (String) ((JSONObject) listeNomUtilisateur.get(i)).get("nomUtilisateur"); 
		    if (nomU.equals(pseudo.getText())) {
		        index = i; // r�cup�re l'indice du nom d'utilisateur connect�
		        break;
		    }
		}
		return nom = (String) ((JSONObject) listeNomUtilisateur.get(index)).get("nom"); //  renvoie le nom de l'employ� connect�
	}

}
