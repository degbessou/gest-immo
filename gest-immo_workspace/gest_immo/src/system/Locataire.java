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
	//private static JSONArray listeLocataire = Json.LireData(Json.path(getChemin())); 
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
	    		JOptionPane.showMessageDialog(null, "<html>Entrez toutes les informations du locataire"); 
	    		break;
	    	}
	        coord[i] = text[i].getText();
	    }
	    
	    for (int i = 0; i < coord.length; i++) {
		    obj.put(infosLocataire[i], coord[i]);
		}
	    
	    Json.EcrireData(obj, Json.path(getChemin()));
	    // Éfface les champs pour entrer de nouvelles données
	    for (int i = 0; i < text.length; i++) {
			text[i].setText("");
		}
	}
	
    /**
     * méthode qui vérifie que les informations du locataire 
     * ont été bien sauvegardées dans le fichier json.
     */
	public static boolean VérificationInscriptionLocataire (JTextField nom) {
		// parcours le fichier json à la recherche des identifiants entrés par l'utilisateur
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		for (int i = 0; i < listeLocataire.size(); i++) { 
			JSONObject object = (JSONObject) listeLocataire.get(i);
			if (object.get("nom").equals(nom.getText())) { 
				JOptionPane.showMessageDialog(null, "<html>Le Locataire "+nom.getText()+" a été bien enregistré"); // popup de succès si le nom entré est trouvé dans le json à la fin de l'itération
				return true;
				
			} else if(i == listeLocataire.size()-1){
				JOptionPane.showMessageDialog(null, "<html>Échec de l'inscription du locataire <br/> Éssayer de nouveau"); // popup de d'échec si le nom entré n'est pas trouvé dans le json à la fin de l'itération
			}
		}
		return false;
	}
	
    /**
     * méthode qui parcours la liste des locataire 
     * et remplie la liste déroulante des noms des locataires 
     */
	public static Component remplirSelection (JComboBox box) {
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		for (int i = 0; i < listeLocataire.size(); i++) {
			JSONObject object = (JSONObject) listeLocataire.get(i);
			box.addItem(object.get("nom"));
		}
		return box;
		
		
	}
	
	public static Component remplirFiltreAffichage(JComboBox box) {
		List<Integer> nombreAafficher = new ArrayList<Integer>();
		for (int i = 0; i < 15; i += 5) {
			nombreAafficher.add(i);
		}

		for (int i = 0; i < nombreAafficher.size(); i++) {
			box.addItem(nombreAafficher.get(i));
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void modifierInfosLocataire(Component nom, JTextField[] text) {
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeLocataire.size(); i++) {
			object = (JSONObject) listeLocataire.get(i);
			if (object.get("nom").equals(((JComboBox) nom).getSelectedItem().toString())) { // le locataire sélectionné.
				System.out.println(object);
				Json.SupprimerData(object, Json.path(getChemin()));
			}
		}
		System.out.println(listeLocataire);
		InscrireClient(text);
		

//		// Éfface les champs pour entrer de nouvelles donées
//		for (int i = 0; i < text.length; i++) {
//			text[i].setText("");
//		}
	}

	public static String getChemin() {
		return chemin;
	}

	public static void setChemin(String chemin) {
		Locataire.chemin = chemin;
	}
	
	public static Component afficherListeLocataire() {
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		Vector<Vector<String>> dataList = new Vector<>();
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeLocataire.size(); i++) {

			object = (JSONObject) listeLocataire.get(i);
			Vector<String> data = new Vector<>();

			data.add((String) object.get("nom"));
			data.add((String) object.get("prenom"));
			data.add((String) object.get("adresse"));
			data.add((String) object.get("telephone"));
			data.add((String) object.get("typeLocataire"));
			data.add((String) object.get("typeUnites"));
			data.add(String.valueOf(object.get("coteCredit")));

			dataList.add(data);

		}

		Vector<String> nomColonne = new Vector<>();
		nomColonne.add("nom");
		nomColonne.add("prenom");
		nomColonne.add("adresse");
		nomColonne.add("telephone");
		nomColonne.add("typeLocataire");
		nomColonne.add("typeUnites");
		nomColonne.add("coteCredit");

		JTable table = new JTable(dataList, nomColonne);
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
	
	
	
	



}
