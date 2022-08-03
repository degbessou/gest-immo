package test;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Test1 {
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("nom d'utilisateur : ");
		String a = input.next();

	    JSONParser parser = new JSONParser();
	    JSONArray tab = new JSONArray();
	    Object obj = null;
	    try {
	    	FileReader file = new FileReader("D:\\coding\\app\\inf1163 projet\\gest-immo_workspace\\gest_immo\\Target\\employer.json");
	        obj = parser.parse(file);
	        tab = (JSONArray) obj;

	        for(int i = 0 ; i< tab.size() ;i++){
	            JSONObject object = (JSONObject) tab.get(i);
	            //System.out.println(object);
				if (object.get("nom").equals(a)) {
					System.out.println("yessir");
					break;
				} else {
					//System.out.println("false");
				}
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    input.close();
	}
	

}

