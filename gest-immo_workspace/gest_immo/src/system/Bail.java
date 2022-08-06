package system;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import outils.Json;

public class Bail {
	
	private static String chemin = "baux.json";
	private static String [] infosBail = {"idBail", "idUnites", "typeUnites", "dateEntree", "idAssurance",  "remisage", "locataire", "loyerBase", "dateSortie",  "revouvelabiliter", "stationnement", "loyerTotal"};
	
    /**
     * méthode qui récupère les informations du bail 
     * et les sauvegarde dans le fichier json.
     */
	@SuppressWarnings("unchecked")
	public  static void CreerBail (JTextField [] text) {
		String[] coord = new String[12];
		JSONObject obj = new JSONObject();
		
		coord[0] = Json.NumeroId();
		coord[11] = "";
		
	    for (int i = 0; i < text.length; i++) {
	    	if (text[i].getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "<html>Entrez toutes les informations du bail"); 
	    		break;
	    	}
	        coord[i+1] = text[i].getText();
	    }
	    
	    for (int i = 0; i < coord.length; i++) {
		    obj.put(infosBail[i], coord[i]);
		}
	    
	    
	    Json.EcrireData(obj, Json.path(getChemin()));
	    // Éfface les champs pour entrer de nouvelles données
	    for (int i = 0; i < text.length; i++) {
			text[i].setText("");
		}
	}
	
	@SuppressWarnings("unchecked")
	public  static void ModifierBail (JTextField [] text, String id) {
		String[] coord = new String[12];
		JSONObject obj = new JSONObject();
		
		coord[0] = id;
		coord[11] = "";
		
	    for (int i = 0; i < text.length; i++) {
	    	if (text[i].getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "<html>Entrez toutes les informations du bail"); 
	    		break;
	    	}
	        coord[i+1] = text[i].getText();
	        System.out.println(text[i].getText());
	        
	    }
	    
	    for (int i = 0; i < coord.length; i++) {
		    obj.put(infosBail[i], coord[i]);
		}
	    System.out.println(obj);
	    
	    Json.EcrireData(obj, Json.path(getChemin()));
	    // Éfface les champs pour entrer de nouvelles données
	    for (int i = 0; i < text.length; i++) {
			text[i].setText("");
		}
	}
	
	public static boolean VérificationCreationBail (JTextField id) {
		// parcours le fichier json à la recherche des identifiants entrés par l'utilisateur
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		for (int i = 0; i < listeBail.size(); i++) { 
			JSONObject object = (JSONObject) listeBail.get(i);
			
			System.out.println(object);
			System.out.println(object.get("locataire"));
			System.out.println(id.getText());
			
			if (object.get("idAssurance").equals(id.getText())) { 
				
				JOptionPane.showMessageDialog(null, "<html>Le bail de "+id.getText()+" a été bien enregistré"); 
				return true;
				
			} else if(i == listeBail.size()-1){
				JOptionPane.showMessageDialog(null, "<html>Échec de la création du bail <br/> Éssayer de nouveau"); 
			}
		}
		return false;
	}
	
    /**
     * méthode qui parcours la liste des baux 
     * et remplie la liste déroulante des noms des détenteurs de baux 
     */
	public static Component remplirSelection (JComboBox box) {
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		for (int i = 0; i < listeBail.size(); i++) {
			JSONObject object = (JSONObject) listeBail.get(i);
			box.addItem(object.get("locataire"));
		}
		return box;	
	}
	
    /**
     * méthode qui parcours la liste des baux 
     * et remplie les différents champs du menu avec 
     * les données du bail choisi.
     */
	@SuppressWarnings("rawtypes")
	public static void afficherInfosBail (Component locataire, JTextField [] text) {
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeBail.size(); i++) { 
			object = (JSONObject) listeBail.get(i);
			if (object.get("locataire").equals(((JComboBox) locataire).getSelectedItem().toString())) { // le bail sélectionné.
				text[0].setText(object.get(infosBail[1]).toString());
				text[1].setText(object.get(infosBail[2]).toString());
				text[2].setText(object.get(infosBail[3]).toString());
				text[3].setText(object.get(infosBail[4]).toString());
				text[4].setText(object.get(infosBail[5]).toString());
				text[5].setText(object.get(infosBail[6]).toString());
				text[6].setText(object.get(infosBail[7]).toString());
				text[7].setText(object.get(infosBail[8]).toString());
				text[8].setText(object.get(infosBail[9]).toString());
				text[9].setText(object.get(infosBail[10]).toString());
				
			}
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void modifierInfosBail(Component locataire, JTextField[] text) {
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		String id = null;
		for (int i = 0; i < listeBail.size(); i++) {
			object = (JSONObject) listeBail.get(i);
			if (object.get("locataire").equals(((JComboBox) locataire).getSelectedItem().toString())) { // le locataire sélectionné.
				id = (String) object.get("idBail");
				Json.SupprimerData(object, Json.path(getChemin()));
			}
		}
		ModifierBail(text, id);
		

//		// Éfface les champs pour entrer de nouvelles donées
//		for (int i = 0; i < text.length; i++) {
//			text[i].setText("");
//		}
	}
	
	public static String getChemin() {
		return chemin;
	}

	public static void setChemin(String chemin) {
		Bail.chemin = chemin;
	}
}
