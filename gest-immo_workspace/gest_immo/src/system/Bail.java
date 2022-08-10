package system;

import java.awt.Component;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import outils.Fonctions;
import outils.Json;

public class Bail {
	
	private static String chemin = "baux.json";
	private static String [] infosBail = {"idBail", "idUnites", "typeUnites", "dateEntree", "idAssurance",  "remisage", "locataire", "loyer", "dateSortie",  "revouvelabiliter", "stationnement"};
	private long idBail ;
	private LocalDate dateEntree ;
	private LocalDate dateSortie;
	private String idAss ;
	private boolean remise ;
	private boolean revouv;
	private boolean stationnement;
	private Unites_1 unites;
	private Locataire locataire;
	private Unites uniteLoue ;
	
    /**
     * méthode qui récupère les informations du bail 
     * et les sauvegarde dans le fichier json.
     */
	@SuppressWarnings("unchecked")
	public  static void CreerBail (JTextField [] text) {
		String[] coord = new String[12];
		JSONObject obj = new JSONObject();
		
		coord[0] = Json.NumeroId(); // attribution de l'id du bail
		
	    for (int i = 0; i < text.length; i++) { // parcours les données saisies 
	    	if (text[i].getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "<html>Entrez toutes les informations du bail"); // message d'erreur si toutes les données n'ont pas été saisies 
	    		break; 
	    	} else {
	    		coord[i+1] = text[i].getText(); // enregistre les données saisies dans un tableau
	    	}
	    }
	    
	    for (int j = 0; j < coord.length; j++) { // parcours le tableau de données
	    		obj.put(infosBail[j], coord[j]); // enregistre les données dans un object json
		}
	    
	    obj.put(infosBail[0], coord[0]); // ajoute l'id à l'objet
	    
	    if (obj.containsValue(null)) {
	    	Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		} else if (obj.isEmpty()){
			Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		}else {
			Json.EcrireData(obj, Json.path(getChemin())); // si l'objet n'est pas vide on l'enregistre dans le fichier json
	    	JOptionPane.showMessageDialog(null, "Le bail de "+obj.get("locataire")+" a été bien enregistré"); // message d'enregistrement
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
		
		coord[0] = id; // attribution de l'id du bail
		
	    for (int i = 0; i < text.length; i++) { // parcours les données saisies 
	    	if (text[i].getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "Entrez toutes les informations du bail"); // message d'erreur si toutes les données n'ont pas été saisies
	    		break;
	    	}
	        coord[i+1] = text[i].getText();
	    }
	    
	    for (int i = 0; i < coord.length; i++) {
		    obj.put(infosBail[i], coord[i]);
		}
	    
	    obj.put(infosBail[0], coord[0]); // ajoute l'id à l'objet
	    
	    if (obj.containsValue(null)) {
	    	Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		} else if (obj.isEmpty()){
			Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		}else {
			Json.EcrireData(obj, Json.path(getChemin())); // si l'objet n'est pas vide on l'enregistre dans le fichier json
	    	JOptionPane.showMessageDialog(null, "Le bail de "+obj.get("locataire")+" a été bien enregistré"); // message d'enregistrement
		}
	    
