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

public class Unites {
	//JSONArray listeBail = Json.LireData(Json.path(getChemin()));
	private static String chemin = "unit�s.json";
	private static String [] infosUnit�s = {"idUnites", "typeUnites", "adresse", "anneeConstruction", "superficie", "nombrePieces", "condition", "disponibiliter", "proprietaire", "loyerMensuel", "prixRemisageMensuel", "prixStationnementMensuel"};
	
	private String nombrePieces;
	private static String loyerMensuel;
	private int idUnites;
	private String typeUnites;
	private String adresse;
	private String anneeConstruction;
	private String superficie;
	private String condition;
	private boolean disponibiliter;
	private String proprietaire;
	private static int prixRemisageMensuel = 75;
	private static int prixStationnementMensuel = 100;

	public Unites() {
		super();
	}


	public Unites(String nombrePieces, String loyerMensuel, int idUnites, String typeUnites, String adresse,
			String anneeConstruction, String superficie, String condition, boolean disponibiliter, String proprietaire,
			int prixRemisageMensuel, int prixStationnementMensuel) {
		super();
		this.nombrePieces = nombrePieces;
		this.idUnites = idUnites;
		this.typeUnites = typeUnites;
		this.adresse = adresse;
		this.anneeConstruction = anneeConstruction;
		this.superficie = superficie;
		this.condition = condition;
		this.disponibiliter = disponibiliter;
		this.proprietaire = proprietaire;
	}


	public static String getChemin() {
		return chemin;
	}

	public static void setChemin(String chemin) {
		Unites.chemin = chemin;
	}
	
	public static String[] getInfosUnit�s() {
		return infosUnit�s;
	}

	public static void setInfosUnit�s(String[] infosUnit�s) {
		Unites.infosUnit�s = infosUnit�s;
	}


	public String getNombrePieces() {
		return nombrePieces;
	}


	public void setNombrePieces(String nombrePieces) {
		this.nombrePieces = nombrePieces;
	}


	public static String getLoyerMensuel(String text) {
		switch (text) {
		case "1":
			loyerMensuel = "900";
			break;
		case "2":
			loyerMensuel = "1200";
			break;
		case "3":
			loyerMensuel = "1500";
			break;
		case "4":
			loyerMensuel = "1800";
			break;
		case "5":
			loyerMensuel = "2200";
			break;
		case "6":
			loyerMensuel = "2700";
			break;
		}
		return loyerMensuel;
	}


	public void setLoyerMensuel(String loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}


	public int getIdUnites() {
		return idUnites;
	}


	public void setIdUnites(int idUnites) {
		this.idUnites = idUnites;
	}


	public String getTypeUnites() {
		return typeUnites;
	}


	public void setTypeUnites(String typeUnites) {
		this.typeUnites = typeUnites;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getAnneeConstruction() {
		return anneeConstruction;
	}


	public void setAnneeConstruction(String anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
	}


	public String getSuperficie() {
		return superficie;
	}


	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public boolean isDisponibiliter() {
		return disponibiliter;
	}


	public void setDisponibiliter(boolean disponibiliter) {
		this.disponibiliter = disponibiliter;
	}


	public String getProprietaire() {
		return proprietaire;
	}


	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}


	public static int getPrixRemisageMensuel() {
		return prixRemisageMensuel;
	}


	public void setPrixRemisageMensuel(int prixRemisageMensuel) {
		this.prixRemisageMensuel = prixRemisageMensuel;
	}


	public static int getPrixStationnementMensuel() {
		return prixStationnementMensuel;
	}


	public void setPrixStationnementMensuel(int prixStationnementMensuel) {
		this.prixStationnementMensuel = prixStationnementMensuel;
	}
	
    /**
     * m�thode qui r�cup�re les informations des unit�s 
     * et les sauvegarde dans le fichier json.
     */
	@SuppressWarnings("unchecked")
	public  static void CreerUnites (JTextField [] text) {
		String[] coord = new String[12];
		JSONObject obj = new JSONObject();
		
		coord[9] = getLoyerMensuel(text[5].getText());
		coord[10] = String.valueOf(getPrixRemisageMensuel());
		coord[11] = String.valueOf(getPrixStationnementMensuel());
		
	    for (int i = 0; i < text.length; i++) {
	    	if (text[i].getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "<html>Entrez toutes les informations de l'unit�s"); 
	    		break;
	    	} else {
	    		coord[i] = text[i].getText();
	    	}
	        
	    }
	    
	    for (int j = 0; j < coord.length; j++) {
	    	obj.put(infosUnit�s[j], coord[j]);
		}
	    
	    if (obj.containsValue(null)) {
	    	Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		} else if (obj.isEmpty()){
			Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		}else {
			Json.EcrireData(obj, Json.path(getChemin())); // si l'objet n'est pas vide on l'enregistre dans le fichier json
	    	JOptionPane.showMessageDialog(null, "L'unit� "+obj.get("idUnites")+" a �t� bien enregistr�"); // message d'enregistrement
		}
	    

