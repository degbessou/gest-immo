package system;

import java.awt.Component;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import outils.Json;

public class Locataire {
	
	private static String nom;
	private static String prenom;
	private static String adresse;
	private static String telephone;
	private static String typeLocataire;
	private static String typeUnites;
	private static String coteCredit;
	private static String chemin = "locataire.json";
	private static String [] infosLocataire = {"nom", "prenom", "adresse", "telephone", "typeLocataire", "typeUnites", "coteCredit"};
	
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
	    		JOptionPane.showMessageDialog(null, "<html>Entrez toutes les informations du locataire"); // message d'erreur si tous les champs ne sont pas remplis
	    		break; // on sort de la boucle
	    	} else {
	    		coord[i] = text[i].getText(); // on recueille les données rentrées
	    	}
	    }
	    
	    
	    for (int j = 0; j < coord.length; j++) { // parcourt les données recueillies 
	    	if (coord [j] == "" || coord [j] == null) { 
				break; // la boucle s'arrêtte si des données vides sont rencontrées
			} else {
				obj.put(infosLocataire[j], coord[j]); // sinon on sauvegarge ca dans un objet Json
			}
		}
	    
	    if (!obj.isEmpty()) {
	    	Json.EcrireData(obj, Json.path(getChemin())); // si l'objet n'est pas vide on l'enregistre dans le fichier json
	    	JOptionPane.showMessageDialog(null, "<html>Le bail de "+obj.get("idAssurance")+" a été bien enregistré"); // message d'enregistrement
		} else {
			Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		}
	    
	 // Éfface les champs pour entrer de nouvelles données
	    for (int i = 0; i < text.length; i++) {
			text[i].setText(""); 
		}
	}
	
 

	/**
     * méthode qui parcours la liste des locataire 
     * et remplie la liste déroulante des noms des locataires 
     */
	public static Component remplirSelection (JComboBox box) {
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		for (int i = 0; i < listeLocataire.size(); i++) {
			JSONObject object = (JSONObject) listeLocataire.get(i);
			box.addItem(object.get("nom")); // ajoute la valeur de l'attribut nom à la liste déroulante
		}
		return box;	
	}
	
	
    /**
     * méthode qui parcours la liste des locataires 
     * et remplie les différents champs du menu avec 
     * les données du locataire choisi.
     */
	@SuppressWarnings("rawtypes")
	public static void afficherInfosLocataire (Component nom, JTextField [] text) {
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeLocataire.size(); i++) { 
			object = (JSONObject) listeLocataire.get(i);
			if (object.get("nom").equals(((JComboBox) nom).getSelectedItem().toString())) { // le locataire sélectionné.
				for (int j = 0; j < object.size(); j++) { // parcours les informations du locataire
					text[j].setText(object.get(infosLocataire[j]).toString()); // remplie les champs du menu avec les informations du locataire sélectionné.
				}
				
			}
		}
		
	}
	
    /**
     * méthode qui parcours la liste des locataires 
     * et modifie les données du locataire choisi 
     * avec les nouvelles valeurs saisies
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void modifierInfosLocataire(Component nom, JTextField[] text) {
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeLocataire.size(); i++) {
			object = (JSONObject) listeLocataire.get(i);
			if (object.get("nom").equals(((JComboBox) nom).getSelectedItem().toString())) { // le locataire sélectionné.
				Json.SupprimerData(object, Json.path(getChemin())); // supprime les données du locataire.
			}
		}
		//System.out.println(listeLocataire);
		InscrireClient(text); //recrée le locataire choisi avec les nouvelle données saisies 
	}

	public static String getChemin() {
		return chemin;
	}

	public static void setChemin(String chemin) {
		Locataire.chemin = chemin;
	}
	
    /**
     * méthode qui affiche la liste des locataires 
     * dans une table
     */
	public static Component afficherListeLocataire() {
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		Vector<Vector<String>> dataList = new Vector<>(); 
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeLocataire.size(); i++) {

			object = (JSONObject) listeLocataire.get(i);
			Vector<String> data = new Vector<>(); // liste qui définie une ligne du tableau ie les données d'un locataire
			
			// aout de chaque données du locataire 
			data.add((String) object.get("nom"));
			data.add((String) object.get("prenom"));
			data.add((String) object.get("adresse"));
			data.add((String) object.get("telephone"));
			data.add((String) object.get("typeLocataire"));
			data.add((String) object.get("typeUnites"));
			data.add(String.valueOf(object.get("coteCredit")));

			dataList.add(data); // ajout des lignes à la liste qui définie le tableau

		}

		Vector<String> nomColonne = new Vector<>(); // liste qui contient le nom de chaque colonne
		nomColonne.add("Nom");
		nomColonne.add("Prénom");
		nomColonne.add("Adresse");
		nomColonne.add("téléphone");
		nomColonne.add("Type de locataire");
		nomColonne.add("Type d'unités");
		nomColonne.add("Cote de crédit");

		JTable table = new JTable(dataList, nomColonne); // table à afficher
		return table;
	}
	
