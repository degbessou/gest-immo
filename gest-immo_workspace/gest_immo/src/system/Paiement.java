package system;

import java.awt.Component;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import outils.Json;

public class Paiement {
	private static String chemin = "historique_paiement.json";
	private static String [] infosPaiement = {"locataire", "idBail", "mois", "annee", "montantAPayer", "montantPayer"};
	private static String idBail;
	private static String locataire;
	private static String dateEntree;
	private static String dateSortie;
	private static String mois [] = {"janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"};
	private static String annee [] = {"2021", "2022", "2023" };
	private static String montantAPayer;
	private static String montantPayer;
	
	
	  /**
     * méthode qui enregistre les paiements de loyer 
     * des locataires.
     */
	@SuppressWarnings("unchecked")
	public  static void enregistrementPaiement (JComboBox boxLocataire, JComboBox boxBail, JComboBox boxMois, JComboBox boxAnnee,JTextField text) {
		String[] coord = new String[6];
		JSONObject obj = new JSONObject();
		
		coord[0] = ((JComboBox) boxLocataire).getSelectedItem().toString();
		coord[1] = ((JComboBox) boxBail).getSelectedItem().toString();
		coord[2] = ((JComboBox) boxMois).getSelectedItem().toString();
		coord[3] = ((JComboBox) boxAnnee).getSelectedItem().toString();
		coord[4] = "test";
		coord[5] = text.getText();	    
	    
	    for (int j = 0; j < coord.length; j++) { // parcourt les données recueillies 
	    	if (coord [j] == "" || coord [j] == null) { 
				break; // la boucle s'arrêtte si des données vides sont rencontrées
			} else {
				obj.put(infosPaiement[j], coord[j]); // sinon on sauvegarge ca dans un objet Json
			}
		}
	    
	    if (!obj.isEmpty()) {
	    	Json.EcrireData(obj, Json.path(getChemin())); // si l'objet n'est pas vide on l'enregistre dans le fichier json
	    	JOptionPane.showMessageDialog(null, "<html>Le bail "+obj.get("idBail")+" de "+obj.get("locataire")+"a été bien enregistré"); // message d'enregistrement
		} else {
			Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		}
	    
	 // Éfface les champs pour entrer de nouvelles données
		text.setText(""); 
		
	}

    /**
     * méthode qui parcours la liste des baux 
     * et remplie la liste déroulante des noms des détenteurs de baux 
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Component remplirSelectionLocataire (JComboBox box) {
		JSONArray listeLocataire = Json.LireData(Json.path(Bail.getChemin()));
		for (int i = 0; i < listeLocataire.size(); i++) {
			JSONObject object = (JSONObject) listeLocataire.get(i);
			box.addItem(object.get("locataire"));
		}
		return box;	
	}
	


	/**
     * méthode qui parcours la liste des baux 
     * et remplie la liste déroulante des baux détenus par le locataire sélectionné
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Component remplirSelectionBail (JComboBox boxLocataire, JComboBox boxBail) {
		JSONArray listePaiement = Json.LireData(Json.path(Bail.getChemin()));
		for (int i = 0; i < listePaiement.size(); i++) {
			JSONObject object = (JSONObject) listePaiement.get(i);
			if (((JComboBox) boxLocataire).getSelectedItem().toString().equals(object.get("locataire"))) {
				if (boxBail.getItemCount() == 0) {
					boxBail.addItem(object.get("idBail"));
				} else {
					boxBail.removeAllItems();
					boxBail.addItem(object.get("idBail"));
				}
				
			}
			
		}
		return boxBail;	
	}
	
	
    /**
     * méthode qui parcours la liste des baux 
     * et remplie la liste déroulante des noms des détenteurs de baux 
     */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static Component remplirSelectionMois (JComboBox box) {
		for (int i = 0; i < getMois().length; i++) {
			box.addItem(getMois()[i]);
		}
		return box;	
	}
	
    /**
     * méthode qui parcours la liste des baux 
     * et remplie la liste déroulante des noms des détenteurs de baux 
     */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static Component remplirSelectionAnnee (JComboBox box) {
		for (int i = 0; i < getAnnee().length; i++) {
			box.addItem(getAnnee()[i]);
		}
		return box;	
	}
	
	/**
	 * méthode qui affiche l'hstorique de paiement dans une table
	 */
	public static Component AfficherHistoriquePaiement() {
		JSONArray listePaiement = Json.LireData(Json.path(getChemin()));
		Vector<Vector<String>> dataList = new Vector<>();
		JSONObject object = new JSONObject();
		for (int i = 0; i < listePaiement.size(); i++) {

			object = (JSONObject) listePaiement.get(i);
			Vector<String> data = new Vector<>(); // liste qui définie une ligne du tableau ie les données d'un
													// locataire

			// ajout de chaque données du locataire
			data.add((String) object.get("locataire"));
			data.add((String) object.get("idBail"));
			data.add((String) object.get("mois"));
			data.add((String) object.get("annee"));
			data.add((String) object.get("montantAPayer"));
			data.add((String) object.get("montantPayer"));

			dataList.add(data); // ajout des lignes à la liste qui définie le tableau

		}

		Vector<String> nomColonne = new Vector<>(); // liste qui contient le nom de chaque colonne

		nomColonne.add(("Locataire"));
		nomColonne.add(("Numéro du bail"));
		nomColonne.add(("Mois"));
		nomColonne.add(("Année"));
		nomColonne.add(("montant à Payer"));
		nomColonne.add(("montant Payer"));

		JTable table = new JTable(dataList, nomColonne); // table à afficher
		return table;
	}
	
	public static String getChemin() {
		return chemin;
	}
	public static void setChemin(String chemin) {
		Paiement.chemin = chemin;
	}

	public static String getIdBail() {
		return idBail;
	}
	public static void setIdBail(String idBail) {
		Paiement.idBail = idBail;
	}
	public static String getLocataire() {
		return locataire;
	}
	public static void setLocataire(String locataire) {
		Paiement.locataire = locataire;
	}
	public static String getDateEntree() {
		return dateEntree;
	}
	public static void setDateEntree(String dateEntree) {
		Paiement.dateEntree = dateEntree;
	}
	public static String getDateSortie() {
		return dateSortie;
	}
	public static void setDateSortie(String dateSortie) {
		Paiement.dateSortie = dateSortie;
	}

	public static String getMontantAPayer() {
		return montantAPayer;
	}

	public static void setMontantAPayer(String montantAPayer) {
		Paiement.montantAPayer = montantAPayer;
	}

	public static String getMontantPayer() {
		return montantPayer;
	}

	public static void setMontantPayer(String montantPayer) {
		Paiement.montantPayer = montantPayer;
	}
	
	public static String[] getAnnee() {
		return annee;
	}

	public static void setAnnee(String[] annee) {
		Paiement.annee = annee;
	}

	public static String[] getMois() {
		return mois;
	}

	public static void setMois(String[] mois) {
		Paiement.mois = mois;
	}
	
	

}
