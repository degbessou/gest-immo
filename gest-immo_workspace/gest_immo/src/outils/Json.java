package outils;

import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Json {
	
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
	
	

}
