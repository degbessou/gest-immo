package system;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import outils.Json;

public class Bail {
	
	private static String chemin = "baux.json";
	private static String [] infosBail = {"idBail", "idUnites", "typeUnites", "dateEntree", "idAssurance",  "remisage", "locataire", "loyerBase", "dateSortie",  "revouvelabiliter", "stationnement", "loyerTotal"};
	private static String locataire;
	private static String idBail;
	private static String idUnites;
	private static String typeUnites;
	private static String dateEntree;
	private static String idAssurance;
	private static String remisage;
	private static String loyerTotal;
	private static String loyerBase;
	private static String dateSortie;
	private static String revouvelabiliter;
	private static String stationnement;
	
    /**
     * méthode qui récupère les informations du bail 
     * et les sauvegarde dans le fichier json.
     */
	@SuppressWarnings("unchecked")
	public  static void CreerBail (JTextField [] text) {
		String[] coord = new String[12];
		JSONObject obj = new JSONObject();
		
		coord[11] = "";
		
	    for (int i = 0; i < text.length; i++) {
	    	if (text[i].getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "<html>Entrez toutes les informations du bail"); 
	    		break;
	    	} else {
	    		coord[i+1] = text[i].getText();
	    		
	    	}
	        
	    }
	    
	    for (int j = 0; j < coord.length; j++) {
	    	if (coord [j] == "" || coord [j] == null) {
				break;
			} else {
				obj.put(infosBail[j], coord[j]);
			}
		}

	    
	    if (!obj.isEmpty()) {
		    coord[0] = Json.NumeroId();
		    obj.put(infosBail[0], coord[0]);
	    	Json.EcrireData(obj, Json.path(getChemin()));
	    	JOptionPane.showMessageDialog(null, "<html>Le bail de "+obj.get("idAssurance")+" a été bien enregistré"); 
		} else {
			Json.SupprimerData(obj, Json.path(getChemin()));	
		}
	    
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
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void RenouvelerBail(Component locataire, JTextField[] text) {
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		String id = null;
		for (int i = 0; i < listeBail.size(); i++) {
			object = (JSONObject) listeBail.get(i);
			if (object.get("locataire").equals(((JComboBox) locataire).getSelectedItem().toString())) { // le locataire sélectionné.
				CreerBail(text);
			}
		}
	}
	
	/**
     * méthode qui affiche la liste des baux
     * dans une table
     */
	public static Component afficherListeBail() {
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		Vector<Vector<String>> dataList = new Vector<>(); 
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeBail.size(); i++) {

			object = (JSONObject) listeBail.get(i);
			Vector<String> data = new Vector<>(); // liste qui définie une ligne du tableau ie les données d'un locataire
			
			// aout de chaque données du locataire 
			data.add((String) object.get("idBail"));
			data.add((String) object.get("idUnites"));
			data.add((String) object.get("locataire"));
			data.add((String) object.get("typeUnites"));
			data.add((String) object.get("dateEntree"));
			data.add((String) object.get("dateSortie"));
			data.add((String) object.get("idAssurance"));
			data.add((String) object.get("loyerBase"));
			data.add((String) object.get("revouvelabiliter"));
			data.add((String) object.get("stationnement"));
			data.add((String) object.get("remisage"));
			data.add((String) object.get("loyerTotal")); 

			dataList.add(data); // ajout des lignes à la liste qui définie le tableau

		}

		Vector<String> nomColonne = new Vector<>(); // liste qui contient le nom de chaque colonne

		nomColonne.add(("Id du bail"));
		nomColonne.add(("Id de l'unités"));
		nomColonne.add(("Locataire"));
		nomColonne.add(("Type de l'unité"));
		nomColonne.add(("Date d'entrée"));
		nomColonne.add(("Date de sortie"));
		nomColonne.add(("Id de l'assurance"));
		nomColonne.add(("Loyer de base"));
		nomColonne.add(("Revouvelabilité"));
		nomColonne.add(("Stationnement"));
		nomColonne.add(("Remisage"));
		nomColonne.add(("Loyer Total")); 

		JTable table = new JTable(dataList, nomColonne); // table à afficher
		return table;
	}
	
	
	public static String getChemin() {
		return chemin;
	}

	public static void setChemin(String chemin) {
		Bail.chemin = chemin;
	}

	public static String getLocataire() {
		return locataire;
	}

	public static void setLocataire(String locataire) {
		Bail.locataire = locataire;
	}

	public static String[] getInfosBail() {
		return infosBail;
	}

	public static void setInfosBail(String[] infosBail) {
		Bail.infosBail = infosBail;
	}

	public static String getIdBail() {
		return idBail;
	}

	public static void setIdBail(String idBail) {
		Bail.idBail = idBail;
	}

	public static String getIdUnites() {
		return idUnites;
	}

	public static void setIdUnites(String idUnites) {
		Bail.idUnites = idUnites;
	}

	public static String getTypeUnites() {
		return typeUnites;
	}

	public static void setTypeUnites(String typeUnites) {
		Bail.typeUnites = typeUnites;
	}

	public static String getDateEntree() {
		return dateEntree;
	}

	public static void setDateEntree(String dateEntree) {
		Bail.dateEntree = dateEntree;
	}

	public static String getIdAssurance() {
		return idAssurance;
	}

	public static void setIdAssurance(String idAssurance) {
		Bail.idAssurance = idAssurance;
	}

	public static String getRemisage() {
		return remisage;
	}

	public static void setRemisage(String remisage) {
		Bail.remisage = remisage;
	}

	public static String getLoyerTotal() {
		return loyerTotal;
	}

	public static void setLoyerTotal(String loyerTotal) {
		Bail.loyerTotal = loyerTotal;
	}

	public static String getLoyerBase() {
		return loyerBase;
	}

	public static void setLoyerBase(String loyerBase) {
		Bail.loyerBase = loyerBase;
	}

	public static String getDateSortie() {
		return dateSortie;
	}

	public static void setDateSortie(String dateSortie) {
		Bail.dateSortie = dateSortie;
	}

	public static String getRevouvelabiliter() {
		return revouvelabiliter;
	}

	public static void setRevouvelabiliter(String revouvelabiliter) {
		Bail.revouvelabiliter = revouvelabiliter;
	}

	public static String getStationnement() {
		return stationnement;
	}

	public static void setStationnement(String stationnement) {
		Bail.stationnement = stationnement;
	}
	
	
}