//	public static Component afficherListeLocataireNbreAffichage(JComboBox affichage) {
//		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
//		Vector<Vector<String>> dataList = new Vector<>();
//		JSONObject object = new JSONObject();
//		String nbreSelectioner = ((JComboBox) affichage).getSelectedItem().toString();
//		for (int i = 0; i < listeLocataire.size(); i++) {
//
//	        object = (JSONObject) listeLocataire.get(i);
//	        
//	        if (i  ==Integer.valueOf(nbreSelectioner)) {
//	        	for (int j = 0; j <= i; j++) {
//			        Vector<String> data = new Vector<>();
//
//			        data.add((String) object.get("nom"));
//			        data.add((String) object.get("prenom"));
//			        data.add((String) object.get("adresse"));
//			        data.add((String) object.get("telephone"));
//			        data.add((String) object.get("typeLocataire"));
//			        data.add((String) object.get("typeUnites"));
//			        data.add(String.valueOf(object.get("coteCredit")));
//			        
//			        dataList.add(data);
//				}
//	        }
//	        
//	    }
//		
//		Vector<String> nomColonne = new Vector<>();
//		nomColonne.add("nom");
//		nomColonne.add("prenom");
//		nomColonne.add("adresse");
//		nomColonne.add("telephone");
//		nomColonne.add("typeLocataire");
//		nomColonne.add("typeUnites");
//		nomColonne.add("coteCredit");
//		
//		JTable table = new JTable(dataList, nomColonne);
//		return table;
//		
//		//return  dataList;
//	}
	
	   public static String getNom() {
			return nom;
		}

		public static void setNom(String nom) {
			Locataire.nom = nom;
		}

		public static String getPrenom() {
			return prenom;
		}

		public static void setPrenom(String prenom) {
			Locataire.prenom = prenom;
		}

		public static String getAdresse() {
			return adresse;
		}

		public static void setAdresse(String adresse) {
			Locataire.adresse = adresse;
		}

		public static String getTelephone() {
			return telephone;
		}

		public static void setTelephone(String telephone) {
			Locataire.telephone = telephone;
		}

		public static String getTypeLocataire() {
			return typeLocataire;
		}

		public static void setTypeLocataire(String typeLocataire) {
			Locataire.typeLocataire = typeLocataire;
		}

		public static String getTypeUnites() {
			return typeUnites;
		}

		public static void setTypeUnites(String typeUnites) {
			Locataire.typeUnites = typeUnites;
		}

		public static String getCoteCredit() {
			return coteCredit;
		}

		public static void setCoteCredit(String coteCredit) {
			Locataire.coteCredit = coteCredit;
		}

		public static String[] getInfosLocataire() {
			return infosLocataire;
		}

		public static void setInfosLocataire(String[] infosLocataire) {
			Locataire.infosLocataire = infosLocataire;
		}
	
	
	
	



}
