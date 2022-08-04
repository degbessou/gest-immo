package test;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class json {
	public static String path (String nomFichier) {
		return "D:\\coding\\app\\inf1163 projet\\gest-immo_workspace\\gest_immo\\Target\\"+nomFichier; // chemin d'accés à modifier selon le répertoire du projet chez l'utilisateur
	}
	public static JSONArray LireData (String chemin) {
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
	
	public static void EcrireData (JSONObject object, String chemin) {
		JSONParser parser = new JSONParser();
	    JSONArray tab = new JSONArray();
	    
	    try {
			FileReader file = new FileReader(chemin);
			tab = (JSONArray) parser.parse(file);
			
	    } catch (Exception e) {
			e.printStackTrace();
		}
	    
	    tab.add(object);
	    System.out.println(tab);
	    
	    try {
	    	FileWriter file = new FileWriter(chemin);
	    	file.write(tab.toJSONString());
	    	System.out.println(tab.toJSONString());
	    	file.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
