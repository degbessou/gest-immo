package system;

import java.awt.Component;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import outils.Json;

public class Locataire {
	
	private  String nom;
	private  String prenom;
	private  String adresse;
	private  String telephone;
	private  String typeLocataire;
	private  String typeUnites;
	private  String coteCredit;
	private static String chemin = "locataire.json";
	private static String [] infosLocataire = {"nom", "prenom", "adresse", "telephone", "typeLocataire", "typeUnites", "coteCredit"};
	
	public Locataire() {
		super();
	}

	public Locataire(String nom, String prenom, String adresse, String telephone, String typeLocataire,
			String typeUnites, String coteCredit) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.typeLocataire = typeLocataire;
		this.typeUnites = typeUnites;
		this.coteCredit = coteCredit;
	}

	public static String[] getInfosLocataire() {
		return infosLocataire;
	}

	public static void setInfosLocataire(String[] infosLocataire) {
		Locataire.infosLocataire = infosLocataire;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTypeLocataire() {
		return typeLocataire;
	}

	public void setTypeLocataire(String typeLocataire) {
		this.typeLocataire = typeLocataire;
	}

	public String getTypeUnites() {
		return typeUnites;
	}

	public void setTypeUnites(String typeUnites) {
		this.typeUnites = typeUnites;
	}

	public String getCoteCredit() {
		return coteCredit;
	}

	public void setCoteCredit(String coteCredit) {
		this.coteCredit = coteCredit;
	}
	
	/** 
     * méthode qui récupère les informations du locataire 
     * et les sauvegarde dans le fichier json.
	 * @param text : 
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
	    
	    for (int j = 0; j < coord.length; j++) { // parcours les données recueillies 
			obj.put(infosLocataire[j], coord[j]); // sinon on sauvegarge ca dans un objet Json
			
		}
	    
	    if (obj.containsValue(null)) {
	    	Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		} else if (obj.isEmpty()){
			Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		}else {
			Json.EcrireData(obj, Json.path(getChemin())); // si l'objet n'est pas vide on l'enregistre dans le fichier json
	    	JOptionPane.showMessageDialog(null, "<html>Le locataire "+obj.get("nom")+" a été bien enregistré"); // message d'enregistrement
		}
	    
	 // Éfface les champs pour entrer de nouvelles données
	    for (int i = 0; i < text.length; i++) {
			text[i].setText(""); 
		}
	}

	/**
	 * 	
     * méthode qui parcours la liste des locataire 
     * et remplie la liste déroulante des noms des locataires 
     *
	 * @param box : JComboBox
	 * @return Component
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Component remplirSelection (JComboBox box) {
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		for (int i = 0; i < listeLocataire.size(); i++) {
			JSONObject object = (JSONObject) listeLocataire.get(i);
			box.addItem(object.get("nom")); // ajoute la valeur de l'attribut nom à la liste déroulante
		}
		return box;	
	}
	
	
	/**
	 *
     * méthode qui parcours la liste des locataires 
     * et remplie les différents champs du menu avec 
     * les données du locataire choisi.
     *
	 * @param nom : Component
	 * @param text : 
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
     * 
     * @param nom : Component
	 * @param text :
     */
	@SuppressWarnings({"rawtypes" })
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
	 * méthode qui affiche le nom des colonnes de la liste 
	 * @return Vector
	 */
	public static Vector<String> Colonne () {
		Vector<String> nomColonne = new Vector<>(); // liste qui contient le nom de chaque colonne
		nomColonne.add("Nom");
		nomColonne.add("Prénom");
		nomColonne.add("Adresse");
		nomColonne.add("téléphone");
		nomColonne.add("Type de locataire");
		nomColonne.add("Type d'unités");
		nomColonne.add("Cote de crédit");
		
		return nomColonne;
	}
	
    /**
     * méthode qui affiche la liste des locataires 
     * dans une table
     * 
	 * @return Component
     * 
     */
	public static Vector<Vector<String>> afficherListeLocataire() {
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
		return dataList;
	}

}
