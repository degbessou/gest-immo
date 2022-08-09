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
	private static String chemin = "unités.json";


	private static String [] infosUnités = {"idUnites", "typeUnites", "adresse", "anneeConstruction", "superficie", "nombrePieces", "condition", "disponibiliter", "proprietaire", "loyerMensuel", "prixRemisageMensuel", "prixStationnementMensuel"};
	private static String idUnites;
	private static String typeUnites;
	private static String adresse;
	private static String anneeConstruction;
	private static String superficie;
	private static String nombrePieces;
	private static String condition;
	private static String disponibiliter;
	private static String proprietaire;
	private static String loyerMensuel;
	private static String prixRemisageMensuel = "75";
	private static String prixStationnementMensuel = "100";
	
    /**
     * méthode qui récupère les informations du locataire 
     * et les sauvegarde dans le fichier json.
     */
	public  static void CreerUnites (JTextField [] text) {
		String[] coord = new String[12];
		JSONObject obj = new JSONObject();
		
		coord[9] = getLoyerMensuel(text[5]);
		coord[10] = getPrixRemisageMensuel();
		coord[11] = getPrixStationnementMensuel();
		
	    for (int i = 0; i < text.length; i++) {
	    	if (text[i].getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "<html>Entrez toutes les informations de l'unités"); 
	    		break;
	    	} else {
	    		coord[i] = text[i].getText();
	    	}
	        
	    }
	    
	    
	    for (int j = 0; j < coord.length; j++) {
	    	if (coord [j] == "" || coord [j] == null) {
				break;
			} else {
				obj.put(infosUnités[j], coord[j]);
			}
		}
	    
	    if (!obj.isEmpty()) {
	    	Json.EcrireData(obj, Json.path(getChemin()));
	    	JOptionPane.showMessageDialog(null, "<html>Le bail de "+obj.get("idUnites")+" a été bien enregistré"); 
		} else {
			Json.SupprimerData(obj, Json.path(getChemin()));	
		}
	    

	    // Éfface les champs pour entrer de nouvelles données
	    for (int i = 0; i < text.length; i++) {
			text[i].setText("");
		}
	}

	
    /**
     * méthode qui parcours la liste des unités
     * et remplie la liste déroulante des noms des détenteurs de baux 
     */
	public static Component RemplirSelection (JComboBox box) {
		JSONArray listeUnites = Json.LireData(Json.path(getChemin()));
		for (int i = 0; i < listeUnites.size(); i++) {
			JSONObject object = (JSONObject) listeUnites.get(i);
			box.addItem(object.get("idUnites"));
		}
		return box;	
	}
	
    /**
     * méthode qui parcours la liste des unités 
     * et remplie les différents champs du menu avec 
     * les données de l'unité choisi.
     */
	@SuppressWarnings("rawtypes")
	public static void AfficherInfosUnites (Component id, JTextField [] text) {
		JSONArray listeUnites = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeUnites.size(); i++) { 
			object = (JSONObject) listeUnites.get(i);
			if (object.get("idUnites").equals(((JComboBox) id).getSelectedItem().toString())) { // l'unité sélectionné.
				text[0].setText(object.get(infosUnités[0]).toString());
				text[1].setText(object.get(infosUnités[1]).toString());
				text[2].setText(object.get(infosUnités[2]).toString());
				text[3].setText(object.get(infosUnités[3]).toString());
				text[4].setText(object.get(infosUnités[4]).toString());
				text[5].setText(object.get(infosUnités[5]).toString());
				text[6].setText(object.get(infosUnités[6]).toString());
				text[7].setText(object.get(infosUnités[7]).toString());
				text[8].setText(object.get(infosUnités[8]).toString());
				//text[9].setText(object.get(infosUnités[9]).toString()); // loyer mensuel
			}
		}
		
	}
	
    /**
     * méthode qui parcours la liste des unités 
     * et modifie les données de l'unité choisi 
     * avec les nouvelles valeurs saisies
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void ModifierInfosUnites(Component nom, JTextField[] text) {
		JSONArray listeUnites = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		String id = null;
		for (int i = 0; i < listeUnites.size(); i++) {
			object = (JSONObject) listeUnites.get(i);
			if (object.get("idUnites").equals(((JComboBox) nom).getSelectedItem().toString())) { // l'unité sélectionné.
				id = (String) object.get("idUnites");
				Json.SupprimerData(object, Json.path(getChemin())); // supprime les données de l'unité.
			}
		}
		//System.out.println(listeLocataire);
		CreerUnites(text); //recrée l'unité choisi avec les nouvelle données saisies.
		JOptionPane.showMessageDialog(null, "<html>L'unité "+id+" a été bien modifiée"); 
	}
	
	/**
	 * méthode qui affiche la liste des baux dans une table
	 */
	public static Component AfficherListeUnites() {
		JSONArray listeUnites = Json.LireData(Json.path(getChemin()));
		Vector<Vector<String>> dataList = new Vector<>();
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeUnites.size(); i++) {

			object = (JSONObject) listeUnites.get(i);
			Vector<String> data = new Vector<>(); // liste qui définie une ligne du tableau ie les données d'un
													// locataire

			// ajout de chaque données du locataire
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

			dataList.add(data); // ajout des lignes à la liste qui définie le tableau

		}

		Vector<String> nomColonne = new Vector<>(); // liste qui contient le nom de chaque colonne

		nomColonne.add(("Id Unité"));
		nomColonne.add(("Type Unité"));
		nomColonne.add(("Adresse"));
		nomColonne.add(("Année de Construction"));
		nomColonne.add(("Superficie"));
		nomColonne.add(("Nombre de Pieces"));
		nomColonne.add(("Condition"));
		nomColonne.add(("Disponibilité"));
		nomColonne.add(("Proprietaire"));
		nomColonne.add(("Loyer Mensuel"));
		nomColonne.add(("Prix Remisage"));
		nomColonne.add(("Prix Stationnement"));

		JTable table = new JTable(dataList, nomColonne); // table à afficher
		return table;
	}

	public static String getChemin() {
		return chemin;
	}

	public static void setChemin(String chemin) {
		Unites.chemin = chemin;
	}
	
	public static String[] getInfosUnités() {
		return infosUnités;
	}

	public static void setInfosUnités(String[] infosUnités) {
		Unites.infosUnités = infosUnités;
	}

	public static String getIdUnites() {
		return idUnites;
	}

	public static void setIdUnites(String idUnites) {
		Unites.idUnites = idUnites;
	}

	public static String getTypeUnites() {
		return typeUnites;
	}

	public static void setTypeUnites(String typeUnites) {
		Unites.typeUnites = typeUnites;
	}

	public static String getAdresse() {
		return adresse;
	}

	public static void setAdresse(String adresse) {
		Unites.adresse = adresse;
	}

	public static String getAnneeConstruction() {
		return anneeConstruction;
	}

	public static void setAnneeConstruction(String anneeConstruction) {
		Unites.anneeConstruction = anneeConstruction;
	}

	public static String getSuperficie() {
		return superficie;
	}

	public static void setSuperficie(String superficie) {
		Unites.superficie = superficie;
	}

	public static String getNombrePieces() {
		return nombrePieces;
	}

	public static void setNombrePieces(String nombrePieces) {
		Unites.nombrePieces = nombrePieces;
	}

	public static String getCondition() {
		return condition;
	}

	public static void setCondition(String condition) {
		Unites.condition = condition;
	}

	public static String getDisponibiliter() {
		return disponibiliter;
	}

	public static void setDisponibiliter(String disponibiliter) {
		Unites.disponibiliter = disponibiliter;
	}

	public static String getProprietaire() {
		return proprietaire;
	}

	public static void setProprietaire(String proprietaire) {
		Unites.proprietaire = proprietaire;
	}

	public static String getLoyerMensuel(JTextField nbreP) {
		switch (nbreP.getText()) {
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

	public static void setLoyerMensuel(String loyerMensuel) {
		Unites.loyerMensuel = loyerMensuel;
	}

	public static String getPrixRemisageMensuel() {
		return prixRemisageMensuel;
	}

	public static void setPrixRemisageMensuel(String prixRemisageMensuel) {
		Unites.prixRemisageMensuel = prixRemisageMensuel;
	}

	public static String getPrixStationnementMensuel() {
		return prixStationnementMensuel;
	}

	public static void setPrixStationnementMensuel(String prixStationnementMensuel) {
		Unites.prixStationnementMensuel = prixStationnementMensuel;
	}
	
	
}
