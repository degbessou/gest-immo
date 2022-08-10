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

	private Bail bail;
	private Locataire locataire;
	private int montantPayer;
	private static String mois [] = {"janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"};
	private static String annee [] = {"2021", "2022", "2023" };
	private static String chemin = "historique_paiement.json";
	private static String [] infosPaiement = {"locataire", "idBail", "mois", "annee", "montantPayer"};

	public Paiement() {
		super();
	}

	public Paiement(Bail bail, Locataire locataire, int montantPayer) {
		super();
		this.bail = bail;
		this.locataire = locataire;
		this.montantPayer = montantPayer;
	}

	
	public static String getChemin() {
		return chemin;
	}

	public static void setChemin(String chemin) {
		Paiement.chemin = chemin;
	}
	
	public Bail getBail() {
		return bail;
	}

	public void setBail(Bail bail) {
		this.bail = bail;
	}

	public Locataire getLocataire() {
		return locataire;
	}

	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}

	public int getMontantPayer() {
		return montantPayer;
	}

	public void setMontantPayer(int montantPayer) {
		this.montantPayer = montantPayer;
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
	
	/**
	 * m�thode qui enregistre les paiements de loyer des locataires.
	 * @param boxLocataire
	 * @param boxBail
	 * @param boxMois
	 * @param boxAnnee
	 * @param text
	 */
	@SuppressWarnings("unchecked")
	public  static void enregistrementPaiement (JComboBox boxLocataire, JComboBox boxBail, JComboBox boxMois, JComboBox boxAnnee,JTextField text) {
		String[] coord = new String[6];
		JSONObject obj = new JSONObject();
		
		coord[0] = ((JComboBox) boxLocataire).getSelectedItem().toString();
		coord[1] = ((JComboBox) boxBail).getSelectedItem().toString();
		coord[2] = ((JComboBox) boxMois).getSelectedItem().toString();
		coord[3] = ((JComboBox) boxAnnee).getSelectedItem().toString();
		coord[4] = text.getText();	    
	    
	    for (int j = 0; j < coord.length; j++) { // parcourt les donn�es recueillies 
	    	if (coord [j] == "" || coord [j] == null) { 
				break; // la boucle s'arr�tte si des donn�es vides sont rencontr�es
			} else {
				obj.put(infosPaiement[j], coord[j]); // sinon on sauvegarge ca dans un objet Json
			}
		}
	    
	    if (!obj.isEmpty()) {
	    	Json.EcrireData(obj, Json.path(getChemin())); // si l'objet n'est pas vide on l'enregistre dans le fichier json
	    	JOptionPane.showMessageDialog(null, "<html>Le bail "+obj.get("idBail")+" de "+obj.get("locataire")+"a �t� bien enregistr�"); // message d'enregistrement
		} else {
			Json.SupprimerData(obj, Json.path(getChemin()));	// on supprime l'objet json
		}
	    
	    // �fface les champs pour entrer de nouvelles donn�es
		text.setText(""); 
		
	}

	/**
	 * m�thode qui parcours la liste des baux et remplie 
	 * la liste d�roulante des noms des d�tenteurs de bail
	 * 
	 * @param box
	 * @return
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
	 * m�thode qui parcours la liste des baux et remplie 
	 * la liste d�roulante des baux d�tenus par le locataire s�lectionn�
	 * @param boxLocataire
	 * @param boxBail
	 * @return
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
	 * m�thode qui parcours la liste des baux et remplie 
	 * la liste d�roulante des noms des d�tenteurs de bail 
	 * 
	 * @param box
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static Component remplirSelectionMois (JComboBox box) {
		for (int i = 0; i < getMois().length; i++) {
			box.addItem(getMois()[i]);
		}
		return box;	
	}
	
	/**
	 * m�thode qui parcours la liste des baux et 
	 * remplie la liste d�roulante des noms des d�tenteurs de baux 
	 * 
	 * @param box
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static Component remplirSelectionAnnee (JComboBox box) {
		for (int i = 0; i < getAnnee().length; i++) {
			box.addItem(getAnnee()[i]);
		}
		return box;	
	}
	
	/**
	 * m�thode qui affiche l'hstorique de paiement dans une table
	 * @return
	 */
	public static Vector<Vector<String>> AfficherHistoriquePaiement() {
		JSONArray listePaiement = Json.LireData(Json.path(getChemin()));
		Vector<Vector<String>> dataList = new Vector<>();
		JSONObject object = new JSONObject();
		for (int i = 0; i < listePaiement.size(); i++) {

			object = (JSONObject) listePaiement.get(i);
			Vector<String> data = new Vector<>(); // liste qui d�finie une ligne du tableau ie les donn�es d'un
													// locataire

			// ajout de chaque donn�es du locataire
			data.add((String) object.get("locataire"));
			data.add((String) object.get("idBail"));
			data.add((String) object.get("mois"));
			data.add((String) object.get("annee"));
			data.add((String) object.get("montantPayer"));

			dataList.add(data); // ajout des lignes � la liste qui d�finie le tableau

		}
		return dataList;
	}
	
	/**
	 * m�thode qui affiche le nom des colonnes de la liste 
	 * @return Vector
	 */
	public static Vector<String> Colonne () {
		Vector<String> nomColonne = new Vector<>(); // liste qui contient le nom de chaque colonne

		nomColonne.add(("Locataire"));
		nomColonne.add(("Num�ro du bail"));
		nomColonne.add(("Mois"));
		nomColonne.add(("Ann�e"));
		nomColonne.add(("montant Payer"));
		
		return nomColonne;
	}

}
