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
     * m�thode qui r�cup�re les informations du locataire 
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
	    // �fface les champs pour entrer de nouvelles donn�es
	    for (int i = 0; i < text.length; i++) {
			text[i].setText("");
		}
	}
	
    /**
     * m�thode qui v�rifie que les informations du locataire 
     * ont �t� bien sauvegard�es dans le fichier json.
     */
	public static boolean V�rificationInscriptionLocataire (JTextField nom) {
		// parcours le fichier json � la recherche des identifiants entr�s par l'utilisateur
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		for (int i = 0; i < listeLocataire.size(); i++) { 
			JSONObject object = (JSONObject) listeLocataire.get(i);
			
			if (object.get("nom").equals(nom.getText())) { 
				JOptionPane.showMessageDialog(null, "<html>Le locataire "+nom.getText()+" a �t� bien enregistr�"); // popup de succ�s si le nom entr� est trouv� dans le json � la fin de l'it�ration
				return true;
				
			} else if(i == listeLocataire.size()-1){
				JOptionPane.showMessageDialog(null, "<html>�chec de l'inscription du locataire <br/> �ssayer de nouveau"); // popup de d'�chec si le nom entr� n'est pas trouv� dans le json � la fin de l'it�ration
			}
		}
		return false;
	}
	
    /**
     * m�thode qui parcours la liste des locataire 
     * et remplie la liste d�roulante des noms des locataires 
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
     * m�thode qui parcours la liste des locataires 
     * et remplie les diff�rents champs du menu avec 
     * les donn�es du locataire choisi.
     */
	@SuppressWarnings("rawtypes")
	public static void afficherInfosLocataire (Component nom, JTextField [] text) {
		JSONArray listeLocataire = Json.LireData(Json.path(getChemin()));
		JSONObject object = new JSONObject();
		for (int i = 0; i < listeLocataire.size(); i++) { 
			object = (JSONObject) listeLocataire.get(i);
			if (object.get("nom").equals(((JComboBox) nom).getSelectedItem().toString())) { // le locataire s�lectionn�.
				for (int j = 0; j < object.size(); j++) { // parcours les informations du locataire
					text[j].setText(object.get(infosLocataire[j]).toString()); // remplie les champs du menu avec les informations du locataire s�lectionn�.
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
			if (object.get("nom").equals(((JComboBox) nom).getSelectedItem().toString())) { // le locataire s�lectionn�.
				Json.SupprimerData(object, Json.path(getChemin()));
			}
		}
		System.out.println(listeLocataire);
		InscrireClient(text);
		

//		// �fface les champs pour entrer de nouvelles don�es
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
