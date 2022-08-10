package system;

import java.time.LocalDate;

import org.json.simple.JSONObject;

public class Bail_1 {
	
	private long idBail ;
	private LocalDate dateEntree ;
	private LocalDate dateSortie;
	private String idAss ;
	private boolean remise ;
	private boolean revouv;
	private boolean stationnement;
	private Unites_1 unites;
	private Locataire locataire;
	
	
	
	public double loyerTotal () {
		
		double prixremise = this.remise==false?0:this.unites.getPrixRemisageMensuel();
		double prixStationnement = this.stationnement==false?0:this.unites.getPrixStationnementMensuel();
		
		return prixremise + prixStationnement + this.unites.getLoyerMensuel();
	}
	
	
	
	
	
	
	
	
	

	public Bail_1() {
		super();
	}
	
	
	public Bail_1(long idBail, LocalDate dateEntree, LocalDate dateSortie, String idAss, boolean remise, boolean revouv,
			boolean stationnement, Unites_1 unites, Locataire locataire) {
		super();
		this.idBail = idBail;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.idAss = idAss;
		this.remise = remise;
		this.revouv = revouv;
		this.stationnement = stationnement;
		this.unites = unites;
		this.locataire = locataire;
	}


	public long getIdBail() {
		return idBail;
	}
	public void setIdBail(long idBail) {
		this.idBail = idBail;
	}
	public LocalDate getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}
	public LocalDate getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
	public String getIdAss() {
		return idAss;
	}
	public void setIdAss(String idAss) {
		this.idAss = idAss;
	}
	public boolean isRemise() {
		return remise;
	}
	public void setRemise(boolean remise) {
		this.remise = remise;
	}
	public boolean isRevouv() {
		return revouv;
	}
	public void setRevouv(boolean revouv) {
		this.revouv = revouv;
	}
	public boolean isStationnement() {
		return stationnement;
	}
	public void setStationnement(boolean stationnement) {
		this.stationnement = stationnement;
	}
	public Unites_1 getUnites() {
		return unites;
	}
	public void setUnites(Unites_1 unites) {
		this.unites = unites;
	}
	public Locataire getLocataire() {
		return locataire;
	}
	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}
	
	
	

}
