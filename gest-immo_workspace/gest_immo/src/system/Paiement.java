package system;

import java.awt.Component;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import outils.Json;

public class Paiement {
	private static String chemin = "historique_paiement.json";
	private static String [] infosPaiement = {"idBail", "locataire", "mois", "annee", "montantAPayer", "montantPayer"};
	private static String idBail;
	private static String locataire;
	private static String dateEntree;
	private static String dateSortie;
	private static String periode [] = {"janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"};
	private static String annee;
	private static String montantAPayer;
	private static String montantPayer;
	
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
		JSONArray listePaiement = Json.LireData(Json.path(Paiement.getChemin()));
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
     * méthode qui enregistre les paiements de loyer 
     * des locataires.
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void enregistrerPaiement(Component locataire, Component bail, Component mois, Component annee, JTextField[] text) {
		JSONArray listePaiement = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		boolean boolLocataire = object.get("locataire").equals(((JComboBox) locataire).getSelectedItem().toString());
		boolean boolBail = object.get("idBail").equals(((JComboBox) bail).getSelectedItem().toString());
		boolean boolMois = object.get("mois").equals(((JComboBox) mois).getSelectedItem().toString());
		boolean boolAnnee = object.get("annee").equals(((JComboBox) annee).getSelectedItem().toString());
//		String id = null;
//		for (int i = 0; i < listePaiement.size(); i++) {
//			object = (JSONObject) listePaiement.get(i);
//			if ( boolLocataire && boolBail && boolMois && boolAnnee) { // l'unité sélectionné.
//				object.put(infosPaiement[i], text[j]);
//				Json.SupprimerData(object, Json.path(getChemin())); // supprime les données de l'unité.
//			}
//		}
//		//System.out.println(listeLocataire);
//		CreerUnites(text); //recrée l'unité choisi avec les nouvelle données saisies.
//		JOptionPane.showMessageDialog(null, "<html>L'unité "+id+" a été bien modifiée"); 
	}
	
    /**
     * méthode qui parcours la liste des baux 
     * et remplie la liste déroulante des noms des détenteurs de baux 
     */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static Component remplirSelectionPeriode (JComboBox box) {
		for (int i = 0; i < getPeriode().length; i++) {
			box.addItem(getPeriode()[i]);
		}
		return box;	
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

	public static String[] getPeriode() {
		return periode;
	}

	public static void setPeriode(String periode[]) {
		Paiement.periode = periode;
	}
	
    public static String getAnnee() {
		return annee;
	}

	public static void setAnnee(String annee) {
		Paiement.annee = annee;
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

}