	    // �fface les champs pour entrer de nouvelles donn�es
	    for (int i = 0; i < text.length; i++) {
			text[i].setText("");
		}
	}

	
    /**
     * m�thode qui parcours la liste des unit�s
     * et remplie la liste d�roulante des noms des d�tenteurs de baux 
     */
	@SuppressWarnings("unchecked")
	public static Component RemplirSelection (JComboBox box) {
		JSONArray listeUnites = Json.LireData(Json.path(getChemin()));
		for (int i = 0; i < listeUnites.size(); i++) {
			JSONObject object = (JSONObject) listeUnites.get(i);
			box.addItem(object.get("idUnites"));
		}
		return box;	
	}
	
    /**
     * m�thode qui parcours la liste des unit�s 
     * et remplie les diff�rents champs du menu avec 
     * les donn�es de l'unit� choisi.
     */
	@SuppressWarnings("rawtypes")
	public static void AfficherInfosUnites (Component id, JTextField [] text) {
		JSONArray listeUnites = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeUnites.size(); i++) { 
			object = (JSONObject) listeUnites.get(i);
			if (object.get("idUnites").equals(((JComboBox) id).getSelectedItem().toString())) { // l'unit� s�lectionn�.
				text[0].setText(object.get(infosUnit�s[0]).toString());
				text[1].setText(object.get(infosUnit�s[1]).toString());
				text[2].setText(object.get(infosUnit�s[2]).toString());
				text[3].setText(object.get(infosUnit�s[3]).toString());
				text[4].setText(object.get(infosUnit�s[4]).toString());
				text[5].setText(object.get(infosUnit�s[5]).toString());
				text[6].setText(object.get(infosUnit�s[6]).toString());
				text[7].setText(object.get(infosUnit�s[7]).toString());
				text[8].setText(object.get(infosUnit�s[8]).toString());
				//text[9].setText(object.get(infosUnit�s[9]).toString()); // loyer mensuel
			}
		}
		
	}
	
    /**
     * m�thode qui parcours la liste des unit�s 
     * et modifie les donn�es de l'unit� choisi 
     * avec les nouvelles valeurs saisies
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void ModifierInfosUnites(Component nom, JTextField[] text) {
		JSONArray listeUnites = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		String id = null;
		for (int i = 0; i < listeUnites.size(); i++) {
			object = (JSONObject) listeUnites.get(i);
			if (object.get("idUnites").equals(((JComboBox) nom).getSelectedItem().toString())) { // l'unit� s�lectionn�.
				id = (String) object.get("idUnites");
				Json.SupprimerData(object, Json.path(getChemin())); // supprime les donn�es de l'unit�.
			}
		}
		CreerUnites(text); //recr�e l'unit� choisi avec les nouvelle donn�es saisies.
	}
	
	/**
	 * m�thode qui affiche la liste des unit�s dans une table
	 */
	public static Vector<Vector<String>> AfficherListeUnites() {
		JSONArray listeUnites = Json.LireData(Json.path(getChemin()));
		Vector<Vector<String>> dataList = new Vector<>();
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeUnites.size(); i++) {

			object = (JSONObject) listeUnites.get(i);
			Vector<String> data = new Vector<>(); // liste qui d�finie une ligne du tableau ie les donn�es d'un
													// locataire

			// ajout de chaque donn�es du locataire
			data.add((String) object.get("idUnites"));
			data.add((String) object.get("typeUnites"));
			data.add((String) object.get("adresse"));
			data.add((String) object.get("anneeConstruction"));
			data.add((String) object.get("superficie"));
			data.add((String) object.get("nombrePieces"));
			data.add((String) object.get("condition"));
			data.add((String) object.get("disponibiliter"));
			data.add((String) object.get("proprietaire"));
			data.add((String) object.get("loyerMensuel"));
			data.add((String) object.get("prixRemisageMensuel"));
			data.add((String) object.get("prixStationnementMensuel"));

			dataList.add(data); // ajout des lignes � la liste qui d�finie le tableau

		}
		return dataList;
	}
	
	public static Vector<String> Colonne () {
		Vector<String> nomColonne = new Vector<>(); // liste qui contient le nom de chaque colonne

		nomColonne.add(("Id Unit�"));
		nomColonne.add(("Type Unit�"));
		nomColonne.add(("Adresse"));
		nomColonne.add(("Ann�e de Construction"));
		nomColonne.add(("Superficie"));
		nomColonne.add(("Nombre de Pieces"));
		nomColonne.add(("Condition"));
		nomColonne.add(("Disponibilit�"));
		nomColonne.add(("Proprietaire"));
		nomColonne.add(("Loyer Mensuel"));
		nomColonne.add(("Prix Remisage"));
		nomColonne.add(("Prix Stationnement"));
		
		return nomColonne;
	}	
}