	    // Éfface les champs pour entrer de nouvelles données
	    for (int i = 0; i < text.length; i++) {
			text[i].setText("");
		}
	}
	
    /**
     * méthode qui parcours la liste des baux 
     * et remplie la liste déroulante des noms des détenteurs de baux 
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	
    /**
     * méthode qui parcours la liste des baux 
     * et modifie les données du bail choisi 
     * avec les nouvelles valeurs saisies
     */
	@SuppressWarnings({"rawtypes" })
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
	
	/**
     * méthode qui permet de renouveler le bail d'un locataire
     * 
     */
	@SuppressWarnings({"rawtypes" })
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
	public static Vector<Vector<String>> afficherListeBail() {
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		Vector<Vector<String>> dataList = new Vector<>(); 
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeBail.size(); i++) {

			object = (JSONObject) listeBail.get(i);
			Vector<String> data = new Vector<>(); // liste qui définie une ligne du tableau ie les données d'un locataire
			
			// ajout de chaque données du locataire 
			data.add((String) object.get("idBail"));
			data.add((String) object.get("idUnites"));
			data.add((String) object.get("locataire"));
			data.add((String) object.get("typeUnites"));
			data.add((String) object.get("dateEntree"));
			data.add((String) object.get("dateSortie"));
			data.add((String) object.get("idAssurance"));
			data.add((String) object.get("loyer"));
			data.add((String) object.get("revouvelabiliter"));
			data.add((String) object.get("stationnement"));
			data.add((String) object.get("remisage"));

			dataList.add(data); // ajout des lignes à la liste qui définie le tableau

		}
		return dataList;
	}
	
	
	public static Vector<String> Colonne () {
		Vector<String> nomColonne = new Vector<>(); // liste qui contient le nom de chaque colonne

		nomColonne.add(("Id du bail"));
		nomColonne.add(("Id de l'unités"));
		nomColonne.add(("Locataire"));
		nomColonne.add(("Type de l'unité"));
		nomColonne.add(("Date d'entrée"));
		nomColonne.add(("Date de sortie"));
		nomColonne.add(("Id de l'assurance"));
		nomColonne.add(("Loyer"));
		nomColonne.add(("Revouvelabilité"));
		nomColonne.add(("Stationnement"));
		nomColonne.add(("Remisage"));
		
		return nomColonne;
	}
	/**
	 * Méthode qui affiche la liste des renouvellement
	 * prochain
	 * @return Vector
	 */ 
	public static Vector<Vector<Object>>  ListeRenouvProchain (){
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		
		Vector<Vector<Object>> listeRenouvProch = new Vector<>();
		for (int i = 0; i < listeBail.size(); i++) {

			object = (JSONObject) listeBail.get(i);
			LocalDate dateFin = Fonctions.stringEnDate(object.get("dateSortie").toString()) ;
			LocalDate dateRef = dateFin.minusMonths(6);
			Vector<Object> data = new Vector<>();
			if (LocalDate.now().isAfter(dateRef)) { // le locataire sélectionné.
				// ajout de chaque données du locataire 
				data.add((String) object.get("idBail"));
				data.add((String) object.get("idUnites"));
				data.add((String) object.get("locataire"));
				data.add((String) object.get("typeUnites"));
				data.add((String) object.get("dateEntree"));
				data.add((String) object.get("dateSortie"));
				data.add((String) object.get("idAssurance"));
				data.add((String) object.get("loyer"));
				data.add((String) object.get("revouvelabiliter"));
				data.add((String) object.get("stationnement"));
				data.add((String) object.get("remisage"));
			}
			listeRenouvProch.add(data);
		}
		return listeRenouvProch;
	}
	
	/**
	 * Méthode qui affiche la liste des Futurs Vacants
	 * @return Vector
	 */
	public static Vector<Vector<String>>  ListeFutursVacant (){
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		
		Vector<Vector<String>> listFV = new Vector<>();
		for (int i = 0; i < listeBail.size(); i++) {

			object = (JSONObject) listeBail.get(i);
			LocalDate dateFin = Fonctions.stringEnDate(object.get("dateSortie").toString()) ;
			LocalDate dateRef = dateFin.minusMonths(6);
			Vector<String> data = new Vector<>();
			if (LocalDate.now().isAfter(dateRef) && object.get("revouvelabiliter").toString().equals("non")) { 
				// ajout de chaque données du locataire 
				data.add((String) object.get("idBail"));
				data.add((String) object.get("idUnites"));
				data.add((String) object.get("locataire"));
				data.add((String) object.get("typeUnites"));
				data.add((String) object.get("dateEntree"));
				data.add((String) object.get("dateSortie"));
				data.add((String) object.get("idAssurance"));
				data.add((String) object.get("loyer"));
				data.add((String) object.get("revouvelabiliter"));
				data.add((String) object.get("stationnement"));
				data.add((String) object.get("remisage"));
			}
			listFV.add(data);
			
		}
		return listFV;
	}
	
	/**
	 * Méthode qui affiche la liste des modifications
	 * @return Vector
	 */
	public static Vector<Vector<String>>  ListeModification (){
		JSONArray listeBail = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		
		Vector<Vector<String>> listModif = new Vector<>();
		for (int i = 0; i < listeBail.size(); i++) {

			object = (JSONObject) listeBail.get(i);
			LocalDate dateFin = Fonctions.stringEnDate(object.get("dateSortie").toString()) ;
			LocalDate dateRef = dateFin.minusMonths(6);
			Vector<String> data = new Vector<>();
			if (LocalDate.now().isAfter(dateRef) && object.get("revouvelabiliter").toString().equals("oui")) { 
				// ajout de chaque données du locataire 
				data.add((String) object.get("idBail"));
				data.add((String) object.get("idUnites"));
				data.add((String) object.get("locataire"));
				data.add((String) object.get("typeUnites"));
				data.add((String) object.get("dateEntree"));
				data.add((String) object.get("dateSortie"));
				data.add((String) object.get("idAssurance"));
				data.add((String) object.get("loyer"));
				data.add((String) object.get("revouvelabiliter"));
				data.add((String) object.get("stationnement"));
				data.add((String) object.get("remisage"));
			}
			listModif.add(data);
			
		}
		return listModif;
	}
	
	public Bail() {
		super();
	}

	public Bail(long idBail, LocalDate dateEntree, LocalDate dateSortie, String idAss, boolean remise, boolean revouv,
			boolean stationnement, Unites_1 unites, Locataire locataire, Unites uniteLoue) {
		super();
		this.idBail = idBail;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.idAss = idAss;
		this.remise = remise;
		this.revouv = revouv;
		this.stationnement = stationnement;
		this.unites = unites;
		this.locataire = locataire;
		this.uniteLoue = uniteLoue;
	}

	public static String getChemin() {
		return chemin;
	}

	public static void setChemin(String chemin) {
		Bail.chemin = chemin;
	}

	public long getIdBail() {
		return idBail;
	}

	public void setIdBail(long idBail) {
		this.idBail = idBail;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getIdAss() {
		return idAss;
	}

	public void setIdAss(String idAss) {
		this.idAss = idAss;
	}

	public boolean isRemise() {
		return remise;
	}

	public void setRemise(boolean remise) {
		this.remise = remise;
	}

	public boolean isRevouv() {
		return revouv;
	}

	public void setRevouv(boolean revouv) {
		this.revouv = revouv;
	}

	public boolean isStationnement() {
		return stationnement;
	}

	public void setStationnement(boolean stationnement) {
		this.stationnement = stationnement;
	}

	public Unites_1 getUnites() {
		return unites;
	}

	public void setUnites(Unites_1 unites) {
		this.unites = unites;
	}

	public Locataire getLocataire() {
		return locataire;
	}

	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}

	public Unites getUniteLoue() {
		return uniteLoue;
	}

	public void setUniteLoue(Unites uniteLoue) {
		this.uniteLoue = uniteLoue;
	}
	
	

	
	
	
}
