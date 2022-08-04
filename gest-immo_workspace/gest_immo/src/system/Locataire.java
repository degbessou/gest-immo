package system;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import outils.Json;

public class Locataire {
	private static JSONArray listeLocataire = Json.LireData(Json.path("Locataire2.json")); 
	private static String [] infosLocataire = {"nom", "prenom", "adresse", "telephone", "typeLocataire", "typeUnites", "coteCredit"};
	private static String nom;
	private static String prenom;
	private static String adresse;
	private static String telephone;
	private static String typeLocataire;
	private static String typeUnites;
	private static String coteCredit;
	
    /**
     * méthode qui récupère les informations du locataire 
     * et les sauvegarde dans le fichier json.
     */
	@SuppressWarnings("unchecked")
	public  static void InscrireClient (JTextField [] text) {
		String[] coord = new String[7];
		JSONObject obj = new JSONObject();
	    for (int i = 0; i < text.length; i++) {
	    	if (text[i].getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "<html>Entrez toutes les informations du locataire"); 
	    		break;
	    	}
	        coord[i] = text[i].getText();
	    }
	    
	    for (int i = 0; i < coord.length; i++) {
		    obj.put(infosLocataire[i], coord[i]);
		}
	    
	    Json.EcrireData(obj, Json.path("Locataire2.json"));
	    // Éfface les champs pour entrer de nouvelles donées
//	    for (int i = 0; i < text.length; i++) {
//			text[i].setText("");
//		}
	}
	
    /**
     * méthode qui vérifie que les informations du locataire 
     * ont été bien sauvegardées dans le fichier json.
     */
	public static boolean VérificationInscriptionLocataire (JTextField nom) {
		// parcours le fichier json à la recherche des identifiants entrés par l'utilisateur
		for (int i = 0; i < listeLocataire.size(); i++) { 
			JSONObject object = (JSONObject) listeLocataire.get(i);
			if (object.get("nom").equals(nom.getText())) { 
				JOptionPane.showMessageDialog(null, "<html>Le Locataire "+nom.getText()+" a été bien enregistré"); // popup de succès si le nom entré est trouvé dans le json à la fin de l'itération
				return true;
				
			} else if(i == listeLocataire.size()-1){
				JOptionPane.showMessageDialog(null, "<html>Échec de l'inscription du locataire <br/> Éssayer de nouveau"); // popup de d'échec si le nom entré n'est pas trouvé dans le json à la fin de l'itération
			}
		}
		return false;
	}
	
    /**
     * méthode qui parcours la liste des locataire 
     * et remplie la liste déroulante des noms des locataires 
     */
	public static Component remplirSelection (JComboBox box) {
		for (int i = 0; i < listeLocataire.size(); i++) {
			JSONObject object = (JSONObject) listeLocataire.get(i);
			box.addItem(object.get("nom"));
		}
		return box;
		
		
	}
	
    /**
     * méthode qui parcours la liste des locataires 
     * et remplie les différents champs du menu avec 
     * les données du locataire choisi.
     */
	public static void afficherInfosLocataire (Component nom, JTextField [] text) {
		for (int i = 0; i < listeLocataire.size(); i++) { 
			JSONObject object = (JSONObject) listeLocataire.get(i);
			if (object.get("nom").equals(((JComboBox) nom).getSelectedItem().toString())) { // le locataire sélectionné.
				for (int j = 0; j < object.size(); j++) { // parcours les informations du locataire
					text[j].setText(object.get(infosLocataire[j]).toString()); // remplie les champs du menu avec les informations du locataire sélectionné.
				}
				
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void modifierInfosLocataire (Component nom, JTextField [] text) {
		
		
		//String[] coord = new String[7];
		JSONObject object = new JSONObject();
		
		for (int i = 0; i < listeLocataire.size(); i++) { 
			object = (JSONObject) listeLocataire.get(i);
			if (object.get("nom").equals(((JComboBox) nom).getSelectedItem().toString())) { // le locataire sélectionné.
				for (int j = 0; j < object.size(); j++) { // parcours les informations du locataire
					if (!(text[j].getText().equals(object.get(infosLocataire[j]).toString()))) {
						object.replace(infosLocataire[j], text[j].getText());
					}
				}
				
			}
		}
		Json.EcrireData(object, Json.path("Locataire2.json"));

	    //Éfface les champs pour entrer de nouvelles donées
	    for (int i = 0; i < text.length; i++) {
			text[i].setText("");
		}
	}
	
	



}
