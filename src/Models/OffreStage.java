package Models;

import java.util.ArrayList;

public class OffreStage {
	private int idOffreStage;
	private String libelleOffre;
	private String descriptifOffre;
	private String domaineOffre;
	private String dateDebut;
	private String dureeOffre;
	private String cheminOffre;
	private int isValide=0; //0 1 2
	private Entreprise entreprise;
	private String commentaire;
	private ArrayList<EtuPostStage> listPostulant = new ArrayList<EtuPostStage>();
	public OffreStage() {
		super();
	}
    public OffreStage(int idOffreStage, String libelleOffre, String descriptifOffre, String domaineOffre,
			String dureeOffre, String cheminOffre, int isValide, Entreprise entreprise,
			ArrayList<EtuPostStage> listPostulant) {
		super();
		this.idOffreStage = idOffreStage;
		this.libelleOffre = libelleOffre;
		this.descriptifOffre = descriptifOffre;
		this.domaineOffre = domaineOffre;
		this.dureeOffre = dureeOffre;
		this.cheminOffre = cheminOffre;
		this.isValide = isValide;
		this.entreprise = entreprise;
		this.listPostulant = listPostulant;
	}
	public int getIsValide() {
		return isValide;
	}
	public void setIsValide(int isValide) {
		this.isValide = isValide;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public int getIdOffreStage() {
		return idOffreStage;
	}
	public String getLibelleOffre() {
		return libelleOffre;
	}
	public String getDescriptifOffre() {
		return descriptifOffre;
	}
	public String getDomaineOffre() {
		return domaineOffre;
	}
	public String getDureeOffre() {
		return dureeOffre;
	}
	public String getCheminOffre() {
		return cheminOffre;
	}
	public int isValide() {
		return isValide;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public ArrayList<EtuPostStage> getListPostulant() {
		return listPostulant;
	}
	public void setIdOffreStage(int idOffreStage) {
		this.idOffreStage = idOffreStage;
	}
	public void setLibelleOffre(String libelleOffre) {
		this.libelleOffre = libelleOffre;
	}
	public void setDescriptifOffre(String descriptifOffre) {
		this.descriptifOffre = descriptifOffre;
	}
	public void setDomaineOffre(String domaineOffre) {
		this.domaineOffre = domaineOffre;
	}
	public void setDureeOffre(String dureeOffre) {
		this.dureeOffre = dureeOffre;
	}
	public void setCheminOffre(String cheminOffre) {
		this.cheminOffre = cheminOffre;
	}
	public void setValide(int isValide) {
		this.isValide = isValide;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public void setListPostulant(ArrayList<EtuPostStage> listPostulant) {
		this.listPostulant = listPostulant;
	}
	public void addPostulant(EtuPostStage postulant){
		this.listPostulant.add(postulant);
	}
	public EtuPostStage getPostulant(int indice){
	return this.listPostulant.get(indice);
	}


}
