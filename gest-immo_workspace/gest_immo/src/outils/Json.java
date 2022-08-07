package outils;

import java.awt.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComboBox;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Json {
	
    /**
     * méthode qui définie le chemin d,accès aux fichiers json 
     * dans une table
     */
	public static String path (String nomFichier) {
		return "D:\\coding\\app\\inf1163 projet\\gest-immo_workspace\\gest_immo\\Target\\"+nomFichier; // chemin d'accés à modifier selon le répertoire du projet chez l'utilisateur
	}
	
    /**
     * méthode qui permet de lire les données d'un fichier json 
     * 
     */
	public static JSONArray LireData(String chemin) {
		JSONParser parser = new JSONParser();
		JSONArray tab = new JSONArray();
		Object obj = null;
		try {
			FileReader file = new FileReader(chemin);
			obj = parser.parse(file);
			tab = (JSONArray) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tab;
	}
	
    /**
     * méthode qui permet d'écrire des données dans un fichier json 
     * 
     */
	public static void EcrireData(JSONObject object, String chemin) {
		JSONParser parser = new JSONParser();
		JSONArray tab = new JSONArray();

		try {
			FileReader file = new FileReader(chemin);
			tab = (JSONArray) parser.parse(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		tab.add(object);

		try {
			FileWriter file = new FileWriter(chemin);
			file.write(tab.toJSONString());
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
    /**
     * méthode qui permet de supprimer les données d'un fichier json 
     * 
     */
	@SuppressWarnings("unchecked")
	public static void SupprimerData (JSONObject object, String chemin) {
		JSONParser parser = new JSONParser();
		JSONArray tab = new JSONArray();

		try {
			FileReader file = new FileReader(chemin);
			tab = (JSONArray) parser.parse(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		tab.remove(object);

		try {
			FileWriter file = new FileWriter(chemin);
			file.write(tab.toJSONString());
			//System.out.println(tab.toJSONString());
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	   /**
     * méthode qui remlie la liste déroulante  
     * de valeur qui determineront le nombre d'élément à afficher
     */
	public static Component remplirFiltreAffichage(JComboBox box) {
		List<Integer> nombreAafficher = new ArrayList<Integer>();
		// crée les valeurs puis les stock dans une liste
		for (int i = 0; i < 15; i += 5) {
			nombreAafficher.add(i); 
		}

		for (int i = 0; i < nombreAafficher.size(); i++) {
			box.addItem(nombreAafficher.get(i)); // ajoute les valeurs à la liste déroulante
		}
		return box;
	}
	
    /**
     * méthode qui génère un nomdre
     * 
     */
	public static String NumeroId () {
		Random rand = new Random();

		// Renvoi un nombre entre [10 - 99].
		int n = rand.nextInt(100-10)+10;
		return String.valueOf(n);
	}
	

}
