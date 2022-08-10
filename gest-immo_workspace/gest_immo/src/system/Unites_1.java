package system;

public class Unites_1 {
	private  int idUnites;
	private  String typeUnites;
	private  String adresse;
	private  String anneeConstruction;
	private  String superficie;
	private  int nombrePieces;
	private  String condition;
	private  boolean disponibiliter;
	private  String proprietaire;
	private  double loyerMensuel;
	private  double prixRemisageMensuel ;
	
	
	public Unites_1() {
		super();
	}
	
	public Unites_1(int idUnites, String typeUnites, String adresse, String anneeConstruction, String superficie,
			int nombrePieces, String condition, boolean disponibiliter, String proprietaire, double loyerMensuel,
			double prixRemisageMensuel, double prixStationnementMensuel) {
		super();
		this.idUnites = idUnites;
		this.typeUnites = typeUnites;
		this.adresse = adresse;
		this.anneeConstruction = anneeConstruction;
		this.superficie = superficie;
		this.nombrePieces = nombrePieces;
		this.condition = condition;
		this.disponibiliter = disponibiliter;
		this.proprietaire = proprietaire;
		this.loyerMensuel = loyerMensuel;
		this.prixRemisageMensuel = prixRemisageMensuel;
		this.prixStationnementMensuel = prixStationnementMensuel;
	}
	public int getIdUnites() {
		return idUnites;
	}
	public void setIdUnites(int idUnites) {
		this.idUnites = idUnites;
	}
	public String getTypeUnites() {
		return typeUnites;
	}
	public void setTypeUnites(String typeUnites) {
		this.typeUnites = typeUnites;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAnneeConstruction() {
		return anneeConstruction;
	}
	public void setAnneeConstruction(String anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
	}
	public String getSuperficie() {
		return superficie;
	}
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	public int getNombrePieces() {
		return nombrePieces;
	}
	public void setNombrePieces(int nombrePieces) {
		this.nombrePieces = nombrePieces;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public boolean isDisponibiliter() {
		return disponibiliter;
	}
	public void setDisponibiliter(boolean disponibiliter) {
		this.disponibiliter = disponibiliter;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public double getLoyerMensuel() {
		return loyerMensuel;
	}
	public void setLoyerMensuel(double loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}
	public double getPrixRemisageMensuel() {
		return prixRemisageMensuel;
	}
	public void setPrixRemisageMensuel(double prixRemisageMensuel) {
		this.prixRemisageMensuel = prixRemisageMensuel;
	}
	public double getPrixStationnementMensuel() {
		return prixStationnementMensuel;
	}
	public void setPrixStationnementMensuel(double prixStationnementMensuel) {
		this.prixStationnementMensuel = prixStationnementMensuel;
	}
	private  double prixStationnementMensuel ;
}
