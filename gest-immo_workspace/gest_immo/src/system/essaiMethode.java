package system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import outils.Fonctions;
import outils.Json;

public class essaiMethode {

	private static String chemin = "baux.json";
	public static ArrayList<Object> ListeRenouvProchain (){
		JSONArray listeBail = Json.LireData(Json.path(chemin));
		JSONObject object = new JSONObject();
		
		ArrayList<Object> listeRenouvProch = new ArrayList<>();
		for (int i = 0; i < listeBail.size(); i++) {

			object = (JSONObject) listeBail.get(i);
			LocalDate dateFin = Fonctions.stringEnDate(object.get("dateSortie").toString()) ;
			LocalDate dateRef = dateFin.minusMonths(6);
			if (LocalDate.now().isAfter(dateRef)) { // le locataire sélectionné.
				listeRenouvProch.add(object);
			}
		}
		return listeRenouvProch;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		LocalDate datefin = LocalDate.of(2023, 1, 25);
//		
//		
//		LocalDate dateLim = LocalDate.now().minusMonths(-6);
//		
//		
//		boolean b =datefin.isAfter(dateLim);
//		System.out.println(b);
		for (int i = 1; i < ListeRenouvProchain().size(); i++) {
			
			System.out.println(ListeRenouvProchain().get(i).toString());
		}
		
		
		//DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//String dateString = dateLim.format(formatDate);
		
		
		
		
		
		
		//System.out.println(dateString);
	}

}
