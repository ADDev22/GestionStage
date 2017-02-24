package Models;

import java.util.ArrayList;

public class Entreprise extends Utilisateur {
	private int idEntreprise;
	private String raisonSociale;
	private String adresseVilleEnt;
	private String adresseRueEnt;
	private String adresseCodePostaleEnt;
	private String mail;
	private String tel;
	private String secteurActivite;
	private  ArrayList<OffreStage> listOfOffreSTage = new ArrayList<OffreStage>();
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Entreprise(int idEntreprise, String raisonSociale, String adresseVilleEnt, String adresseRueEnt,
			String adresseCodePostaleEnt, String mail, String tel, String secteurActivite,
			ArrayList<OffreStage> listOfOffreSTage) {
		super();
		this.idEntreprise = idEntreprise;
		this.raisonSociale = raisonSociale;
		this.adresseVilleEnt = adresseVilleEnt;
		this.adresseRueEnt = adresseRueEnt;
		this.adresseCodePostaleEnt = adresseCodePostaleEnt;
		this.mail = mail;
		this.tel = tel;
		this.secteurActivite = secteurActivite;
		this.listOfOffreSTage = listOfOffreSTage;
	}
	public int getIdEntreprise() {
		return idEntreprise;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public String getAdresseVilleEnt() {
		return adresseVilleEnt;
	}
	public String getAdresseRueEnt() {
		return adresseRueEnt;
	}
	public String getAdresseCodePostaleEnt() {
		return adresseCodePostaleEnt;
	}
	public String getMail() {
		return mail;
	}
	public String getTel() {
		return tel;
	}
	public String getSecteurActivite() {
		return secteurActivite;
	}
	public ArrayList<OffreStage> getListOfOffreSTage() {
		return listOfOffreSTage;
	}
	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public void setAdresseVilleEnt(String adresseVilleEnt) {
		this.adresseVilleEnt = adresseVilleEnt;
	}
	public void setAdresseRueEnt(String adresseRueEnt) {
		this.adresseRueEnt = adresseRueEnt;
	}
	public void setAdresseCodePostaleEnt(String adresseCodePostaleEnt) {
		this.adresseCodePostaleEnt = adresseCodePostaleEnt;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}
	public void setListOfOffreSTage(ArrayList<OffreStage> listOfOffreSTage) {
		this.listOfOffreSTage = listOfOffreSTage;
	}
	public void addOffreStage(OffreStage stage)
	{
		listOfOffreSTage.add(stage);
	}
		
	}

}
