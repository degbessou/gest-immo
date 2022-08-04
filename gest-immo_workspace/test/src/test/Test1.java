package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Test1 {
//	public static String path (String nomFichier) {
//		return "D:\\coding\\app\\inf1163 projet\\gest-immo_workspace\\gest_immo\\Target\\"+nomFichier;
//	}
	
	private static String [] infosLocataire = {"nom", "prenom", "adresse", "telephone", "typeLocataire", "typeUnites", "coteCredit"};
	
//	public  static void InscrireClient (String [] text) {
//		String[] coord = new String[2];
//		JSONObject obj = new JSONObject();
//	    for (int i = 0; i < text.length; i++)
//	    {
//	        coord[i] = text[i];
//	    }
//	    System.out.println(coord);
//	    
//	    for (int i = 0; i < coord.length; i++) {
//		    obj.put(infosLocataire[i], coord[i]);
//		}
//	    
//	    System.out.println(obj);
//	    json.EcrireData(obj, json.path("Locataire2.json"));
//	}
	
//	@SuppressWarnings({ "unlikely-arg-type", "unchecked" })
	public  static void modClient () {
//		String[] coord = new String[2];
//		String[] id = {"nom", "prenom"} ;
		//JSONObject obj = new JSONObject();
		
		try {
			FileReader reader = new FileReader(json.path("test.json"));
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			System.out.println(jsonObject);
			
			JSONArray jsonArray = (JSONArray)jsonObject.get("1");
			System.out.println(jsonArray);
		    JSONObject jsonObject1 = ((JSONObject)(jsonArray).get(0));
		    jsonObject1.put("name", "abc");
		    System.out.println(jsonObject.toJSONString());
			
	            
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public static void main(String args[]) {
		
//		Scanner input = new Scanner(System.in);
//		System.out.println("nom d'utilisateur : ");
//		String a = input.next();
//
//	    JSONParser parser = new JSONParser();
//	    JSONArray tab = new JSONArray();
//	    Object obj = null;
//	    try {
//	    	FileReader file = new FileReader("D:\\coding\\app\\inf1163 projet\\gest-immo_workspace\\gest_immo\\Target\\employer.json");
//	        obj = parser.parse(file);
//	        tab = (JSONArray) obj;
//
//	        for(int i = 0 ; i< tab.size() ;i++){
//	            JSONObject object = (JSONObject) tab.get(i);
//	            //System.out.println(object);
//				if (object.get("nom").equals(a)) {
//					System.out.println("yessir");
//					break;
//				} else {
//					//System.out.println("false");
//				}
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    
//	    input.close();
		
//		Scanner input = new Scanner(System.in);
//		String[] coord = new String[2];
//		String[] id = {"nom", "prenom"} ;
//	    for (int i = 0; i < coord.length; i++)
//	    {
//	        System.out.println("Please enter your : "+id[i]);
//	        coord[i] = input.nextLine();
//	    }
//	    
	    modClient();

//
//	    JSONParser parser = new JSONParser();
//	    JSONArray tab = new JSONArray();
//	    JSONObject obj = new JSONObject();
//	    try {
//			FileReader file = new FileReader(path("Locataire2.json"));
//			tab = (JSONArray) parser.parse(file);
//	    } catch (Exception e) {
//			e.printStackTrace();
//		}
//	    for (int i = 0; i < coord.length; i++) {
//		    obj.put(id[i], coord[i]);
//		}
//
//	    tab.add(obj);
//	    
//	    try {
//	    	FileWriter file = new FileWriter(path("Locataire2.json"));
//	    	file.write(tab.toJSONString());
//	    	file.close();
////	        obj = parser.parse(file);
////	        tab = (JSONArray) obj;
//
////	        for(int i = 0 ; i< tab.size() ;i++){
////	            JSONObject object = (JSONObject) tab.get(i);
////	            //System.out.println(object);
////				if (object.get("nom").equals(a)) {
////					System.out.println("yessir");
////					break;
////				} else {
////					//System.out.println("false");
////				}
////	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
	    
//	    input.close();
	}
	

}

